package com.cris.controller;

import com.cris.domain.*;
import com.cris.service.ReplyService;
import com.cris.service.TopicService;
import com.cris.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * 帖子相关
 */
@Controller
public class TopicController {
    @Autowired
    private TopicService topicService;
    @Autowired
    private UserService userService;
    @Autowired
    private ReplyService replyService;

    /**
     * 准备数据，然后转到主界面cate.jsp显示
     */
    @RequestMapping("/")
    public String toCate(Model model){
        //分页查询帖子
        Page<Topic> page = new Page<>(1, 10, 0);  //id=0表示查询所有分类的帖子
        page = topicService.selectTopicsOfTab(page);
        if(page.getList().size() != 0){
            model.addAttribute("topicList", page.getList());
            model.addAttribute("page", page);
        }
        //准备其他数据
        model = prepare(model);
        //跳转到主界面显示
        return "cate";
    }

    /**
     * 分页查看帖子详情
     */
    @RequestMapping("/topicDetail")
    public String topicDetail(HttpServletRequest request, HttpServletResponse response, Model model){
        //获取帖子id
        int id = Integer.parseInt(request.getParameter("id"));
        //获取查询页数
        int p = Integer.parseInt(request.getParameter("page"));
        //根据id查询该帖子的详细信息
        Topic topic = topicService.selectTopicById(id);
        //查询到帖子
        if(topic != null){
            //点击量+1
            topic.setClick(topic.getClick() + 1);
            topicService.clickIncrease(id);
            //分页查询该帖子下的回复
            Page<Reply> page = new Page<>(p, 10, id);
            page = topicService.selectRepliesOfTopic(page);
            model.addAttribute("topic", topic);
            model.addAttribute("page", page);
            model.addAttribute("replyList", page.getList());
            //准备其他数据
            model = prepare(model);
            //转到详情页面显示
            return "detail";
        }
        else{
            //未查询到帖子，转到404页面
            return "404";
        }
    }

    /**
     * 分页查看板块下的帖子
     */
    @RequestMapping("/topicsOfTab")
    public String topicsOfTab(HttpServletRequest request, Model model){
        int tabId = Integer.parseInt(request.getParameter("id"));
        int p = Integer.parseInt(request.getParameter("page"));
        Page<Topic> page = new Page<>(p, 10, tabId);
        page = topicService.selectTopicsOfTab(page);
        Tab tab = new Tab();
        tab.setId(tabId);
        if(page.getList().size() != 0){
            //该模块下有帖子
            model.addAttribute("topicList", page.getList());
            model.addAttribute("page", page);
        }
        model.addAttribute("tab", tab);
        //准备其他数据
        model = prepare(model);
        //跳转到主界面显示
        return "cate";
    }

    /**
     * 封装用于准备数据的一些重复代码
     */
    public Model prepare(Model model){
        //查询总用户数
        int usersNum = userService.selectUserNum();
        //查询总帖子数
        int topicsNum = topicService.selectTotalTopicsNum();
        //查询热议帖子
        List<Topic> hotTopicList = topicService.selectHotTopics();
        //数据添加到model中
        model.addAttribute("usersNum", usersNum);
        model.addAttribute("topicsNum", topicsNum);
        model.addAttribute("hotTopicList", hotTopicList);
        return model;
    }

    /**
     * 用户发帖
     */
    @RequestMapping("/addTopic")
    public String  addTopic(HttpServletRequest request){
        //获取参数并封装Topic对象
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        int tabId = Integer.parseInt(request.getParameter("tab"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        Topic topic = new Topic();
        topic.setUserId(userId);
        Date date = new Date();
        topic.setCreateTime(date);
        topic.setTitle(title);
        topic.setContent("");
        topic.setClick(0);
        topic.setTabId(Byte.parseByte(tabId + ""));
        //完成发帖
        topicService.addTopic(topic);
        //自抢二楼
        Reply reply = new Reply();
        reply.setReplyUserId(userId);
        reply.setTopicId(topic.getId());
        reply.setContent(content);
        reply.setCreateTime(date);
        //添加回复
        replyService.addReply(reply);
        //更新用户积分
        User user = (User) request.getSession().getAttribute("user");
        user.setCredit(user.getCredit() + 10);
        request.getSession().setAttribute("user", user);
        //重定向到首页
        return "redirect:/";
    }

    /**
     * 用户自己删帖
     */
    @RequestMapping("/deleteTopic")
    public String deleteTopic(HttpServletRequest request){
        int topicId = Integer.parseInt(request.getParameter("id"));
        topicService.deleteTopic(topicId);
        return "redirect:/";
    }

}

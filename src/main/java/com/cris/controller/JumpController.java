package com.cris.controller;

import com.cris.domain.Tab;
import com.cris.domain.Topic;
import com.cris.domain.User;
import com.cris.service.TabService;
import com.cris.service.TopicService;
import com.cris.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 控制页面的跳转
 */
@Controller
public class JumpController {
    @Autowired
    private UserService userService;
    @Autowired
    private TopicService topicService;
    @Autowired
    private TabService tabService;

    /**
     * 准备数据，跳转到注册页面
     */
    @RequestMapping("/signUp")
    public String jumpToSignUp(Model model){
        //准备数据
        model = prepare(model);
        return "signup";
    }

    /**
     * 准备数据，跳转到登录页面
     */
    @RequestMapping("/signIn")
    public String jumpToSignIn(Model model){
        //准备数据
        model = prepare(model);
        return "signin";
    }

    /**
     * 跳转到用户信息设置页面
     */
    @RequestMapping("/settings")
    public String jumpToSettings(HttpServletRequest request, Model model){
        //准备数据
        model = prepare(model);
        return "settings";
    }

    /**
     * 跳转到用户头像上传页面
     */
    @RequestMapping("/updateAvatar")
    public String jumpToAvatar(HttpServletRequest request, Model model){
        //准备数据
        model = prepare(model);
        return "update_avatar";
    }

    /**
     * 查询用户数据，跳转到查看用户信息页面
     */
    @RequestMapping("/userInfo")
    public String jumpToUserInfo(HttpServletRequest request, Model model){
        //查询用户数据
        int id = Integer.parseInt(request.getParameter("id"));
        User userInfo = userService.userInfo(id);
        model.addAttribute("userInfo", userInfo);
        //准备其他数据
        model = prepare(model);
        return "user_info";
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
     * 跳转到发帖页面
     */
    @RequestMapping("/jumpToAddTopic")
    public String jumpToAddTopic(Model model){
        //查询所有帖子板块，以供发帖者选择
        List<Tab> tabList = tabService.selectAllTabs();
        model.addAttribute("tabList", tabList);
        //准备其他数据
        model = prepare(model);
        //跳转页面
        return "new";
    }

    /**
     * 跳转到管理员登录页面
     */
    @RequestMapping("/admin")
    public String jumpToAdminSignIn(){
        return "admin/signin";
    }

    /**
     * 跳转到添加板块页面
     */
    @RequestMapping("/jumpToAddTab")
    public String jumpToAddTab(){
        return "admin/tab/add";
    }

    /**
     * 跳转到404页面
     */
    @RequestMapping("/404")
    public String jumpTo404 () {
        return "404";
    }
}

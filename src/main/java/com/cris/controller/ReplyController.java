package com.cris.controller;

import com.cris.domain.Reply;
import com.cris.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 回复相关
 */
@Controller
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    /**
     * 添加一条新回复
     */
    @RequestMapping("addReply")
    public String addReply(HttpServletRequest request){
        //回复者的id
        int userId = Integer.parseInt(request.getParameter("userId"));
        //被回复帖子的id
        int topicId = Integer.parseInt(request.getParameter("topicId"));
        //回复内容
        String content = request.getParameter("content");
        //封装Reply对象
        Reply reply = new Reply();
        reply.setReplyUserId(userId);
        reply.setTopicId(topicId);
        reply.setContent(content);
        reply.setCreateTime(new Date());
        //添加回复
        replyService.addReply(reply);
        //重定向回帖子页面
        return "redirect:/topicDetail?id=" + topicId;
    }

    /**
     * 删除一条回复
     */
    @RequestMapping("/deleteReply")
    public String deleteReply(HttpServletRequest request){
        //得到帖子id
        int topicId = Integer.parseInt(request.getParameter("topicId"));
        //得到要删除的回复的id
        Long id = Long.parseLong(request.getParameter("id"));
        //删除此回复
        replyService.deleteReply(id);
        //重定向回帖子页面
        return "redirect:/topicDetail?id=" + topicId;
    }

}

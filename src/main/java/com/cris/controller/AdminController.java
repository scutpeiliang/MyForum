package com.cris.controller;

import com.cris.domain.*;
import com.cris.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * 管理员相关操作。里面一些操作在其他Controller已经实现过了，但考虑到那些方法以后可能还进行功能加强，所以在这里再写一遍
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 管理员登录
     */
    @RequestMapping("/signIn")
    public String adminSignIn(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        //封装登录表单信息
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        Admin info = new Admin();
        info.setName(name);
        info.setPassword(password);
        //进行登录
        Admin admin = adminService.adminSignIn(info);
        //登录成功，跳转到管理页面
        if(admin != null){
            request.getSession().setAttribute("admin", admin);
            return "admin/home";
        }
        //登录失败
        else{
            model.addAttribute("message", "名字或密码错误，请重试！");
            return "admin/signin";
        }
    }

    /**
     * 查询所有帖子板块
     */
    @RequestMapping("/listAllTabs")
    public String listAllTabs(Model model){
        List<Tab> tabList = adminService.listAllTabs();
        model.addAttribute("tabList", tabList);
        return "admin/tab/list";
    }

    /**
     * 增加一个帖子板块
     */
    @RequestMapping("/addTab")
    public String addTab(HttpServletRequest request, Model model){
        //获取参数并封装tab对象
        String tabName = request.getParameter("tabName");
        String tabNameEn = request.getParameter("tabNameEn");
        Tab tab = new Tab();
        tab.setTabName(tabName);
        tab.setTabNameEn(tabNameEn);
        //增加板块
        adminService.addTab(tab);
        //返回板块列表页面
        List<Tab> tabList = adminService.listAllTabs();
        model.addAttribute("tabList", tabList);
        return "admin/tab/list";
    }

    /**
     * 查询某板块下的所有帖子
     */
    @RequestMapping("/listTopicsOfTab")
    public String listTopicsOfTab(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        //获取参数，封装Tab对象
        String tabName = request.getParameter("tabName");
        Tab tab = new Tab();
        tab.setTabName(tabName);
        //查询该板块下所有帖子
        List<Topic> topicList = adminService.listTopicsOfTab(tab);
        //转到显示页面
        model.addAttribute("tab", tab);
        model.addAttribute("topicList", topicList);
        return "admin/topic/list";
    }

    /**
     * 查询某帖子下的所有回复
     */
    @RequestMapping("/listRepliesOfTopic")
    public String listRepliesOfTopic(HttpServletRequest request, Model model){
        int topicId = Integer.parseInt(request.getParameter("topicId"));
        //查询该帖子下所有回复
        List<Reply> replyList = adminService.listRepliesOfTopic(topicId);
        //转到显示页面
        model.addAttribute("replyList", replyList);
        model.addAttribute("topicId", topicId);
        return "admin/reply/list";
    }

    /**
     * 查询所有已注册用户
     */
    @RequestMapping("/listAllUsers")
    public String listAllUsers(Model model){
        //查询所有已注册用户
        List<User> userList = adminService.listAllUsers();
        //转到显示页面
        model.addAttribute("userList", userList);
        return "admin/user/list";
    }

    /**
     * 查询登录日志
     */
    @RequestMapping("/listLog")
    public String listLog(Model model){
        //查询登录日志
        List<LoginLog> logList = adminService.listLog();
        //转到显示页面
        model.addAttribute("logList", logList);
        return "admin/log/list";
    }

    /**
     * 删除一条回复
     */
    @RequestMapping("/deleteOneReply")
    public String deleteOneReply(HttpServletRequest request){
        //获取帖子id
        int topicId = Integer.parseInt(request.getParameter("topicId"));
        //获取要删除的回复的id
        int id = Integer.parseInt(request.getParameter("id"));
        //删除回复
        adminService.deleteOneReply(id);
        //重定向回原帖子
        return "redirect:/admin/listRepliesOfTopic?topicId=" + topicId;
    }

    /**
     * 删除一个帖子
     */
    @RequestMapping("/deleteOneTopic")
    public String deleteOneTopic(HttpServletRequest request){
        //获取帖子id
        int id = Integer.parseInt(request.getParameter("id"));
        //删除帖子
        adminService.deleteOneTopic(id);
        //重定向回板块页面
        return "redirect:/admin/listAllTabs";
    }

    /**
     * 删除一个板块
     */
    @RequestMapping("/deleteOneTab")
    public String deleteOneTab(HttpServletRequest request){
        //获取板块名
        String tabName = request.getParameter("tabName");
        //删除板块
        adminService.deleteOneTab(tabName);
        //重定向回板块页面
        return "redirect:/admin/listAllTabs";
    }
}

package com.cris.controller;

import com.cris.domain.User;
import com.cris.service.UserService;
import com.cris.utils.ProduceMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * 用户相关
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 校验用户名是否已存在
     */
    @RequestMapping("/checkUsername")
    public void checkUsername(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int exist = userService.checkUsername(username).intValue();
        if(exist != 0){
            //已存在此用户名，用户名不可用
            response.getWriter().write("exist");
        }
    }

    /**
     * 完成用户注册
     */
    @RequestMapping("/signUp")
    public String signUp(HttpServletRequest request, HttpServletResponse response, Model model) throws ServletException, IOException {
        //创建User对象，完善用户信息
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(ProduceMD5.getMD5(request.getParameter("password")));
        user.setEmail(request.getParameter("email"));
        user.setPhoneNum(request.getParameter("areaCode") + request.getParameter("tel"));
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        int avatar = new Random().nextInt(10) + 1;
        user.setAvatar("avatar-default-" + avatar + ".png");
        user.setCredit(0);
        user.setType(new Byte("0"));
        //调用Service层完成注册
        boolean result = userService.signUp(user);
        //设置编码
        response.setContentType("text/html;charset=utf-8");
        //注册成功
        if(result){
            model.addAttribute("signUpMessage", "注册成功，欢迎登录发言！");
            return "signin";
        }
        //注册失败
        else{
            model.addAttribute("signUpMessage", "注册失败，请重试！");
            return "signup";
        }
    }

    /**
     * 完成用户登录
     */
    @RequestMapping("/signIn")
    public String signIn(HttpServletRequest request, HttpServletResponse response, Model model) throws ServletException, IOException {
        //封装用户信息，进行登录
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        User info = new User();
        info.setUsername(username);
        info.setPassword(ProduceMD5.getMD5(password));
        User user = userService.signIn(info);
        if(user != null){
            //登录成功
            if("1".equals(request.getParameter("auto"))){
                //一天内自动登录
                Cookie usernameCookie = new Cookie("username", info.getUsername());
                usernameCookie.setMaxAge(3600 * 24);
                usernameCookie.setPath("/");
                response.addCookie(usernameCookie);
                Cookie passwordCookie = new Cookie("password", info.getPassword());
                passwordCookie.setMaxAge(3600 * 24);
                passwordCookie.setPath("/");
                response.addCookie(passwordCookie);
            }
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            return "redirect:/";
        }
        else{
            //登录失败
            model.addAttribute("signInMessage", "登录失败，用户名或密码错误，请重试！");
            return "signin";
        }
    }

    /**
     * 完成用户注销
     */
    @RequestMapping("/signOut")
    public void signOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        session.removeAttribute("user");
        //清掉Cookie，防止再自动登录
        Cookie usernameCookie = new Cookie("username", user.getUsername());
        usernameCookie.setMaxAge(0);
        usernameCookie.setPath("/");
        response.addCookie(usernameCookie);
        Cookie passwordCookie = new Cookie("password", user.getPassword());
        passwordCookie.setMaxAge(0);
        passwordCookie.setPath("/");
        response.addCookie(passwordCookie);
        //重定向回首页
        response.sendRedirect("/");
    }

    /**
     * 完成用户头像修改
     */
    @RequestMapping("/updateAvatar")
    public String updateAvatar(HttpServletRequest request, MultipartFile picture) throws IOException {
        //拼接新头像的路径
        String uuid = UUID.randomUUID().toString();
        String originalFilename = picture.getOriginalFilename();
        String postfix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newAvatar = uuid + postfix;
        //完成新头像的上传，注意：用户自己上传的头像保存在本地，然后设置了虚拟路径，可参考：
        //https://blog.csdn.net/jacksonzhou88/article/details/62508188
        picture.transferTo(new File("/usr/local/tomcat/userAvatar/" + newAvatar));
        //更新用户信息
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        user.setAvatar(newAvatar);
        userService.updateAvatar(user);
        session.setAttribute("user", user);
        //返回页面
        return "update_avatar";
    }
}

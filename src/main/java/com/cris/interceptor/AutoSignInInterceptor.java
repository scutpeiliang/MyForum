package com.cris.interceptor;

import com.cris.domain.LoginLog;
import com.cris.domain.User;
import com.cris.service.LoginLogService;
import com.cris.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * 实现自动登录的拦截器
 */
public class AutoSignInInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;
    @Autowired
    private LoginLogService loginLogService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //检查用户登录状态。如果未登录且携带Cookie，则检查Cookie进行自动登录；否则直接放行。
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null && request.getCookies() != null){
            Cookie[] cookies = request.getCookies();
            String username = null;
            String password = null;
            for(Cookie cookie : cookies){
                if("username".equals(cookie.getName())){
                    username = cookie.getValue();
                }
                if("password".equals(cookie.getName())){
                    password = cookie.getValue();
                }
            }
            if(username != null && password != null){
                User info = new User();
                info.setUsername(username);
                info.setPassword(password);
                User signIn = userService.signIn(info);
                if(signIn != null){
                    //登录成功，记录日志
                    LoginLog log = new LoginLog();
                    log.setUserId(signIn.getId());
                    log.setLoginTime(new Date());
                    log.setIp(request.getRemoteAddr());
                    loginLogService.addLoginLog(log);
                    session.setAttribute("user", signIn);
                }
            }
        }
        return true;
    }
}

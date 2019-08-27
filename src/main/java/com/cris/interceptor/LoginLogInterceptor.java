package com.cris.interceptor;

import com.cris.domain.LoginLog;
import com.cris.domain.User;
import com.cris.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 记录登录日志的拦截器
 */
public class LoginLogInterceptor implements HandlerInterceptor {
    @Autowired
    private LoginLogService loginLogService;

    /**
     *收到登录表单，还不清楚用户名密码是否正确，先放行
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }


    /**
     *检查session域有没有用户对象，有则登录成功，记录日志；没有则登录失败，不做处理
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        if(user != null){
            //登录成功，记录日志
            LoginLog log = new LoginLog();
            log.setUserId(user.getId());
            log.setLoginTime(new Date());
            log.setIp(request.getRemoteAddr());
            loginLogService.addLoginLog(log);
        }
    }

}

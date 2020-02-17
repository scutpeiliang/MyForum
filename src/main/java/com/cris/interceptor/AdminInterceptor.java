package com.cris.interceptor;

import com.cris.domain.Admin;
import com.cris.exception.UnauthorizedException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 检查管理员权限的拦截器
 */

public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //检查管理员登录状态。如果未登录则提示403，已登录则放行
        HttpSession session = request.getSession();
        Admin admin = (Admin)session.getAttribute("admin");
        if (admin == null) {
            throw new UnauthorizedException("无权限进行此操作！");
        }
        return true;
    }
}

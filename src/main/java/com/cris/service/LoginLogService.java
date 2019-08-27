package com.cris.service;

import com.cris.domain.LoginLog;

/**
 * 登录日志相关操作
 */
public interface LoginLogService {

    /**
     * 记录用户登录日志
     */
    public void addLoginLog(LoginLog log);

}

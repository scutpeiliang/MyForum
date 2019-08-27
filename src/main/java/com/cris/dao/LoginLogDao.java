package com.cris.dao;

import com.cris.domain.LoginLog;

/**
 * 登录日志相关操作
 */
public interface LoginLogDao {

    /**
     * 记录用户登录日志
     */
    public void addLoginLog(LoginLog log);

}

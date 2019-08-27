package com.cris.service.impl;

import com.cris.dao.LoginLogDao;
import com.cris.domain.LoginLog;
import com.cris.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("LoginLogService")
public class LoginLogServiceImpl implements LoginLogService {
    @Autowired
    private LoginLogDao loginLogDao;

    @Override
    public void addLoginLog(LoginLog log) {
        loginLogDao.addLoginLog(log);
    }
}

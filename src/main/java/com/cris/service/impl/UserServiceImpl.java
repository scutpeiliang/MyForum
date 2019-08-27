package com.cris.service.impl;

import com.cris.dao.UserDao;
import com.cris.domain.User;
import com.cris.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public boolean signUp(User user) {
        return userDao.signUp(user) > 0;
    }

    @Override
    public int selectUserNum() {
        return userDao.selectUserNum();
    }

    @Override
    public User signIn(User info) {
        return userDao.signIn(info);
    }

    @Override
    public Long checkUsername(String username) {
        return userDao.checkUsername(username);
    }

    @Override
    public void updateAvatar(User user) {
        userDao.updateAvatar(user);
    }

    @Override
    public User userInfo(int id) {
        return userDao.userInfo(id);
    }
}


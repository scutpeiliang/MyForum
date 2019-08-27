package com.cris.service;

import com.cris.domain.User;

/**
 * 用户相关操作
 */
public interface UserService {

    /**
     * 完成用户注册
     */
    public boolean signUp(User user);

    /**
     * 查询总用户数
     */
    public int selectUserNum();

    /**
     * 完成用户登录
     */
    public User signIn(User info);

    /**
     * 校验用户名是否已存在
     */
    public Long checkUsername(String username);

    /**
     * 完成用户头像修改
     */
    public void updateAvatar(User user);

    /**
     * 查询用户的基本信息
     */
    public User userInfo(int id);
}

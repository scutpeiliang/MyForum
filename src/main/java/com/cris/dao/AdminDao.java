package com.cris.dao;

import com.cris.domain.*;

import java.util.List;

/**
 * 管理员相关操作
 */
public interface AdminDao {

    /**
     *管理员登录
     */
    public Admin adminSignIn(Admin info);

    /**
     * 查询所有帖子板块
     */
    public List<Tab> listAllTabs();

    /**
     * 增加一个帖子板块
     */
    public void addTab(Tab tab);

    /**
     * 查询某板块下所有帖子
     */
    public List<Topic> listTopicsOfTab(Tab tab);

    /**
     * 查询某帖子下所有回复
     */
    public List<Reply> listRepliesOfTopic(int topicId);

    /**
     * 查询所有已注册用户
     */
    public List<User> listAllUsers();

    /**
     * 查询登录日志
     */
    public List<LoginLog> listLog();

    /**
     * 删除一条回复
     */
    public void deleteOneReply(int id);

    /**
     * 删除某帖子下的所有回复
     */
    public void deleteAllRepliesOfTopic(int id);

    /**
     * 删除一个帖子本身
     */
    public void deleteOneTopic(int id);

    /**
     * 删除一个板块本身
     */
    public void deleteOneTab(String tabName);
}

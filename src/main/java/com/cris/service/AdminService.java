package com.cris.service;

import com.cris.domain.*;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 管理员相关操作
 */
public interface AdminService {

    /**
     *管理员登录
     */
    public Admin adminSignIn(Admin info);

    /**
     *查询所有帖子板块
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
     *查询所有已注册用户
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
     * 删除一个帖子，需要开启事务，先删除帖子下的所有回复，再删除帖子本身
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteOneTopic(int id);

    /**
     * 删除一个板块，需要开启事务，先删除板块下的全部帖子，再删除板块本身
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteOneTab(String tabName);
}

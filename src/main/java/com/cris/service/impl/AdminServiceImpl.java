package com.cris.service.impl;

import com.cris.dao.AdminDao;
import com.cris.domain.*;
import com.cris.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AdminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin adminSignIn(Admin info) {
        return adminDao.adminSignIn(info);
    }

    @Override
    public List<Tab> listAllTabs() {
        return adminDao.listAllTabs();
    }

    @Override
    public void addTab(Tab tab) {
        adminDao.addTab(tab);
    }

    @Override
    public List<Topic> listTopicsOfTab(Tab tab) {
        return adminDao.listTopicsOfTab(tab);
    }

    @Override
    public List<Reply> listRepliesOfTopic(int topicId) {
        return adminDao.listRepliesOfTopic(topicId);
    }

    @Override
    public List<User> listAllUsers() {
        return adminDao.listAllUsers();
    }

    @Override
    public List<LoginLog> listLog() {
        return adminDao.listLog();
    }

    @Override
    public void deleteOneReply(int id) {
        adminDao.deleteOneReply(id);
    }

    @Override
    public void deleteOneTopic(int id) {
        //删除帖子下的所有回复
        adminDao.deleteAllRepliesOfTopic(id);
        //删除帖子本身
        adminDao.deleteOneTopic(id);
    }

    @Override
    public void deleteOneTab(String tabName) {
        //先得到该板块的所有帖子
        Tab tab = new Tab();
        tab.setTabName(tabName);
        List<Topic> topicList = adminDao.listTopicsOfTab(tab);
        //对每个帖子都进行删除
        for(Topic topic : topicList){
            adminDao.deleteAllRepliesOfTopic(topic.getId());
            adminDao.deleteOneTopic(topic.getId());
        }
        //删除板块本身
        adminDao.deleteOneTab(tabName);
    }

}

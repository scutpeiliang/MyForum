package com.cris.service.impl;

import com.cris.dao.ReplyDao;
import com.cris.dao.TopicDao;
import com.cris.dao.UserDao;
import com.cris.domain.Reply;
import com.cris.domain.Topic;
import com.cris.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("TopicService")
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicDao topicDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ReplyDao replyDao;

    @Override
    public List<Topic> selectAllTopics() {
        return topicDao.selectAllTopics();
    }

    @Override
    public List<Topic> selectHotTopics() {
        return topicDao.selectHotTopics();
    }

    @Override
    public Topic selectTopicById(int id) {
        return topicDao.selectTopicById(id);
    }

    @Override
    public void clickIncrease(int id) {
        topicDao.clickIncrease(id);
    }

    @Override
    public List<Reply> selectAllRepliesById(int id) {
        return topicDao.selectAllRepliesById(id);
    }

    @Override
    public List<Topic> selectTopicsOfTab(int tabId) {
        return topicDao.selectTopicsOfTab(tabId);
    }

    @Override
    public void addTopic(Topic topic){
        //发帖
        topicDao.addTopic(topic);
        //用户积分+10
        userDao.addCredit(topic.getUserId());
    }

    @Override
    public void deleteTopic(int topicId) {
        //删除帖子下的所有回复
        replyDao.deleteAll(topicId);
        //删除帖子
        topicDao.deleteById(topicId);
    }

}

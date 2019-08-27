package com.cris.service;

import com.cris.domain.Reply;
import com.cris.domain.Topic;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 帖子相关
 */
public interface TopicService {

    /**
     * 查询所有帖子
     */
    public List<Topic> selectAllTopics();

    /**
     * 查询热议帖子
     */
    public List<Topic> selectHotTopics();

    /**
     * 根据id查询某个帖子的信息
     */
    public Topic selectTopicById(int id);

    /**
     * 帖子点击量+1
     */
    public void clickIncrease(int id);

    /**
     * 查询某帖子下的所有回复
     */
    public List<Reply> selectAllRepliesById(int id);

    /**
     * 查询特定板块的所有帖子
     */
    public List<Topic> selectTopicsOfTab(int tabId);

    /**
     * 完成发帖和发帖用户积分增加，需要配置事务
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void addTopic(Topic topic);

    /**
     * 删帖，包括帖子本身及其所有回复的删除，需要配置事务
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteTopic(int topicId);
}

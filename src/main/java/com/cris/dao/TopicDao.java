package com.cris.dao;

import com.cris.domain.Reply;
import com.cris.domain.Topic;

import java.util.List;

/**
 * 帖子相关操作
 */
public interface TopicDao {

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
     * 用户发帖
     */
    public void addTopic(Topic topic);

    /**
     * 用户自己删帖
     */
    public void deleteById(int topicId);
}

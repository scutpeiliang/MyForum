package com.cris.dao;

import com.cris.domain.Page;
import com.cris.domain.Reply;
import com.cris.domain.Topic;

import java.util.List;

/**
 * 帖子相关操作
 */
public interface TopicDao {

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
     * 用户发帖
     */
    public void addTopic(Topic topic);

    /**
     * 用户自己删帖
     */
    public void deleteById(int topicId);

    /**
     * 查询帖子总数
     */
    public int selectTotalTopicsNum();

    /**
     * 查询某帖子回复总数
     */
    public int selectReplyNumOfTopic(int id);

    /**
     * 分页查询帖子下回复
     */
    public List<Reply> selectRepliesOfTopic(Page page);
}

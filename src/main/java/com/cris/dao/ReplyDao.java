package com.cris.dao;

import com.cris.domain.Reply;

/**
 * 回复相关操作
 */
public interface ReplyDao {

    /**
     * 添加一条新回复
     */
    public void addReply(Reply reply);

    /**
     * 删除一条回复
     */
    public void deleteReply(Long id);

    /**
     * 删除指定帖子下的所有回复
     */
    public void deleteAll(int topicId);
}

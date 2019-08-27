package com.cris.service;

import com.cris.domain.Reply;

/**
 * 回复相关操作
 */
public interface ReplyService {

    /**
     * 添加一条新回复
     */
    public void addReply(Reply reply);

    /**
     * 删除一条回复
     */
    public void deleteReply(Long id);
}

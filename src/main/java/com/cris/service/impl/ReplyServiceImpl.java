package com.cris.service.impl;

import com.cris.dao.ReplyDao;
import com.cris.domain.Reply;
import com.cris.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ReplyService")
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    private ReplyDao replyDao;

    @Override
    public void addReply(Reply reply) {
        replyDao.addReply(reply);
    }

    @Override
    public void deleteReply(Long id) {
        replyDao.deleteReply(id);
    }
}

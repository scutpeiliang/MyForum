package com.cris.service.impl;

import com.cris.dao.ReplyDao;
import com.cris.dao.TopicDao;
import com.cris.dao.TabDao;
import com.cris.dao.UserDao;
import com.cris.domain.Page;
import com.cris.domain.Reply;
import com.cris.domain.Topic;
import com.cris.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("TopicService")
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicDao topicDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ReplyDao replyDao;
    @Autowired
    private TabDao tabDao;

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
    public Page<Reply> selectRepliesOfTopic(Page page) {
        //计算各参数
        int totalNum = topicDao.selectReplyNumOfTopic(page.getId());
        int totalPage = totalNum % page.getPageSize() == 0? (totalNum / page.getPageSize()): (totalNum / page.getPageSize()) + 1;
        int index = (page.getPage() - 1) * page.getPageSize();
        List<Integer> pages = new ArrayList<>();
        if (totalPage < 5) {
            //总页数小于5，如总页数为4时，页面选项为1234
            for (int i = 1; i <= totalPage; i++) {
                pages.add(i);
            }
        } else if (page.getPage() <= 2) {
            for (int i = 1; i <= 5; i++) {
                pages.add(i);
            }
        } else if (page.getPage() >= totalPage - 1) {
            for (int i = totalPage - 4; i <= totalPage; i++) {
                pages.add(i);
            }
        } else {
            for (int i = page.getPage() - 2; i <= page.getPage() + 2; i++) {
                pages.add(i);
            }
        }
        page.setTotalNum(totalNum);
        page.setTotalPage(totalPage);
        page.setIndex(index);
        page.setPages(pages);
        //查询该页
        page.setList(topicDao.selectRepliesOfTopic(page));
        return page;
    }

    @Override
    public Page<Topic> selectTopicsOfTab(Page page) {
        //计算各参数
        int totalNum = tabDao.selectTopicsNumByTabId(page.getId());
        int totalPage = totalNum % page.getPageSize() == 0? (totalNum / page.getPageSize()): (totalNum / page.getPageSize()) + 1;
        int index = (page.getPage() - 1) * page.getPageSize();
        List<Integer> pages = new ArrayList<>();
        if (totalPage < 5) {
            //总页数小于5，如总页数为4时，页面选项为1234
            for (int i = 1; i <= totalPage; i++) {
                pages.add(i);
            }
        } else if (page.getPage() <= 2) {
            for (int i = 1; i <= 5; i++) {
                pages.add(i);
            }
        } else if (page.getPage() >= totalPage - 1) {
            for (int i = totalPage - 4; i <= totalPage; i++) {
                pages.add(i);
            }
        } else {
            for (int i = page.getPage() - 2; i <= page.getPage() + 2; i++) {
                pages.add(i);
            }
        }
        page.setTotalNum(totalNum);
        page.setTotalPage(totalPage);
        page.setIndex(index);
        page.setPages(pages);
        //查询该页
        page.setList(tabDao.selectTopicsOfTab(page));
        return page;
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

    @Override
    public int selectTotalTopicsNum() {
        return topicDao.selectTotalTopicsNum();
    }

}

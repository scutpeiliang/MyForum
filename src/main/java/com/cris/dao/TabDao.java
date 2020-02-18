package com.cris.dao;

import com.cris.domain.Page;
import com.cris.domain.Tab;
import com.cris.domain.Topic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 板块相关操作
 */
public interface TabDao {

    /**
     * 查询所有板块
     */
    public List<Tab> selectAllTabs();

    /**
     * 查询某板块下帖子总数
     */
    public int selectTopicsNumByTabId(@Param("id") int id);

    /**
     * 分页查询某板块下帖子
     */
    public List<Topic> selectTopicsOfTab(Page<Topic> page);
}

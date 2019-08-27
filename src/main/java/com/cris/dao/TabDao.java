package com.cris.dao;

import com.cris.domain.Tab;

import java.util.List;

/**
 * 板块相关操作
 */
public interface TabDao {

    /**
     * 查询所有板块
     */
    public List<Tab> selectAllTabs();

}

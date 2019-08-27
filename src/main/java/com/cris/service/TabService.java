package com.cris.service;

import com.cris.domain.Tab;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 板块相关操作
 */
public interface TabService {

    /**
     * 查询所有板块
     */
    public List<Tab> selectAllTabs();

}

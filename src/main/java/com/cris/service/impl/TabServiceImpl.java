package com.cris.service.impl;

import com.cris.dao.TabDao;
import com.cris.domain.Tab;
import com.cris.service.TabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("TabService")
public class TabServiceImpl implements TabService {
    @Autowired
    private TabDao tabDao;

    @Override
    public List<Tab> selectAllTabs() {
        return tabDao.selectAllTabs();
    }

}

package com.cris.controller;

import com.cris.domain.Tab;
import com.cris.service.TabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 板块相关
 */
@Controller
public class TabController {
    @Autowired
    private TabService tabService;

    /**
     * 接收ajax请求，查询所有帖子板块并返回json
     */
    @RequestMapping("/selectAllTabs")
    public void selectAllTabs(HttpServletResponse response) throws IOException {
        List<Tab> tabList = tabService.selectAllTabs();
        StringBuffer sb = new StringBuffer("[");
        for(Tab tab : tabList){
            sb.append("{\"tabId\":\"" + tab.getId() + "\",\"tabName\":\"" + tab.getTabName() + "\"},");
        }
        String json = sb.substring(0, sb.length() - 1);
        json += "]";
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

}

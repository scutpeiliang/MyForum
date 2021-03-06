package com.cris.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 板块实体类
 */
public class Tab implements Serializable {
    //板块id
    private Integer id;

    //板块名
    private String tabName;

    //板块英文名
    private String tabNameEn;

    //板块下的所有帖子
    private List<Topic> topics;

    public String getTabNameEn() {
        return tabNameEn;
    }

    public void setTabNameEn(String tabNameEn) {
        this.tabNameEn = tabNameEn;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    @Override
    public String toString() {
        return "Tab{" +
                "id=" + id +
                ", tabName='" + tabName + '\'' +
                ", tabNameEn='" + tabNameEn + '\'' +
                ", topics=" + topics +
                '}';
    }
}

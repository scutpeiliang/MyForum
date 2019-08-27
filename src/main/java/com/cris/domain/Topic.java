package com.cris.domain;

import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * 帖子实体类
 */
public class Topic implements Serializable {
    //帖子所属用户（发帖人）
    private User user;

    //帖子所属板块
    private Tab tab;

    //帖子的总回复数
    private Integer countReplies;

    //帖子id
    private Integer id;

    //发帖人id
    private Integer userId;

    //发帖时间
    private Date createTime;

    private Date updateTime;

    //帖子题目
    private String title;

    //帖子总点击数
    private Integer click;

    //帖子所属板块id
    private Byte tabId;

    //帖子正文内容
    private String content;

    public Integer getCountReplies() {
        return countReplies;
    }

    public void setCountReplies(Integer countReplies) {
        this.countReplies = countReplies;
    }

    public void setTab(Tab tab) {
        this.tab = tab;
    }

    public Tab getTab() {
        return tab;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public Byte getTabId() {
        return tabId;
    }

    public void setTabId(Byte tabId) {
        this.tabId = tabId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getLocalCreateTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");//设置日期格式
        String date = df.format(this.createTime);
        return date;
    }

    public String getLocalUpdateTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");//设置日期格式
        String date = df.format(updateTime);
        return date;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "user=" + user +
                ", tab=" + tab +
                ", countReplies=" + countReplies +
                ", id=" + id +
                ", userId=" + userId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", title='" + title + '\'' +
                ", click=" + click +
                ", tabId=" + tabId +
                ", content='" + content + '\'' +
                '}';
    }
}

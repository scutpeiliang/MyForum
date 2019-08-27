package com.cris.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 回复实体类
 */
public class Reply implements Serializable {
    //回复者
    private User user;

    //此回复的唯一标识id
    private Long id;

    //此回复对应的帖子id
    private Integer topicId;

    //回复者id
    private Integer replyUserId;

    //回复时间
    private Date createTime;

    private Date updateTime;

    //回复者使用的设备
    private String device;

    //回复内容
    private String content;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getReplyUserId() {
        return replyUserId;
    }

    public void setReplyUserId(Integer replyUserId) {
        this.replyUserId = replyUserId;
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

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device == null ? null : device.trim();
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
        return "Reply{" +
                "user=" + user +
                ", id=" + id +
                ", topicId=" + topicId +
                ", replyUserId=" + replyUserId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", device='" + device + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

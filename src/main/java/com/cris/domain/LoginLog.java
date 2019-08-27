package com.cris.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 登录日志实体类
 */
public class LoginLog implements Serializable {
    //唯一标识id
    private Long id;

    //登录用户id
    private Integer userId;

    //登录时间
    private Date loginTime;

    //ip地址
    private String ip;

    //登录设备
    private String device;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device == null ? null : device.trim();
    }

    public String getLocalLoginTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");//设置日期格式
        String date = df.format(this.loginTime);
        return date;
    }

    @Override
    public String toString() {
        return "LoginLog{" +
                "id=" + id +
                ", userId=" + userId +
                ", loginTime=" + loginTime +
                ", ip='" + ip + '\'' +
                ", device='" + device + '\'' +
                '}';
    }
}

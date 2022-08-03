package com.coin.entity;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    /**登录名*/
    private String loginName;
    /**登录密码*/
    private String loginPass;
    /**轮盘抽奖次数*/
    private Integer rouletteTotalTime;
    /**剩余抽奖次数*/
    private Integer rouletteSurplusTime;
    /**状态 1-正常 0-禁用*/
    private Integer status;
    private String createUser;
    private Date createDate;
    private String updateUser;
    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPass() {
        return loginPass;
    }

    public void setLoginPass(String loginPass) {
        this.loginPass = loginPass;
    }

    public Integer getRouletteTotalTime() {
        return rouletteTotalTime;
    }

    public void setRouletteTotalTime(Integer rouletteTotalTime) {
        this.rouletteTotalTime = rouletteTotalTime;
    }

    public Integer getRouletteSurplusTime() {
        return rouletteSurplusTime;
    }

    public void setRouletteSurplusTime(Integer rouletteSurplusTime) {
        this.rouletteSurplusTime = rouletteSurplusTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}

package com.coin.entity;

import java.io.Serializable;
import java.util.Date;

public class TAgentPageConfig implements Serializable {
    private Integer id;

    private String userName;

    private String telegram;

    private String flygram;

    private String qq;

    private String letstalk;

    private String agentRegisterLink;

    private String platformRegisterLink;

    private String activitySysName;

    private String activityLink;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTelegram() {
        return telegram;
    }

    public void setTelegram(String telegram) {
        this.telegram = telegram;
    }

    public String getFlygram() {
        return flygram;
    }

    public void setFlygram(String flygram) {
        this.flygram = flygram;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getLetstalk() {
        return letstalk;
    }

    public void setLetstalk(String letstalk) {
        this.letstalk = letstalk;
    }

    public String getAgentRegisterLink() {
        return agentRegisterLink;
    }

    public void setAgentRegisterLink(String agentRegisterLink) {
        this.agentRegisterLink = agentRegisterLink;
    }

    public String getPlatformRegisterLink() {
        return platformRegisterLink;
    }

    public void setPlatformRegisterLink(String platformRegisterLink) {
        this.platformRegisterLink = platformRegisterLink;
    }

    public String getActivitySysName() {
        return activitySysName;
    }

    public void setActivitySysName(String activitySysName) {
        this.activitySysName = activitySysName;
    }

    public String getActivityLink() {
        return activityLink;
    }

    public void setActivityLink(String activityLink) {
        this.activityLink = activityLink;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userName=").append(userName);
        sb.append(", telegram=").append(telegram);
        sb.append(", flygram=").append(flygram);
        sb.append(", qq=").append(qq);
        sb.append(", letstalk=").append(letstalk);
        sb.append(", agentRegisterLink=").append(agentRegisterLink);
        sb.append(", platformRegisterLink=").append(platformRegisterLink);
        sb.append(", activitySysName=").append(activitySysName);
        sb.append(", activityLink=").append(activityLink);
        sb.append(", createUser=").append(createUser);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
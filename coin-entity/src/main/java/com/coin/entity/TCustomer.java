package com.coin.entity;

import java.io.Serializable;
import java.util.Date;

public class TCustomer implements Serializable {
    private Integer id;

    private String loginName;

    private String loginPass;

    private Integer vip;

    private Integer rouletteTotalTime;

    private Integer rouletteUsedTime;

    private String wallet;

    private Integer status;

    private Integer isLogin;

    private String source;

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

    public Integer getVip() {
        return vip;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }

    public Integer getRouletteTotalTime() {
        return rouletteTotalTime;
    }

    public void setRouletteTotalTime(Integer rouletteTotalTime) {
        this.rouletteTotalTime = rouletteTotalTime;
    }

    public Integer getRouletteUsedTime() {
        return rouletteUsedTime;
    }

    public void setRouletteUsedTime(Integer rouletteUsedTime) {
        this.rouletteUsedTime = rouletteUsedTime;
    }

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(Integer isLogin) {
        this.isLogin = isLogin;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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
        sb.append(", loginName=").append(loginName);
        sb.append(", loginPass=").append(loginPass);
        sb.append(", vip=").append(vip);
        sb.append(", rouletteTotalTime=").append(rouletteTotalTime);
        sb.append(", rouletteUsedTime=").append(rouletteUsedTime);
        sb.append(", wallet=").append(wallet);
        sb.append(", status=").append(status);
        sb.append(", isLogin=").append(isLogin);
        sb.append(", source=").append(source);
        sb.append(", createUser=").append(createUser);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
package com.coin.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TCustomer implements Serializable {
    private Integer id;
    /**登录名*/
    private String loginName;
    /**登录密码*/
    private String loginPass;
    /**VIP等级*/
    private Integer vip;
    /**轮盘抽奖次数*/
    private Integer rouletteTotalTime;
    /**已抽奖次数*/
    private Integer rouletteUsedTime;
    /**钱包*/
    private String wallet;
    /**状态 1-正常 0-禁用*/
    private Integer status;
    /**是否已登录过：默认0-未登录过 1-已登录过*/
    private Integer isLogin;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

    private static final long serialVersionUID = 1L;

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
        sb.append(", createUser=").append(createUser);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
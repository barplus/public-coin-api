package com.coin.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    /**登录名*/
    private String loginName;
    /**登录密码*/
    private String loginPass;
    /**VIP等级*/
    private Integer vip;
    /**轮盘抽奖次数*/
    private Integer rouletteTotalTime;
    /**剩余抽奖次数*/
    private Integer rouletteUsedTime;
    /**状态 1-正常 0-禁用*/
    private Integer status;
    /**是否已登录过：默认0-未登录过 1-已登录过*/
    private Integer isLogin;
    private String createUser;
    private Date createDate;
    private String updateUser;
    private Date updateDate;

}

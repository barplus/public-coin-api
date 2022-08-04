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
    /**轮盘抽奖次数*/
    private Integer rouletteTotalTime;
    /**剩余抽奖次数*/
    private Integer rouletteUsedTime;
    /**状态 1-正常 0-禁用*/
    private Integer status;
    private String createUser;
    private Date createDate;
    private String updateUser;
    private Date updateDate;

}

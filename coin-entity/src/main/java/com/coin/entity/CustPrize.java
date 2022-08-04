package com.coin.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CustPrize implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    /**奖品id*/
    private Integer prizeId;
    /**奖品名称*/
    private String prizeName;
    /**会员登录名*/
    private String loginName;
    /**滚动条获取时间*/
    private Date requestDate;
    private String createUser;
    private Date createDate;
    private String updateUser;
    private Date updateDate;

}

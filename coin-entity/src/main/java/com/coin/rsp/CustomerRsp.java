package com.coin.rsp;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CustomerRsp implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String loginName;

    private Integer vip;

    private Integer rouletteTotalTime;

    private Integer rouletteUsedTime;

    private String wallet;

    private Integer status;

    private Integer isLogin;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

}

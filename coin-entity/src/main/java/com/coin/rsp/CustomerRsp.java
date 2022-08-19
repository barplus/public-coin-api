package com.coin.rsp;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CustomerRsp implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    @Excel(name = "登录账号", width = 20)
    private String loginName;
    @Excel(name = "vip等级", width = 20, orderNum = "4")
    private Integer vip;
    @Excel(name = "总抽奖次数", width = 25, orderNum = "3")
    private Integer rouletteTotalTime;

    private Integer rouletteUsedTime;
    @Excel(name = "剩余抽奖次数", width = 25, orderNum = "2")
    private Integer rouletteSurplusTime;

    private String wallet;

    private Integer status;
    @Excel(name = "是否登录", width = 20, orderNum = "1", replace = {"是_1", "否_0"})
    private Integer isLogin;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

}

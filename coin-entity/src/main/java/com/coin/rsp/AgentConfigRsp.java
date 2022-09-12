package com.coin.rsp;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AgentConfigRsp implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    @Excel(name = "业务人员", width = 20, orderNum = "1")
    private String userName;
    @Excel(name = "小飞机号码", width = 20, orderNum = "2")
    private String telegram;
    @Excel(name = "飞豹号码", width = 20, orderNum = "3")
    private String flygram;
    @Excel(name = "QQ号码", width = 20, orderNum = "4")
    private String qq;
    @Excel(name = "Letstalk号码", width = 20, orderNum = "5")
    private String letstalk;
    @Excel(name = "代理注册链接", width = 35, orderNum = "6")
    private String agentRegisterLink;
    @Excel(name = "平台注册链接", width = 35, orderNum = "7")
    private String platformRegisterLink;
    @Excel(name = "落地页链接", width = 35, orderNum = "8")
    private String activityLink;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

}
package com.coin.rsp.template;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerTemplate implements Serializable {

    private static final long serialVersionUID = 1L;

    @Excel(name = "会员账号", width = 20, orderNum = "1")
    private String loginName;
    @Excel(name = "总抽奖次数", width = 25, orderNum = "2")
    private Integer rouletteTotalTime;
    @Excel(name = "VIP等级", width = 20, orderNum = "3")
    private Integer vip;

}

package com.coin.rsp;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CustPrizeRsp implements Serializable {

    private static final long serialVersionUID = 1L;

    @Excel(name = "ID", width = 10)
    private Integer id;
    /**奖品id*/
    @Excel(name = "奖品编号", width = 25)
    private Integer prizeId;
    /**奖品名称*/
    @Excel(name = "奖品名称", width = 25, needMerge = true)
    private String prizeName;
    /**会员登录名*/
    @Excel(name = "会员登录名", width = 25, needMerge = true)
    private String loginName;
    /**滚动条获取时间*/
    private Date requestDate;
    private String createUser;
    @Excel(name = "中奖时间", width = 35, format = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    private String updateUser;
    private Date updateDate;

}

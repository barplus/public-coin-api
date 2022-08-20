package com.coin.rsp;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CustPrizeRsp implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    /**记录编号*/
    @Excel(name = "记录编号", width = 35, orderNum = "1")
    private String billNo;
    /**奖品id*/
    private Integer prizeId;
    /**奖品名称*/
    @Excel(name = "抽中奖品", width = 20, orderNum = "3")
    private String prizeName;
    /**会员登录名*/
    @Excel(name = "会员账号", width = 20, orderNum = "2")
    private String loginName;
    /**滚动条获取时间*/
    private Date requestDate;
    @Excel(name = "转入钱包", width = 20, orderNum = "5")
    private String wallet;
    private String prizePic;
    private String createUser;
    @Excel(name = "抽奖时间", width = 35, format = "yyyy-MM-dd HH:mm:ss", orderNum = "4")
    private Date createDate;
    private String updateUser;
    private Date updateDate;

}

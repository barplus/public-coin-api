package com.coin.rsp;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysLogRsp implements Serializable {

    private static final long serialVersionUID = 1L;

    @Excel(name = "编号", width = 20, orderNum = "1")
    private Integer id;
    @Excel(name = "会员账号", width = 25, orderNum = "2")
    private String loginName;
    @Excel(name = "操作类型", width = 20, orderNum = "3", replace = {"清除密码_1", "添加次数_2"})
    private Integer logType;
    @Excel(name = "操作前", width = 25, orderNum = "4")
    private String beforeVal;
    private String changeVal;
    @Excel(name = "操作后", width = 25, orderNum = "5")
    private String afterVal;
    @Excel(name = "操作人", width = 20, orderNum = "7")
    private String createUser;
    @Excel(name = "操作时间", width = 35, orderNum = "6", format = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

}

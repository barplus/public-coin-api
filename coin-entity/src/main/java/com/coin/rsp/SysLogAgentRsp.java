package com.coin.rsp;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysLogAgentRsp implements Serializable {

    private static final long serialVersionUID = 1L;

    @Excel(name = "序号", width = 15, orderNum = "1")
    private Integer id;
    @Excel(name = "操作类型", width = 20, orderNum = "3", replace = {"批量配置_4", "删除_5", "单次配置_6", "修改_7"})
    private Integer logType;
    @Excel(name = "操作人", width = 15, orderNum = "2")
    private String createUser;
    @Excel(name = "结果", width = 15, orderNum = "4")
    private String result = "成功";
    @Excel(name = "操作时间", width = 35, orderNum = "6", format = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

}

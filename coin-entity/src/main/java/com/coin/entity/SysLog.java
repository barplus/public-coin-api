package com.coin.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysLog implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    /**被操作信息所属人*/
    private String loginName;
    /**1-office 2-api*/
    private Integer sysType;
    /**日志类型:修改密码-1, 增加抽奖次数-2*/
    private Integer logType;
    /**修改前值*/
    private String beforeVal;
    /**修改后值*/
    private String afterVal;
    /**备注*/
    private String logRemark;
    private String createUser;
    private Date createDate;
    private String updateUser;
    private Date updateDate;

}

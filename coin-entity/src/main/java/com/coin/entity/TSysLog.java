package com.coin.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TSysLog implements Serializable {
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

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", loginName=").append(loginName);
        sb.append(", sysType=").append(sysType);
        sb.append(", logType=").append(logType);
        sb.append(", beforeVal=").append(beforeVal);
        sb.append(", afterVal=").append(afterVal);
        sb.append(", logRemark=").append(logRemark);
        sb.append(", createUser=").append(createUser);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
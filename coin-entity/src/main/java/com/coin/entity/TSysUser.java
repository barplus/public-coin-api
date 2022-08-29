package com.coin.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TSysUser implements Serializable {
    private Integer id;
    /**登录名*/
    private String loginName;
    /**登录密码*/
    private String loginPass;
    /**角色编码*/
    private String roleCode;
    /**状态：1-正常 0-禁用*/
    private Integer status;

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
        sb.append(", loginPass=").append(loginPass);
        sb.append(", roleCode=").append(roleCode);
        sb.append(", status=").append(status);
        sb.append(", createUser=").append(createUser);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
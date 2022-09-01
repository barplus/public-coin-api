package com.coin.rsp;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysRoleRsp implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer roleType;

    private String roleCode;

    private String roleName;

    private String parentCode;

    private Integer status;

    private Integer sortNum;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

}
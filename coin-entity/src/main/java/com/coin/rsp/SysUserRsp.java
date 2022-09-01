package com.coin.rsp;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class SysUserRsp implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String loginName;
    private String loginPass;
    private String roleCode;
    private Integer status;
    private String createUser;
    private Date createDate;
    private String updateUser;
    private Date updateDate;
    private List<SysResourceRsp> resources;

}
package com.coin.rsp;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class SysResourceRsp implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String resourceType;

    private String resourceCode;

    private String resourceName;

    private String resourcePath;

    private String parentCode;

    private Integer status;

    private Integer sortNum;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

    private Integer isAuth;

    private List<SysResourceRsp> childList;

}
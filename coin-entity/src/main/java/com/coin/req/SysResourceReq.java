package com.coin.req;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 系统资源请求对象
 */
@Data
@ToString(callSuper=true)
public class SysResourceReq extends CommonReq implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String resourceType;
    private String resourceCode;
    private String resourceName;
    private String resourcePath;
    private String parentCode;
    private Integer status;
    private Integer sortNum;
    private String roleCode;
    private Integer onlyAuth;

}
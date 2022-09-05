package com.coin.req;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 系统角色请求对象
 */
@Data
@ToString(callSuper=true)
public class SysRoleReq extends CommonReq implements Serializable {

    private static final long serialVersionUID = 1L;

    /**查询角色名*/
    private String roleName;
    private Integer roleType;
    private String roleCode;
    private String parentCode;
    private Integer status;
    private Integer sortNum;
    private String addResourceCodes;
    private String delResourceCodes;

}

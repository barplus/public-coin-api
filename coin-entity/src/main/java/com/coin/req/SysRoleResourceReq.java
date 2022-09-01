package com.coin.req;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 系统资源请求对象
 */
@Data
@ToString(callSuper=true)
public class SysRoleResourceReq extends CommonReq implements Serializable {

    private static final long serialVersionUID = 1L;

    private String roleCode;
    private String addResourceCodes;
    private String delResourceCodes;

}
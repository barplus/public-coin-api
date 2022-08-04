package com.coin.req;

import lombok.Data;

import java.io.Serializable;

/**
 * 业务用户请求对象
 */
@Data
public class SysUserReq implements Serializable {

    private static final long serialVersionUID = 1L;

    /**用户登录名*/
    private String loginName;
    /**用户登录密码*/
    private String loginPass;

}

package com.coin.req;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 业务用户请求对象
 */
@Data
@ToString(callSuper=true)
public class SysUserReq extends CommonReq implements Serializable {

    private static final long serialVersionUID = 1L;

    /**用户登录密码*/
    private String loginPass;
    /**新密码*/
    private String newPass;

}

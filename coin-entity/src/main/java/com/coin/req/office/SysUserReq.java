package com.coin.req.office;

import java.io.Serializable;

/**
 * 业务用户请求对象
 */
public class SysUserReq implements Serializable {

    /**用户登录名*/
    private String loginName;
    /**用户登录密码*/
    private String loginPass;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPass() {
        return loginPass;
    }

    public void setLoginPass(String loginPass) {
        this.loginPass = loginPass;
    }
}

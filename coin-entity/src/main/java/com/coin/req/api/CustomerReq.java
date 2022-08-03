package com.coin.req.api;

import java.io.Serializable;

/**
 * 业务用户请求对象
 */
public class CustomerReq extends CommonReq implements Serializable {

    /**用户登录密码*/
    private String loginPass;

    public String getLoginPass() {
        return loginPass;
    }

    public void setLoginPass(String loginPass) {
        this.loginPass = loginPass;
    }
}

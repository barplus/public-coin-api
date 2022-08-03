package com.coin.req.api;

import java.io.Serializable;

/**
 * 公共请求对象
 */
public class CommonReq implements Serializable {

    /**用户登录名*/
    private String loginName;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

}

package com.coin.req.office;

import java.io.Serializable;

/**
 * 公共请求对象
 */
public class OfficeReq implements Serializable {

    /**用户登录名*/
    private String loginName;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

}

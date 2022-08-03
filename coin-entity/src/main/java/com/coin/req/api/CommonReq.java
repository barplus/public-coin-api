package com.coin.req.api;

import java.io.Serializable;

/**
 * 公共请求对象
 */
public class CommonReq implements Serializable {

    /**用户登录名*/
    private String loginName;
    private Integer pageNum;
    private Integer pageSize;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}

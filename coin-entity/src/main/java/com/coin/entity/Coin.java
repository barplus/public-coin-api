package com.coin.entity;

import java.io.Serializable;

public class Coin implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String loginName;
    private Integer num;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

}

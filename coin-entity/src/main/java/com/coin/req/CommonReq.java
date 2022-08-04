package com.coin.req;

import lombok.Data;

import java.io.Serializable;

/**
 * 公共请求对象
 */
@Data
public class CommonReq implements Serializable {

    private static final long serialVersionUID = 1L;

    /**用户登录名*/
    private String loginName;
    private Integer pageNum;
    private Integer pageSize;
    private Integer id;

}

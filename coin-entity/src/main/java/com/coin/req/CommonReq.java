package com.coin.req;

import lombok.Data;

import java.io.Serializable;

/**
 * 公共请求对象
 */
@Data
public class CommonReq implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String loginName;
    private Integer pageNum;
    private Integer pageSize;
    private String token;

}

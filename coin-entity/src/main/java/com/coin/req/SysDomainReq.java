package com.coin.req;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 系统域名地址请求对象
 */
@Data
@ToString(callSuper=true)
public class SysDomainReq extends CommonReq implements Serializable {

    private static final long serialVersionUID = 1L;

    private String sysName;

    private String domainUrl;

    private String belongUser;

    private String remark;

    private Integer status;

    private Integer num;

    private Integer isUsed;

}
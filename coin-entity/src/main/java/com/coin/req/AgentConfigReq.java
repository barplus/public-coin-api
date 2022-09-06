package com.coin.req;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 代理页面配置请求对象
 */
@Data
@ToString(callSuper=true)
public class AgentConfigReq extends CommonReq implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String userName;

    private String telegram;

    private String flygram;

    private String qq;

    private String letstalk;

    private String agentRegisterLink;

    private String platformRegisterLink;

    private String activityLink;

    private String agentCode;

}
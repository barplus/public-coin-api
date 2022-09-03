package com.coin.req;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 会员客户请求对象
 */
@Data
@ToString(callSuper=true)
public class CustomerReq extends CommonReq implements Serializable {

    private static final long serialVersionUID = 1L;

    /**用户登录密码*/
    private String loginPass;
    /**查询条件-会员登录名*/
    private String queryLoginName;
    /**总抽奖次数*/
    private Integer rouletteTotalTime;
    /**会员的钱包*/
    private String wallet;
    /**vip*/
    private Integer vip;
    /**vips*/
    private String vips;
    /**是否登录：1-是 0-否*/
    private Integer isLogin;
    /**当前抽奖方式：1、10*/
    private Integer lotteryType;
    /**来源*/
    private String source;

}

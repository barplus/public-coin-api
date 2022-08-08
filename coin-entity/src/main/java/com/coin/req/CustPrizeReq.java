package com.coin.req;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 客户抽奖记录请求对象
 */
@Data
@ToString(callSuper=true)
public class CustPrizeReq extends CommonReq implements Serializable {

    private static final long serialVersionUID = 1L;

    /**请求时间类型：*/
    private Integer dateType;
    /**请求数据类型：*/
    private Integer dataType;
    /**最小时间*/
    private Date minDate;
    /**最大时间*/
    private Date maxDate;
    /**抽奖会员登录名*/
    private String queryLoginName;
    /**是否中奖：1-中奖 0-未中奖*/
    private String isWin;

}

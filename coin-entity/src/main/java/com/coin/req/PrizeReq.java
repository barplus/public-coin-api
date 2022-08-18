package com.coin.req;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 业务用户请求对象
 */
@Data
@ToString(callSuper=true)
public class PrizeReq extends CommonReq implements Serializable {

    private static final long serialVersionUID = 1L;

    /**奖品名*/
    private String prizeName;
    /**奖品图片路径*/
    private String prizePic;
    /**价值*/
    private Integer amount;
    /**最大数量*/
    private Integer maxNum;
    /**剩余数量*/
    private Integer usedNum;
    /**中奖率*/
    private BigDecimal rate;
    /**VIP等级中奖率*/
    private String vipRate;
    private Integer status;
    /**查询中奖概率大于0的奖品*/
    private Integer rateNoZero;
    /**剩余数量大于0*/
    private Integer numNoZero;
    /**名称是否模糊匹配*/
    private String nameLike;

}

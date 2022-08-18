package com.coin.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Prize implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    /**奖品名称*/
    private String prizeName;
    /**奖品图片路径*/
    private String prizePic;
    /**奖品价值*/
    private Integer amount;
    /**最大投放数*/
    private Integer maxNum;
    /**已抽取数量*/
    private Integer usedNum;
    /**中奖率*/
    private BigDecimal rate;
    /**VIP中奖率*/
    private String vipRate;
    /**状态：1-正常 0-禁用*/
    private Integer status;
    private String createUser;
    private Date createDate;
    private String updateUser;
    private Date updateDate;

}

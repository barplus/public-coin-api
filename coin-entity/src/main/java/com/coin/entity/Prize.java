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
    /**奖品价值*/
    private Integer amount;
    /**最大投放数*/
    private Integer maxNum;
    /**剩余投放数*/
    private Integer usedNum;
    /**中奖率*/
    private BigDecimal rate;
    /**状态：1-正常 0-禁用*/
    private Integer status;
    private String createUser;
    private Date createDate;
    private String updateUser;
    private Date updateDate;

}

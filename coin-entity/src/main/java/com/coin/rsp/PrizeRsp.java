package com.coin.rsp;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class PrizeRsp implements Serializable {

    private Integer id;
    /**奖品名称*/
    private String prizeName;
    /**奖品图片*/
    private String prizePic;
    /**奖品价值*/
    private Integer amount;
    /**全部奖品总的中奖率*/
    private BigDecimal totalRate;
    /**已启用的全部奖品总的中奖率*/
    private BigDecimal enabledTotalRate;
    /**已禁用的全部奖品总的中奖率*/
    private BigDecimal disabledTotalRate;

}

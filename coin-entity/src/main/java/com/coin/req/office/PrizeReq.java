package com.coin.req.office;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 业务用户请求对象
 */
public class PrizeReq extends OfficeReq implements Serializable {

    /**奖品名*/
    private String prizeName;
    /**价值*/
    private Integer amount;
    /**最大数量*/
    private Integer maxNum;
    /**剩余数量*/
    private Integer surplusNum;
    /**中奖率*/
    private BigDecimal rate;

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(Integer maxNum) {
        this.maxNum = maxNum;
    }

    public Integer getSurplusNum() {
        return surplusNum;
    }

    public void setSurplusNum(Integer surplusNum) {
        this.surplusNum = surplusNum;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}

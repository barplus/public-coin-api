package com.coin.req.office;

import com.coin.req.api.CommonReq;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 业务用户请求对象
 */
public class PrizeReq extends CommonReq implements Serializable {

    private String prizeName;
    private Integer amount;
    private Integer maxNum;
    private Integer surplusNum;
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

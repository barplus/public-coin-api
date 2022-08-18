package com.coin.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class TPrize implements Serializable {
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
    /**默认中奖率*/
    private BigDecimal rate;
    /**VIP特定中奖率*/
    private String vipRate;
    /**状态：1-正常 0-禁用*/
    private Integer status;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", prizeName=").append(prizeName);
        sb.append(", prizePic=").append(prizePic);
        sb.append(", amount=").append(amount);
        sb.append(", maxNum=").append(maxNum);
        sb.append(", usedNum=").append(usedNum);
        sb.append(", rate=").append(rate);
        sb.append(", vipRate=").append(vipRate);
        sb.append(", status=").append(status);
        sb.append(", createUser=").append(createUser);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
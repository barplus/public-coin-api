package com.coin.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TCustPrize implements Serializable {
    private Integer id;
    /**记录编号*/
    private String billNo;
    /**奖品id*/
    private Integer prizeId;
    /**奖品名称*/
    private String prizeName;
    /**会员登录名*/
    private String loginName;
    /**滚动条获取时间*/
    private Date requestDate;

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
        sb.append(", billNo=").append(billNo);
        sb.append(", prizeId=").append(prizeId);
        sb.append(", prizeName=").append(prizeName);
        sb.append(", loginName=").append(loginName);
        sb.append(", requestDate=").append(requestDate);
        sb.append(", createUser=").append(createUser);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
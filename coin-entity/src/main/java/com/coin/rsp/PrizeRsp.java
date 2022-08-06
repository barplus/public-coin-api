package com.coin.rsp;

import lombok.Data;

import java.io.Serializable;

@Data
public class PrizeRsp implements Serializable {

    private Integer id;
    /**奖品名称*/
    private String prizeName;

}

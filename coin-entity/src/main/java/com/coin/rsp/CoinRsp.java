package com.coin.rsp;

import com.coin.entity.Coin;

import java.io.Serializable;

public class CoinRsp extends Coin implements Serializable {

    private static final long serialVersionUID = 1L;

    private String coinName;

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

}

package com.coin.service;

import com.coin.entity.Coin;

import java.util.List;

public interface CoinService {

    List<Coin> getCoins() throws Exception;

}

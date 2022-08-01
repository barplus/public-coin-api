package com.coin.service.impl;

import com.coin.entity.Coin;
import com.coin.mapper.CoinMapper;
import com.coin.service.CoinService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CoinServiceImpl implements CoinService {

    @Resource
    private CoinMapper coinMapper;

    @Override
    public List<Coin> getCoins() throws Exception {
        return coinMapper.getCoins();
    }

}

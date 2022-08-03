package com.coin.web;

import com.coin.service.BizEntity.MyResp;
import com.coin.utils.BizUtil;
import com.coin.web.controller.api.CoinController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class CoinWebApplicationTests {

    @Resource
    private CoinController controller;

    @Test
    void test() {
        MyResp resp = controller.getCoins(null);
        System.out.println(BizUtil.objToJson(resp).toJSONString());
    }

}

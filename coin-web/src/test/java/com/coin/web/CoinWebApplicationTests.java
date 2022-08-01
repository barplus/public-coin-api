package com.coin.web;

import com.coin.utils.BizUtil;
import com.coin.web.controller.CoinController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Map;

@SpringBootTest
class CoinWebApplicationTests {

    @Resource
    private CoinController controller;

    @Test
    void test() {
        Map<String, Object> map = controller.getCoins(null);
        System.out.println(BizUtil.objToJson(map).toJSONString());
    }

}

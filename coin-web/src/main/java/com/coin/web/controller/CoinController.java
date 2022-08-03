package com.coin.web.controller;

import com.coin.req.api.CommonReq;
import com.coin.service.CoinService;
import com.coin.web.annotation.CommonSecure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/coin")
public class CoinController {

    private static final Logger logger = LoggerFactory.getLogger(CoinController.class);

    @Resource
    private CoinService coinService;

    @ResponseBody
    @PostMapping("/getCoins")
    @CommonSecure
    public Map<String, Object> getCoins(CommonReq req){
        Map<String, Object> map = new HashMap<>();
        try{
            map.put("status", 0000);
            map.put("body", coinService.getCoins());
            return map;
        }catch(Exception e){
            logger.error("getCoins-error", e);
            map.put("status", 9999);
        }
        return map;
    }

}

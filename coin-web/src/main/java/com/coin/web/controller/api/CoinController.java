package com.coin.web.controller.api;

import com.coin.entity.Coin;
import com.coin.req.CommonReq;
import com.coin.service.BizEntity.MyResp;
import com.coin.service.CoinService;
import com.coin.service.constant.CodeCons;
import com.coin.web.annotation.CommonSecure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/coin")
public class CoinController {

    private static final Logger logger = LoggerFactory.getLogger(CoinController.class);

    @Resource
    private CoinService coinService;

    @PostMapping("/getCoins")
    @CommonSecure
    public MyResp getCoins(@RequestBody CommonReq req){
        try{
            List<Coin> list = coinService.getCoins();
            return new MyResp(CodeCons.SUCCESS, "", list);
        }catch(Exception e){
            logger.error("getCoins-error", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

}

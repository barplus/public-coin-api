package com.coin.web.task;

import com.coin.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 每日任务
 */
@Component
public class EveryDayTask {

    private static final Logger logger = LoggerFactory.getLogger(EveryDayTask.class);

    @Resource
    private CustomerService customerService;

    /**
     * 抽奖次数清零-整点检测，每日执行一次
     */
    @Scheduled(cron = "0 0 * * * ?")
    public void clearLotteryNum() {
        String uuid = UUID.randomUUID().toString();
        try{
            logger.info("["+uuid+"]EveryDayTask-clearLotteryNum, 每日抽奖次数清零任务开始");
            customerService.clearLotteryNum();
            logger.info("["+uuid+"]EveryDayTask-clearLotteryNum, 每日抽奖次数清零任务结束");
        }catch(Exception e){
            logger.error("["+uuid+"]EveryDayTask-clearLotteryNum, 每日抽奖次数清零任务异常", e);
        }
    }

}

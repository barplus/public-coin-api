package com.coin.web.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
public class TestTask {

    private static final Logger logger = LoggerFactory.getLogger(TestTask.class);

    /**
     * 5秒执行一次：
     */
    @Scheduled(cron = "0/5 * * * * ? ")
    public void doTest() {
        try{
            System.out.println("****************");
            Thread.sleep(1000000l);
            System.out.println("使用SpringMVC框架配置定时任务-5");
        }catch(Exception e){
            logger.error("TestTask-doTest-error", e);
        }

    }

}

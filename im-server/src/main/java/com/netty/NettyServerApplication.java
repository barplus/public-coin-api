package com.netty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = "com.coin")
//@MapperScan({"com.coin.mapper", "com.coin.mapper.ext"})
public class NettyServerApplication {

    private static final Logger logger = LoggerFactory.getLogger(NettyServerApplication.class);

    public static void main(String[] args) {
        try{
            SpringApplication.run(NettyServerApplication.class, args);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}

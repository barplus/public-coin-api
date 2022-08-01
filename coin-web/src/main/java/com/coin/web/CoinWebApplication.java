package com.coin.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.coin")
@MapperScan(basePackages = "com.coin.mapper")
public class CoinWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoinWebApplication.class, args);
    }

}

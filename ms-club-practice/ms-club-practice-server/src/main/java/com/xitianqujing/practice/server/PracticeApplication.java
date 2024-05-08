package com.xitianqujing.practice.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 练习微服务启动类
 *
 */
@SpringBootApplication
@ComponentScan("com.xitianqujing")
@MapperScan("com.jingdianjichi.**.dao")
@EnableFeignClients(basePackages = "com.xitianqujing")
public class PracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticeApplication.class);
    }

}

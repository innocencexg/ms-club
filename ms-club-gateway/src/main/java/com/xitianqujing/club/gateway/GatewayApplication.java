package com.xitianqujing.club.gateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 网关服务启动器
 *
 * @author: gx
 * @data: 2024/2/11
 */
@SpringBootApplication
@ComponentScan("com.xitianqujing")
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class);
    }
}

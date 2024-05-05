package com.xitianqujing.subject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.mybatis.spring.annotation.MapperScan;
/**
 * 刷题微服务启动类
 * @Author: gx
 * @CreateTime: 2024/04/15  15:47
 */
@SpringBootApplication
@ComponentScan("com.xitianqujing")
@MapperScan("com.xitianqujing.**.mapper")
@EnableFeignClients(basePackages = "com.xitianqujing")
public class SubjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(SubjectApplication.class);
    }
}

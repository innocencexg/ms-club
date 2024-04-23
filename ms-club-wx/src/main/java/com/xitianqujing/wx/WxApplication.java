package com.xitianqujing.wx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: gx
 * @CreateTime: 2024/02/26  17:50
 */
@SpringBootApplication
@ComponentScan("com.xitianqujing")
public class WxApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxApplication.class);
    }

}

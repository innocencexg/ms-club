package com.xitianqujing.subject.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 刷题controller
 * @Author: gx
 * @CreateTime: 2024/04/15  16:27
 */
@RestController
public class SubjectController {
    @GetMapping("/test")
    public String test(){
        return "hello";
    }
}

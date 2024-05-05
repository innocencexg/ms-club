package com.xitianqujing.subject.application.controller;

import com.xitianqujing.subject.infra.entity.UserInfo;
import com.xitianqujing.subject.infra.rpc.UserRpc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @Author: gx
 * @CreateTime: 2024/03/05  15:21
 */
@RestController
@RequestMapping("/subject/category")
@Slf4j
public class TestFeignController {

    @Resource
    private UserRpc userRpc;

    @GetMapping("testFeign")
    public void testFeign() {
        UserInfo userInfo = userRpc.getUserInfo("oxLm_6YuM9fL57rb1_0MS3Br9Ets");
        log.info("testFeign.userInfo:{}", userInfo);
    }
}

//package com.xitianqujing.auth.api;
//import com.xitianqujing.auth.entity.AuthUserDTO;
//import com.xitianqujing.auth.entity.Result;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//
///**
// * 用户服务feign
// * @Author: gx
// * @CreateTime: 2024/03/02  01:11
// */
//@FeignClient("cp-club-auth-dev")
//public interface UserFeignService {
//    @RequestMapping("/user/getUserInfo")
//    Result<AuthUserDTO> getUserInfo(@RequestBody AuthUserDTO authUserDTO);
//
//}

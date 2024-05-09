package com.xitianqujing.practice.server.util;


import com.xitianqujing.practice.server.config.context.LoginContextHolder;

/**
 * 用户登录util
 */
public class LoginUtil {

    public static String getLoginId() {
        return LoginContextHolder.getLoginId();
    }


}

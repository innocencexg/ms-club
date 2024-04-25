package com.xitianqujing.subject.common.util;

import com.xitianqujing.subject.common.context.LoginContextHolder;

/**
 * 用户登录util
 */
public class LoginUtil {
    public static String getLoginId() {
        return LoginContextHolder.getLoginId();
    }

}

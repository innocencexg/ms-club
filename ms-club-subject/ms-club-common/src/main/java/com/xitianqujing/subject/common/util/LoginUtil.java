package com.xitianqujing.subject.common.util;

import com.xitianqujing.subject.common.context.LoginContextHolder;

/**
 * 用户登录util
 * @Author: gx
 * @CreateTime: 2024/03/02  01:01
 */
public class LoginUtil {
    public static String getLoginId() {
        return LoginContextHolder.getLoginId();
    }

}

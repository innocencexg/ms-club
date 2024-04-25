package com.xitianqujing.auth.domain.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.xitianqujing.auth.domain.entity.AuthUserBO;

/**
 * 用户领域service
 */
public interface AuthUserDomainService {
    /**
     * 注册
     */
    Boolean register(AuthUserBO authUserBO);

    /**
     * 更新用户信息
     */
    Object update(AuthUserBO authUserBO);

    /**
     * 更新用户信息
     */
    Boolean delete(AuthUserBO authUserBO);

    /**
     * 登录验证
     */
    SaTokenInfo doLogin(String validCode);

    /**
     * 获取用户信息
     */
    AuthUserBO getUserInfo(AuthUserBO authUserBO);


}

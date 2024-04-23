package com.xitianqujing.auth.domain.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.xitianqujing.auth.domain.entity.AuthUserBO;

/**
 * 用户领域service
 * @Author: gx
 * @CreateTime: 2024/02/26  11:15
 */
public interface AuthUserDomainService {

    /**
     * 注册
     */
    Boolean register(AuthUserBO authUserBO);

    /**
     * 更新用户信息
     * @param authUserBO
     * @return
     */
    Object update(AuthUserBO authUserBO);

    /**
     * 更新用户信息
     */
    Boolean delete(AuthUserBO authUserBO);


    /**
     * 登录验证
     * @param validCode
     * @return
     */
    SaTokenInfo doLogin(String validCode);

    AuthUserBO getUserInfo(AuthUserBO authUserBO);


}

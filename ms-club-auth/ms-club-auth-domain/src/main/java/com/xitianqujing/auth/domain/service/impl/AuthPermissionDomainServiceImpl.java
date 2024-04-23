package com.xitianqujing.auth.domain.service.impl;

import com.xitianqujing.auth.common.enums.IsDeletedFlagEnum;
import com.xitianqujing.auth.domain.convert.AuthPermissionBOConverter;
import com.xitianqujing.auth.domain.entity.AuthPermissionBO;
import com.xitianqujing.auth.domain.redis.RedisUtil;
import com.xitianqujing.auth.domain.service.AuthPermissionDomainService;
import com.xitianqujing.auth.infra.basic.entity.AuthPermission;
import com.xitianqujing.auth.infra.basic.service.AuthPermissionService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: gx
 * @CreateTime: 2024/02/26  14:29
 */
@Service
@Slf4j
public class AuthPermissionDomainServiceImpl implements AuthPermissionDomainService {

    @Resource
    private AuthPermissionService authPermissionService;
    @Resource
    private RedisUtil redisUtil;


    private String authPermissionPrefix = "auth.permission";

    @Override
    public Boolean add(AuthPermissionBO authPermissionBO) {
        AuthPermission authPermission = AuthPermissionBOConverter.INSTANCE.convertBOToEntity(authPermissionBO);
        authPermission.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        Integer count = authPermissionService.insert(authPermission);
        return count > 0;
    }

    @Override
    public Boolean update(AuthPermissionBO authPermissionBO) {
        AuthPermission authPermission = AuthPermissionBOConverter.INSTANCE.convertBOToEntity(authPermissionBO);
        Integer count = authPermissionService.update(authPermission);
        return count > 0;
    }

    @Override
    public Boolean delete(AuthPermissionBO authPermissionBO) {
        AuthPermission authPermission = new AuthPermission();
        authPermission.setId(authPermissionBO.getId());
        authPermission.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        Integer count = authPermissionService.update(authPermission);
        return count > 0;
    }

    @Override
    public List<String> getPermission(String userName) {
        String permissionKey = redisUtil.buildKey(authPermissionPrefix, userName);
        String permissionValue = redisUtil.get(permissionKey);
        if (StringUtils.isBlank(permissionValue)) {
            return Collections.emptyList();
        }
        List<AuthPermission> permissionList = new Gson().fromJson(permissionValue,
                new TypeToken<List<AuthPermission>>() {
                }.getType());
        List<String> authList = permissionList.stream().map(AuthPermission::getPermissionKey).collect(Collectors.toList());
        return authList;
    }

}


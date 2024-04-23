package com.xitianqujing.auth.domain.service;

import com.xitianqujing.auth.domain.entity.AuthRoleBO;

/**
 * 角色领域service
 */
public interface AuthRoleDomainService {
    Boolean add(AuthRoleBO authRoleBO);

    Boolean update(AuthRoleBO authRoleBO);

    Boolean delete(AuthRoleBO authRoleBO);


}

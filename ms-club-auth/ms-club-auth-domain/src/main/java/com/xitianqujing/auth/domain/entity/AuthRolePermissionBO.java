package com.xitianqujing.auth.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 角色权限关联表(AuthRolePermission)bo
 *
 * @author gx
 * @since 2024-02-26 14:43:47
 */
@Data
public class AuthRolePermissionBO implements Serializable {
    private static final long serialVersionUID = 288156903778049737L;
    /**
     * 注解id
     */
    private Long id;
    /**
     * 角色id
     */
    private Long roleId;
    /**
     * 权限id
     */
    private Long permissionId;

    private List<Long> permissionIdList;

}


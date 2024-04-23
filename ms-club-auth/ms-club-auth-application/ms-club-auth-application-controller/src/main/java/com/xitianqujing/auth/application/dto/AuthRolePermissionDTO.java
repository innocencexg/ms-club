package com.xitianqujing.auth.application.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 角色权限关联表(AuthRolePermission)dto
 *
 * @author gx
 * @since 2024-02-26 14:43:47
 */
@Data
public class AuthRolePermissionDTO implements Serializable {
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


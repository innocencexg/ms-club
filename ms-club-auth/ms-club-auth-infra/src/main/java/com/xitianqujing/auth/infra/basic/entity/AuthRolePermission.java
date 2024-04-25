package com.xitianqujing.auth.infra.basic.entity;

import java.util.Date;

import lombok.Data;

import java.io.Serializable;

/**
 * 角色权限关联表(AuthRolePermission)实体类
 */
@Data
public class AuthRolePermission implements Serializable {
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
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 更新人
     */
    private String updateBy;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 0是未删除，1是删除状态
     */
    private Integer isDeleted;


}


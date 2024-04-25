package com.xitianqujing.auth.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 角色dto
 */
@Data
public class AuthRoleDTO implements Serializable {
    private static final long serialVersionUID = 974088621580336158L;

    private Long id;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色唯一标识
     */
    private String roleKey;


}


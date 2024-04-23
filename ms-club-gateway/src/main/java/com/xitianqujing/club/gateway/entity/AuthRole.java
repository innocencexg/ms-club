package com.xitianqujing.club.gateway.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (AuthRole)实体类
 *
 * @author gx
 * @since 2024-02-26 10:53:55
 */
@Data
public class AuthRole implements Serializable {
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
     * 是否被删除 0未删除 1已删除
     */
    private Integer isDeleted;


}


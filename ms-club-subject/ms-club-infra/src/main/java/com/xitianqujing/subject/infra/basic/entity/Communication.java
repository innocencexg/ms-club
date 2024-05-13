package com.xitianqujing.subject.infra.basic.entity;

import java.util.Date;
import lombok.Data;
import java.io.Serializable;

/**
 * (Communication)实体类
 *
 * @author gx
 * @since 2024-05-13 15:25:41
 */
@Data
public class Communication implements Serializable {
    private static final long serialVersionUID = 944925336177749217L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 修改人
     */
    private String updateBy;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 内容
     */
    private String content;
    /**
     * 标题
     */
    private String contentTitle;
    /**
     * 头像
     */
    private String avatar;


}


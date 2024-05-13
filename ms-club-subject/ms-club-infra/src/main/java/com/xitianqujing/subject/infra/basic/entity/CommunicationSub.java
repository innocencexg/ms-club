package com.xitianqujing.subject.infra.basic.entity;

import java.util.Date;
import lombok.Data;
import java.io.Serializable;

/**
 * (CommunicationSub)实体类
 *
 * @author gx
 * @since 2024-05-13 21:00:06
 */
@Data
public class CommunicationSub implements Serializable {
    private static final long serialVersionUID = -99626320562122533L;
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
     * 评论内容
     */
    private String content;
    /**
     * 父id（原话题id）
     */
    private Long parentId;


}


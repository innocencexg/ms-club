package com.xitianqujing.subject.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 题目标签dto
 *
 * @author makejava
 * @since 2024-03-07 20:33:02
 */
@Data
public class SubjectLabelDTO implements Serializable {

    /**
     * 主键
     */
    private Long id;
    /**
     * 分类的id
     */
    private long categoryId;
    /**
     * 标签分类
     */
    private String labelName;
    /**
     * 排序
     */
    private Integer sortNum;

}



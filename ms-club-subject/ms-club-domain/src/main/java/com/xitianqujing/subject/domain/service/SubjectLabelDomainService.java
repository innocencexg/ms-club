package com.xitianqujing.subject.domain.service;

import com.xitianqujing.subject.domain.entity.SubjectLabelBO;

import java.util.List;

/**
 * 题目标签领域服务
 */
public interface SubjectLabelDomainService {

    /**
     * 新增标签
     * @param subjectCategoryBO
     */
    Boolean add(SubjectLabelBO subjectCategoryBO);


    /**
     * 更新标签
     * @param subjectLabelBO
     * @return
     */
    Boolean update(SubjectLabelBO subjectLabelBO);

    /**
     * 删除标签
     * @param subjectLabelBO
     * @return
     */
    Boolean delete(SubjectLabelBO subjectLabelBO);

    /**
     * 查询分类下标签
     * @param subjectLabelBO
     * @return
     */
    List<SubjectLabelBO> queryLabelByCategoryId(SubjectLabelBO subjectLabelBO);

    List<SubjectLabelBO> queryLabel();
}



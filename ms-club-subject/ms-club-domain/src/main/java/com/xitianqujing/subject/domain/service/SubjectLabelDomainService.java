package com.xitianqujing.subject.domain.service;

import com.xitianqujing.subject.domain.entity.SubjectLabelBO;

import java.util.List;

/**
 * 标签领域服务
 */
public interface SubjectLabelDomainService {
    /**
     * 新增标签
     */
    Boolean add(SubjectLabelBO subjectLableBO);

    /**
     * 更新标签
     */
    Boolean update(SubjectLabelBO subjectLableBO);
    /**
     * 删除标签
     */
    Boolean delete(SubjectLabelBO subjectLableBO);
    /**
     * 查询分类下标签
     */
    List<SubjectLabelBO> queryLableByCategoryId(SubjectLabelBO subjectLableBO);
}

package com.xitianqujing.subject.domain.handler.subject;

import com.xitianqujing.subject.common.enums.IsDeletedFlagEnum;
import com.xitianqujing.subject.common.enums.SubjectInfoTypeEnum;
import com.xitianqujing.subject.domain.convert.BriefSubjectConvert;
import com.xitianqujing.subject.domain.entity.SubjectInfoBO;
import com.xitianqujing.subject.domain.entity.SubjectOptionBO;
import com.xitianqujing.subject.infra.basic.entity.SubjectBrief;
import com.xitianqujing.subject.infra.basic.service.SubjectBriefService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 简单题目的策略类
 */
@Component
public class BriefTypeHandler implements SubjectTypeHandler {

    @Resource
    private SubjectBriefService subjectBriefService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.BRIEF;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        //简答题插入
        SubjectBrief subjectBrief = BriefSubjectConvert.INSTANT.convertBoToEntity(subjectInfoBO);
        subjectBrief.setSubjectId(subjectInfoBO.getId().intValue());
        subjectBrief.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        subjectBriefService.insert(subjectBrief);
    }

    @Override
    public SubjectOptionBO query(int subjectId) {
        SubjectBrief subjectBrief = new SubjectBrief();
        subjectBrief.setSubjectId(subjectId);
        SubjectBrief result = subjectBriefService.queryByCondition(subjectBrief);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setSubjectAnswer(result.getSubjectAnswer());
        return subjectOptionBO;
    }
}

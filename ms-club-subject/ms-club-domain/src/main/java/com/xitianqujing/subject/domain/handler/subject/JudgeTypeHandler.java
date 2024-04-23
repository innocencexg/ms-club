package com.xitianqujing.subject.domain.handler.subject;

import com.xitianqujing.subject.common.enums.IsDeletedFlagEnum;
import com.xitianqujing.subject.common.enums.SubjectInfoTypeEnum;
import com.xitianqujing.subject.domain.convert.JudgeSubjectConvert;
import com.xitianqujing.subject.domain.entity.SubjectAnswerBO;
import com.xitianqujing.subject.domain.entity.SubjectInfoBO;
import com.xitianqujing.subject.domain.entity.SubjectOptionBO;
import com.xitianqujing.subject.infra.basic.entity.SubjectJudge;
import com.xitianqujing.subject.infra.basic.service.SubjectJudgeService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 判断题目的策略类
 */
@Component
public class JudgeTypeHandler implements SubjectTypeHandler {
    @Resource
    private SubjectJudgeService subjectJudgeService;


    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.JUDGE;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        //判断题目的插入
        SubjectJudge subjectJudge = new SubjectJudge();
        SubjectAnswerBO subjectAnswerBO = subjectInfoBO.getOptionList().get(0);
        subjectJudge.setSubjectId(subjectInfoBO.getId());
        subjectJudge.setIsCorrect(subjectAnswerBO.getIsCorrect());
        subjectJudge.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        subjectJudgeService.insert(subjectJudge);
    }

    @Override
    public SubjectOptionBO query(int subjectId) {
        SubjectJudge subjectJudge = new SubjectJudge();
        subjectJudge.setSubjectId((long) subjectId);
        List<SubjectJudge> result = subjectJudgeService.queryByCondition(subjectJudge);
        List<SubjectAnswerBO> subjectAnswerBOList = JudgeSubjectConvert.INSTANT.convertEntityToBoList(result);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setOptionList(subjectAnswerBOList);
        return subjectOptionBO;
    }
}

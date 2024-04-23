package com.xitianqujing.subject.domain.handler.subject;

import com.xitianqujing.subject.common.enums.IsDeletedFlagEnum;
import com.xitianqujing.subject.common.enums.SubjectInfoTypeEnum;
import com.xitianqujing.subject.domain.convert.RadioSubjectConvert;
import com.xitianqujing.subject.domain.entity.SubjectAnswerBO;
import com.xitianqujing.subject.domain.entity.SubjectInfoBO;
import com.xitianqujing.subject.domain.entity.SubjectOptionBO;
import com.xitianqujing.subject.infra.basic.entity.SubjectRadio;
import com.xitianqujing.subject.infra.basic.service.SubjectRadioService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 单选题目的策略类
 */
@Component
public class RadioTypeHandler implements com.xitianqujing.subject.domain.handler.subject.SubjectTypeHandler {

    @Resource
    private SubjectRadioService subjectRadioService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.RADIO;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        //单选题目的插入
        List<SubjectRadio> subjectRadioList = new LinkedList<>();
        subjectInfoBO.getOptionList().forEach(option -> {
            SubjectRadio subjectRadio = RadioSubjectConvert.INSTANT.convertBoToEntity(option);
            subjectRadio.setSubjectId(subjectInfoBO.getId());
            subjectRadio.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
            subjectRadioList.add(subjectRadio);
        });
        subjectRadioService.batchInsert(subjectRadioList);

    }

    @Override
    public SubjectOptionBO query(int subjectId) {
        SubjectRadio subjectRadio = new SubjectRadio();
        subjectRadio.setSubjectId((long) subjectId);
        List<SubjectRadio> result = subjectRadioService.queryByCondition(subjectRadio);
        List<SubjectAnswerBO> subjectAnswerBOList = RadioSubjectConvert.INSTANT.convertEntityToBoList(result);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setOptionList(subjectAnswerBOList);
        return subjectOptionBO;
    }
}

package com.xitianqujing.subject.domain.convert;


import com.xitianqujing.subject.domain.entity.SubjectAnswerBO;
import com.xitianqujing.subject.infra.basic.entity.SubjectRadio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RadioSubjectConvert {
    RadioSubjectConvert INSTANT = Mappers.getMapper(RadioSubjectConvert.class);

    SubjectRadio convertBoToEntity(SubjectAnswerBO subjectAnswerBO);

    List<SubjectAnswerBO> convertEntityToBoList(List<SubjectRadio> subjectRadioList);
}

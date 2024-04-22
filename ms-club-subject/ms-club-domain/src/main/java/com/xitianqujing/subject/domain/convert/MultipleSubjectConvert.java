package com.xitianqujing.subject.domain.convert;


import com.xitianqujing.subject.domain.entity.SubjectAnswerBO;
import com.xitianqujing.subject.infra.basic.entity.SubjectMultiple;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MultipleSubjectConvert {
    MultipleSubjectConvert INSTANT = Mappers.getMapper(MultipleSubjectConvert.class);

    SubjectMultiple convertBoToEntity(SubjectAnswerBO subjectAnswerBO);

    List<SubjectAnswerBO> convertEntityToBoList(List<SubjectMultiple> subjectMultipleList);
}

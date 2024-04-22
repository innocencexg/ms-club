package com.xitianqujing.subject.domain.convert;


import com.xitianqujing.subject.domain.entity.SubjectAnswerBO;
import com.xitianqujing.subject.infra.basic.entity.SubjectJudge;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface JudgeSubjectConvert {
    JudgeSubjectConvert INSTANT = Mappers.getMapper(JudgeSubjectConvert.class);

    List<SubjectAnswerBO>  convertEntityToBoList(List<SubjectJudge> subjectJudgeList);

}

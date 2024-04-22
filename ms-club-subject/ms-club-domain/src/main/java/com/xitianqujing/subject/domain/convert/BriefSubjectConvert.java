package com.xitianqujing.subject.domain.convert;


import com.xitianqujing.subject.domain.entity.SubjectInfoBO;
import com.xitianqujing.subject.infra.basic.entity.SubjectBrief;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BriefSubjectConvert {
    BriefSubjectConvert INSTANT = Mappers.getMapper(BriefSubjectConvert.class);

    SubjectBrief convertBoToEntity(SubjectInfoBO subjectInfoBO);

}

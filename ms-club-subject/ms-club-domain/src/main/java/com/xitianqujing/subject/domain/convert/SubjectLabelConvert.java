package com.xitianqujing.subject.domain.convert;

import com.xitianqujing.subject.domain.entity.SubjectLabelBO;
import com.xitianqujing.subject.infra.basic.entity.SubjectLabel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubjectLabelConvert {

    SubjectLabelConvert INSTANTCE = Mappers.getMapper(SubjectLabelConvert.class);

    SubjectLabel convertBoToLabel(SubjectLabelBO subjectLabelBO);
}

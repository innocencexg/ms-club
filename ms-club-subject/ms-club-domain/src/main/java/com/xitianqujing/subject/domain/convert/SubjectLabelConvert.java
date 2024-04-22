package com.xitianqujing.subject.domain.convert;

import com.xitianqujing.subject.domain.entity.SubjectLabelBO;
import com.xitianqujing.subject.infra.basic.entity.SubjectLabel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectLabelConvert {

    SubjectLabelConvert INSTANT = Mappers.getMapper(SubjectLabelConvert.class);

    SubjectLabel convertBoToLabel(SubjectLabelBO subjectLabelBO);

    List<SubjectLabelBO> convertLabelToBoList(List<SubjectLabel> subjectLabelList);
}

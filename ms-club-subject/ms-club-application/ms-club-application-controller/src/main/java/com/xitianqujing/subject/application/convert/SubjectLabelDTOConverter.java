package com.xitianqujing.subject.application.convert;

import com.xitianqujing.subject.application.dto.SubjectLabelDTO;
import com.xitianqujing.subject.domain.entity.SubjectLabelBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 标签dto的转换
 */
@Mapper
public interface SubjectLabelDTOConverter {

    SubjectLabelDTOConverter INSTANCE = Mappers.getMapper(SubjectLabelDTOConverter.class);

    SubjectLabelBO convertDtoToLabelBO(SubjectLabelDTO subjectLabelDTO);

    SubjectLabelDTO convertBOToLabelDTOList(SubjectLabelBO boList);
    List<SubjectLabelDTO> convertBOToLabelDTOList(List<SubjectLabelBO> boList);
}

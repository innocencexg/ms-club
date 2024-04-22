package com.xitianqujing.subject.application.convert;


import com.xitianqujing.subject.application.dto.SubjectAnswerDTO;
import com.xitianqujing.subject.domain.entity.SubjectAnswerBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectAnswerDTOConvert {
    SubjectAnswerDTOConvert INSTANT = Mappers.getMapper(SubjectAnswerDTOConvert.class);

    SubjectAnswerBO convertDTOToBO(SubjectAnswerDTO subjectAnswerDTO);

    List<SubjectAnswerBO> convertListDTOToBO(List<SubjectAnswerDTO> dtoList);

}

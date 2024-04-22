package com.xitianqujing.subject.application.convert;


import com.xitianqujing.subject.application.dto.SubjectInfoDTO;
import com.xitianqujing.subject.domain.entity.SubjectInfoBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface SubjectInfoDTOConvert {

    SubjectInfoDTOConvert INSTANT = Mappers.getMapper(SubjectInfoDTOConvert.class);

    SubjectInfoBO convertDTOToBO(SubjectInfoDTO subjectInfoDTO);

    SubjectInfoDTO convertBOToDTO(SubjectInfoBO subjectInfoBO);
    List<SubjectInfoDTO> convertBOToDTOList(List<SubjectInfoBO> subjectInfoBO);
}

package com.xitianqujing.subject.application.convert;

import com.xitianqujing.subject.application.dto.CommunicationDTO;
import com.xitianqujing.subject.application.dto.SubjectCategoryDTO;

import com.xitianqujing.subject.domain.entity.CommunicationBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CommunicationDTOConvert {
    CommunicationDTOConvert INSTANT = Mappers.getMapper(CommunicationDTOConvert.class);


    CommunicationBO convertDtoToCommunicationBO(CommunicationDTO communicationDTO);

    CommunicationDTO convertToDTO(CommunicationBO communicationBO1);
}

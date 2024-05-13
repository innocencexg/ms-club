package com.xitianqujing.subject.application.convert;


import com.xitianqujing.subject.application.dto.CommunicationSubDTO;
import com.xitianqujing.subject.domain.entity.CommunicationBO;
import com.xitianqujing.subject.domain.entity.CommunicationSubBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentDTOConvert {

    CommentDTOConvert INSTANCE = Mappers.getMapper(CommentDTOConvert.class);

    CommunicationSubBO communicationSubBO(CommunicationSubDTO communicationSubDTO);

}

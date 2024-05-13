package com.xitianqujing.subject.domain.convert;


import com.xitianqujing.subject.domain.entity.CommunicationBO;
import com.xitianqujing.subject.infra.basic.entity.Communication;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper()
public interface CommunicationConvert {

    CommunicationConvert INSTANCE = Mappers.getMapper(CommunicationConvert.class);

    Communication convertBoToCommunication(CommunicationBO communicationBO);

    List<CommunicationBO> convertListToBO(List<Communication> communicationList);

    CommunicationBO convertToBO(Communication communication1);
}

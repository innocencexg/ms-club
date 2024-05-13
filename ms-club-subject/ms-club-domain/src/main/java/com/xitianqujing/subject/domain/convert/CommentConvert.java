package com.xitianqujing.subject.domain.convert;


import com.xitianqujing.subject.domain.entity.CommunicationSubBO;
import com.xitianqujing.subject.infra.basic.entity.CommunicationSub;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CommentConvert {
    CommentConvert INSTANCE = Mappers.getMapper(CommentConvert.class);

    CommunicationSub convertBoToCommunicationSub(CommunicationSubBO communicationSubBO);

    List<CommunicationSubBO> convertListToBO(List<CommunicationSub> communicationSubList);
}

package com.xitianqujing.subject.domain.service;

import com.xitianqujing.subject.common.entity.PageResult;
import com.xitianqujing.subject.domain.entity.CommunicationBO;
import com.xitianqujing.subject.domain.entity.SubjectInfoBO;
import com.xitianqujing.subject.infra.basic.entity.Communication;


public interface CommunicationDomainService {

    void add(CommunicationBO communicationBO);

    PageResult<CommunicationBO> getCommunicationPage(CommunicationBO communicationBO);

    PageResult<CommunicationBO> getCommunicationByUser(CommunicationBO communicationBO);

    Boolean delete(CommunicationBO communicationBO);

    CommunicationBO getcommunicationdetail(CommunicationBO communicationBO);
}

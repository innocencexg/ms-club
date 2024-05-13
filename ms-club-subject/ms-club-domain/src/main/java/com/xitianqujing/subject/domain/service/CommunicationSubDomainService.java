package com.xitianqujing.subject.domain.service;

import com.xitianqujing.subject.common.entity.PageResult;
import com.xitianqujing.subject.domain.entity.CommunicationSubBO;

public interface CommunicationSubDomainService {
    void add(CommunicationSubBO communicationSubBO);

    PageResult<CommunicationSubBO> getCommentPage(CommunicationSubBO communicationSubBO);

    PageResult<CommunicationSubBO> getCommentByUser(CommunicationSubBO communicationSubBO);

    Boolean deleteComment(CommunicationSubBO communicationSubBO);

}

package com.xitianqujing.subject.infra.basic.service;

import com.xitianqujing.subject.common.entity.PageResult;
import com.xitianqujing.subject.infra.basic.entity.SubjectInfoEs;

public interface SubjectEsService {

    boolean insert(SubjectInfoEs subjectInfoEs);

    PageResult<SubjectInfoEs> querySubjectList(SubjectInfoEs subjectInfoEs);

}


package com.xitianqujing.subject.domain.handler.subject;

import com.xitianqujing.subject.common.enums.SubjectInfoTypeEnum;
import com.xitianqujing.subject.domain.entity.SubjectInfoBO;
import com.xitianqujing.subject.domain.entity.SubjectOptionBO;


public interface SubjectTypeHandler {

    /**
     * 枚举身份识别
     *
     * @return
     */
    SubjectInfoTypeEnum getHandlerType();

    /**
     * 实际的题目插入
     *
     * @param subjectInfoBO
     */
    void add(SubjectInfoBO subjectInfoBO);

    /**
     * 实际的题目插入
     *
     * @param subjectId
     * @return
     */
    SubjectOptionBO query(int subjectId);
}

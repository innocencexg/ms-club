package com.xitianqujing.subject.domain.entity;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 题目bo
 */
@Data
public class SubjectOptionBO implements Serializable {

    /**
     * 题目答案
     */
    private String subjectAnswer;

    /**
     * 答案选项
     */
    private List<com.xitianqujing.subject.domain.entity.SubjectAnswerBO> optionList;


}


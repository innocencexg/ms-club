package com.xitianqujing.practice.server.service;

import com.xitianqujing.practice.api.common.PageResult;
import com.xitianqujing.practice.api.req.GetPracticeSubjectsReq;
import com.xitianqujing.practice.api.req.GetUnCompletePracticeReq;
import com.xitianqujing.practice.api.vo.*;
import com.xitianqujing.practice.server.entity.dto.PracticeSetDTO;
import com.xitianqujing.practice.server.entity.dto.PracticeSubjectDTO;

import java.util.List;

public interface PracticeSetService {
    /**
     * 获取专项练习内容
     */
    List<SpecialPracticeVO> getSpecialPracticeContent();

    /**
     * 开始练习
     */
    PracticeSetVO addPractice(PracticeSubjectDTO dto);
    /**
     * 获取练习题
     */
    PracticeSubjectListVO getSubjects(GetPracticeSubjectsReq req);

    /**
     * 获取题目
     */
    PracticeSubjectVO getPracticeSubject(PracticeSubjectDTO dto);
    /**
     * 获取模拟套题内容
     */
    PageResult<PracticeSetVO> getPreSetContent(PracticeSetDTO dto);




}

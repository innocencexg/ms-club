package com.xitianqujing.practice.server.dao;


import com.xitianqujing.practice.server.entity.dto.PracticeSubjectDTO;
import com.xitianqujing.practice.server.entity.po.SubjectPO;

import java.util.List;

public interface SubjectDao {


    /**
     * 获取练习面试题目
     */
    List<SubjectPO> getPracticeSubject(PracticeSubjectDTO dto);



}

package com.xitianqujing.practice.server.service;

import com.xitianqujing.practice.api.vo.SpecialPracticeVO;

import java.util.List;

public interface PracticeSetService {
    /**
     * 获取专项练习内容
     */
    List<SpecialPracticeVO> getSpecialPracticeContent();

}

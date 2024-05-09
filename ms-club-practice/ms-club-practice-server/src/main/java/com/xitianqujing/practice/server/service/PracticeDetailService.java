package com.xitianqujing.practice.server.service;

import com.xitianqujing.practice.api.req.*;
import com.xitianqujing.practice.api.vo.RankVO;
import com.xitianqujing.practice.api.vo.ReportVO;
import com.xitianqujing.practice.api.vo.ScoreDetailVO;
import com.xitianqujing.practice.api.vo.SubjectDetailVO;

import java.util.List;

public interface PracticeDetailService {
    /**
     * 练习提交题目
     */
    Boolean submitSubject(SubmitSubjectDetailReq req);

    /**
     * 提交练题情况
     */
    Boolean submit(SubmitPracticeDetailReq req);
    /**
     * 每题得分详情
     */
    List<ScoreDetailVO> getScoreDetail(GetScoreDetailReq req);

    /**
     * 获得答案详情
     */
    SubjectDetailVO getSubjectDetail(GetSubjectDetailReq req);

    /**
     * 答案解析-评估报告
     */
    ReportVO getReport(GetReportReq req);
    /**
     * 练习榜
     */
    List<RankVO> getPracticeRankList();

}

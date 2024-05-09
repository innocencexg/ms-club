package com.xitianqujing.practice.server.dao;

import com.xitianqujing.practice.server.entity.po.PracticeDetailPO;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface PracticeDetailDao {



    /**
     * 根据练习id，题目id，查询详情
     */
    PracticeDetailPO selectDetail(@Param("practiceId") Long practiceId,
                                  @Param("subjectId") Long subjectId,
                                  @Param("loginId") String loginId);


}

package com.xitianqujing.practice.server.dao;
import com.xitianqujing.practice.server.entity.po.PracticeSetPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PracticeSetDao {

    /**
     * 新增套题
     */
    int add(PracticeSetPO po);

    PracticeSetPO selectById(Long setId);

    int updateHeat(Long setId);

}

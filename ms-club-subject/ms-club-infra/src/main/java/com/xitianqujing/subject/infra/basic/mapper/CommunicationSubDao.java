package com.xitianqujing.subject.infra.basic.mapper;

import com.xitianqujing.subject.infra.basic.entity.CommunicationSub;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (CommunicationSub)表数据库访问层
 *
 * @author gx
 * @since 2024-05-13 21:00:05
 */
public interface CommunicationSubDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CommunicationSub queryById(Long id);

    /**
     * 统计总行数
     *
     * @param communicationSub 查询条件
     * @return 总行数
     */
    long count(CommunicationSub communicationSub);

    /**
     * 新增数据
     *
     * @param communicationSub 实例对象
     * @return 影响行数
     */
    int insert(CommunicationSub communicationSub);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<CommunicationSub> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<CommunicationSub> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<CommunicationSub> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<CommunicationSub> entities);

    /**
     * 修改数据
     *
     * @param communicationSub 实例对象
     * @return 影响行数
     */
    int update(CommunicationSub communicationSub);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    int countByCondition(@Param("parentId") Long parentId);

    List<CommunicationSub> quertPage(@Param("parentId") Long parentId,
                                     @Param("start") int start,
                                     @Param("pageSize") Integer pageSize);

    List<CommunicationSub> quertPageByUser(@Param("userName") String userName,
                                           @Param("start") int start,
                                           @Param("pageSize") Integer pageSize);
}


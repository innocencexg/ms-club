package com.xitianqujing.subject.infra.basic.mapper;

import com.xitianqujing.subject.infra.basic.entity.Communication;
import com.xitianqujing.subject.infra.basic.entity.SubjectInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Communication)表数据库访问层
 *
 * @author gx
 * @since 2024-05-13 15:25:39
 */
public interface CommunicationDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Communication queryById(Long id);

    /**
     * 统计总行数
     *
     * @param communication 查询条件
     * @return 总行数
     */
    long count(Communication communication);

    /**
     * 新增数据
     *
     * @param communication 实例对象
     * @return 影响行数
     */
    int insert(Communication communication);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Communication> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Communication> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Communication> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Communication> entities);

    /**
     * 修改数据
     *
     * @param communication 实例对象
     * @return 影响行数
     */
    int update(Communication communication);

    /**
     * 通过主键删除数据
     *
     * @param id
     * @return 影响行数
     */
    int deleteByUser(Long id);

    int countByCondition(@Param("communication") Communication communication);


    List<Communication> quertPage(@Param("communication") Communication communication,
                                  @Param("start") int start,
                                  @Param("pageSize") Integer pageSize);

    String querybyUserId(String loginId);

    List<Communication> quertPageByUser(@Param("userName") String userName,
                                        @Param("start") int start,
                                        @Param("pageSize") Integer pageSize);

    String queryurl(String loginId);

    Communication getcommunicationdetail(@Param("id") Long id);
}


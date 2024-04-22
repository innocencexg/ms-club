package com.xitianqujing.subject.infra.basic.service;

import com.xitianqujing.subject.infra.basic.entity.SubjectLabel;

import java.util.List;

/**
 * 题目标签表(SubjectLabel)表服务接口
 *
 * @author makejava
 * @since 2024-03-07 20:33:02
 */
public interface SubjectLabelService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectLabel queryById(Long id);

    /**
     * 新增数据
     *
     * @param subjectLabel 实例对象
     * @return 实例对象
     */
    int insert(SubjectLabel subjectLabel);

    /**
     * 修改数据
     *
     * @param subjectLabel 实例对象
     * @return 实例对象
     */
    int update(SubjectLabel subjectLabel);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 根据id查询标签信息（批量）
     * @param labelIdList
     * @return
     */
    List<SubjectLabel> batchQueryById(List<Long> labelIdList);

    /**
     * 条件查询
     * @param subjectLabel
     * @return
     */
    List<SubjectLabel> queryByCondition(SubjectLabel subjectLabel);
}

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
     * @param subjectLable 实例对象
     * @return 实例对象
     */
    int insert(SubjectLabel subjectLable);

    /**
     * 修改数据
     *
     * @param subjectLable 实例对象
     * @return 实例对象
     */
    int update(SubjectLabel subjectLable);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    List<SubjectLabel> batchQueryById(List<Long> lableIdList);
}

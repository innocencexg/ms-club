package com.xitianqujing.subject.infra.basic.service.impl;

import com.xitianqujing.subject.infra.basic.entity.SubjectLabel;
import com.xitianqujing.subject.infra.basic.mapper.SubjectLabelDao;
import com.xitianqujing.subject.infra.basic.service.SubjectLabelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 题目标签表(SubjectLabel)表服务实现类
 *
 * @author makejava
 * @since 2024-03-07 20:33:02
 */
@Service("subjectLabelService")
public class SubjectLabelServiceImpl implements SubjectLabelService {
    @Resource
    private SubjectLabelDao subjectLabelDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectLabel queryById(Long id) {
        return this.subjectLabelDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param subjectLable 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(SubjectLabel subjectLable) {
        return this.subjectLabelDao.insert(subjectLable);
    }

    /**
     * 修改数据
     *
     * @param subjectLable 实例对象
     * @return 实例对象
     */
    @Override
    public int update(SubjectLabel subjectLable) {
        return this.subjectLabelDao.update(subjectLable);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.subjectLabelDao.deleteById(id) > 0;
    }

    @Override
    public List<SubjectLabel> batchQueryById(List<Long> lableIdList) {
        return this.subjectLabelDao.batchQueryById(lableIdList);
    }
}

package com.xitianqujing.subject.infra.basic.service.impl;

import com.xitianqujing.subject.infra.basic.entity.SubjectInfo;
import com.xitianqujing.subject.infra.basic.mapper.SubjectInfoDao;
import com.xitianqujing.subject.infra.basic.service.SubjectInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 题目信息表(SubjectInfo)表服务实现类
 *
 * @author gx
 * @since 2024-02-14 16:14:20
 */
@Service("subjectInfoService")
public class SubjectInfoServiceImpl implements SubjectInfoService {
    @Resource
    private SubjectInfoDao subjectInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectInfo queryById(Long id) {
        return this.subjectInfoDao.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param subjectInfo 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectInfo insert(SubjectInfo subjectInfo) {
        this.subjectInfoDao.insert(subjectInfo);
        return subjectInfo;
    }

    /**
     * 修改数据
     *
     * @param subjectInfo 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectInfo update(SubjectInfo subjectInfo) {
        this.subjectInfoDao.update(subjectInfo);
        return this.queryById(subjectInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.subjectInfoDao.deleteById(id) > 0;
    }

    /**
     * 分页查询
     * @param subjectInfo
     * @param categoryId
     * @param labelId
     * @return
     */
    @Override
    public int countByCondition(SubjectInfo subjectInfo, Long categoryId, Long labelId) {
        return this.subjectInfoDao.countByCondition(subjectInfo,categoryId,labelId);
    }

    @Override
    public List<SubjectInfo> quertPage(SubjectInfo subjectInfo, Long categoryId, Long labelId, int start, Integer pageSize) {
        return this.subjectInfoDao.quertPage(subjectInfo,categoryId,labelId,start,pageSize);
    }
    @Override
    public List<SubjectInfo> getContributeCount() {
        return this.subjectInfoDao.getContributeCount();
    }

    @Override
    public String getUserName(String nickname){
        return this.subjectInfoDao.getUserName(nickname);
    }

    @Override
    public Long querySubjectIdCursor(Long subjectId, Long categoryId, Long labelId, int cursor) {
        return this.subjectInfoDao.querySubjectIdCursor(subjectId, categoryId, labelId, cursor);
    }

}

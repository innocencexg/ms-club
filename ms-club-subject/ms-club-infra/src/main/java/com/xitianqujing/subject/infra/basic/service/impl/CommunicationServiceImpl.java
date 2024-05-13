package com.xitianqujing.subject.infra.basic.service.impl;

import com.xitianqujing.subject.infra.basic.entity.Communication;
import com.xitianqujing.subject.infra.basic.entity.SubjectInfo;
import com.xitianqujing.subject.infra.basic.mapper.CommunicationDao;
import com.xitianqujing.subject.infra.basic.service.CommunicationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Communication)表服务实现类
 *
 * @author gx
 * @since 2024-05-13 15:25:41
 */
@Service("communicationService")
public class CommunicationServiceImpl implements CommunicationService {
    @Resource
    private CommunicationDao communicationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Communication queryById(Long id) {
        return this.communicationDao.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param communication 实例对象
     * @return 实例对象
     */
    @Override
    public Communication insert(Communication communication) {
        this.communicationDao.insert(communication);
        return communication;
    }

    /**
     * 修改数据
     *
     * @param communication 实例对象
     * @return 实例对象
     */
    @Override
    public Communication update(Communication communication) {
        this.communicationDao.update(communication);
        return this.queryById(communication.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id
     * @return 是否成功
     */
    @Override
    public int deleteByUser(Long id) {
        return this.communicationDao.deleteByUser(id) ;
    }


    @Override
    public int countByCondition(Communication communication) {
        return this.communicationDao.countByCondition(communication);
    }

    @Override
    public List<Communication> quertPage(Communication communication, int start, Integer pageSize) {
        return this.communicationDao.quertPage(communication,start,pageSize);
    }

    @Override
    public String querybyUserId(String loginId) {
        return this.communicationDao.querybyUserId(loginId);
    }

    @Override
    public List<Communication> quertPageByUser(String userName, int start, Integer pageSize) {
        return this.communicationDao.quertPageByUser(userName,start,pageSize);
    }

    @Override
    public String queryurl(String loginId) {
        return this.communicationDao.queryurl(loginId);
    }

    @Override
    public Communication getcommunicationdetail(Long id) {
        return this.communicationDao.getcommunicationdetail(id);
    }
}

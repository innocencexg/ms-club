package com.xitianqujing.subject.infra.basic.service.impl;

import com.xitianqujing.subject.infra.basic.entity.CommunicationSub;
import com.xitianqujing.subject.infra.basic.mapper.CommunicationSubDao;
import com.xitianqujing.subject.infra.basic.service.CommunicationSubService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CommunicationSub)表服务实现类
 *
 * @author gx
 * @since 2024-05-13 21:00:06
 */
@Service("communicationSubService")
public class CommunicationSubServiceImpl implements CommunicationSubService {
    @Resource
    private CommunicationSubDao communicationSubDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public CommunicationSub queryById(Long id) {
        return this.communicationSubDao.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param communicationSub 实例对象
     * @return 实例对象
     */
    @Override
    public CommunicationSub insert(CommunicationSub communicationSub) {
        this.communicationSubDao.insert(communicationSub);
        return communicationSub;
    }

    /**
     * 修改数据
     *
     * @param communicationSub 实例对象
     * @return 实例对象
     */
    @Override
    public CommunicationSub update(CommunicationSub communicationSub) {
        this.communicationSubDao.update(communicationSub);
        return this.queryById(communicationSub.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Long id) {
        return this.communicationSubDao.deleteById(id) ;
    }

    @Override
    public int countByCondition(Long parentId) {
        return this.communicationSubDao.countByCondition(parentId);
    }

    @Override
    public List<CommunicationSub> quertPage(Long parentId, int start, Integer pageSize) {
        return this.communicationSubDao.quertPage(parentId,start,pageSize);
    }

    @Override
    public List<CommunicationSub> quertPageByUser(String userName, int start, Integer pageSize) {
        return this.communicationSubDao.quertPageByUser(userName,start,pageSize);
    }
}

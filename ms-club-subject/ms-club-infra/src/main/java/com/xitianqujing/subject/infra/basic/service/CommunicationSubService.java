package com.xitianqujing.subject.infra.basic.service;

import com.xitianqujing.subject.infra.basic.entity.CommunicationSub;

import java.util.List;

/**
 * (CommunicationSub)表服务接口
 *
 * @author gx
 * @since 2024-05-13 21:00:06
 */
public interface CommunicationSubService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CommunicationSub queryById(Long id);

    /**
     * 新增数据
     *
     * @param communicationSub 实例对象
     * @return 实例对象
     */
    CommunicationSub insert(CommunicationSub communicationSub);

    /**
     * 修改数据
     *
     * @param communicationSub 实例对象
     * @return 实例对象
     */
    CommunicationSub update(CommunicationSub communicationSub);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    int deleteById(Long id);

    int countByCondition(Long parentId);

    List<CommunicationSub> quertPage( Long parentId, int start, Integer pageSize);

    List<CommunicationSub> quertPageByUser(String userName, int start, Integer pageSize);

}

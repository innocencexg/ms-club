package com.xitianqujing.subject.infra.basic.service;

import com.xitianqujing.subject.infra.basic.entity.Communication;
import com.xitianqujing.subject.infra.basic.entity.SubjectInfo;

import java.util.List;

/**
 * (Communication)表服务接口
 *
 * @author gx
 * @since 2024-05-13 15:25:41
 */
public interface CommunicationService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Communication queryById(Long id);

    /**
     * 新增数据
     *
     * @param communication 实例对象
     * @return 实例对象
     */
    Communication insert(Communication communication);

    /**
     * 修改数据
     *
     * @param communication 实例对象
     * @return 实例对象
     */
    Communication update(Communication communication);

    /**
     * 通过主键删除数据
     *
     * @param id 名字
     * @return 是否成功
     */
    int deleteByUser(Long id);

    int countByCondition(Communication communication);

    List<Communication> quertPage(Communication communication,int start, Integer pageSize);

    String querybyUserId(String loginId);

    List<Communication> quertPageByUser(String userName, int start, Integer pageSize);


    String queryurl(String loginId);

    Communication getcommunicationdetail(Long id);
}

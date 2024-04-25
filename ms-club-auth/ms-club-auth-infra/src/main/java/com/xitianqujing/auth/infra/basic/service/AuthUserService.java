package com.xitianqujing.auth.infra.basic.service;

import com.xitianqujing.auth.infra.basic.entity.AuthUser;

import java.util.List;

/**
 * 用户信息表(AuthUser)表服务接口
 */
public interface AuthUserService {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AuthUser queryById(Long id);

    /**
     * 新增数据
     *
     * @param authUser 实例对象
     * @return 实例对象
     */
    Integer insert(AuthUser authUser);

    /**
     * 修改数据
     *
     * @param authUser 实例对象
     * @return 实例对象
     */
    Integer updateByUserName(AuthUser authUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);


    /**
     * 删除数据
     * @param authUser
     * @return
     */
    Integer update(AuthUser authUser);

    List<AuthUser> queryByCondition(AuthUser existAuthUser);
}

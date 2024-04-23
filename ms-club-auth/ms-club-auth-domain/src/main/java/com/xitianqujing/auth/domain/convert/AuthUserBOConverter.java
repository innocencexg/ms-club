package com.xitianqujing.auth.domain.convert;

import com.xitianqujing.auth.domain.entity.AuthUserBO;
import com.xitianqujing.auth.infra.basic.entity.AuthUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Author: gx
 * @CreateTime: 2024/02/26  11:20
 */
@Mapper
public interface AuthUserBOConverter {
    AuthUserBOConverter INSTANCE = Mappers.getMapper(AuthUserBOConverter.class);

    AuthUser convertBOToEntity(AuthUserBO authUserBO);

    AuthUserBO convertEntityToBO(AuthUser authUser);
}

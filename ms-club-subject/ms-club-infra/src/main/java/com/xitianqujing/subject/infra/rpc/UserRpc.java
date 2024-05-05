package com.xitianqujing.subject.infra.rpc;

import com.xitianqujing.auth.api.UserFeignService;
import com.xitianqujing.auth.entity.AuthUserDTO;
import com.xitianqujing.auth.entity.Result;
import com.xitianqujing.subject.infra.entity.UserInfo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: gx
 * @CreateTime: 2024/03/05  15:16
 */
@Component
public class UserRpc {
    @Resource
    private UserFeignService userFeignService;



    public UserInfo getUserInfo(String userName) {
        AuthUserDTO authUserDTO = new AuthUserDTO();
        authUserDTO.setUserName(userName);
        Result<AuthUserDTO> result = userFeignService.getUserInfo(authUserDTO);
        UserInfo userInfo = new UserInfo();
        if (!result.getSuccess()) {
            return userInfo;
        }
        AuthUserDTO data = result.getData();
        userInfo.setUserName(data.getUserName());
        userInfo.setNickName(data.getNickName());
        userInfo.setAvatar(data.getAvatar());
        return userInfo;
    }

}

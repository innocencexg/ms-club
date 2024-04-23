package com.xitianqujing.wx.handler;

import java.util.Map;

/**
 * @Author: gx
 * @CreateTime: 2024/02/26  18:42
 */
public interface WxChatMsgHandler {

    WxChatMsgTypeEnum getMsgType();

    String dealMsg(Map<String, String> messageMap);

}

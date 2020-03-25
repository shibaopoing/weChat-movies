package com.cloud.wechat.movies.security.service.impl;

import com.cloud.wechat.movies.dto.rsp.BaseRsp;
import com.cloud.wechat.movies.security.dto.CheckAuthorDto;
import com.cloud.wechat.movies.security.service.IAuthorTokenCheckService;
import com.cloud.wechat.movies.security.utils.HSDES;

import java.io.UnsupportedEncodingException;

public class AuthorTokenCheckServiceImpl implements IAuthorTokenCheckService {
    @Override
    public BaseRsp checkToken(CheckAuthorDto checkAuthorDto) {
        String channel = checkAuthorDto.getChannel();
        if("weChat".equals(channel)){
            //前端操作校验，用户名，密码，权限等
        }else if("fbi".equals(channel)){
            //渠道请求 校验MAC，url权限
            try {
                HSDES.getBodyMac("");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

package com.cloud.wechat.movies.security.service;

import com.cloud.wechat.movies.dto.rsp.BaseRsp;
import com.cloud.wechat.movies.security.dto.CheckAuthorDto;

public interface IAuthorTokenCheckService {
    public BaseRsp checkToken(CheckAuthorDto checkAuthorDto );
}

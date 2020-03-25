package com.cloud.wechat.movies.security.provider;

import com.cloud.wechat.movies.dto.rsp.BaseRsp;
import com.cloud.wechat.movies.provider.BaseProvider;
import com.cloud.wechat.movies.security.SecurityCommandFeignApi;
import com.cloud.wechat.movies.security.dto.CheckAuthorDto;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorTokenCheckProvider extends BaseProvider implements SecurityCommandFeignApi {
    @Override
    public BaseRsp AuthorTokenCheck(CheckAuthorDto checkAuthorDto) {
        return null;
    }
}

package com.cloud.wechat.movies.security.sentinel;


import com.cloud.wechat.movies.dto.rsp.BaseRsp;
import com.cloud.wechat.movies.security.SecurityCommandFeignApi;
import com.cloud.wechat.movies.security.dto.CheckAuthorDto;
import com.cloud.wechat.movies.sentinel.BaseSentinel;
import org.springframework.stereotype.Component;

@Component
public class SecurityCommandFeignSentinel extends BaseSentinel implements SecurityCommandFeignApi {
    @Override
    public BaseRsp AuthorTokenCheck(CheckAuthorDto checkAuthorDto) {
        return defualt();
    }
}

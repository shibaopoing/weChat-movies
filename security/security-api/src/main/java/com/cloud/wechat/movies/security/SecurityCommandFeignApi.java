package com.cloud.wechat.movies.security;

import com.cloud.wechat.movies.dto.rsp.BaseRsp;
import com.cloud.wechat.movies.security.dto.CheckAuthorDto;
import com.cloud.wechat.movies.security.sentinel.SecurityCommandFeignSentinel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "security-command",fallback = SecurityCommandFeignSentinel.class)
public interface SecurityCommandFeignApi {
    @PostMapping("/author")
    public BaseRsp AuthorToken(CheckAuthorDto checkAuthorDto);
}

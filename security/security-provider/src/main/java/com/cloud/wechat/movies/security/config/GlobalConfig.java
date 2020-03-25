package com.cloud.wechat.movies.security.config;

import com.cloud.wechat.movies.security.exception.CommonExceptionResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalConfig {
    /**
     * 异常配置
     *
     * @param
     */
    @Bean
    public CommonExceptionResolver commonExceptionResolver() {
        CommonExceptionResolver commonExceptionResolver = new CommonExceptionResolver();
        return commonExceptionResolver;
    }

}

package com.cloud.wechat.movies.security.handler;

import com.cloud.wechat.movies.security.constant.ResultCode;
import com.cloud.wechat.movies.security.utils.ResUtil;
import com.cloud.wechat.movies.security.utils.ResponseUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName EntryPointUnauthorizedHandler
 * @Description TODO
 * @Author liuheming
 * @Date 2019/6/10 16:57
 * @Version 1.0
 **/
@Component
public class EntryPointUnauthorizedHandler implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ResponseUtil.out(response, ResUtil.getJsonStr(ResultCode.FORBIDDEN, "请登录后操作"));
    }
}

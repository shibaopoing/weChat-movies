package com.cloud.wechat.movies.security.handler;


import com.cloud.wechat.movies.security.constant.ResultCode;
import com.cloud.wechat.movies.security.utils.ResUtil;
import com.cloud.wechat.movies.security.utils.ResponseUtil;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Exrickx
 */
@Component

public class RestAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException)
            throws IOException, ServletException {
        ResponseUtil.out(response, ResUtil.getJsonStr(ResultCode.FORBIDDEN, "您没有权限"));
    }

}

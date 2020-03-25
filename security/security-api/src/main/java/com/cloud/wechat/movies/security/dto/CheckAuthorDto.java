package com.cloud.wechat.movies.security.dto;

import com.cloud.wechat.movies.dto.req.BaseReq;
import lombok.Data;


import java.io.Serializable;

/**
 * @Author: 石保平
 * @Description: ${description}
 * @Date: 2019/3/16 22:27
 * @Version: 1.0
 */
@Data
public class CheckAuthorDto extends BaseReq implements Serializable {
    private  static final  long serialVersionUID=233120897433423L;
    //@NotBlank(message = "不能为空")
    private String token;
    private String method;
    private String format;
}

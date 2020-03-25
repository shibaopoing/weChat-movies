package com.cloud.wechat.movies.security.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author liuheming
 * @since 2019-05-06
 */
@Data
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户主键
     */
    private String id;

    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 密码
     */
    private String userPwd;

    /**
     * 用户头像地址
     */
    private String faceImage;

    /**
     * 手机号
     */
    private Integer userPhone;

    /**
     * 邮箱
     */
    private String userEmail;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 是否生效
     */
    private String status;


}

package com.cloud.wechat.movies.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.wechat.movies.security.entity.Users;
import com.cloud.wechat.movies.security.pojo.AuthUserPoJo;

/**
 * <p>
 * 用户服务相关接口
 * </p>
 *
 * @author liuheming
 * @since 2019-05-06
 */
public interface IUsersService extends IService<Users> {

    /**
     * @return com.lhm.springcloud.security.pojo.AuthUserPoJo
     * @Author liuheming
     * @Description 通过用户名 查询用户信息 角色列表 权限列表
     * @Date 14:41 2019/5/6
     * @Param [username]
     **/
    AuthUserPoJo findAuthUserByUsername(String username);

}

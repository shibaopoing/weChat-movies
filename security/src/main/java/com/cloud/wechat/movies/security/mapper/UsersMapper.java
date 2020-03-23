package com.cloud.wechat.movies.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.wechat.movies.security.entity.UserInfo;
import com.cloud.wechat.movies.security.pojo.AuthUserPoJo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author security
 * @since 2019-05-06
 */
public interface UsersMapper extends BaseMapper<UserInfo> {

    /**
        * @Author liuheming
        * @Description 通过用户名 查询用户信息 角色列表 权限列表
        * @Date 14:39 2019/5/6
        * @Param [username]
        * @return com.lhm.springcloud.security.pojo.AuthUserPoJo
     **/
    AuthUserPoJo findAuthUserByUsername(@Param("userName") String username);
}

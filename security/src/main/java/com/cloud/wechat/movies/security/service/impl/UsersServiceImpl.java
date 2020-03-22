package com.cloud.wechat.movies.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.wechat.movies.security.entity.Users;
import com.cloud.wechat.movies.security.mapper.UsersMapper;
import com.cloud.wechat.movies.security.pojo.AuthUserPoJo;
import com.cloud.wechat.movies.security.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author liuheming
 * @since 2019-05-06
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public AuthUserPoJo findAuthUserByUsername(String username) {
        return usersMapper.findAuthUserByUsername(username);
    }
}

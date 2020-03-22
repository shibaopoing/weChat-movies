package com.cloud.wechat.movies.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.wechat.movies.security.entity.MapUserRole;
import com.cloud.wechat.movies.security.mapper.MapUserRoleMapper;
import com.cloud.wechat.movies.security.service.IMapUserRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author security
 * @since 2019-05-06
 */
@Service
public class MapUserRoleServiceImpl extends ServiceImpl<MapUserRoleMapper, MapUserRole> implements IMapUserRoleService {

}

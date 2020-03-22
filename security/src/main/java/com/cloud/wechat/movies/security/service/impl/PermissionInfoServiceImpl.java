package com.cloud.wechat.movies.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.wechat.movies.security.entity.PermissionInfo;
import com.cloud.wechat.movies.security.mapper.PermissionInfoMapper;
import com.cloud.wechat.movies.security.service.IPermissionInfoService;
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
public class PermissionInfoServiceImpl extends ServiceImpl<PermissionInfoMapper, PermissionInfo> implements IPermissionInfoService {

}

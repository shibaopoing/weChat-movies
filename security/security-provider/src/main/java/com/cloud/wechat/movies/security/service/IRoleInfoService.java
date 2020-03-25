package com.cloud.wechat.movies.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.wechat.movies.security.entity.RoleInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author security
 * @since 2019-05-06
 */
public interface IRoleInfoService extends IService<RoleInfo> {
    public List<RoleInfo> findRoleInfoAndPermission();
}

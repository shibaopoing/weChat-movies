package com.cloud.wechat.movies.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.wechat.movies.security.entity.RoleInfo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author security
 * @since 2019-05-06
 */
public interface RoleInfoMapper extends BaseMapper<RoleInfo> {

    /**
     * @Author liuheming
     * @Description 查询全部角色及对应权限
     * @Date 16:31 2019/6/13
     * @Param
     * @return
     **/
    List<RoleInfo> findRoleInfoAndPermission();
}

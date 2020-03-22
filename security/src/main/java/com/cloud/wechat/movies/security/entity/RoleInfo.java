package com.cloud.wechat.movies.security.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author security
 * @since 2019-05-06
 */
@Data
public class RoleInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
    private String id;

    /**
     * 角色名
     */
    private String name;

    private String createBy;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    private String updateBy;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 角色等级  从小到大  1大于2
     */
    private Integer roleLevel;

    /**
     * 启用'ENABLE'      关闭'DISABLE'
     */
    private String status;

    /**
     * 角色说明
     */
    private String description;

    /**
     * 角色权限
     */
    @TableField(exist = false)
    private List<PermissionInfo> permissionInfos;

}

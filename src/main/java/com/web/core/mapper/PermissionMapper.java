package com.web.core.mapper;

import com.web.core.pojo.Permission;

import java.util.List;

public interface PermissionMapper {

    /**
     * 根据角色名获取权限
     * @param roleId
     * @return
     */
    List<Permission> queryByRoleId(int roleId);
}

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


    /**
     * 给角色添加权限
     * @param roleId
     * @param potence
     */
    void addPermission(int roleId,String potence);


    /**
     * 删除某角色的权限
     * @param roleId
     * @param potence
     */
    void delPermission(int roleId,String potence);
}

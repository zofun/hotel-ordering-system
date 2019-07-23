package com.web.core.mapper;

import com.web.core.pojo.Permission;
import com.web.core.pojo.Role;
import com.web.core.pojo.User;

import java.util.List;

/**
 * @author TCW
 */
public interface ShiroMapper {
    /**
     * 根据账号获取用户
     * @param username
     * @return UserPojo
     */
    User getUserByUserName(String username);

    /**
     * 根据角色id获取该账号的权限
     * @param roleId
     * @return List
     */
    List<Permission> getPermissionsByRoleId(int roleId);

    /**
     * 根据userId获取角色
     * @param id
     * @return Role
     */
    Role getUserRoleByUserId(int id);
}

package com.web.core.service;

import com.web.core.pojo.Permission;
import com.web.core.pojo.Role;
import com.web.core.pojo.User;

import java.util.List;

public interface ShiroService {
    /**
     * 根据账号获取用户
     * @param username
     * @return UserPojo
     */
    User getUserByUserName(String username);


    /**
     * 根据账号获取该账号的权限
     *
     * @param user
     * @return List
     */
    List<Permission> getPermissionsByUser(User user);

    /**
     * 根据用户id获取角色
     * @param id
     * @return
     */
    Role getRoleByUserId(int id);
}

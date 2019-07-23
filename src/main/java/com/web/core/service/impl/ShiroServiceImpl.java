package com.web.core.service.impl;

import com.web.core.mapper.ShiroMapper;
import com.web.core.pojo.Permission;
import com.web.core.pojo.Role;
import com.web.core.pojo.User;
import com.web.core.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShiroServiceImpl implements ShiroService {

    @Autowired
    private ShiroMapper shiroMapper;
    @Override
    public User getUserByUserName(String username) {

        User user = shiroMapper.getUserByUserName(username);
        return user;
    }

    @Override
    public List<Permission> getPermissionsByUser(User user) {
        Role role = shiroMapper.getUserRoleByUserId(user.getId());
        List<Permission> permissions = shiroMapper.getPermissionsByRoleId(role.getId());
        return permissions;
    }

    @Override
    public Role getRoleByUserId(int id) {
        Role role = shiroMapper.getUserRoleByUserId(id);
        return role;
    }
}

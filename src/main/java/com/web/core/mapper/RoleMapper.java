package com.web.core.mapper;

import com.web.core.pojo.Role;
import com.web.core.pojo.RoleInfo;

import java.util.List;

public interface RoleMapper {

    /**
     * 查询所有的角色
     * @return
     */
    List<Role> queryAllRole();
}

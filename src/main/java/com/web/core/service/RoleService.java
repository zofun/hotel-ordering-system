package com.web.core.service;

import com.web.core.pojo.RoleInfo;

import java.util.List;

public interface RoleService {

    /**
     * 获取角色
     * @return
     */
    List<RoleInfo> getRoleList();
}
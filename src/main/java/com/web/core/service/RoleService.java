package com.web.core.service;

import com.web.core.pojo.RoleInfo;

import java.util.List;

public interface RoleService {

    /**
     * 获取角色
     * @return
     */
   String getRoleList(int page,int limit);


    /**
     * 修改角色的权限
     * @param roleId
     * @param permission
     * @param status
     */
   void changeRolesPermission(int roleId,String permission,String status);


    /**
     * 添加角色，具体权限后续分配
     * @param roleName
     * @param roleMsg
     */
   void addRole(String roleName,String roleMsg);
}

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


    /**
     * 获取用户角色列表
     * @param page
     * @param limit
     * @return
     */
   String getUserRoleList(int page,int limit);


    /**
     * 获取所有的角色
     * @return
     */
   String getAllRole();


    /**
     * 更改用户角色
     * @param userId
     * @param roleId

     */
    void changeRole(int userId,int roleId);
}

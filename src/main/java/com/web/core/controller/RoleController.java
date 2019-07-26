package com.web.core.controller;


import com.web.core.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.faces.event.PostPutFlashValueEvent;

@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "getRoleInfo",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getRoleInfo(int page,int limit){
        String json=roleService.getRoleList(page,limit);
        return json;
    }

    /**
     * 修改权限
     * @param roleId
     * @param permission
     * @param status
     * @return
     */
    @RequestMapping("changeRolesPermission")
    @ResponseBody
    public String changeRolesPermission(int roleId,String permission,String status){

        roleService.changeRolesPermission(roleId,permission,status);
        return "1";
    }


    @RequestMapping(value = "addRole",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String addRole(String roleName,String roleMsg){
        roleService.addRole(roleName,roleMsg);
        return "1";
    }


    @RequestMapping(value = "getUserRoleList",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getUserRoleList(int page,int limit){

        String json = roleService.getUserRoleList(page, limit);
        return json;
    }

    /**
     * 获取所有角色列表
     * @return
     */
    @RequestMapping(value = "getAllRole",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getAllRole(){
        return roleService.getAllRole();
    }

    @RequestMapping(value = "changeRole",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String changeRole(int userId,int roleId){

        roleService.changeRole(userId,roleId);
        return "1";
    }
}

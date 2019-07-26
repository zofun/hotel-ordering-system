package com.web.core.service.impl;

import com.web.core.mapper.PermissionMapper;
import com.web.core.mapper.RoleMapper;
import com.web.core.mapper.UserMapper;
import com.web.core.pojo.Permission;
import com.web.core.pojo.Role;
import com.web.core.pojo.RoleInfo;
import com.web.core.pojo.UserRoleInfo;
import com.web.core.service.RoleService;
import com.web.utils.ConvertToJson;
import com.web.utils.ConvertToRoleInfoUtil;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionMapper permissionMapper;


    @Autowired
    private UserMapper userMapper;

    @Override
    public String getRoleList(int page,int limit) {

        List<Role> roles = roleMapper.queryAllRole((page-1)*limit,limit);
        int count=roleMapper.queryRoleCount();
        List<RoleInfo> infos=new LinkedList<>();
        for (Role r:roles){
            List<Permission> permissions = permissionMapper.queryByRoleId(r.getId());
            RoleInfo info = ConvertToRoleInfoUtil.convertToRoleInfo(r, permissions);
            System.out.println("info--->"+info.toString());
            infos.add(info);
        }


        Map<String,Object> result=new HashMap<>();
        result.put("code","0");
        result.put("msg","角色表");
        result.put("data",infos);
        result.put("count",count);
        ObjectMapper mapper=new ObjectMapper();
        try {
            String json=mapper.writeValueAsString(result);
            return json;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }



    }



    @Override
    public void changeRolesPermission(int roleId, String permission, String status) {
            if ("true".equals(status)){
                permissionMapper.addPermission(roleId,permission);
            }else {
                permissionMapper.delPermission(roleId,permission);
            }

    }

    @Override
    public void addRole(String roleName, String roleMsg) {
        roleMapper.insertRole(roleName,roleMsg);
    }

    @Override
    public String getUserRoleList(int page, int limit) {

        List<UserRoleInfo> roleInfos = userMapper.queryUserRoleInfoList((page - 1) * limit, limit);
        int count=userMapper.queryAdminCount();
        String json = ConvertToJson.toDataTableJson("0", "权限分配表", count, roleInfos);

        return json;
    }

    @Override
    public String getAllRole()  {
        List<Role> roles = roleMapper.queryAll();
        Map<String,List<Role>>  result=new HashMap<>();
        result.put("roleList",roles);
        ObjectMapper mapper=new ObjectMapper();
        try {
            return mapper.writeValueAsString(result);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

    }

    @Override
    public void changeRole(int userId, int roleId) {
        userMapper.updateRole(userId,roleId);

    }
}

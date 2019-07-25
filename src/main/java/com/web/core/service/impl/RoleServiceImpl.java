package com.web.core.service.impl;

import com.web.core.mapper.PermissionMapper;
import com.web.core.mapper.RoleMapper;
import com.web.core.pojo.Permission;
import com.web.core.pojo.Role;
import com.web.core.pojo.RoleInfo;
import com.web.core.service.RoleService;
import com.web.utils.ConvertToRoleInfoUtil;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

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
}

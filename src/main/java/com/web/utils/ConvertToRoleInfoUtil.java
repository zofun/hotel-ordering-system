package com.web.utils;

import com.web.core.pojo.Permission;
import com.web.core.pojo.Role;
import com.web.core.pojo.RoleInfo;

import java.util.List;

public class ConvertToRoleInfoUtil {


    /**
     * 将角色和其对应的权限列表转换为适用于前端的RoleInfo类型
     * 代码写成这样实在是，都怪数据库没搞好( ఠൠఠ )ﾉ
     * @param role
     * @param permissions
     * @return
     */
    public static RoleInfo convertToRoleInfo(Role role, List<Permission> permissions){
        RoleInfo roleInfo=new RoleInfo();
        roleInfo.setId(role.getId());
        roleInfo.setRoleName(role.getRoleName());
        roleInfo.setRoleMsg(role.getRoleMsg());

        for (Permission p:permissions){
            switch (p.getPotence()){
                case "readRoomType": {
                    roleInfo.setReadRoomType("true");
                    break;
                }
                case "manRoomType":{
                    roleInfo.setManRoomType("true");
                    break;
                }
                case "readRoom":{
                    roleInfo.setReadRoom("true");
                    break;
                }
                case "manRoom":{
                    roleInfo.setManRoom("true");
                    break;
                }

                case "readSignIn":{
                    roleInfo.setReadSignIn("true");
                    break;
                }

                case "manSignIn":{
                    roleInfo.setManSignIn("true");
                    break;
                }
                case "manRole":{
                    roleInfo.setManRole("true");
                    break;
                }

                case "roleAllo":{
                    roleInfo.setRoleAllo("true");
                    break;
                }
                case "readService":{
                    roleInfo.setReadService("true");
                    break;
                }
                case "manService":{
                    roleInfo.setManService("true");
                    break;
                }

                default:{
                    break;
                }

            }
        }

        return roleInfo;

    }
}

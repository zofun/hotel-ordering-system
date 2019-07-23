package com.web.core.shiro;

import com.web.core.pojo.Permission;
import com.web.core.pojo.User;
import com.web.core.service.ShiroService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.List;


/**
 * @author TCW
 */
public class MyShiroReaml extends AuthorizingRealm {


    private ShiroService shiroService;

    /**
     * 授权管理
     *
     * @param pc
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
        //获得user对象
        User user = (User) pc.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if (user != null) {
            //添加角色角色信息
            info.addRole(shiroService.getRoleByUserId(user.getId()).getRoleName());
            List<Permission> permissionsByUser = shiroService.getPermissionsByUser(user);
            if (permissionsByUser.size() != 0) {
                for (Permission p : permissionsByUser) {
                    //添加权限信息
                    info.addStringPermission(p.getPotence());
                }
                return info;
            }
        }
        return null;
    }

    /**
     * 认证管理
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获得用户输入的用户名,这个对象就是login()传递过来的，将它强转以取出封装的用户名
        UsernamePasswordToken usernameToken = (UsernamePasswordToken) token;
        String userName = usernameToken.getUsername();

        User user = shiroService.getUserByUserName(userName);

        if (user == null){
            //用户不存在，返回null
            return null;
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(), "");

    }

    public ShiroService getShiroService() {
        return shiroService;
    }

    public void setShiroService(ShiroService shiroService) {
        this.shiroService = shiroService;
    }


}

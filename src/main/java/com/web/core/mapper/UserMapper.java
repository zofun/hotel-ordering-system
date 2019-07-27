package com.web.core.mapper;

import com.web.core.pojo.User;
import com.web.core.pojo.UserRoleInfo;

import javax.management.Query;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserMapper {

    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return
     */
    User selectUserByUsername(String username);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User selectUserById(int id);

    /**
     * 插入用户
     * @param user
     */
    void insertUser(User user);

    /**
     * 根据登录名查询盐值
     * @param username
     * @return
     */
    String selectSaltByUsername(String username);


    /**
     * 判断username是否可用
     * @param username 用户名
     * @return
     */
    int selectCountByUsername(String username);

    /**
     * 查询UserRoleInfo列表
     * @param begin
     * @param limit
     * @return
     */
    List<UserRoleInfo> queryUserRoleInfoList(int begin,int limit);

    /**
     * 查询用户的数量
     * @return
     */
    int queryAdminCount();

    /**
     * 更改角色
     */
    void updateRole(int usedId,int roleId);

    /**
     * 更改密码
     * @param username
     * @param password
     * @param salt
     */
    void changePwd(String username,String password,String salt);

    /**
     * 修改用户的名字
     * @param id
     * @param username
     */
    void changeUserNmae(int id,String username);
}

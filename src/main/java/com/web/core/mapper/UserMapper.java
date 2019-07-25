package com.web.core.mapper;

import com.web.core.pojo.User;

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
     * 改变密码
     * @param user
     * @param passward
     */
    void changePwd(User user, String passward);
}

package com.web.core.service;

import com.web.core.pojo.User;

import javax.servlet.http.HttpSession;

public interface UserService{

    /**
     *
     * @param user
     * @return
     */
    boolean register(User user);

    /**
     * 登录功能
     * @param user
     * @param session
     * @return
     */
    boolean login(User user, HttpSession session);


    /**
     * 修改用户密码
     * @param user
     * @return
     */
    void changePwd(User user,String password);

}

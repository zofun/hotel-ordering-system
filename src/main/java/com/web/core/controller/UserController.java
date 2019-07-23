package com.web.core.controller;


import com.web.core.pojo.User;
import com.web.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 用户注册功能
     * @param user
     * @return
     */
    @RequestMapping("register")
    @ResponseBody
    public String register(User user){


        if (userService.register(user)){
            return "1";
        }

        return "0";
    }
}

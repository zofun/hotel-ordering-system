package com.web.core.controller;


import com.web.core.pojo.User;
import com.web.core.service.UserService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;

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
    public String register(User user,HttpSession session){
        /*从前端得到验证码，并且判断是否与产生的相等*/
        if(session.getAttribute("captcha")==session.getAttribute("vcode")) {
            if(userService.login(user,session)){
                return "1";
            }else{
                return "0";
            }
        }
        return "0";
    }


    @RequestMapping("login")
    @ResponseBody
    public String login(User user, HttpSession session){
        if(session.getAttribute("captcha")==session.getAttribute("vcode")) {
            if (userService.login(user, session)) {
                return "1";
            }
        }
        return "0";
    }


    @RequestMapping(value = "getUserInfo",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getUserInfo(HttpSession session){
        User user = (User)session.getAttribute("User");
        if(user!=null){
            ObjectMapper mapper=new ObjectMapper();
            try {
                String json=mapper.writeValueAsString(user);
                return json;
            } catch (IOException e) {
                e.printStackTrace();
                return "error";
            }
        }

        return "error";
    }
}

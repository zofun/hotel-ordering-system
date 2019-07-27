package com.web.core.controller;


import com.web.core.mapper.UserMapper;
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


    @Autowired
    private UserMapper userMapper;

    /**
     * 用户注册功能
     * @param user
     * @return
     */
    @RequestMapping("register")
    @ResponseBody
    public String register(User user,String captcha,HttpSession session){
        /*从前端得到验证码，并且判断是否与产生的相等*/
        String str = session.getAttribute("vcode").toString();
        System.out.println(str);
        System.out.println(captcha);
        if(str.equals(captcha)) {
            System.out.println("验证码正确！！");
            if(userService.register(user)){
                System.out.println("可以进行注册！！！");
                return "1";
            }else{
                return "2";
            }
        }else{
            return "0";
        }
    }


    @RequestMapping("login")
    @ResponseBody
    public String login(User user,String captcha, HttpSession session){
        String str = session.getAttribute("vcode").toString();

        if(str.equals(captcha)) {

            if (userService.login(user, session)) {

                return "1";
            }
        }else {
            return "2";
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

    @RequestMapping(value = "forgot")
    @ResponseBody
    public String changePwd(User user,String newpassword,String captcha,HttpSession session){
        String str = session.getAttribute("vcode").toString();
        System.out.println(str);
        System.out.println(captcha);
        if(str.equals(captcha)) {
            userService.changePwd(user,newpassword);
            return "1";
        }
        return "0";
    }

    @RequestMapping(value = "changePwd")
    @ResponseBody
    public String changePwd(String username,String password){
        User user = userMapper.selectUserByUsername(username);
        if(user == null){
            return "0";
        }else{
           userService.changePwd(user,password);
           return "1";
        }
    }

    @RequestMapping(value = "changeUserPwd")
    @ResponseBody
    public String changeUserPwd(String username,String password,String captcha, HttpSession session){
        String str = session.getAttribute("vcode").toString();
        User user = userMapper.selectUserByUsername(username);
        if(str.equals(captcha)){
            if(user!=null){
                userService.changePwd(user,password);
                return "1";
            }else{
                return "0";
            }
        }else{
            return "2";
        }
    }

    @RequestMapping(value = "changeUserName")
    @ResponseBody
    public String changeUserName(int id,String username){
        if(id == 0){
            return "0";
        }else{
            String str = userService.changeUserName(id,username);
            if(str == "0"){
                return "2";
            }else{
                return "1";
            }
        }
    }
}

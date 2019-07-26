package com.web.core.controller;

import com.web.core.pojo.User;
import com.web.core.service.OrderSerive;
import com.web.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Auther: http://www.tanwei.com
 * @Date: 2019/7/26
 * @Description: com.web.core.controller
 * @versio: 1.0
 */
@Controller
public class OrderController {
    @Autowired
    private OrderSerive orderSerive;

    @RequestMapping(value = "getAllOrder",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getAllOrder(){
        String json = orderSerive.getAllOrder();
        return json;
    }

    @RequestMapping(value = "getUserOrder",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getUserOrder(HttpSession session){
        User user = (User) session.getAttribute("User");
        String json = orderSerive.getUserOrder(user.getId());
        return json;
    }
}
package com.web.core.controller;

import com.web.core.pojo.Order;
import com.web.core.pojo.User;
import com.web.core.service.OrderSerive;
import com.web.core.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.net.ssl.HttpsURLConnection;
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





    @RequiresAuthentication
    @RequestMapping(value = "getAllOrder",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getAllOrder(){
        String json = orderSerive.getAllOrder();
        return json;
    }


    @RequiresAuthentication
    @RequestMapping(value = "getUserOrder",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getUserOrder(HttpSession session){
        User user = (User) session.getAttribute("User");
        String json = orderSerive.getUserOrder(user.getId());
        return json;
    }

    /**
     * 下订单
     * @param session
     * @param roomTypeId
     * @param time
     * @return
     */
    @RequestMapping(value = "makeOrder",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String MakeOrder(HttpSession session,int roomTypeId,String time){
        User user=(User)session.getAttribute("User");
        if(user==null){
            return "2";
        }
        if(orderSerive.MakeOrder(user.getId(),roomTypeId,time)){
            return "1";
        }

        return "0";
    }

    @RequestMapping(value = "delorderbyorderId")
    @ResponseBody
    public String delOrderByOrderId(int id){
        Order order = orderSerive.queryOrderByOrderId(id);
        if(order!=null){
            return "1";
        }
        return "0";
    }
}

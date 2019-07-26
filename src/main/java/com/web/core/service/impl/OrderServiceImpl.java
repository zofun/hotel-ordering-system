package com.web.core.service.impl;

import com.web.core.mapper.OrderMapper;
import com.web.core.mapper.UserMapper;
import com.web.core.pojo.Order;
import com.web.core.pojo.OrderInfo;
import com.web.core.pojo.User;
import com.web.core.service.OrderSerive;
import com.web.core.service.UserService;
import org.aspectj.weaver.ast.Or;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: http://www.tanwei.com
 * @Date: 2019/7/24
 * @Description: com.web.core.service.impl
 * @versio: 1.0
 */
@Service
public class OrderServiceImpl implements OrderSerive {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public String  getUserOrder(Integer userid) {

        List<OrderInfo> orders = orderMapper.getUserOrder(userid);
        int count = orderMapper.qurryUserOrderCount(userid);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",orders);
        ObjectMapper mapper=new ObjectMapper();
        try {
            String json=mapper.writeValueAsString(map);
            return json;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }


    @Override
    public String  getAllOrder() {
        List<OrderInfo> orders = orderMapper.getAllOrder();
        int count=orderMapper.qurryAllOrderCount();
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",orders);

        ObjectMapper mapper=new ObjectMapper();
        try {
            String json=mapper.writeValueAsString(map);
            return json;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public String addUserOrder(Integer userid) {
        return null;
    }

    @Override
    public void delete(String username) {
        User user = userMapper.selectUserByUsername(username);

    }
}

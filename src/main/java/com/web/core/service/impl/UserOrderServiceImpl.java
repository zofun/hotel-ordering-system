package com.web.core.service.impl;

import com.web.core.mapper.UserOrderMapper;
import com.web.core.pojo.Order;
import com.web.core.service.UserOrderSerive;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

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
public class UserOrderServiceImpl implements UserOrderSerive {
    @Autowired
    private UserOrderMapper userOrderMapper;

    @Override
    public String getAllOrder(Integer userid) {

        List<Order> orders = userOrderMapper.getAllOrder(userid);
        Map<String,List<Order>> map = new HashMap<>();
        map.put("orderList",orders);
        ObjectMapper mapper=new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(map);
            return json;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }


    @Override
    public Order addUserOrder(Integer userid) {
        return null;
    }
}

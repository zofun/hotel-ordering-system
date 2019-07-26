package com.web.core.service;

import com.web.core.pojo.Order;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: http://www.tanwei.com
 * @Date: 2019/7/24
 * @Description: com.web.core.service
 * @versio: 1.0
 */
public interface OrderSerive {
    /**
     * 用户得到自己的订单
     * @param userid
     * @return
     */
    String getUserOrder(Integer userid);

    /**
     * 获取所有的订单，用json返回
     * @return
     */
    String getAllOrder();

    /**
     * 用户创建订单
     * @param userid
     * @return
     */
    String addUserOrder(Integer userid);

    /**
     * 删除订单
     * @param username
     */
    void delete(String username);
}


package com.web.core.mapper;

import com.web.core.pojo.Order;

import java.util.List;

/**
 * @Auther: http://www.tanwei.com
 * @Date: 2019/7/24
 * @Description: com.web.core.mapper
 * @versio: 1.0
 */
public interface UserOrderMapper {
    /**
     * 用户获取自己的订单消息
     * @param userid
     * @return
     */
    List<Order> getAllOrder(Integer userid);

    /**
     * 用户创建订单
     * @param userid
     */
    void addUserOrder(Integer userid);
}

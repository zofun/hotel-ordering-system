package com.web.core.service;

import com.web.core.pojo.Order;

/**
 * @Auther: http://www.tanwei.com
 * @Date: 2019/7/24
 * @Description: com.web.core.service
 * @versio: 1.0
 */
public interface UserOrderSerive {
    /**
     * 用户得到自己的订单
     * @param userid
     * @return
     */
    String getAllOrder(Integer userid);

    Order addUserOrder(Integer userid);
}


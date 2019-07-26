package com.web.core.mapper;

import com.web.core.pojo.Order;
import com.web.core.pojo.OrderInfo;

import java.util.List;

/**
 * @Auther: http://www.tanwei.com
 * @Date: 2019/7/24
 * @Description: com.web.core.mapper
 * @versio: 1.0
 */
public interface OrderMapper {

    /**
     * 用户获取自己的订单消息
     * @param userid
     * @return
     */
    List<OrderInfo> getUserOrder(Integer userid);

    /**
     * 用户获取自己的订单总数
     * @param userid
     * @return
     */
    int qurryUserOrderCount(int userid);




    /**
     * 查询所有的订单
     * @return
     */
    List<OrderInfo> getAllOrder();

    /**
     * 获取总的订单数
     * @return
     */
    int qurryAllOrderCount();


    /**
     * 用户创建订单
     * @param userid
     */
    void addUserOrder(Integer userid);

    void deleteOrder(Integer userid);


    /**
     * 根据订单的id查询订单
     * @param id
     * @return
     */
    Order queryOrderByOrderId(int id);


    /**
     * 更新指定id的订单的状态
     * @param id
     * @param status
     */
    void updateOrderInfoByOrderId(int id,String status);

    /**
     * 查询订单的单价
     * @param orderId
     * @return
     */
    String queryOrderPrice(int orderId);

    /**
     * 删除指定的订单
     * @param orderId
     */
    void delOrderByOrderId(int orderId);



}
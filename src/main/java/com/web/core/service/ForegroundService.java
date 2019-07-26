package com.web.core.service;


import org.springframework.stereotype.Service;




public interface ForegroundService {


    /**
     * 指定分店获取信息
     * @param subbranch
     * @return
     */
    String getUserCheckInInfo(int subbranch,int page,int limit);


    /**
     * 使用模糊查询搜索前台入住信息
     * @param subbranch
     * @param name
     * @param page
     * @param limit
     * @return
     */
    String searchUserCheckInInfo(int subbranch,String name,int page,int limit);


    /**
     * 入住
     * @param orderId
     * @return
     */
    boolean checkIn(int orderId);
}

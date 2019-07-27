package com.web.core.service;

public interface ViewService {

    /**
     * 获取推荐房型的列表
     * @return
     */
    String getTipsList();


    /**
     * 获取所有的房间类型
     * @param page
     * @param limit
     * @return
     */
    String  getAllRoomType(int page,int limit);


    /**
     * 获取房型的数量
     * @return
     */
    int getRoomTypeCount();
}

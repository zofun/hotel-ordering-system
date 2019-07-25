package com.web.core.service;

import com.web.core.pojo.Room;

public interface RoomService {

    /**
     * 查询指定分店的房间列表
     * @param page
     * @param limit
     * @param subbranchId
     * @return
     */
    String getRoomList(int page,int limit,int subbranchId);


    /**
     * 添加新的房间
     * @param room
     * @return
     */
    boolean addRoom(Room room);
}

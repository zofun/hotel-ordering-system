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

    /**
     * 更改房间的开闭状态
     * @param id
     * @param status
     * @return
     */
    void closeOrOpenRoom(int id,String status);

    /**
     * 根据传来的roomNO查询room的id
     * @param roomNo
     * @return
     */
    int qurryRoomByRoomNo(String roomNo);
}

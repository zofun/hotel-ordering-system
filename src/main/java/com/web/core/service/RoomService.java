package com.web.core.service;

public interface RoomService {

    /**
     * 查询指定分店的房间列表
     * @param page
     * @param limit
     * @param subbranchId
     * @return
     */
    String getRoomList(int page,int limit,int subbranchId);
}

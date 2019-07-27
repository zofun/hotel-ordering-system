package com.web.core.mapper;


import com.web.core.pojo.Room;
import com.web.core.pojo.RoomInfo;

import java.util.List;

public interface RoomMapper {

    /**
     * 查询指定
     * @param begin
     * @param limit
     * @param subBranchId
     * @return
     */
    List<RoomInfo> queryRoomList(int begin,int limit,int subBranchId );


    /**
     * 查询指定分店的房间总数
     * @param subBranchId
     * @return
     */
    int queryRoomNumOfSubBranch(int subBranchId);


    /**
     * 查询指定门牌号指定房间类型的房间的数量
     * 用于判断是否存在门牌号重复的现象
     * @param roomNo
     * @param roomTypeId
     * @return
     */
    int queryByRoomNo(String roomNo,int roomTypeId);

    /**
     * 插入新的房间
     * @param room
     */
    void insertRoom(Room room);

    /**
     * 更改房间的状态
     * @param id
     * @param status
     */
    void updateRoomStatus(int id,String status);

    /**
     * 根据roomNO查询该room
     * @param roomNo
     * @return
     */
    Room qurryRoomByRoomNo(String roomNo);


    /**
     * 根据房间类型查询所有的房间
     * @param roomTypeId
     * @return
     */
    List<Room> querytRoomByType(int roomTypeId);
}

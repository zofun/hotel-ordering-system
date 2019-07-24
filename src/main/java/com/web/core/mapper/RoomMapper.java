package com.web.core.mapper;


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
}

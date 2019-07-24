package com.web.core.mapper;

import com.web.core.pojo.RoomTypeInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomTypeMapper {


    /**
     * 查询所有的房间类型信息
     * @return
     */
    List<RoomTypeInfo> queryRoomTypeList(int page,int limit);


    /**
     * 获取房间类型的总数
     * @return
     */
    int queryRoomTypeCount();

    /**
     * 更改room_type信息
     * @param info
     */
    void updateRoomTypeInfo(@Param("homeTypeInfo") RoomTypeInfo homeTypeInfo);


}

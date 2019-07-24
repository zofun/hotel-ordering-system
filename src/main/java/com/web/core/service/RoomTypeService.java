package com.web.core.service;

import com.web.core.pojo.RoomType;
import com.web.core.pojo.RoomTypeInfo;

import java.io.IOException;

/**
 * @author TCW
 */
public interface RoomTypeService {

    /**
     * 获取房间类型列表
     * @return 返回json格式的数据
     */
    String getRoomTypeList(int page,int limit);


    /**
     * 更新roomTypeInfo中的部分字段
     * 只更新 capacity price desc
     * @param info
     */
    void updateRoomTypeInfo(RoomTypeInfo info);


    /**
     * 修改指定的房型的推荐状态
     * @param id
     * @param value
     */
    void changeRecommendStatus(int id,String value);


    /**
     * 创建新的房间类型
     * @param roomType
     */
    void addRoomType(RoomType roomType);

}

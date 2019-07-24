package com.web.core.service;

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
}

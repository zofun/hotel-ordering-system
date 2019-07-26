package com.web.core.mapper;

import com.web.core.pojo.Hotel;

import java.util.List;

public interface HotelMapper {

    /**
     * 获取所有的酒店
     * @return
     */
    List<Hotel> queryAll();


}

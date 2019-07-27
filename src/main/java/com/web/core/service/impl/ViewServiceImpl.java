package com.web.core.service.impl;

import com.web.core.mapper.RoomTypeMapper;
import com.web.core.pojo.TipInfo;
import com.web.core.service.RoomTypeService;
import com.web.core.service.ViewService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ViewServiceImpl implements ViewService {


    @Autowired
    private RoomTypeMapper roomTypeMapper;

    @Override
    public String getTipsList() {
        List<TipInfo> infos = roomTypeMapper.queryByRecommendStatus();

        Map<String,List<TipInfo>> result=new HashMap<>();
        result.put("tipList",infos);
        ObjectMapper mapper=new ObjectMapper();
        try {
            return mapper.writeValueAsString(result);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public String getAllRoomType(int page, int limit) {
        List<TipInfo> infos = roomTypeMapper.queryAllHote((page - 1) * limit, limit);
        Map<String,List<TipInfo>> result=new HashMap<>();
        result.put("tipList",infos);
        ObjectMapper mapper=new ObjectMapper();
        try {
            return mapper.writeValueAsString(result);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public int getRoomTypeCount() {
        return  roomTypeMapper.queryCount();

    }
}

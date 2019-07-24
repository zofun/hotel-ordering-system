package com.web.core.service.impl;

import com.web.core.mapper.RoomMapper;
import com.web.core.pojo.RoomInfo;
import com.web.core.service.RoomService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;


    @Override
    public String getRoomList(int page, int limit, int subbranchId) {

        List<RoomInfo> infos = roomMapper.queryRoomList((page - 1) * limit, limit, subbranchId);
        int count=roomMapper.queryRoomNumOfSubBranch(subbranchId);
        Map<String,Object> result=new HashMap<>();
        ObjectMapper mapper=new ObjectMapper();
        result.put("code","0");
        result.put("msg","房间列表");
        result.put("count",count);
        try {
            result.put("data",infos);
            String json = mapper.writeValueAsString(result);
            return json;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

    }
}

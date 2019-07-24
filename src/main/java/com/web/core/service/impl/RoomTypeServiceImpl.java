package com.web.core.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.web.core.mapper.RoomTypeMapper;
import com.web.core.pojo.RoomTypeInfo;
import com.web.core.service.RoomTypeService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author TCW
 */
@Service
public class RoomTypeServiceImpl implements RoomTypeService {

    @Autowired
    private RoomTypeMapper roomTypeMapper;

    /**
     * "code": 0,
     * 	"msg": "",
     * 	"count":
     * 	data
     * @return
     */
    @Override
    public String getRoomTypeList(int page,int limit){

        List<RoomTypeInfo> infos = roomTypeMapper.queryRoomTypeList((page-1)*limit,limit);
        int count=roomTypeMapper.queryRoomTypeCount();
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",infos);

        ObjectMapper mapper=new ObjectMapper();
        try {
            String json=mapper.writeValueAsString(map);
            return json;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

    }

    @Override
    public void updateRoomTypeInfo(RoomTypeInfo info) {
        roomTypeMapper.updateRoomTypeInfo(info);
    }

    @Override
    public void changeRecommendStatus(int id, String value) {
        if ("true".equals(value)){
            roomTypeMapper.updateRecommend(id,"1");
        }else {
            roomTypeMapper.updateRecommend(id,"0");
        }
    }
}

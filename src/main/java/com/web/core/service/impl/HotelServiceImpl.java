package com.web.core.service.impl;

import com.web.core.mapper.HotelMapper;
import com.web.core.pojo.Hotel;
import com.web.core.service.HotelService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelMapper hotelMapper;

    @Override
    public String getHotelList() {

        List<Hotel> hotels = hotelMapper.queryAll();
        Map<String,List<Hotel>> map=new HashMap<>();
        map.put("hotelList",hotels);
        ObjectMapper mapper=new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(map);
            return json;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

    }
}

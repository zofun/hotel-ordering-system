package com.web.core.controller;


import com.web.core.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("hotel")
@Controller
public class HotelContorller {
    @Autowired
    private HotelService hotelService;

    @RequestMapping(value = "queryAllHotel",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String queryAllHotel(){
        String json=hotelService.getHotelList();
        return json;
    }
}

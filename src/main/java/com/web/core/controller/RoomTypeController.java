package com.web.core.controller;


import com.web.core.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("roomType")
public class RoomTypeController {

    @Autowired
    private RoomTypeService roomTypeService;


    @RequestMapping(value = "gerRoomTypeList",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getRoomTypeList(int page,int limit){
       String json= roomTypeService.getRoomTypeList(page,limit);
       return json;
    }

}

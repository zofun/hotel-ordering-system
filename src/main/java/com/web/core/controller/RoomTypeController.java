package com.web.core.controller;


import com.web.core.pojo.RoomTypeInfo;
import com.web.core.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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



    @RequestMapping(value = "changeRoomTypeInfo",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String changeRoomTypeInfo(@RequestBody RoomTypeInfo info){

       roomTypeService.updateRoomTypeInfo(info);
       return "1";
    }


    @RequestMapping(value = "changeRecommendStatus",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String changeRecommendStatus(int id,String status){

        roomTypeService.changeRecommendStatus(id,status);
        return "1";
    }

}

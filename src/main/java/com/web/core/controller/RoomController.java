package com.web.core.controller;


import com.web.core.pojo.Room;
import com.web.core.service.HotelService;
import com.web.core.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author TCW
 */
@RequestMapping("room")
@Controller
public class RoomController {


    @Autowired
    private RoomService roomService;

    @RequestMapping("getRoomList")
    @ResponseBody
    public String getRoomList(int page,int limit,int subbranchId){

        String json = roomService.getRoomList(page, limit, subbranchId);
        System.out.println(json);
        return json;
    }


    /**
     * 添加房间
     * @param room
     * @return
     */
    @RequestMapping(value = "addRoom",produces = "application/json;charset=utf-8")
    @ResponseBody
    public  String addRoom(Room room){

        if(roomService.addRoom(room)){
            return "1";
        }
        return "0";
    }

}

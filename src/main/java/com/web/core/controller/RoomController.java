package com.web.core.controller;


import com.web.core.pojo.Room;
import com.web.core.service.HotelService;
import com.web.core.service.RoomService;
import jdk.net.SocketFlow;
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


    /**
     * 更改房间的状态
     * @param id
     * @param status
     * @return
     */
    @RequestMapping("changeRoomStatus")
    @ResponseBody
    public String changeRoomStatus(int id,String status){
        roomService.closeOrOpenRoom(id,status);
        return "1";
    }

}

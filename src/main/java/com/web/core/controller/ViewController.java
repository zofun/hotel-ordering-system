package com.web.core.controller;


import com.web.core.service.RoomTypeService;
import com.web.core.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("view")
public class ViewController {

    @Autowired
    private ViewService viewService;

    @RequestMapping(value = "getTipsList",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getTipsList(){
        return viewService.getTipsList();
    }


    @RequestMapping(value = "getAllRoomType",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String  getAllRoomType(int page,int limit,Integer minPrice,Integer maxPrice,Integer capacity){

        return viewService.getAllRoomType(page,limit);
    }


    /**
     * 查询房型的数量
     * @return
     */
    @RequestMapping(value = "getRoomTypeCount",produces = "application/json;charset=utf-8")
    @ResponseBody
    public int getRoomTypeCount(){

        return viewService.getRoomTypeCount();

    }

}

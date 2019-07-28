package com.web.core.controller;


import com.web.core.pojo.RoomType;
import com.web.core.pojo.RoomTypeInfo;
import com.web.core.service.RoomTypeService;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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


    /**
     * 获取房间类型表的数据
     * @param page
     * @param limit
     * @return
     */
    @RequiresAuthentication
    @RequiresPermissions("readRoomType")
    @RequestMapping(value = "gerRoomTypeList",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getRoomTypeList(int page,int limit){
       String json= roomTypeService.getRoomTypeList(page,limit);
       return json;
    }


    /**
     * 修改房间类型的信息
     * @param info
     * @return
     */
    @RequiresAuthentication
    @RequiresPermissions("manRoomType")
    @RequestMapping(value = "changeRoomTypeInfo",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String changeRoomTypeInfo(@RequestBody RoomTypeInfo info){

       roomTypeService.updateRoomTypeInfo(info);
       return "1";
    }


    /**
     * 更改房型的推荐状态
     * @param id
     * @param status
     * @return
     */
    @RequiresAuthentication
    @RequiresPermissions("manRoomType")
    @RequestMapping(value = "changeRecommendStatus",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String changeRecommendStatus(int id,String status){

        roomTypeService.changeRecommendStatus(id,status);
        return "1";
    }


    /**
     * 添加房间类型
     * @param roomType
     * @return
     */
    @RequiresAuthentication
    @RequiresPermissions("manRoomType")
    @ResponseBody
    @RequestMapping("addRoomType")
    public String addRoomType(RoomType roomType){
        roomTypeService.addRoomType(roomType);
        return "1";
    }


    /**
     * 获取指定分店的房型列表
     * @return
     */
    @RequiresAuthentication
    @RequestMapping(value = "getRoomTypeOfSubbranch",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getRoomTypeOfSubbranch(int subbranchId){

        String json=roomTypeService.getRoomTypeOfSubbranch(subbranchId);
        System.out.println("json--->"+json);

        return json;

    }

}

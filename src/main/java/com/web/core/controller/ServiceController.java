package com.web.core.controller;


import com.web.core.mapper.ServiceMapper;
import com.web.core.service.RoomService;
import com.web.core.service.ServiceManService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("service")
public class ServiceController {
    @Autowired
    private ServiceManService serviceManService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private ServiceMapper serviceMapper;

    @RequiresAuthentication
    @RequiresPermissions("readService")
    @RequestMapping(value = "getServiceInfoList",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getServiceInfo(int page,int limit,int subbranchId){
        String json = serviceManService.getServiceInfoList(page,limit,subbranchId);
        return json;
    }

    @RequiresAuthentication
    @RequiresPermissions("manService")
    @RequestMapping(value = "changeServiceStatus",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String changeServiceStatus(int id,String status){

        serviceManService.changeServiceStatus(id,status);
        return "1";
    }


    @RequiresAuthentication
    @RequestMapping(value = "addservice",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String addService(String roomNo,String serviceMsg){

        int roomid = roomService.qurryRoomByRoomNo(roomNo);
        if(roomid!=0){
            serviceMapper.addService(roomid,serviceMsg);
            return "1";
        }
        return "0";
    }

}

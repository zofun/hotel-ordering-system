package com.web.core.controller;


import com.web.core.service.ForegroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("foreground")
public class ForegroundController {


    @Autowired
    private ForegroundService foregroundService;

    /**
     * 前台获取用户信息
     * @param subbranchId
     * @return
     */
    @RequestMapping(value = "getUserCheckInInfoList",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getUserCheckInInfoList(int page,int limit,int subbranchId,String name){
        String json;
        if(name==null){
             json= foregroundService.getUserCheckInInfo(subbranchId,page,limit);
            return json;
        }else {

            json=foregroundService.searchUserCheckInInfo(subbranchId,name,page,limit);
            return json;
        }

    }

    @RequestMapping(value = "checkIn",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String checkIn(int orderId){
        if(foregroundService.checkIn(orderId)){
            return "1";
        }
        return "0";

    }

    /**
     * 退房
     * @param orderId
     * @return
     */
    @RequestMapping("checkOut")
    @ResponseBody
    public String checkOut(int orderId){

        return foregroundService.checkOut(orderId);
    }
}

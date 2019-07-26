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
}

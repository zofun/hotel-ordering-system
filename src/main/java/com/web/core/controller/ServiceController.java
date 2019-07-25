package com.web.core.controller;


import com.web.core.service.ServiceManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("service")
public class ServiceController {
    @Autowired
    private ServiceManService serviceManService;


    @RequestMapping(value = "getServiceInfoList",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getServiceInfo(int page,int limit,int subbranchId){
        String json = serviceManService.getServiceInfoList(page,limit,subbranchId);
        return json;
    }

    @RequestMapping(value = "changeServiceStatus",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String changeServiceStatus(int id,String status){

        serviceManService.changeServiceStatus(id,status);
        return "1";
    }


}

package com.web.core.controller;


import com.web.core.service.OverviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("overview")
public class OverviewController {

    @Autowired
    private OverviewService overviewService;

    @RequestMapping(value = "getData",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getTodaysData(){
        return overviewService.getData();
    }

    @RequestMapping(value = "getChartsData",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getChartsData(){

       return overviewService.getChartsData();

    }
}

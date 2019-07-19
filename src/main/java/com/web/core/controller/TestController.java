package com.web.core.controller;

import com.web.core.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {


    @Autowired
    TestService testService;

    @RequestMapping("getdate")
    @ResponseBody
    public String getDate(int page,int limit){
        String json=testService.getDate(page,limit);
        return json;
    }
}

package com.web.core.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("view")
public class ViewController {

    @RequestMapping("getTipsList")
    @ResponseBody
    public String getTipsList(){
        //获取推荐列表
        return "";
    }

}

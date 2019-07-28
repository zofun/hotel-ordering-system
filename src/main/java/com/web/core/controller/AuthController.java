package com.web.core.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {

    @RequestMapping("noAuth")
    public String noAuth(){
        return "error";
    }
}

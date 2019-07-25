package com.web.core.controller;


import com.web.core.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "getRoleInfo",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getRoleInfo(int page,int limit){
        String json=roleService.getRoleList(page,limit);
        return json;
    }
}

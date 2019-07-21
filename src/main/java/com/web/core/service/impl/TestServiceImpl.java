package com.web.core.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.web.core.mapper.UserMapper;
import com.web.core.pojo.User;
import com.web.core.service.TestService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TestServiceImpl  implements TestService {

    @Autowired
    UserMapper userMapper;


    @Override
    public void test() {
        System.out.println("方法执行");
    }

    @Override
    public String getDate(int page, int limit) {
        int start=(page-1)*limit;
        List<User> list = userMapper.queryAll(start, limit);

        JsonObject json=new JsonObject();
        json.addProperty("code",0);
        json.addProperty("msg","");
        json.addProperty("count",13);
        JsonArray jsonArray=new JsonArray();
         JsonObject jo;
        for (User u:list){
            jo=new JsonObject();
            jo.addProperty("id",u.getId());
            jo.addProperty("username",u.getAccount());
            jo.addProperty("password",u.getPassword());
            jsonArray.add(jo);
            jo=null;

        }
        json.add("data",jsonArray);
        System.out.println(json.toString());

        return json.toString();
    }
}

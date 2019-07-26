package com.web.utils;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertToJson {

    public static String toDataTableJson(String code, String msg, int count,List data){
        Map<String,Object> result=new HashMap<>();
        result.put("code",code);
        result.put("msg",msg);
        result.put("data",data);
        result.put("count",count);
        ObjectMapper mapper=new ObjectMapper();
        try {
            return mapper.writeValueAsString(result);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}

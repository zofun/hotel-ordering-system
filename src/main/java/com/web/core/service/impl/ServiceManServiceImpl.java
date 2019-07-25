package com.web.core.service.impl;

import com.web.core.mapper.ServiceMapper;
import com.web.core.pojo.ServiceInfo;
import com.web.core.service.ServiceManService;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServiceManServiceImpl implements ServiceManService {

    @Autowired
    private ServiceMapper serviceMapper;

    @Override
    public String getServiceInfoList(int page,int limit,int subbranchId) {

        List<ServiceInfo> infos = serviceMapper.queryServiceInfoOfSubbranch((page-1)*limit,limit,subbranchId);
        int count=serviceMapper.queryServiceCountOfSubbranch(subbranchId);
        Map<String,Object> result=new HashMap<>();
        result.put("data",infos);
        result.put("count",count);
        result.put("code",0);
        result.put("msg","特定分店的服务表");
        ObjectMapper mapper=new ObjectMapper();
        //更改时间解析方式
        mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleDateFormat myDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.getSerializationConfig().setDateFormat(myDateFormat);
        try {
           String json= mapper.writeValueAsString(result);
           return json;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public void changeServiceStatus(int id,String status){
        if ("true".equals(status)){
            serviceMapper.updateServiceStatus(id,"已处理");
        }else{
            serviceMapper.updateServiceStatus(id,"未处理");
        }
    }
}

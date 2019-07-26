package com.web.core.service.impl;

import com.web.core.mapper.StatisticsMapper;
import com.web.core.pojo.Statistics;
import com.web.core.service.OverviewService;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class OverviewServiceImpl implements OverviewService {


    @Autowired
    private StatisticsMapper statisticsMapper;


    @Override
    public String getData() {

        Statistics sta = statisticsMapper.query();
        ObjectMapper mapper=new ObjectMapper();
        try {
            return mapper.writeValueAsString(sta);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

    }

    @Override
    public String getChartsData() {
        List<Statistics> list = statisticsMapper.queryChartsDate();
        ObjectMapper mapper=new ObjectMapper();
        //更改时间解析方式
        mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleDateFormat myDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        mapper.getSerializationConfig().setDateFormat(myDateFormat);

        try {
            return mapper.writeValueAsString(list);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

    }
}

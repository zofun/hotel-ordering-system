package com.web.core.service.impl;

import com.web.core.mapper.ForegroundMapper;
import com.web.core.mapper.OrderMapper;
import com.web.core.pojo.Order;
import com.web.core.pojo.UserCheckInInfo;
import com.web.core.service.ForegroundService;
import com.web.utils.ConvertToJson;
import com.web.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ForegroundServiceImpl implements ForegroundService {

    @Autowired
    private ForegroundMapper foregroundMapper;

    @Autowired
    private OrderMapper orderMapper;



    @Override
    public String getUserCheckInInfo(int subbranch,int page,int limit) {
        int count=foregroundMapper.queryCountBySubbranch(subbranch);
        List<UserCheckInInfo> infos = foregroundMapper.queryBySubbranchId(subbranch,(page-1)*limit,limit);
        String json = ConvertToJson.toDataTableJson("0", "前台信息表", count, infos);
        return json;
    }

    @Override
    public String searchUserCheckInInfo(int subbranch, String name, int page, int limit) {

        int count =foregroundMapper.searchCount(subbranch,name);
        List<UserCheckInInfo> infos = foregroundMapper.searchByName(subbranch, (page - 1) * limit, limit, name);
        String json=ConvertToJson.toDataTableJson("0","前台信息表",count,infos);
        return json;
    }

    @Override
    public boolean checkIn(int orderId) {

        Order order = orderMapper.queryOrderByOrderId(orderId);
        String now= TimeUtils.getNowTime("yyyy-MM-dd");
        System.out.println("now"+now);
        System.out.println(TimeUtils.convertTime(order.getTime(),"yyyy-MM-dd"));
        if (now.equals(TimeUtils.convertTime(order.getTime(),"yyyy-MM-dd"))){
            orderMapper.updateOrderInfoByOrderId(orderId,"已入住");
            return true;
        }

        return false;
    }
}

package com.web.core.service.impl;

import com.web.core.mapper.ForegroundMapper;
import com.web.core.pojo.UserCheckInInfo;
import com.web.core.service.ForegroundService;
import com.web.utils.ConvertToJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ForegroundServiceImpl implements ForegroundService {

    @Autowired
    private ForegroundMapper foregroundMapper;



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
}

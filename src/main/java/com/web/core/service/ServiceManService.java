package com.web.core.service;

import com.web.core.pojo.ServiceInfo;

import java.util.List;

/**
 * 用户服务管理相关
 */
public interface ServiceManService {


    /**
     * 根据分店id获取服务信息列表
     * @param subbranchId
     * @return
     */
    String getServiceInfoList(int page,int limit,int subbranchId);

    /**
     * 更改服务的状态
     * @param id
     * @param status
     */
    void changeServiceStatus(int id,String status);
}

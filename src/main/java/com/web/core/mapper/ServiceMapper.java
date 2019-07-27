package com.web.core.mapper;

import com.web.core.pojo.ServiceInfo;

import java.util.List;

public interface ServiceMapper {


    /**
     * 查询指定分店的所有服务信息
     * @param subbranchId
     * @return
     */
    List<ServiceInfo> queryServiceInfoOfSubbranch(int begin,int limit,int subbranchId);

    /**
     * 查询指定的分店的服务订单的总数
     * @param subbranchId
     * @return
     */
    int queryServiceCountOfSubbranch(int subbranchId);

    /**
     * 更新服务的状态
     * @param id
     * @param status
     */
    void updateServiceStatus(int id,String status);

    /**
     * 用户呼叫服务
     * @param roomId
     * @param serviceType
     */
    void addService(int roomId,String serviceType);
}

package com.web.core.mapper;

import com.web.core.pojo.UserCheckInInfo;

import java.util.List;

public interface ForegroundMapper {

    /**
     * 查询指定的分店的所有前台信息
     * @param subbranch
     * @return
     */
    List<UserCheckInInfo> queryBySubbranchId(int subbranch,int begin,int limit);


    /**
     * 获取指定分店的前台信息总数
     * @param subbranch
     * @return
     */
    int queryCountBySubbranch(int subbranch);


    /**
     * 模糊搜索
     * @param subbranch
     * @param begin
     * @param limit
     * @param name
     * @return
     */
    List<UserCheckInInfo> searchByName(int subbranch,int begin,int limit,String name);

    /**
     * 查询满足搜索条件的记录的数量
     * @param subbranch
     * @param name
     * @return
     */
    int searchCount(int subbranch,String name);
}

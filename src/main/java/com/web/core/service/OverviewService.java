package com.web.core.service;

public interface OverviewService {


    /**
     * 获取当天的数据
     * @return
     */
    String getData();


    /**
     * 查询统计表信息
     * @return
     */
    String getChartsData();

}

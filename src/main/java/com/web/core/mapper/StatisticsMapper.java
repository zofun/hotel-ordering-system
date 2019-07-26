package com.web.core.mapper;


import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowProcessListStatement;
import com.web.core.pojo.Statistics;

import java.util.List;

public interface StatisticsMapper {

    /**
     * 查询当天的信息
     * @return
     */
    Statistics query();

    /**
     * 查询7天统计信息
     * @return
     */
    List<Statistics> queryChartsDate();
}

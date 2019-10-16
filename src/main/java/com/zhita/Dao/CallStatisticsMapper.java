package com.zhita.Dao;

import com.zhita.Model.CallStatistics;

public interface CallStatisticsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CallStatistics record);

    int insertSelective(CallStatistics record);

    CallStatistics selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CallStatistics record);

    int updateByPrimaryKey(CallStatistics record);
}
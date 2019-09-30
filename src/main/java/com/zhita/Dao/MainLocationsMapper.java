package com.zhita.Dao;

import com.zhita.Model.MainLocations;

public interface MainLocationsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MainLocations record);

    int insertSelective(MainLocations record);

    MainLocations selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MainLocations record);

    int updateByPrimaryKey(MainLocations record);
}
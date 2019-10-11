package com.zhita.Dao;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Param;

import com.zhita.Model.MainLocations;

public interface MainLocationsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MainLocations record);

    int insertSelective(MainLocations record);

    MainLocations selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MainLocations record);

    int updateByPrimaryKey(MainLocations record);

	void setmainLocations(@Param("location")String location,@Param("percent") BigDecimal percent,@Param("id") int id);
}
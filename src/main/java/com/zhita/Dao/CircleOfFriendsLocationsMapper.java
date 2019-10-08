package com.zhita.Dao;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Param;

import com.zhita.Model.CircleOfFriendsLocations;

public interface CircleOfFriendsLocationsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CircleOfFriendsLocations record);

    int insertSelective(CircleOfFriendsLocations record);

    CircleOfFriendsLocations selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CircleOfFriendsLocations record);

    int updateByPrimaryKey(CircleOfFriendsLocations record);

	void setcircleOfFriendsLocations(@Param("location")String location,@Param("percent") BigDecimal percent);
}
package com.zhita.Dao;

import com.zhita.Model.CircleOfFriendsLocations;

public interface CircleOfFriendsLocationsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CircleOfFriendsLocations record);

    int insertSelective(CircleOfFriendsLocations record);

    CircleOfFriendsLocations selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CircleOfFriendsLocations record);

    int updateByPrimaryKey(CircleOfFriendsLocations record);
}
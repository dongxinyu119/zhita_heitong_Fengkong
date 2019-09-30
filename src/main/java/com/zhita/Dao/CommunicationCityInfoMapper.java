package com.zhita.Dao;

import java.util.List;

import com.zhita.Model.CommunicationCityInfo;

public interface CommunicationCityInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommunicationCityInfo record);

    int insertSelective(CommunicationCityInfo record);

    CommunicationCityInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommunicationCityInfo record);

    int updateByPrimaryKey(CommunicationCityInfo record);
    
    //列表查询——通话区域分布(省级)表
    List<CommunicationCityInfo> queryAll(Integer userid);
}
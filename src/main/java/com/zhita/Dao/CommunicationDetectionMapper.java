package com.zhita.Dao;

import java.util.List;

import com.zhita.Model.CommunicationDetection;

public interface CommunicationDetectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommunicationDetection record);

    int insertSelective(CommunicationDetection record);

    CommunicationDetection selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommunicationDetection record);

    int updateByPrimaryKey(CommunicationDetection record);
    
    //列表查询——通信检测
    List<CommunicationDetection> queryAll(Integer userid);
}
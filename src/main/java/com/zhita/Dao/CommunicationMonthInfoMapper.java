package com.zhita.Dao;

import java.util.List;

import com.zhita.Model.CommunicationMonthInfo;

public interface CommunicationMonthInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommunicationMonthInfo record);

    int insertSelective(CommunicationMonthInfo record);

    CommunicationMonthInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommunicationMonthInfo record);

    int updateByPrimaryKey(CommunicationMonthInfo record);
    
    //列表查询——通话月份分布
    List<CommunicationMonthInfo> queryAll(Integer userid);
}
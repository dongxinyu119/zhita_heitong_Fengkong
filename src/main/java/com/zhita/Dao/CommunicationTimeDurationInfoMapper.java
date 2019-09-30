package com.zhita.Dao;

import java.util.List;

import com.zhita.Model.CommunicationTimeDurationInfo;

public interface CommunicationTimeDurationInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommunicationTimeDurationInfo record);

    int insertSelective(CommunicationTimeDurationInfo record);

    CommunicationTimeDurationInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommunicationTimeDurationInfo record);

    int updateByPrimaryKey(CommunicationTimeDurationInfo record);
    
    //列表差——通话时长分布表
    List<CommunicationTimeDurationInfo> queryAll(Integer userid);
}
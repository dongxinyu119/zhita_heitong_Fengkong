package com.zhita.Dao;

import java.util.List;

import com.zhita.Model.RechargeInfo;

public interface RechargeInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RechargeInfo record);

    int insertSelective(RechargeInfo record);

    RechargeInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RechargeInfo record);

    int updateByPrimaryKey(RechargeInfo record);
    
    //列表查询——充值记录
    List<RechargeInfo> queryAll(Integer userid);
}
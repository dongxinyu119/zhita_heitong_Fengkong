package com.zhita.Dao;

import java.util.List;

import com.zhita.Model.OperatorInfo;

public interface OperatorInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OperatorInfo record);

    int insertSelective(OperatorInfo record);

    OperatorInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OperatorInfo record);

    int updateByPrimaryKey(OperatorInfo record);
    
    //查询列表——运营商基本信息
    List<OperatorInfo> queryAll(Integer userid);
}
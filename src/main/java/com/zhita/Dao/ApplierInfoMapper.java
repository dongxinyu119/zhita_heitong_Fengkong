package com.zhita.Dao;

import java.util.List;

import com.zhita.Model.ApplierInfo;

public interface ApplierInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApplierInfo record);

    int insertSelective(ApplierInfo record);

    ApplierInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ApplierInfo record);

    int updateByPrimaryKey(ApplierInfo record);
    
    //列表查询——申请人基本信息
    List<ApplierInfo> queryAll(Integer userid);
}
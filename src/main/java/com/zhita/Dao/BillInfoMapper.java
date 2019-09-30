package com.zhita.Dao;

import java.util.List;

import com.zhita.Model.BillInfo;

public interface BillInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BillInfo record);

    int insertSelective(BillInfo record);

    BillInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BillInfo record);

    int updateByPrimaryKey(BillInfo record);
    
    //列表查询——消费记录
    List<BillInfo> queryAll(Integer userid);
}
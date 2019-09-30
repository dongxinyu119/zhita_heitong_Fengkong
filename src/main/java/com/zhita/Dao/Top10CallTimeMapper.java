package com.zhita.Dao;

import java.util.List;

import com.zhita.Model.Top10CallTime;

public interface Top10CallTimeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Top10CallTime record);

    int insertSelective(Top10CallTime record);

    Top10CallTime selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Top10CallTime record);

    int updateByPrimaryKey(Top10CallTime record);
    
    //列表查询——通话总时长前10 表
    List<Top10CallTime> queryAll(Integer userid);
}
package com.zhita.Dao;

import com.zhita.Model.CallRecordListItemInfos;

public interface CallRecordListItemInfosMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CallRecordListItemInfos record);

    int insertSelective(CallRecordListItemInfos record);

    CallRecordListItemInfos selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CallRecordListItemInfos record);

    int updateByPrimaryKey(CallRecordListItemInfos record);
    
}
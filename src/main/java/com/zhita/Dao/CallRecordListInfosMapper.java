package com.zhita.Dao;

import com.zhita.Model.CallRecordListInfos;

public interface CallRecordListInfosMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CallRecordListInfos record);

    int insertSelective(CallRecordListInfos record);

    CallRecordListInfos selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CallRecordListInfos record);

    int updateByPrimaryKey(CallRecordListInfos record);
}
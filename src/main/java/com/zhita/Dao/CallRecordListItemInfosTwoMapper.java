package com.zhita.Dao;

import com.zhita.Model.CallRecordListItemInfosTwo;

public interface CallRecordListItemInfosTwoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CallRecordListItemInfosTwo record);

    int insertSelective(CallRecordListItemInfosTwo record);

    CallRecordListItemInfosTwo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CallRecordListItemInfosTwo record);

    int updateByPrimaryKey(CallRecordListItemInfosTwo record);
}
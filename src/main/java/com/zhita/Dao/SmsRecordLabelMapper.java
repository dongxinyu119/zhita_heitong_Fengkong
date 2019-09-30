package com.zhita.Dao;

import com.zhita.Model.SmsRecordLabel;

public interface SmsRecordLabelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SmsRecordLabel record);

    int insertSelective(SmsRecordLabel record);

    SmsRecordLabel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SmsRecordLabel record);

    int updateByPrimaryKey(SmsRecordLabel record);
}
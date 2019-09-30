package com.zhita.Dao;

import com.zhita.Model.SensitiveInfoNew;

public interface SensitiveInfoNewMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SensitiveInfoNew record);

    int insertSelective(SensitiveInfoNew record);

    SensitiveInfoNew selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SensitiveInfoNew record);

    int updateByPrimaryKey(SensitiveInfoNew record);
}
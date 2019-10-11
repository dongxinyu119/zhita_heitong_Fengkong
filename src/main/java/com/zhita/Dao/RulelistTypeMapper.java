package com.zhita.Dao;

import com.zhita.Model.RulelistType;

public interface RulelistTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RulelistType record);

    int insertSelective(RulelistType record);

    RulelistType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RulelistType record);

    int updateByPrimaryKey(RulelistType record);
}
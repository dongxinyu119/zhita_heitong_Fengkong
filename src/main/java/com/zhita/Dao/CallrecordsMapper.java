package com.zhita.Dao;

import com.zhita.Model.Callrecords;

public interface CallrecordsMapper {
    int deleteByPrimaryKey(Integer id);
    
    //添加功能
    int insert(Callrecords record);
    
    //通过userid判断该用户在通话记录表是否有记录
    int querycount(Integer userid);

    int insertSelective(Callrecords record);

    Callrecords selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Callrecords record);

    int updateByPrimaryKey(Callrecords record);
}
package com.zhita.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhita.Model.TravelInfo;

public interface TravelInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TravelInfo record);

    int insertSelective(TravelInfo record);

    TravelInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TravelInfo record);

    int updateByPrimaryKey(TravelInfo record);
    
    //列表查询数量——出行分析表
    int queryAllCount(Integer userid);
    
    //列表查询——出行分析表
    List<TravelInfo> queryAll(@Param("userid") Integer userid,@Param("page") Integer page,@Param("pagesize") Integer pagesize);
}
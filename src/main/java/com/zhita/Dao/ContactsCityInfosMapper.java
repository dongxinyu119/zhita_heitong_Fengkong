package com.zhita.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhita.Model.ContactsCityInfos;

public interface ContactsCityInfosMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ContactsCityInfos record);

    int insertSelective(ContactsCityInfos record);

    ContactsCityInfos selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ContactsCityInfos record);

    int updateByPrimaryKey(ContactsCityInfos record);
    
    //列表查询数量——通话区域分布（城市）表
    int queryAllCount(Integer userid);
    
    //列表查询——通话区域分布（城市）表
    List<ContactsCityInfos> queryAll(@Param("userid") Integer userid,@Param("page") Integer page,@Param("pagesize") Integer pagesize);
}
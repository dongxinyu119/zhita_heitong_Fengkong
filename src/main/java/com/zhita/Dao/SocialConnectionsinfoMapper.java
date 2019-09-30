package com.zhita.Dao;

import java.util.List;

import com.zhita.Model.SocialConnectionsinfo;

public interface SocialConnectionsinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SocialConnectionsinfo record);

    int insertSelective(SocialConnectionsinfo record);

    SocialConnectionsinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SocialConnectionsinfo record);

    int updateByPrimaryKey(SocialConnectionsinfo record);
    
    //列表查询——社交关系
    List<SocialConnectionsinfo> queryAll(Integer userid);
}
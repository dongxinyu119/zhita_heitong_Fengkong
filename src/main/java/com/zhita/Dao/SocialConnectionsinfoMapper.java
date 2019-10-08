package com.zhita.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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

	void setsocialConnectionsinfo(@Param("userId")int userId,@Param("phone_count") String phone_count,
			@Param("interflow_call_phone_count")String interflow_call_phone_count,@Param("compactness_call_count") String compactness_call_count,
			@Param("ephemeral_call_count")String ephemeral_call_count);
}
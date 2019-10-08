package com.zhita.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhita.Model.CommunicationTimeDurationInfo;

public interface CommunicationTimeDurationInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommunicationTimeDurationInfo record);

    int insertSelective(CommunicationTimeDurationInfo record);

    CommunicationTimeDurationInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommunicationTimeDurationInfo record);

    int updateByPrimaryKey(CommunicationTimeDurationInfo record);
    
    //列表差——通话时长分布表
    List<CommunicationTimeDurationInfo> queryAll(Integer userid);

	void setcommunicationTimeDurationInfo(@Param("userId")int userId,@Param("time_duration") String time_duration,
			@Param("calling_count")int calling_count,@Param("calling_duration_time") String calling_duration_time,@Param("called_count") int called_count,
			@Param("called_duration_time")String called_duration_time);
}
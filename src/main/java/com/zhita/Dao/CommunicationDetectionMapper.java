package com.zhita.Dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhita.Model.CommunicationDetection;

public interface CommunicationDetectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommunicationDetection record);

    int insertSelective(CommunicationDetection record);

    CommunicationDetection selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommunicationDetection record);

    int updateByPrimaryKey(CommunicationDetection record);
    
    //列表查询——通信检测
    List<CommunicationDetection> queryAll(Integer userid);

	void setcommunicationDetection(@Param("userId")int userId,@Param("the_last_call_time") String the_last_call_time,
			@Param("silent_count")int silent_count,@Param("silent_duration_time") String silent_duration_time,
			@Param("average_silent_duration_time")String average_silent_duration_time,
			@Param("the_last_silent_duration_time")String the_last_silent_duration_time,@Param("night_activities") BigDecimal night_activities,
			@Param("long_silent_time")String long_silent_time,@Param("long_silent_duration_time") String long_silent_duration_time,
			@Param("the_long_silent_duration_time")String the_long_silent_duration_time);
}
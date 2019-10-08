package com.zhita.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhita.Model.CommunicationTimeBucketInfo;

public interface CommunicationTimeBucketInfoMapper {
    int insert(CommunicationTimeBucketInfo record);

    //列表查询——通话时间段分布
    List<CommunicationTimeBucketInfo> queryAll(Integer userid);

	void setcommunicationTimeBucketInfo(@Param("userId")int userId,@Param("time_bucket") String time_bucket,
			@Param("call_count")int call_count,@Param("phone_count") int phone_count,@Param("phone_times") String phone_times,
			@Param("calling_count")int calling_count,@Param("calling_duration_time") String calling_duration_time,@Param("called_count") int called_count,
			@Param("called_duration_time")String called_duration_time);

}
package com.zhita.Dao;

import java.util.List;




import org.apache.ibatis.annotations.Param;

import com.zhita.Model.Top10CallTime;

public interface Top10CallTimeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Top10CallTime record);

    int insertSelective(Top10CallTime record);

    Top10CallTime selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Top10CallTime record);

    int updateByPrimaryKey(Top10CallTime record);
    
    //列表查询——通话总时长前10 表
    List<Top10CallTime> queryAll(Integer userid);

	void settop10CallTime(@Param("userId")int userId,@Param("phone_number") String phone_number,
			@Param("call_duration_time")String call_duration_time,@Param("calling_duration_time") String calling_duration_time,
			@Param("called_duration_time")String called_duration_time);
}
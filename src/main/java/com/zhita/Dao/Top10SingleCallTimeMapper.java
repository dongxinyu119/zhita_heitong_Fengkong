package com.zhita.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhita.Model.Top10SingleCallTime;

public interface Top10SingleCallTimeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Top10SingleCallTime record);

    int insertSelective(Top10SingleCallTime record);

    Top10SingleCallTime selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Top10SingleCallTime record);

    int updateByPrimaryKey(Top10SingleCallTime record);
    
    //列表查询——单次通话时长前10 表
    List<Top10SingleCallTime> queryAll(Integer userid);

	void settop10SingleCallTime(@Param("userId")int userId,@Param("phone_number") String phone_number,
			@Param("call_duration_time")String call_duration_time);
}
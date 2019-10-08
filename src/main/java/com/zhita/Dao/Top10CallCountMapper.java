package com.zhita.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhita.Model.Top10CallCount;

public interface Top10CallCountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Top10CallCount record);

    int insertSelective(Top10CallCount record);

    Top10CallCount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Top10CallCount record);

    int updateByPrimaryKey(Top10CallCount record);
    
    //列表查询——通话次数前10 表
    List<Top10CallCount> queryAll(Integer userid);

	void settop10CallCount(@Param("userId")int userId,@Param("phone_number") String phone_number,@Param("call_count") String call_count,
			@Param("calling_count")String calling_count,@Param("called_count") String called_count);
}
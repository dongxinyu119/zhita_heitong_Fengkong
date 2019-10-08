package com.zhita.Dao;

import java.math.BigDecimal;
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

	void setContactsCityInfos(@Param("userId")int userId,@Param("city") String city,@Param("call_count") int call_count,
			@Param("calling_count")int calling_count,@Param("calling_duration_time") String calling_duration_time,@Param("called_count") int called_count,
			@Param("called_duration_time")String called_duration_time,@Param("calling_count_per") BigDecimal calling_count_per,
			@Param("calling_duration_time_per")BigDecimal calling_duration_time_per,@Param("called_count_per") BigDecimal called_count_per,
			@Param("called_duration_time_per")BigDecimal called_duration_time_per);
}
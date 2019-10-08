package com.zhita.Dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhita.Model.CommunicationMonthInfo;

public interface CommunicationMonthInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommunicationMonthInfo record);

    int insertSelective(CommunicationMonthInfo record);

    CommunicationMonthInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommunicationMonthInfo record);

    int updateByPrimaryKey(CommunicationMonthInfo record);
    
    //列表查询——通话月份分布
    List<CommunicationMonthInfo> queryAll(Integer userid);

	void setcommunicationMonthInfo(@Param("userId")int userId,@Param("month") String month,
			@Param("call_phone_number_count")String call_phone_number_count,
			@Param("two_way_phone_number_per")BigDecimal two_way_phone_number_per,@Param("call_count") int call_count,
			@Param("calling_count")int calling_count,@Param("calling_duration_time") String calling_duration_time,@Param("called_count") int called_count,
			@Param("called_duration_time")String called_duration_time,@Param("sms_count") int sms_count);
}
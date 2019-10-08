package com.zhita.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhita.Model.EmergencyContactInfo;

public interface EmergencyContactInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmergencyContactInfo record);

    int insertSelective(EmergencyContactInfo record);

    EmergencyContactInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmergencyContactInfo record);

    int updateByPrimaryKey(EmergencyContactInfo record);
    
    //列表查询——紧急联系人
    List<EmergencyContactInfo> queryAll(Integer userid);

	void setemergencyContactInfo(@Param("userId")int userId,@Param("userId") String relation,@Param("userId") String name,
			@Param("userId")String phone_number,@Param("userId") String id_number,@Param("userId") String label_name,
			@Param("userId")String phone_location,@Param("userId") int one_calling_count,@Param("userId") int one_called_count,
			@Param("userId")int one_total_call_count,@Param("userId") String one_calling_duration_time,
			@Param("userId")String one_called_duration_time,
			@Param("userId")String one_total_call_duration_time,@Param("userId") int three_calling_count,
			@Param("userId")int three_called_count,@Param("userId") int three_total_call_count,
			@Param("userId")String three_calling_duration_time,
			@Param("userId")String three_called_duration_time,
			@Param("userId")String three_total_call_duration_time,@Param("userId") int six_calling_count,
			@Param("userId")int six_called_count,@Param("userId") int six_total_call_count,
			@Param("userId")String six_calling_duration_time,@Param("userId") String six_called_duration_time,
			@Param("userId")String six_total_call_duration_time,@Param("userId") int all_calling_count,
			@Param("userId")int all_called_count,@Param("userId") int all_total_call_count,
			@Param("userId")String all_calling_duration_time,@Param("userId") String all_called_duration_time,
			@Param("userId")String all_total_call_duration_time,@Param("userId") String workday_duration_time,
			@Param("userId")String offday_duration_time);
}
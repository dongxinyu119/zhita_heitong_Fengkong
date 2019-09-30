package com.zhita.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhita.Model.ApplierInfo;

public interface ApplierInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApplierInfo record);

    int insertSelective(ApplierInfo record);

    ApplierInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ApplierInfo record);

    int updateByPrimaryKey(ApplierInfo record);
    
    //列表查询——申请人基本信息
    List<ApplierInfo> queryAll(Integer userid);

	void setApplierInfo(@Param("userId")int userId,@Param("name") String name,@Param("gender") String gender,@Param("age") int age,
			@Param("phone_number")String phone_number,@Param("idcard") String idcard,@Param("idcard_location") String idcard_location,
			@Param("home_telephone_number")String home_telephone_number,@Param("home_address") String home_address,
			@Param("home_formatted_address")String home_formatted_address,@Param("home_level") String home_level,
			@Param("home_latitude")String home_latitude,@Param("home_longitude") String home_longitude,
			@Param("company_telephone_number")String company_telephone_number,@Param("company_address") String company_address,
			@Param("company_formatted_address")String company_formatted_address,@Param("company_level") String company_level,
			@Param("company_latitude")String company_latitude,@Param("company_longitude") String company_longitude);
}
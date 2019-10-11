package com.zhita.Dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhita.Model.OperatorInfo;

public interface OperatorInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OperatorInfo record);

    int insertSelective(OperatorInfo record);

    OperatorInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OperatorInfo record);

    int updateByPrimaryKey(OperatorInfo record);
    
    //查询列表——运营商基本信息
    List<OperatorInfo> queryAll(Integer userid);

//   void setoperatorInfo(@Param("userId")int userId,@Param("phone_number") String phone_number,@Param("operator_type") String operator_type,
//			@Param("name")String name,@Param("idcard") String idcard,@Param("email") String email,@Param("address") String address,
//			@Param("vip_level")String vip_level,@Param("registration_history") String registration_history,
//			@Param("available_amount")BigDecimal available_amount,@Param("phone_number_location") String phone_number_location,
//			@Param("main_active_location")String main_active_location,@Param("main_location_percent") BigDecimal main_location_percent);

void setoperatorInfo(OperatorInfo operatorInfo);
}
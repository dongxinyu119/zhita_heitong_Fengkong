package com.zhita.Dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhita.Model.RechargeInfo;

public interface RechargeInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RechargeInfo record);

    int insertSelective(RechargeInfo record);

    RechargeInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RechargeInfo record);

    int updateByPrimaryKey(RechargeInfo record);
    
    //列表查询——充值记录
    List<RechargeInfo> queryAll(Integer userid);

	void setrechargeInfo(@Param("userId")int userId,@Param("recharge_time") String recharge_time,@Param("recharge_count") int recharge_count,
			@Param("recharge_amount")BigDecimal recharge_amount,@Param("recharge_max") BigDecimal recharge_max);
}
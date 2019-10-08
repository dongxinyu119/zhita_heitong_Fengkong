package com.zhita.Dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhita.Model.BillInfo;

public interface BillInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BillInfo record);

    int insertSelective(BillInfo record);

    BillInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BillInfo record);

    int updateByPrimaryKey(BillInfo record);
    
    //列表查询——消费记录
    List<BillInfo> queryAll(Integer userid);

	void setBillInfo(@Param("userId")int userId,@Param("consumption_amount") BigDecimal consumption_amount,@Param("month") String month);
}
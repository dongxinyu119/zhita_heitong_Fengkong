package com.zhita.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhita.Model.ReportInfo;

public interface ReportInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReportInfo record);

    int insertSelective(ReportInfo record);

    ReportInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReportInfo record);

    int updateByPrimaryKey(ReportInfo record);
    
    //列表查询——报告基本信息
    List<ReportInfo> queryAll(Integer userid);

	void setreportInfo(@Param("userId")int userId,@Param("time") String time,@Param("report_no") String report_no,
			@Param("risk_level")String risk_level,@Param("score") int score);
}
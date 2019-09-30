package com.zhita.Dao;

import java.util.List;

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
}
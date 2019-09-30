package com.zhita.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhita.Model.LabelInfo;

public interface LabelInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LabelInfo record);

    int insertSelective(LabelInfo record);

    LabelInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LabelInfo record);

    int updateByPrimaryKey(LabelInfo record);
    
    //列表查询数量——通话数据分析
    int queryAllCount(Integer userid);
    
    
    //列表查询——通话数据分析
    List<LabelInfo> queryAll(@Param("userid") Integer userid,@Param("page") Integer page,@Param("pagesize") Integer pagesize);
}
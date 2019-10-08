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

	void setlabelInfoMapper(@Param("userId")int userId,@Param("sort_index") int sort_index,@Param("contact_count") int contact_count,
			@Param("phone_number")String phone_number,@Param("label_name") String label_name,@Param("label_type") String label_type,
			@Param("phone_location")String phone_location,@Param("contact_duration") String contact_duration,@Param("calling_count") int calling_count,
			@Param("called_count")int called_count,@Param("earliest_time") String earliest_time,@Param("latest_time") String latest_time);
}
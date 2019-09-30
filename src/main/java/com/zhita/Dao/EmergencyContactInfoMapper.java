package com.zhita.Dao;

import java.util.List;

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
}
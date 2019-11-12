package com.zhita.Dao;

import java.util.List;
import com.zhita.Model.SensitiveInfoNewupa;

public interface SensitiveInfoNewupaMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(SensitiveInfoNewupa record);

    int insertSelective(SensitiveInfoNewupa record);

    SensitiveInfoNewupa selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SensitiveInfoNewupa record);

    int updateByPrimaryKey(SensitiveInfoNewupa record);
    
    //后台管理——查询列表
    List<SensitiveInfoNewupa> queryAll(Integer userid);


	void setsensitiveInfoNewupa(SensitiveInfoNewupa sensitiveInfoNewupa);
}
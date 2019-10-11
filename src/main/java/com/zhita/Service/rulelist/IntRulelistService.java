package com.zhita.Service.rulelist;

import java.util.List;
import java.util.Map;

import com.zhita.Model.Rulelist;
import com.zhita.Model.RulelistType;

public interface IntRulelistService {
	
	//后台管理——列表查询
    public Map<String,Object> queryAll(Integer page);
    
    //后台管理——添加功能（先查询出规则分类表所有信息）
    public List<RulelistType> queryAllType();
    
    //后台管理——添加功能
    public int insert(Rulelist record);
    
    //后台管理——根据id查询当前对象
    public Rulelist selectByPrimaryKey(Integer id);
    
    //后台管理——编辑功能
    public int updateByPrimaryKey(Rulelist record);
    
    //后台管理——更新假删除状态
    public int upaFalseDel(Integer id);
}

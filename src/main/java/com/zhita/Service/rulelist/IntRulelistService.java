package com.zhita.Service.rulelist;

import java.util.List;
import java.util.Map;

import com.zhita.Model.Rulelist;
import com.zhita.Model.RulelistType;
import com.zhita.Model.Rulelist_detail;

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
    
    //后台管理——各个规则分类的命中分数
    public Map<String,Object> typeifhit(Integer userid);
    
    //后台管理——查询该条规则被命中的用户集合
    public List<Rulelist_detail> queryuserhit(Integer rulelistid);
    
    //后台管理——查询用户表所有数据
    public Map<String,Object> queryAllUser(Integer page);
    
    //后台管理——查询该用户的规则命中情况
    public List<Rulelist_detail> queryhit(Integer userid,String authentime);
}

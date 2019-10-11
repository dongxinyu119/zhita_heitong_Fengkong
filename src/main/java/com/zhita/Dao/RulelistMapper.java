package com.zhita.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhita.Model.Rulelist;
import com.zhita.Model.RulelistType;

public interface RulelistMapper {
    int deleteByPrimaryKey(Integer id);
    
    //后台管理——添加功能（先查询出规则分类表所有信息）
    List<RulelistType> queryAllType();
    
    //后台管理——添加功能
    int insert(Rulelist record);

    //后台管理——根据id查询当前对象
    Rulelist selectByPrimaryKey(Integer id);
    
    //后台管理——编辑功能
    int updateByPrimaryKey(Rulelist record);
    
    //后台管理——列表查询数量
    int queryAllCount();
    
    //后台管理——列表查询
    List<Rulelist> queryAll(@Param("page") Integer page,@Param("pagesize") Integer pagesize);
    
    //后台管理——更新假删除状态
    int upaFalseDel(Integer id);
    
}
package com.zhita.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhita.Model.Rulelist;
import com.zhita.Model.RulelistType;
import com.zhita.Model.Rulelist_detail;
import com.zhita.Model.User;

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
    
    //后台管理——查询该用户最新一条数据
    User queryuser(Integer userid);
    
    //后台管理——查询该用户的命中情况
    List<Rulelist_detail> queryifhit(@Param("userid") Integer userid,@Param("authentime") String authentime);
    
    //后台管理——查询该用户没有命中的规则分类
    List<Rulelist_detail> queryType(@Param("userid") Integer userid,@Param("authentime") String authentime);
    
    //后台管理——查询该条规则被命中的用户集合
    List<Rulelist_detail> queryuserhit(Integer rulelistid);
    
}
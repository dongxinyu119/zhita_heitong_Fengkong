package com.zhita.Service.rulelist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhita.Dao.RulelistMapper;
import com.zhita.Model.Rulelist;
import com.zhita.Model.RulelistType;
import com.zhita.Util.PageUtil2;

@Service
public class RulelistServiceImp implements IntRulelistService{
	
	@Autowired
	private RulelistMapper rulelistMapper;
	
	//后台管理——列表查询
    public Map<String,Object> queryAll(Integer page){
		List<Rulelist> listrulelist=new ArrayList<>();//规则集合
		PageUtil2 pageUtil=null;
		int totalCount=rulelistMapper.queryAllCount();//查询总数量
		pageUtil=new PageUtil2(page,totalCount);
    	if(page<1) {
    		page=1;
    		pageUtil.setPage(page);
    	}
    	else if(page>pageUtil.getTotalPageCount()) {
    		if(totalCount==0) {
    			page=pageUtil.getTotalPageCount()+1;
    		}else {
    			page=pageUtil.getTotalPageCount();
    		}
    		pageUtil.setPage(page);
    	}
    	int pages=(page-1)*pageUtil.getPageSize();
    	listrulelist=rulelistMapper.queryAll(pages,pageUtil.getPageSize());
    	
    	Map<String,Object> map=new HashMap<String, Object>();
		map.put("listrulelist", listrulelist);
		map.put("pageUtil", pageUtil);
		return map;
	
    }
    
    //后台管理——添加功能（先查询出规则分类表所有信息）
    public List<RulelistType> queryAllType(){
    	return rulelistMapper.queryAllType();
    }
    
    //后台管理——添加功能
    public int insert(Rulelist record){
    	return rulelistMapper.insert(record);
    }
    
    //后台管理——根据id查询当前对象
    public Rulelist selectByPrimaryKey(Integer id){
    	return rulelistMapper.selectByPrimaryKey(id);
    }
    
    //后台管理——编辑功能
    public int updateByPrimaryKey(Rulelist record){
    	return rulelistMapper.updateByPrimaryKey(record);
    }
    
    //后台管理——更新假删除状态
    public int upaFalseDel(Integer id){
    	return rulelistMapper.upaFalseDel(id);
    }
}

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
import com.zhita.Model.Rulelist_detail;
import com.zhita.Model.User;
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
    
    //后台管理——各个规则分类是否命中
    public List<Rulelist_detail> typeifhit(Integer userid){
    	User user=rulelistMapper.queryuser(userid);
    	List<Rulelist_detail> list=rulelistMapper.queryifhit(user.getUserId(), user.getAuthentication_time());
    	List<String> listype=rulelistMapper.queryType(user.getUserId(), user.getAuthentication_time());
    	List<Rulelist_detail> list1=new ArrayList<>();
    	for (int i = 0; i < listype.size(); i++) {
    		Rulelist_detail rulelist_detail=new Rulelist_detail();
    		rulelist_detail.setType(listype.get(i));
    		rulelist_detail.setSum("0");
			list1.add(rulelist_detail);
		}
    	list.addAll(list1);
    	
    	return list;
    }
    
    //后台管理——查询该条规则被命中的用户集合
    public List<Rulelist_detail> queryuserhit(Integer rulelistid){
    	return rulelistMapper.queryuserhit(rulelistid);
    }
}

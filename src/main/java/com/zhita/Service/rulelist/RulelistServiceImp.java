package com.zhita.Service.rulelist;

import java.text.ParseException;
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
import com.zhita.Util.Timestamps;

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
    
    //后台管理——各个规则分类的命中分数
    public Map<String,Object> typeifhit(Integer userid){
    	User user=rulelistMapper.queryuser(userid);
    	List<Rulelist_detail> list=new ArrayList<>();
    	if(user==null||"".equals(user)){
    		List<RulelistType> listtype=rulelistMapper.queryAllType();
    		for (int i = 0; i < listtype.size(); i++) {
				Rulelist_detail rd=new Rulelist_detail();
				rd.setType(listtype.get(i).getType());
				rd.setSum("0");
				list.add(rd);
			}
    	}else{
    		list=rulelistMapper.queryifhit(user.getUserId(), user.getAuthentication_time());
        	List<Rulelist_detail> listype=rulelistMapper.queryType(user.getUserId(), user.getAuthentication_time());
        	for (int i = 0; i < listype.size(); i++) {
        		listype.get(i).setSum("0");
    		}
        	list.addAll(listype);
    	}
    	
    	Map<String,Object> map=new HashMap<>();
    	map.put("list", list);
    	return map;
    }
    
    //后台管理——查询该条规则被命中的用户集合
    public List<Rulelist_detail> queryuserhit(Integer rulelistid){
    	List<Rulelist_detail> list= rulelistMapper.queryuserhit(rulelistid);
    	for (int i = 0; i < list.size(); i++) {
			list.get(i).setAuthentication_time(Timestamps.stampToDate(list.get(i).getAuthentication_time()));
		}
    	return list;
    }
    
    //后台管理——查询用户表所有数据
    public Map<String,Object> queryAllUser(Integer page){
    	List<User> list= new ArrayList<>();
    	PageUtil2 pageUtil=null;
		int totalCount=rulelistMapper.queryAllUserCount();//查询总数量
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
    	
    	list=rulelistMapper.queryAllUser(pages,pageUtil.getPageSize());
    	for (int i = 0; i < list.size(); i++) {
    		list.get(i).setAuthentication_time(Timestamps.stampToDate(list.get(i).getAuthentication_time()));
		}
    	
    	Map<String,Object> map=new HashMap<>();
    	map.put("list", list);
    	map.put("pageUtil", pageUtil);
    	return map;
    }
    
    //后台管理——查询该用户的规则命中情况
    public List<Rulelist_detail> queryhit(Integer userid,String authentime){
    	String authentimesta=null;
    	try {
    		authentimesta=Timestamps.dateToStamp1(authentime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	List<Rulelist_detail> list= rulelistMapper.queryhit(userid, authentimesta);
    	for (int i = 0; i < list.size(); i++) {
    		list.get(i).setAuthentication_time(Timestamps.stampToDate(list.get(i).getAuthentication_time()));
		}
    	return list;
    }
}

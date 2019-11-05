package com.zhita.Collection.rulelist;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhita.Model.Rulelist;
import com.zhita.Model.RulelistType;
import com.zhita.Model.Rulelist_detail;
import com.zhita.Service.rulelist.IntRulelistService;

@Controller
@RequestMapping("/rulelist")
public class RulelistController {
	@Autowired
	private IntRulelistService intRulelistService;
	

	//后台管理——列表查询
	@ResponseBody
	@RequestMapping("/queryAll")
    public Map<String,Object> queryAll(Integer page){
		return intRulelistService.queryAll(page);
	}
	
	//后台管理——添加功能（先查询出规则分类表所有信息）
	@ResponseBody
	@RequestMapping("/queryAllType")
    public List<RulelistType> queryAllType(){
    	return intRulelistService.queryAllType();
    }
    
    //后台管理——添加功能
	@ResponseBody
	@RequestMapping("/insert")
    public int insert(Rulelist record){
    	return intRulelistService.insert(record);
    }
	
	 //后台管理——根据id查询当前对象
	@ResponseBody
	@RequestMapping("/selectByPrimaryKey")
    public Rulelist selectByPrimaryKey(Integer id){
    	return intRulelistService.selectByPrimaryKey(id);
    }
    
    //后台管理——编辑功能
	@ResponseBody
	@RequestMapping("/updateByPrimaryKey")
    public int updateByPrimaryKey(Rulelist record){
    	return intRulelistService.updateByPrimaryKey(record);
    }
	
	//后台管理——更新假删除状态
	@ResponseBody
	@RequestMapping("/upaFalseDel")
    public int upaFalseDel(Integer id){
    	return intRulelistService.upaFalseDel(id);
    }
	
	//后台管理——各个规则分类的命中分数
	@ResponseBody
	@RequestMapping("/typeifhit")
	public Map<String,Object> typeifhit(Integer userid){
		return intRulelistService.typeifhit(userid);
	}
	
	//后台管理——查询该条规则被命中的用户集合
	@ResponseBody
	@RequestMapping("/queryuserhit")
    public List<Rulelist_detail> queryuserhit(Integer rulelistid){
    	return intRulelistService.queryuserhit(rulelistid);
    }
    
    //后台管理——查询用户表所有数据
    @ResponseBody
	@RequestMapping("/queryAllUser")
    public Map<String,Object> queryAllUser(Integer page){
    	return intRulelistService.queryAllUser(page);
    }
    
    //后台管理——查询该用户的规则命中情况
    @ResponseBody
	@RequestMapping("/queryhit")
    public List<Rulelist_detail> queryhit(Integer userid,String authentime){
    	return intRulelistService.queryhit(userid, authentime);
    }

}

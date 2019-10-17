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
	
	//后台管理——各个规则分类是否命中
	@ResponseBody
	@RequestMapping("/typeifhit")
	public List<Rulelist_detail> typeifhit(Integer userid){
		return intRulelistService.typeifhit(userid);
	}

}

package com.zhita.Collection.authen;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhita.Service.IntAuthenService;

@Controller
@RequestMapping("/authen")
public class AuthenController {
	
	@Autowired
	private IntAuthenService intAuthenService;
	
	
	@ResponseBody
	@RequestMapping("/queryauthen")
	public Map<String,Object> queryauthen(Integer userid){
		return intAuthenService.queryauthen(userid);
	}
	
	//通话区域分布（城市）表
	@ResponseBody
	@RequestMapping("/queryauthenconcity")
	public Map<String,Object> queryauthenconcity(Integer userid,Integer page){
		return intAuthenService.queryauthenconcity(userid,page);
	}
	
	//通话数据分析表
	@ResponseBody
	@RequestMapping("/queryauthenconlabel")
	public Map<String,Object> queryauthenconlabel(Integer userid,Integer page){
		return intAuthenService.queryauthenconlabel(userid,page);
	}
	
	//出行分析表
	@ResponseBody
	@RequestMapping("/queryauthenave")
	public Map<String,Object> queryauthenave(Integer userid,Integer page){
		return intAuthenService.queryauthenave(userid,page);
	}
	
	//风险信息检查表
	@ResponseBody
	@RequestMapping("/queryAllsen")
    public Map<String,Object> queryAllsen(Integer userid){
    	return intAuthenService.queryAllsen(userid);
    }
	
	//通话详情（通话月份，通话时间段，通话时长分布）
	@ResponseBody
	@RequestMapping("/queryTelephone")
    public Map<String,Object> queryTelephone(Integer userid){
    	return intAuthenService.queryTelephone(userid);
    }

}

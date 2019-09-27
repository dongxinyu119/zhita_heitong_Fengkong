package com.zhita.Collection.riskmanagement;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhita.Service.RiskService;


@Controller
@RequestMapping("Riskmanage")
public class Riskmanagement {
	
	
	@Autowired
	private RiskService rser;
	
	
	
	/**
	 * 
	 * @param phone
	 * @return
	 */
	@ResponseBody
	@RequestMapping("Risk_ReturnCode")
	public Map<String, Object> RiskreturnCode(String phone){
		return rser.RiskRturncode(phone);
	}
	
	
	
	
	
	
	/**
	 * 查询手机号
	 * 返回 phones
	 * 
	 * @param phone
	 * @return
	 */
	@ResponseBody
	@RequestMapping("UserMaillistPhone")
	public Map<String, Object> UserMaillistPhone(String phone){
		return rser.SelectMaillistPhone(phone);
	}
	
	
	
	

}

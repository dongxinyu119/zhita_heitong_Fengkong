package com.zhita.Collection.beoverdue;

import java.util.HashMap;
import java.util.Map;

public class MapUtil {
	

	
	public String getMap(String key){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("100", "接口调用成功");
		map.put("200", "账户不存在");
		map.put("210", "账号已过期");
		map.put("220", "账户被冻结");
		map.put("230", "账户未激活");
		map.put("240", "账户余额不足");
		map.put("300", "IP 受限");
		map.put("310", "服务无权限");
		map.put("320", "服务已停用");
		map.put("321", "服务已过期");
		map.put("400", "缺少必要参数");
		map.put("410", "参数解析失败");
		map.put("420", "参数格式错误");
		map.put("430", "签名验证失败");
		map.put("999", "服务器错误");
		
		String values = (String) map.get(key);
		return values;
	}
	
	

}

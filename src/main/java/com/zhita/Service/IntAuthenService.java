package com.zhita.Service;

import java.util.Map;

public interface IntAuthenService {
	
	public Map<String,Object> queryauthen(Integer userid);
	
	public Map<String,Object> queryauthenconcity(Integer userid,Integer page);
	
	public Map<String,Object> queryauthenconlabel(Integer userid,Integer page);
	
	public Map<String,Object> queryauthenave(Integer userid,Integer page);
	
	//后台管理——查询列表(风险信息检查)
    public Map<String,Object> queryAllsen(Integer userid);
}

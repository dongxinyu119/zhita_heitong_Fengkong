package com.zhita.Service;

import java.util.Map;

public interface IntAuthenService {
	
	public Map<String,Object> queryauthen(Integer userid);
	
	public Map<String,Object> queryauthenconcity(Integer userid,Integer page);
	
	public Map<String,Object> queryauthenconlabel(Integer userid,Integer page);
	
	public Map<String,Object> queryauthenave(Integer userid,Integer page);
	
	//后台管理——查询列表(风险信息检查)
    public Map<String,Object> queryAllsen(Integer userid);
    
    //通话详情（通话月份，通话时间段，通话时长分布）
    public Map<String,Object> queryTelephone(Integer userid);
    
    //通话亲密度（通话次数前10，通话总时长前10，单次通话时长前10）
    public Map<String,Object> queryTopten(Integer userid);
}

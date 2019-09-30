package com.zhita.Service;

import java.util.Map;

public interface IntAuthenService {
	
	public Map<String,Object> queryauthen(Integer userid);
	
	public Map<String,Object> queryauthenconcity(Integer userid,Integer page);
	
	public Map<String,Object> queryauthenconlabel(Integer userid,Integer page);
	
	public Map<String,Object> queryauthenave(Integer userid,Integer page);
}

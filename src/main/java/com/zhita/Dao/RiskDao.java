package com.zhita.Dao;

import java.util.List;

import com.zhita.Model.Configuration;

public interface RiskDao {
	
	Integer UserPhoneCount(Integer userId);
	
	
	Integer UserLoginNum(Configuration phone);
	
	
	Configuration UserUUID(String phone);
	
	
	Integer UserWifiIPNum(Configuration phone);
	
	
	Integer UserWifiMacNum(Configuration phone);
	
	
	List<String> SelectUserMaillist(Integer userId);
	
	
	Integer NameMaillist(Configuration name);
	
	
	Integer AppNum(Configuration name);
}

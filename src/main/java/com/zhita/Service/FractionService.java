package com.zhita.Service;

import com.zhita.Model.Rulelist;
import com.zhita.Model.Rulelist_detail;
import com.zhita.Model.User;

public interface FractionService {
	
	
	Integer AppCount(Integer userId);
	
	
	Rulelist RulelistFraction(Integer id);
	
	
	Integer Emergency_contact_infoPhone(Integer id);
	
	
	Integer IpPhoneCount(Integer userId);
	
	
	Integer OneHomeCount(String phone);
	
	
	Integer OneHomeIDnumberCount(String idNumber);
	
	
	Integer UserPhoneCount(Integer userId);
	
	
	Integer UserNameFatherCount(Integer userId);
	
	
	Integer UserQinqCount(User user);
	
	
	Integer UserPhoneCount1(Integer userId);
	
	
	Integer AddUser(User u);
	
	
	Integer UserZuC(Integer userId);
	
	
	Integer AppNum(User user);
	
	
	Integer UserAppCount(Integer userId);
	
	
	Integer AddCount(Rulelist_detail rele);
	
	
	
	
}

package com.zhita.Dao;

import com.zhita.Model.Rulelist;
import com.zhita.Model.Rulelist_detail;
import com.zhita.Model.User;

public interface FractionMapper {
	
	
	Integer AppCount(Integer userId);
	
	
	Rulelist FractionUser(Integer id);
	
	
	Integer Emergency_contact_infoPhone(Integer userId);
	
	
	Integer IpPhone(Integer userid);
	
	
	Integer PhoneCount(User user);
	
	
	Integer UserPhoneCount(User user);
	
	
	Integer AddUser(User u);
	
	
	Integer UserZuc(Integer userId);
	
	
	Integer UserAppnum(User user);
	
	
	Integer getId(String phone);
	
	
	Integer UserAppCount(Integer userId);
	
	
	Integer AddUserCount(Rulelist_detail ru);
	
	
}

package com.zhita.Service;

import java.math.BigDecimal;

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
	
	
	Integer MaillstUserPhone(Integer userId);
	
	
	Integer PayUserNum(User user);
	
	
	Integer PhoneNum(User user);
	
	
	Integer jjPhoneNum(User user);
	
	
	Integer PFhoneNum(User user);
	
	
	User ReportNum(User user);
	
	
	Integer ReportID(User user);
	
	
	Integer AppInfoUser(User user);
	
	
	Integer MacUserNum(User user);
	
	
	Integer PhoneUserNum(User user);
	
	
	Integer DeleteRulet(Integer userid,String authentication_time);
	
	
	String PhoneUserMoney(Integer userId);
	
	
	Integer SmsUserMoney(Integer userId);
	
	
	Integer MonthUserphone(Integer userId);
	
	
	Integer UserNum(Integer userId);
	
	
	Integer PassUserNum(Integer userId);
	
	
	Integer WifiNameNum(User user);
	
	
	Integer UserLongintime(User user);
	
}

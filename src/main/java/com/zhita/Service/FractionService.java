package com.zhita.Service;



import java.math.BigDecimal;

import com.zhita.Model.CommunicationCityInfo;
import com.zhita.Model.CommunicationDetection;
import com.zhita.Model.EmergencyContactInfo;
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
	
	
	Integer WifiNameNum(User userwifiaz);
	
	
	Integer UserLongintime(User user);
	
	
	Integer Userpt(Integer userId);
	
	
	int Userappt(User userId);
	
	
	int IDNumberCount(User userId);
	
	
	CommunicationDetection UserJm(Integer userId);
	
	
	CommunicationCityInfo Usercommun(Integer xiaodai_userid);
	
	
	Integer PhoneCa(Integer xiaodai_userid);
	
	
	EmergencyContactInfo JjUserNum(Integer xiaodai_userid);
	
	
	Integer TopUser(Integer userId);
	
	
	Integer TopTime(Integer userId);
	
	
	Integer TopCount(Integer userId);
	
	
	Integer UserAge(String phone);
	
	
	Integer TopJjCount(Integer userId);
	
	
	BigDecimal UserPhoneMoney(Integer userId);
	
	
	Integer MinJUser(User userId);
	
	
	Integer TongHUser(Integer userId);
	
	
	Integer ChuxTimeDay(Integer userId);
	
	
	BigDecimal YueFLv(Integer userId);
	
	
	Integer PhoneUser(Integer userId,String phone);
	
	
	Integer PhoneUserData(Integer userId,String phone);
	
	
	Integer PhoneCUser(Integer userId,String phone);
	
	
	Integer PhonehrUser(Integer userId,String phone);
	
	
	Integer PhoneHrCUser(Integer userId,String phone);
	
	
	Double PhoneCUserData(Integer userId,String phone);
	
	
	Double PhoneCuUserData(Integer userId,String phone);
	
	
	Integer AndroidTop(Integer userId,String phone);
	
	
	Integer AndroidTopJj(Integer userId,String phone);
	
	
	Integer AndroidTopCount(Integer userId,String phone);
	
	
	Integer AndroidTopJJCount(Integer userId,String phone);
	
	
	Integer AndroidTop10(Integer userId,String phone);
	
	
	Integer AndroidTop12560(Integer userId,String phone,String type);
	
	
	Integer UserHR(Integer userId,String phone,String type);
	
	
	Integer UserHROne(Integer userId,String phone,String type);
	
	
	Integer SelectUserApp(Integer userId);
	
	
	Integer MailstNum(Integer userId);
	
	
	Integer ConfigUser(String phone);
	
	
	Integer UserTonghua(Integer userId);
}

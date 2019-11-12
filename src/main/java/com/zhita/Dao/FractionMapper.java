package com.zhita.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhita.Model.CallRecordListItemInfosTwo;
import com.zhita.Model.CommunicationCityInfo;
import com.zhita.Model.CommunicationDetection;
import com.zhita.Model.EmergencyContactInfo;
import com.zhita.Model.RechargeInfo;
import com.zhita.Model.Rulelist;
import com.zhita.Model.Rulelist_detail;
import com.zhita.Model.SensitiveInfoNewupa;
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
	
	
	Integer SelectUserPhone(Integer userId);
	
	
	List<Integer> PayUserNum(User user);
	
	
	List<Integer> PhoneNum(User user);
	
	
	List<Integer> jjPhoneNum(User user);
	
	
	Integer PhoneNumA(User user);
	
	
	User ReportNum(User user);
	
	
	Integer ReportID(User user);
	
	
	Integer AppInFoUser(User user);
	
	
	Integer MacNum(User user);
	
	
	Integer PhoneUserNum(User user);
	
	
	Integer DeleteRule(@Param("userid") Integer userid ,@Param("authentication_time") String authentication_time);
	
	
	String PhoneUserMoney(Integer userId);
	
	
	Integer SmsUserNum(Integer userId);
	
	
	Integer MonthUserphone(Integer userId);
	
	
	Integer UserNum(Integer userId);
	
	
	Integer PassUserNum(Integer userId);
	
	
	Integer WifiNamenum(User user);
	
	
	Integer UserloginTime(User user);
	
	
	Integer Userpt(Integer userId);
	
	
	int Userappt(User userId);
	
	
	int IdNumberUserCount(User userId);
	
	
	CommunicationDetection Userjm(Integer id);
	
	
	CommunicationCityInfo Usercommun(Integer xiaodai_userid);
	
	
	CallRecordListItemInfosTwo UserCallCount(String phone);
	
	
	Integer PhoneCa(Integer xiaodai_userid);
	
	
	EmergencyContactInfo JjUserNum(Integer xiaodai_userid);
	
	
	Integer TopUser(Integer userId);
	
	
	Integer TopTime(Integer userId);
	
	
	Integer TopCount(Integer userId);
	
	
	Integer UserAge(String phone);
	
	
	Integer TopJjCount(@Param("userId")Integer userId,@Param("list")List<String> list);
	
	
	RechargeInfo UserPhoneMoney(Integer userId);
	
	
	List<SensitiveInfoNewupa> MinJUser(User user);
	
	
	List<String> SelectUserPhones(Integer userId);
	
	
	Integer TongHUser(Integer userId);
	
	
	Integer ChuxTimeDay(Integer userId);
	
	
	//BigDecimal YueFLv(Integer userId);
	
	
	String UserphoneRes(String phone);
	
	
	Integer PhoneUser(Integer userId);
	
	
	List<Integer> PhoneCountData(@Param("userId")Integer userId,@Param("type")String type);
	
	
	Integer PhoneCUser(@Param("userId")Integer userId,@Param("type")String type);
	
	
	Integer PhoneCUserData(Integer userId);
	
	
	List<String> SelectPhone(Integer userId);
	
	
	Integer SelectUserCou(@Param("list")List<String> list,@Param("userId")Integer userId);
	
	
	Integer SelectUserCoulX(@Param("list")List<String> list,@Param("userId")Integer userId);
	
	
	List<Integer> SelectUserCoul(@Param("list")List<String> list,@Param("userId")Integer userId);
	
	
	List<String> SelectPhoneTop(Integer userId);
	
	
	List<Integer> SelectUserCoulA(@Param("list")List<String> list,@Param("userId")Integer userId);
	
	
	Integer User12560Count(@Param("userId")Integer userId,@Param("phone")String phone);
	
	
	List<String> UserHR(@Param("userId")Integer userId,@Param("type")String type);
	
	
	Integer SelectUserMaillst(@Param("list")List<String> list,@Param("userId")Integer userId);
	
	
	Integer UserOne(@Param("type")String type,@Param("userId")Integer userId);
	
	
	Integer UserAllPhone(Integer userId);
	
	
	Integer SelectUserApp(Integer userId);
	
	
	Integer OperatorID(Integer userId);
}

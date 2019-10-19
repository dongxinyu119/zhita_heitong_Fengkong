package com.zhita.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
	
}

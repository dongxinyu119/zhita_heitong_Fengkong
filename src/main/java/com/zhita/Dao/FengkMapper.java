package com.zhita.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhita.Collection.jointobligation.Data;
import com.zhita.Model.Beoverdue;
import com.zhita.Model.Configuration;
import com.zhita.Model.Jointobligation;
import com.zhita.Model.Maillist;
import com.zhita.Model.UserApp;
import com.zhita.Model.Usercheat;
import com.zhita.Model.Userportrait;

public interface FengkMapper {
	
	Integer AddAnti_fraud(Usercheat user);
	
	
	int AddJointobligation(Data data);
	
	
	int AddUserportrait(Userportrait userportr);
	
	
	Integer SelectAnti_fraudtotalCount(Usercheat user);
	
	
	List<Usercheat> SelectAnti_fraud(Usercheat user);
	
	
	Integer SelectUserportraittotalCount(Userportrait userportr);
	
	
	List<Userportrait> SelectUserportrait(Userportrait userportr);
	
	
	Integer SelectBeoverduetotalCount(Beoverdue be);
	
	
	List<Beoverdue> SelectBeoverdue(Beoverdue userportr);
	
	
	Integer SelectJointobligationtotalCount(Jointobligation be);
	
	
	List<Jointobligation> SelectJointobligation(Jointobligation userportr);
	
	
	Integer addUserPhone(Configuration conf);
	
	
	List<Configuration> AllUserPhone();

	
	Integer addMaillst(Maillist ma);
	
	
	Integer SelectUserId(String phone);
	
	
	Integer SelectMaillUserCount(Integer userId);
	
	
	Integer AddUserApp(UserApp userapp);
	
	
	int updateconfiguration(@Param("phone") String phone,@Param("phoneMarket") String phoneMarket,@Param("phoneModel") String phoneModel,@Param("phoneRes") String phoneRes,@Param("lac") String lac, @Param("loc")String loc,
			@Param("uuid")String uuid,@Param("wifiIP") String wifiIP,@Param("wifiMac") String wifiMac,@Param("wifiName") String wifiName,@Param("wrapName") String wrapName);

	
	Integer DeleteAppName(Integer uid);
}

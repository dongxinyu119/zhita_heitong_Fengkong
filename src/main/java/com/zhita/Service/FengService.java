package com.zhita.Service;

import java.util.Map;

import com.zhita.Collection.jointobligation.Data;
import com.zhita.Model.Beoverdue;
import com.zhita.Model.Jointobligation;
import com.zhita.Model.Usercheat;
import com.zhita.Model.Userportrait;

public interface FengService {
	
	Integer AddAntiFraud(Usercheat user);
	
	
	int AddJointobligation(Data data);
	
	
	int AddUserportrait(Userportrait userportr);
	
	
	Map<String, Object> SelectAnti_fraud(Usercheat user);
	
	
	Map<String, Object> SelectUserportrait(Userportrait user);
	
	
	Map<String, Object> SelectBeoverdue(Beoverdue user);
	
	
	Map<String, Object> SelectJointobligation(Jointobligation user);
	
	
	Map<String, Object> AddUserPhone(String data);
	
	
	Map<String, Object> AllUserPhone();
	
	
	Map<String, Object> AddMaillist(String jsonlist,String phone,Integer userId);

}

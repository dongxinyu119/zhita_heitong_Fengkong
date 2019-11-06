package com.zhita.Serviceimp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.zhita.Collection.anti_fraud.AppName;
import com.zhita.Collection.jointobligation.Data;
import com.zhita.Collection.riskmanagement.ReturnUserphone;
import com.zhita.Collection.userportrait.Jsonlist;
import com.zhita.Dao.FengkMapper;
import com.zhita.Model.Beoverdue;
import com.zhita.Model.Configuration;
import com.zhita.Model.Jointobligation;
import com.zhita.Model.Maillist;
import com.zhita.Model.UserApp;
import com.zhita.Model.Usercheat;
import com.zhita.Model.Userportrait;
import com.zhita.Service.FengService;
import com.zhita.Util.PageUtil;
import com.zhita.Util.Timestamps;



@Service
public class FengServiceimp implements FengService{

	
	@Autowired
	private FengkMapper fmap;
	
	
	@Override
	public Integer AddAntiFraud(Usercheat user) {
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			user.setSend_time(Timestamps.dateToStamp1(sim.format(new Date())));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return fmap.AddAnti_fraud(user);
	}


	@Override
	public int AddJointobligation(Data data) {
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			data.setSend_time(Timestamps.dateToStamp1(sim.format(new Date())));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return fmap.AddJointobligation(data);
	}


	@Override
	public int AddUserportrait(Userportrait userportr) {
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			userportr.setSend_time(Timestamps.dateToStamp1(sim.format(new Date())));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return fmap.AddUserportrait(userportr);
	}


	@Override
	public Map<String, Object> SelectAnti_fraud(Usercheat user) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer totalCount = fmap.SelectAnti_fraudtotalCount(user);
		PageUtil pages = new PageUtil(user.getPage(), totalCount);
		user.setPage(pages.getPage());
		List<Usercheat> usercheat = fmap.SelectAnti_fraud(user);
		for(int i=0;i<usercheat.size();i++){
			usercheat.get(i).setSend_time(Timestamps.stampToDate(usercheat.get(i).getSend_time()));
		}
		map.put("PageUtil", pages);
		map.put("Usercheat", usercheat);
		return map;
	}
	
	
	
	@Override
	public Map<String, Object> SelectUserportrait(Userportrait user) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer totalCount = fmap.SelectUserportraittotalCount(user);
		PageUtil pages = new PageUtil(user.getPage(), totalCount);
		user.setPage(pages.getPage());
		List<Userportrait> usercheat = fmap.SelectUserportrait(user);
		for(int i=0;i<usercheat.size();i++){
			usercheat.get(i).setSend_time(Timestamps.stampToDate(usercheat.get(i).getSend_time()));
		}
		map.put("PageUtil", pages);
		map.put("Userportrait", usercheat);
		return map;
	}
	
	
	
	@Override
	public Map<String, Object> SelectBeoverdue(Beoverdue user) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer totalCount = fmap.SelectBeoverduetotalCount(user);
		PageUtil pages = new PageUtil(user.getPage(), totalCount);
		user.setPage(pages.getPage());
		List<Beoverdue> usercheat = fmap.SelectBeoverdue(user);
		for(int i=0;i<usercheat.size();i++){
			usercheat.get(i).setSend_time(Timestamps.stampToDate(usercheat.get(i).getSend_time()));
		}
		map.put("PageUtil", pages);
		map.put("Beoverdue", usercheat);
		return map;
	}


	@Override
	public Map<String, Object> SelectJointobligation(Jointobligation user) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer totalCount = fmap.SelectJointobligationtotalCount(user);
		PageUtil pages = new PageUtil(user.getPage(), totalCount);
		user.setPage(pages.getPage());
		List<Jointobligation> usercheat = fmap.SelectJointobligation(user);
		for(int i=0;i<usercheat.size();i++){
			usercheat.get(i).setSend_time(Timestamps.stampToDate(usercheat.get(i).getSend_time()));
		}
		map.put("PageUtil", pages);
		map.put("Usercheat", usercheat);
		return map;
	}


	@Override
	public Map<String, Object> AddUserPhone(String jsonString) {
		ReturnUserphone com = JSONObject.parseObject(jsonString, ReturnUserphone.class);
		Configuration conf = new Configuration();
		conf = JSONObject.parseObject(com.getJsonString(), Configuration.class);
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		conf.setUserId(com.getUserId());
		conf.setApp_name(com.getApp_name());
		  try {
			  conf.setSend_time(Timestamps.dateToStamp1(sim.format(new Date())));
		} catch (Exception e) {
			// TODO: handle exception
		}
		/*JSONObject jsonObject = JSONObject.parseObject(jsonString);
		  String phoneMarket = jsonObject.getString("phoneMarket");
		  String phoneModel = jsonObject.getString("phoneModel");
		  String phoneRes = jsonObject.getString("phoneRes");
		  String phoneStand = jsonObject.getString("phoneStand"); 
		  JSONObject jsonObject1 = JSONObject.parseObject(phoneStand);
		  String lac = jsonObject1.getString("lac");
		  String loc = jsonObject1.getString("loc");
		  String uuid = jsonObject.getString("uuid");
		  String wifiIP = jsonObject.getString("wifiIP");
		  String wifiMac = jsonObject.getString("wifiMac");
		  String wifiName = jsonObject.getString("wifiName");
		  String wrapName = jsonObject.getString("wrapName");*/
		
		System.out.println("手机号:"+com.getPhone());
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(com.getPhone() != null){
			Integer userId = fmap.SelectUserId(com.getPhone());
			
			conf.setPhone(com.getPhone());
			
			if(userId != null){//根据手机号查询用户是否存在  存在  更新
				int num = fmap.updateconfiguration(com.getPhone(),conf.getPhoneMarket(),conf.getPhoneModel(),conf.getPhoneRes(),
						conf.getLac(),conf.getLoc(),conf.getUuid(),conf.getWifiIP(),conf.getWifiMac(),conf.getWifiName(),conf.getWrapName(),conf.getApp_name());
				if (num==1) {
					Integer deleteId = fmap.DeleteAppName(userId);
					System.out.println(deleteId);
					 if(deleteId != null){
						 List<AppName> names = JSONObject.parseArray(conf.getWrapName(), AppName.class);
						  Integer uid = fmap.SelectUserId(com.getPhone());
						  List<UserApp> uapps = new ArrayList<UserApp>();
						  for(int i=0;i<names.size();i++){
							  UserApp uapp = new UserApp();
							  uapp.setName(names.get(i).getName());
							  uapp.setTime(names.get(i).getTime());
							  uapp.setUserId(uid);
							  uapps.add(uapp);
						  }
						  	fmap.AddUserApp(uapps);
						  	map.put("Ncode","2000");
						 	map.put("code","200");
							map.put("msg","数据更新成功");
					 }else{
						 	map.put("Ncode","0");
							map.put("code","0");
							map.put("msg","数据更新失败");
					 }
					  
					  
				}else {
					map.put("Ncode","405");
					map.put("code","405");
					map.put("msg","数据更新失败");
				}
			}else{//不存在  添加
			  
			  Integer addId = fmap.addUserPhone(conf);
			  
			  if(addId != null){
				  List<AppName> names = JSONObject.parseArray(conf.getWrapName(), AppName.class);
				  Integer usId = fmap.SelectUserId(com.getPhone());
				  List<UserApp> uapps = new ArrayList<UserApp>();
				  for(int i=0;i<names.size();i++){
					  UserApp uapp = new UserApp();
					  uapp.setName(names.get(i).getName());
					  uapp.setTime(names.get(i).getTime());
					  uapp.setUserId(usId);
					  uapps.add(uapp);
				  }
				  fmap.AddUserApp(uapps);
				  map.put("code", 200);
				  map.put("msg", "添加成功");
			  }else{
				  map.put("code", 0);
				  map.put("msg", "添加失败");
			  }
			  
			}
		}else{
			map.put("code", 0);
			map.put("msg", "手机号不能为空");
		}
		
		return map;
	}


	@Override
	public Map<String, Object> AllUserPhone() {
		List<Configuration> cons = fmap.AllUserPhone();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Configuration", cons);
		return map;
	}


	@Override
	public Map<String, Object> AddMaillist(String jsonlist,String phone,Integer userId) {
		System.out.println("数据:"+jsonlist);
		List<Jsonlist> jsonlists = JSONObject.parseArray(jsonlist, Jsonlist.class);
		Map<String, Object> map = new HashMap<String, Object>();
		if(userId != null){
			int count = fmap.SelectMaillUserCount(userId);
			if(count == 0){
			for(int i=0;i<jsonlists.size();i++){
				if(!StringUtils.isEmpty(jsonlists.get(i).getName())){
				    String name = jsonlists.get(i).getName().replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", "");
				    jsonlists.get(i).setName(name);
				}else{
				        jsonlists.get(i).getName();
				}
				System.out.println("数据:"+jsonlists.get(i).getName()+":CC:"+jsonlists.get(i).getPhone());
					Maillist ma = new Maillist();
					ma.setPhone(jsonlists.get(i).getPhone());
					ma.setName(jsonlists.get(i).getName());
					ma.setUserId(userId);
					fmap.addMaillst(ma);
				}
				
				map.put("code", 200);
				map.put("msg", "导入成功");
			}else{
				map.put("code", 0);
				map.put("msg", "已导入");
			}
		}else{
			map.put("code", 0);
			map.put("msg", "没有该用户运营商信息");
		}
		
		return map;
	}
	
	
	
	

}

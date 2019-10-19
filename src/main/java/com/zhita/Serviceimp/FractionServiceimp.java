package com.zhita.Serviceimp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhita.Dao.FractionMapper;
import com.zhita.Model.Rulelist;
import com.zhita.Model.Rulelist_detail;
import com.zhita.Model.User;
import com.zhita.Service.FractionService;
import com.zhita.Util.Timestamps;


@Service
public class FractionServiceimp implements FractionService{
	
	
	@Autowired
	private FractionMapper fractionmapper;
	
	

	@Override
	public Integer AppCount(Integer userId) {
		return fractionmapper.AppCount(userId);
	}

	@Override
	public Rulelist RulelistFraction(Integer id) {
		return fractionmapper.FractionUser(id);
	}

	@Override
	public Integer Emergency_contact_infoPhone(Integer id) {
		return fractionmapper.Emergency_contact_infoPhone(id);
	}

	@Override
	public Integer IpPhoneCount(Integer userId) {
		return fractionmapper.IpPhone(userId);
	}

	@Override
	public Integer OneHomeCount(String phone) {
		Integer id = fractionmapper.getId(phone);
		if(id != null){
		User user = new User();
		user.setPhone(phone);
		SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd ");
        SimpleDateFormat sim = new SimpleDateFormat("HH");
        String statu = sim.format(new Date())+":00:00";
        String end = sim.format(new Date())+":59:59";
        try {
        	user.setStatu_time(Timestamps.dateToStamp1(day.format(new Date())+statu));
        	user.setEnd_time(Timestamps.dateToStamp1(day.format(new Date())+end));
		} catch (Exception e) {
			// TODO: handle exception
		}
        return fractionmapper.PhoneCount(user);
		}else{
			return 0;
		}
		
	}

	@Override
	public Integer OneHomeIDnumberCount(String idNumber) {
		User user = new User();
		user.setIdnumber(idNumber);
		SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd ");
        SimpleDateFormat sim = new SimpleDateFormat("HH");
        String statu = sim.format(new Date())+":00:00";
        String end = sim.format(new Date())+":59:59";
        try {
        	user.setStatu_time(Timestamps.dateToStamp1(day.format(new Date())+statu));
        	user.setEnd_time(Timestamps.dateToStamp1(day.format(new Date())+end));
		} catch (Exception e) {
			// TODO: handle exception
		}
        return fractionmapper.PhoneCount(user);
	}

	@Override
	public Integer UserPhoneCount(Integer userId) {
		User user = new User();
		user.setUserId(userId);
		user.setPhone("400");
		return fractionmapper.UserPhoneCount(user);
	}

	@Override
	public Integer UserNameFatherCount(Integer userId) {
		int a = 0;
		User user = new User();
		user.setUserId(userId);
		user.setName("爸爸");
		a=fractionmapper.UserPhoneCount(user);
		user.setName("爹");
		a=a+fractionmapper.UserPhoneCount(user);
		user.setName("妈码");
		a=a+fractionmapper.UserPhoneCount(user);
		user.setName("娘");
		a=a+fractionmapper.UserPhoneCount(user);
		return a;
	}
	
	
	
	@Override
	public Integer UserQinqCount(User user) {
		return fractionmapper.UserPhoneCount(user);
	}

	@Override
	public Integer UserPhoneCount1(Integer userId) {
		User user = new User();
		user.setUserId(userId);
		return fractionmapper.UserPhoneCount(user);
	}

	@Override
	public Integer AddUser(User u) {
		return fractionmapper.AddUser(u);
	}

	@Override
	public Integer UserZuC(Integer userId) {
		return fractionmapper.UserZuc(userId);
	}

	@Override
	public Integer AppNum(User user) {
		return fractionmapper.UserAppnum(user);
	}

	@Override
	public Integer UserAppCount(Integer userId) {
		return fractionmapper.UserAppCount(userId);
	}

	@Override
	public Integer AddCount(Rulelist_detail ru) {
		return fractionmapper.AddUserCount(ru);
	}

	@Override
	public Integer MaillstUserPhone(Integer userId) {
		return fractionmapper.SelectUserPhone(userId);
	}

	@Override
	public Integer PayUserNum(User user) {
		List<Integer> suma = fractionmapper.PayUserNum(user);
		Integer a = 0;
		if(suma==null){
			return a;
		}
		for(int i=0;i<suma.size();i++){
			a = a + suma.get(i);
		}
		return a;
	}

	@Override
	public Integer PhoneNum(User user) {
		List<Integer> suma = fractionmapper.PhoneNum(user);
		Integer a = 0;
		if(suma==null){
			return a;
		}
		
		for(int i=0;i<suma.size();i++){
			a = a + suma.get(i);
		}
		return a;
	}

	@Override
	public Integer jjPhoneNum(User user) {
		List<Integer> suma = fractionmapper.jjPhoneNum(user);
		Integer a = 0;
		
		if(suma==null){
			return a;
		}
		
		for(int i=0;i<suma.size();i++){
			a = a + suma.get(i);
		}
		return a;
	}

	@Override
	public Integer PFhoneNum(User user) {
		return fractionmapper.PhoneNumA(user);
	}

	@Override
	public User ReportNum(User user) {
		return fractionmapper.ReportNum(user);
	}

	@Override
	public Integer ReportID(User user) {
		return fractionmapper.ReportID(user);
	}

	@Override
	public Integer AppInfoUser(User user) {
		return fractionmapper.AppInFoUser(user);
	}

	@Override
	public Integer MacUserNum(User user) {
		return fractionmapper.MacNum(user);
	}

	@Override
	public Integer PhoneUserNum(User user) {
		return fractionmapper.PhoneUserNum(user);
	}

	@Override
	public Integer DeleteRulet(Integer userid,String authentication_time) {
		return fractionmapper.DeleteRule(userid, authentication_time);
	}


	
	
	

}

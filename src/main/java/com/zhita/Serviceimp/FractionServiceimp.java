package com.zhita.Serviceimp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhita.Dao.FractionMapper;
import com.zhita.Model.CommunicationCityInfo;
import com.zhita.Model.CommunicationDetection;
import com.zhita.Model.EmergencyContactInfo;
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
			if(suma.get(i)>3){
				return suma.get(i);
			}
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

	@Override
	public String PhoneUserMoney(Integer userId) {
		return fractionmapper.PhoneUserMoney(userId);
	}

	@Override
	public Integer SmsUserMoney(Integer userId) {
		return fractionmapper.SmsUserNum(userId);
	}

	@Override
	public Integer MonthUserphone(Integer userId) {
		return fractionmapper.MonthUserphone(userId);
	}

	@Override
	public Integer UserNum(Integer userId) {
		return fractionmapper.UserNum(userId);
	}

	@Override
	public Integer PassUserNum(Integer userId) {
		return fractionmapper.PassUserNum(userId);
	}

	@Override
	public Integer WifiNameNum(User userwifiaz) {
		System.out.println("姓名:"+userwifiaz.getName());
		return fractionmapper.WifiNamenum(userwifiaz);
	}

	@Override
	public Integer UserLongintime(User user) {
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String time = sim.format(new Date());
		try {
			user.setStatu_time(Timestamps.dateToStamp1(time+" 24:00:00"));
			user.setEnd_time(Timestamps.dateToStamp1(time+" 05:00:00"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return fractionmapper.UserloginTime(user);
	}

	@Override
	public Integer Userpt(Integer userId) {
		return fractionmapper.Userpt(userId);
	}

	@Override
	public int Userappt(User userId) {
		return fractionmapper.Userappt(userId);
	}

	@Override
	public int IDNumberCount(User userId) {
		return fractionmapper.IdNumberUserCount(userId);
	}

	@Override
	public CommunicationDetection UserJm(Integer userId) {
		return fractionmapper.Userjm(userId);
	}

	@Override
	public CommunicationCityInfo Usercommun(Integer xiaodai_userid) {
		return fractionmapper.Usercommun(xiaodai_userid);
	}

	@Override
	public Integer PhoneCa(Integer xiaodai_userid) {
		return fractionmapper.PhoneCa(xiaodai_userid);
	}

	@Override
	public EmergencyContactInfo JjUserNum(Integer xiaodai_userid) {
		return fractionmapper.JjUserNum(xiaodai_userid);
	}

	@Override
	public Integer TopUser(Integer userId) {
		return fractionmapper.TopUser(userId);
	}

	@Override
	public Integer TopTime(Integer userId) {
		return fractionmapper.TopTime(userId);
	}

	@Override
	public Integer TopCount(Integer userId) {
		return fractionmapper.TopCount(userId);
	}

	@Override
	public Integer UserAge(String phone) {
		return fractionmapper.UserAge(phone);
	}

	@Override
	public Integer TopJjCount(Integer userId) {
		return fractionmapper.TopJjCount(userId);
	}


	
	
	

}

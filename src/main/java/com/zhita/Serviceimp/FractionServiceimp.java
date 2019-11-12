package com.zhita.Serviceimp;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhita.Dao.FractionMapper;
import com.zhita.Model.CommunicationCityInfo;
import com.zhita.Model.CommunicationDetection;
import com.zhita.Model.EmergencyContactInfo;
import com.zhita.Model.RechargeInfo;
import com.zhita.Model.Rulelist;
import com.zhita.Model.Rulelist_detail;
import com.zhita.Model.SensitiveInfoNewupa;
import com.zhita.Model.User;
import com.zhita.Service.FractionService;
import com.zhita.Util.PhoneDeal;
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
		Integer id = fractionmapper.OperatorID(user.getUserId());
		Integer a = 0;
		if(id != null){
			a=fractionmapper.AppInFoUser(user);
		}
		return a;
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
		PhoneDeal phoneDeal = new PhoneDeal();
		List<String> phones = fractionmapper.SelectUserPhones(userId);
		List<String> phonList = new ArrayList<String>();
		for(int i = 0 ; i < phones.size() ; i++){
			phonList.add(phoneDeal.decryption(phones.get(i)));
		}
		return fractionmapper.TopJjCount(userId,phonList);
	}
	
	

	@Override
	public BigDecimal UserPhoneMoney(Integer userId) {
		RechargeInfo rechar = fractionmapper.UserPhoneMoney(userId);
		BigDecimal acmoney = null;
		if(rechar != null){
			acmoney = rechar.getRecharge_amount().divide(new BigDecimal(rechar.getRecharge_count()));
		}else{
			acmoney = new BigDecimal(0);
		}
		
		return acmoney;
	}

	@Override
	public Integer MinJUser(User userId) {
		 List<SensitiveInfoNewupa> sens = fractionmapper.MinJUser(userId);
		 Integer a = 0;
		 if(sens.size()!=0){
			 for(int i=0;i<sens.size();i++){
				 if(sens.get(i).getListc() != null){
					 if(sens.get(i).getListc().get(i).getListct() != null){
						 a = a + Integer.valueOf(sens.get(i).getListc().get(i).getListct().get(i).getCallingCount());
					 }
					
				 }
				
			 }
		 }
		 return null;
	}

	@Override
	public Integer TongHUser(Integer userId) {
		return fractionmapper.TongHUser(userId);
	}

	@Override
	public Integer ChuxTimeDay(Integer userId) {
		return fractionmapper.ChuxTimeDay(userId);
	}

	@Override
	public BigDecimal YueFLv(Integer userId) {
		return null;
	}

	@Override
	public Integer PhoneUser(Integer userId, String phone) {
		String phoneRes = fractionmapper.UserphoneRes(phone);//判断是不是安卓
		Integer aIn = 0;
		if(phoneRes != null){
			aIn=fractionmapper.PhoneUser(userId);
		}
		return aIn;
	}

	@Override
	public Integer PhoneUserData(Integer userId, String phone) {
		String phoneRes = fractionmapper.UserphoneRes(phone);//判断是不是安卓
		Integer aIn = 0;
		if(phoneRes != null){
			String type = "呼出";
			List<Integer> a=fractionmapper.PhoneCountData(userId,type);
			aIn = a.size();
		}
		return aIn;
	}

	@Override
	public Integer PhoneCUser(Integer userId, String phone) {
		String phoneRes = fractionmapper.UserphoneRes(phone);//判断是不是安卓
		Integer aIn = 0;
		if(phoneRes != null){
			String type = "呼出";
			aIn=fractionmapper.PhoneCUser(userId,type);
		}
		return aIn;
	}

	@Override
	public Integer PhonehrUser(Integer userId, String phone) {
		String phoneRes = fractionmapper.UserphoneRes(phone);//判断是不是安卓
		Integer aIn = 0;
		if(phoneRes != null){
			String type = "呼入";
			List<Integer> a=fractionmapper.PhoneCountData(userId,type);
			aIn = a.size();
		}
		return aIn;
	}

	@Override
	public Integer PhoneHrCUser(Integer userId, String phone) {
		String phoneRes = fractionmapper.UserphoneRes(phone);//判断是不是安卓
		Integer aIn = 0;
		if(phoneRes != null){
			String type = "呼入";
			aIn=fractionmapper.PhoneCUser(userId,type);
		}
		return aIn;
	}

	@Override
	public Double PhoneCUserData(Integer userId, String phone) {
		String phoneRes = fractionmapper.UserphoneRes(phone);//判断是不是安卓
		Integer aIn = 0;
		Double f1 = new Double(0);
		if(phoneRes != null){
			Integer a = fractionmapper.PhoneCUserData(userId);
			if(a != null){
				String type = "呼出";
				System.out.println("总数:"+a);
				if(a != 0){
					aIn=fractionmapper.PhoneCUser(userId,type);
					System.out.println("命中数:"+aIn);
					f1 = new BigDecimal((float)aIn/a).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
					f1 = f1*100;
				}
				
			}
			
		}
		return f1;
	}

	@Override
	public Double PhoneCuUserData(Integer userId, String phone) {
		String phoneRes = fractionmapper.UserphoneRes(phone);//判断是不是安卓
		Integer aIn = 0;
		Double f1 = new Double(0);
		if(phoneRes != null){
			Integer a = fractionmapper.PhoneCUserData(userId);
			if(a != null){
				
				if(a != 0){
					String type = "呼入";
					aIn=fractionmapper.PhoneCUser(userId,type);
					f1 = new BigDecimal((float)aIn/a).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
					f1 = f1*100;
				}
				
			}
			
		}
		return f1;
	}

	@Override
	public Integer AndroidTop(Integer userId, String phone) {
		String phoneRes = fractionmapper.UserphoneRes(phone);//判断是不是安卓
		Integer aIn = 0;
		if(phoneRes != null){
			List<String> phones = fractionmapper.SelectPhone(userId);
			if(phones != null){
				if(phones.size()!=0){
					aIn = fractionmapper.SelectUserCou(phones, userId);
				}
			}
		}
		return aIn;
	}

	@Override
	public Integer AndroidTopJj(Integer userId, String phone) {
		String phoneRes = fractionmapper.UserphoneRes(phone);//判断是不是安卓
		Integer aIn = 0;
		if(phoneRes != null){
			List<String> phones = fractionmapper.SelectPhone(userId);
			if(phones != null){
				if(phones.size()!=0){
					aIn = fractionmapper.SelectUserCoulX(phones, userId);
				}
			}
		}
		return aIn;
	}

	@Override
	public Integer AndroidTopCount(Integer userId, String phone) {
		String phoneRes = fractionmapper.UserphoneRes(phone);//判断是不是安卓
		Integer aIn = 0;
		if(phoneRes != null){
			List<String> phones = fractionmapper.SelectPhoneTop(userId);
			if(phones != null){
				System.out.println("电话长度:"+phones.size());
				if(phones.size()!=0){
				List<Integer> mailsList = fractionmapper.SelectUserCoul(phones, userId);
				aIn = mailsList.size();
				}
			}
		}
		return aIn;
	}

	@Override
	public Integer AndroidTopJJCount(Integer userId, String phone) {
		String phoneRes = fractionmapper.UserphoneRes(phone);//判断是不是安卓
		Integer aIn = 0;
		if(phoneRes != null){
			List<String> phones = fractionmapper.SelectPhoneTop(userId);
			if(phones != null){
				if(phones.size() != 0){
					List<Integer> mailsList = fractionmapper.SelectUserCoulA(phones, userId);
					Rulelist reRulelist = fractionmapper.FractionUser(325);
					for(int i=0;i<mailsList.size();i++){
						if(mailsList.get(i)<Integer.valueOf(reRulelist.getThresholdValue())){
							aIn = aIn+1;
						}
					}
				}
			}
		}
		return aIn;
	}

	@Override
	public Integer AndroidTop10(Integer userId, String phone) {
		String phoneRes = fractionmapper.UserphoneRes(phone);//判断是不是安卓
		Integer aIn = 0;
		if(phoneRes != null){
			List<String> phones = fractionmapper.SelectPhoneTop(userId);
			if(phones != null){
				if(phones.size()!=0){
				List<Integer> mailsList = fractionmapper.SelectUserCoul(phones, userId);
				aIn = mailsList.size();
				}
			}
		}
		return aIn;
	}

	@Override
	public Integer AndroidTop12560(Integer userId, String phone,String type) {
		String phoneRes = fractionmapper.UserphoneRes(phone);//判断是不是安卓
		Integer aIn = 0;
		if(phoneRes != null){
			aIn = fractionmapper.User12560Count(userId,type);
		}
		return aIn;
	}

	@Override
	public Integer UserHR(Integer userId, String phone,String type) {
		String phoneRes = fractionmapper.UserphoneRes(phone);//判断是不是安卓
		Integer aIn = 0;
		if(phoneRes != null){
			List<String> numbers = fractionmapper.UserHR(userId,type);//获取通话记录中的手机号
			if(numbers != null){
				if(numbers.size()!=0){
				aIn = fractionmapper.SelectUserMaillst(numbers,userId);
				}
			}
		}
		return aIn;
	}

	@Override
	public Integer UserHROne(Integer userId, String phone,String type) {
		String phoneRes = fractionmapper.UserphoneRes(phone);//判断是不是安卓
		Integer aIn = 0;
		if(phoneRes != null){
			aIn = fractionmapper.UserOne(type,userId);//是否为安卓机且与400开头号码通话次数
		}
		return aIn;
	}

	@Override
	public Integer SelectUserApp(Integer userId) {
		return fractionmapper.SelectUserApp(userId);
	}





	
	
	

}

package com.zhita.Serviceimp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhita.Dao.FengkMapper;
import com.zhita.Dao.RiskDao;
import com.zhita.Model.Configuration;
import com.zhita.Service.RiskService;
import com.zhita.Util.Timestamps;


@Service
public class RiskServiceimp implements RiskService{
	
	@Autowired
	private RiskDao rdao;
	
	
	
	@Autowired
	private FengkMapper fmap;


	
	/**
	 * phonetype   手机通讯录联系人数量
	 * 
	 * daynum   一天内的登陆设配数
	 * 
	 * uuidtype  登陆设备获取异常   
	 * 
	 */
	@Override
	public Map<String, Object> RiskRturncode(String phone) {
		
		Integer uuidtype = 0;
		String phonetype = "0";
		String daytype = "0";
		String wifitype = "0";
		String wifimactype = "0";
		String maillistype = "0";
		String apptype = "0";
		Map<String, Object> map = new HashMap<String, Object>();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String times = sim.format(new Date());
		String statu_time = null;
		String end_time = null;
		
		try {
			statu_time = Timestamps.dateToStamp1(times+" 00:00:01");
			end_time = Timestamps.dateToStamp1(times+" 23:59:59");
		} catch (Exception e) {
			// TODO: handle exception
		}
		Configuration con = rdao.UserUUID(phone);
		Integer userId = fmap.SelectUserId(phone);
		if(userId != null){
			
		
		Integer phonenum = rdao.UserPhoneCount(userId);//通讯录联系人数量
		
		if(phonenum < 20){
			phonetype = "1";
		}
		con.setStatu_time(statu_time);
		con.setEnd_time(end_time);
		if(con.getUuid()!=null){
			Integer daynum = rdao.UserLoginNum(con);//一天内的相同设备数
			if(daynum>8){
				daytype="1";
			}
		}
		if(con.getUuid()==null){
			uuidtype=1;
		}
		Integer WifiIPNum = rdao.UserWifiIPNum(con);//一天内WIFIIP连接相同数
		if(WifiIPNum>3){
			wifitype = "1";
		}
		
		Integer WifiMacNum = rdao.UserWifiMacNum(con);//WIFIMacnum 关联数
		/*if(WifiMacNum>3){
			wifimactype = "1";
		}*/
		Integer sumcount = 0;
		Configuration config = new Configuration();
		config.setUserId(fmap.SelectUserId(phone));
		
		config.setName("借");
		Integer jie = rdao.NameMaillist(config);
		config.setName("贷");
		Integer dai = rdao.NameMaillist(config);
		config.setName("银行");
		Integer bank = rdao.NameMaillist(config);
		sumcount = jie+dai+bank;
		if(sumcount>5){
			maillistype = "1";
		}
		
		Integer appnum = 0;
		config.setName("借");
		Integer cc = rdao.AppNum(config);
		config.setName("贷");
		Integer kuan = rdao.AppNum(config);
		config.setName("银行");
		Integer bn = rdao.AppNum(config);
		config.setName("花");
		Integer hua = rdao.AppNum(config);
		config.setName("米");
		Integer mi = rdao.AppNum(config);
		appnum = mi+cc+bn+hua+kuan;
		if(appnum>10){
			apptype="1";
		}
		}else{
			map.put("phonetype", "1");//通讯录状态
			map.put("uuidtype", 1);//设备异常
			map.put("wifitype", "1");//一天内同一IP关联设备状态
			map.put("daytype", "1");//一天内相同设备状态
			map.put("wifimactype", "1");//wifimac关联用户状态
			map.put("maillistype", "1");//通讯录数量关联用户状态
			map.put("apptype", "1");//app状态
			return map;
		}
		
		map.put("phonetype", phonetype);//通讯录状态
		map.put("uuidtype", uuidtype);//设备异常
		map.put("wifitype", wifitype);//一天内同一IP关联设备状态
		map.put("daytype", daytype);//一天内相同设备状态
		map.put("wifimactype", wifimactype);//wifimac关联用户状态
		map.put("maillistype", maillistype);//通讯录数量关联用户状态
		map.put("apptype", apptype);//app状态
		return map;
	}



	@Override
	public Map<String, Object> SelectMaillistPhone(String phone) {
		Integer userId = fmap.SelectUserId(phone);
		List<String> phones = rdao.SelectUserMaillist(userId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Phones", phones);
		return map;
	}



	
	
	
	
	
	
	
	
	
	
	
	
}

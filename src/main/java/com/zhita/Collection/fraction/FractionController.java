package com.zhita.Collection.fraction;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhita.Dao.FengkMapper;
import com.zhita.Dao.RiskDao;
import com.zhita.Model.Configuration;
import com.zhita.Model.Rulelist;
import com.zhita.Model.Rulelist_detail;
import com.zhita.Model.User;
import com.zhita.Service.FractionService;
import com.zhita.Util.Timestamps;



@Controller
@RequestMapping("fraction")
public class FractionController {
	
	
	@Autowired
	private FractionService fser;
	
	
	
	@Autowired
	private RiskDao rdao;
	
	
	
	@Autowired
	private FengkMapper fmap;
	
	
	@SuppressWarnings("null")
	@RequestMapping("Exhibitionfraction")
	@ResponseBody
	public Map<String, Object> SeleExhibition(Integer userId,String phone,String name,String idNumber,String appId){
		Map<String, Object> map = new HashMap<String, Object>();
		Integer count = 1000;
		User u = new User();
		SimpleDateFormat sima = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			u.setAuthentication_time(Timestamps.dateToStamp1(sima.format(new Date())));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("走接口");
		try {
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
			
			Rulelist_detail ru = new Rulelist_detail();
			ru.setAuthentication_time(u.getAuthentication_time());
			Integer a = fser.AppCount(userId);//26
			int id = 26; 
			Rulelist re = fser.RulelistFraction(id);//查询规则id为  27  的风险分值
			System.out.println(re.getValue_at_risk());
			if(re.getStatus()!=2){
				if(a != null){
					if(a < Integer.valueOf(re.getThresholdValue())){
						count = Integer.valueOf(re.getValue_at_risk());
						ru.setUserid(userId);
						ru.setValue_at_risk(re.getValue_at_risk());
						ru.setRtid(re.getTypeid());
						ru.setRid(id);
						fser.AddCount(ru);
					}
				}
			}
			
			
			id = 27; 
			re = fser.RulelistFraction(id);//查询规则id为  27  的风险分值
			if(re.getStatus()!=2){
					if(a != null){
						if(a > Integer.valueOf(re.getThresholdValue())){
							count = Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			
			Configuration con = rdao.UserUUID(phone);
				
			
			Integer phonenum = rdao.UserPhoneCount(userId);//通讯录联系人数量
			id = 67;
			re = fser.RulelistFraction(id);//查询规则id为 67  的风险分值
			if(re.getStatus()!=2){
					if(phonenum != null){
						if(phonenum < Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			con.setStatu_time(statu_time);
			con.setEnd_time(end_time);
			id = 70;
			re = fser.RulelistFraction(id);//查询规则id为 70  的风险分值
			if(re.getStatus()!=2){
					if(con.getUuid()!=null){//	id 70 
						Integer daynum = rdao.UserLoginNum(con);//一天内的相同设备数
						if(daynum != null){
							if(daynum > Integer.valueOf(re.getValue_at_risk())){
								count = count-Integer.valueOf(re.getValue_at_risk());
								ru.setUserid(userId);
								ru.setValue_at_risk(re.getValue_at_risk());
								ru.setRid(id);
								ru.setRtid(re.getTypeid());
								fser.AddCount(ru);
							}
						}
					}
			}
			
			
			
			
			id = 71;
			re = fser.RulelistFraction(id);//查询规则id为 71  的风险分值
			if(re.getStatus() != 2){
						if(con.getUuid()==null){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
					}
			}
			
			
			
			
			
			id = 72;
			re = fser.RulelistFraction(id);//查询规则id为 72  的风险分值
			if(re.getStatus() != 2){
					Integer WifiIPNum = rdao.UserWifiIPNum(con);//一天内WIFIIP连接相同数
					if(WifiIPNum != null){
						if(WifiIPNum > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
						}
					}
			}
			
			
			id = 75;
			re = fser.RulelistFraction(id);//查询规则id为 75  的风险分值
			if(re.getStatus() != 2){
					Integer WifiMacNum = rdao.UserWifiMacNum(con);//WIFIMacnum 关联数
					if(WifiMacNum != null){
						if(WifiMacNum > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			Configuration config = new Configuration();
			
			id = 76;
			re = fser.RulelistFraction(id);//查询规则id为 76  的风险分值
			if(re.getStatus() != 2){
					Integer sumcount = 0;
					config.setUserId(fmap.SelectUserId(phone));
					config.setName("借");
					Integer jie = rdao.NameMaillist(config);
					config.setName("贷");
					Integer dai = rdao.NameMaillist(config);
					config.setName("银行");
					Integer bank = rdao.NameMaillist(config);
					config.setName("催");
					Integer bankC = rdao.NameMaillist(config);
					sumcount = jie+dai+bank+bankC;
					if(sumcount != null){
						if(sumcount > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			id = 77;
			re = fser.RulelistFraction(id);//查询规则id为 77  的风险分值
			if(re.getStatus() != 2){
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
					if(appnum != null){
						if(appnum > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			id = 25;
			re = fser.RulelistFraction(id);//查询规则id为 25  的风险分值
			if(re.getStatus() != 2){
					Integer WifiMacNum = fser.Emergency_contact_infoPhone(userId);//WIFIMacnum 关联数
					if(WifiMacNum != null){
						if(WifiMacNum > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			
			id = 59;
			re = fser.RulelistFraction(id);//查询规则id为 59  的风险分值
			if(re.getStatus() != 2){
					Integer IpPhone = fser.IpPhoneCount(userId);//WIFIMacnum 关联数
					if(IpPhone != null){
						if(IpPhone > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
						}
					}
			}
			
			
			id = 74;
			re = fser.RulelistFraction(id);//查询规则id为 74  的风险分值
			if(re.getStatus() != 2){
					Integer Onephonecount = fser.OneHomeCount(phone);//1小时内同一手机号申请注册次数
					if(Onephonecount != null){
						if(Onephonecount > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
						}
					}
			}
			
			
			id = 73;
			re = fser.RulelistFraction(id);//查询规则id为 73  的风险分值
			if(re.getStatus() != 2){
					Integer Onephonecount = fser.OneHomeIDnumberCount(idNumber);//1小时内同一身份证申请注册次数
					if(Onephonecount != null){
						if(Onephonecount > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
						}
					}
			}
			
			
			id = 95;
			re = fser.RulelistFraction(id);//查询规则id为 95  的风险分值
			if(re.getStatus() != 2){
					Integer userPhoneCount = fser.UserPhoneCount(userId);//借款人通讯录400开头号码个数
					if(userPhoneCount != null){
						if(userPhoneCount > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			id = 90;
			re = fser.RulelistFraction(id);//查询规则id为 90  的风险分值
			if(re.getStatus() != 2){
					Integer userPhoneCount = fser.UserPhoneCount1(userId);//借款人通讯录联系人数量
					if(userPhoneCount != null){
						if(userPhoneCount > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
						}
					}
			}
			
			
			id = 102;
			re = fser.RulelistFraction(id);//查询规则id为 102  的风险分值
			if(re.getStatus() != 2){
					Integer userPhoneCount = fser.UserNameFatherCount(userId);//通讯录联系人备注命中父母个数
					if(userPhoneCount != null){
						if(userPhoneCount > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			User user = new User();
			id = 103;
			re = fser.RulelistFraction(id);//查询规则id为 103  的风险分值
			if(re.getStatus() != 2){
					Integer suma = 0;
					user.setUserId(userId);
					user.setName("姨");
					suma = fser.UserQinqCount(user);//通讯录联系人备注命中亲属类个数
					user.setName("爷");
					suma =suma + fser.UserQinqCount(user);//通讯录联系人备注命中亲属类个数
					user.setName("奶奶");
					suma =suma + fser.UserQinqCount(user);//通讯录联系人备注命中亲属类个数
					user.setName("侄");
					suma =suma + fser.UserQinqCount(user);//通讯录联系人备注命中亲属类个数
					user.setName("哥");
					suma =suma + fser.UserQinqCount(user);//通讯录联系人备注命中亲属类个数
					user.setName("姐");
					suma =suma + fser.UserQinqCount(user);//通讯录联系人备注命中亲属类个数
					if(suma != null){
						if(suma > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			id = 104;
			re = fser.RulelistFraction(id);//查询规则id为 104  的风险分值
			if(re.getStatus() != 2){
					Integer suma = 0;
					user.setUserId(userId);
					user.setName("彩票");
					suma = fser.UserQinqCount(user);//通讯录联系人备注命中彩票类个数
					if(suma != null){
						if(suma > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			id = 105;
			re = fser.RulelistFraction(id);//查询规则id为 105  的风险分值
			if(re.getStatus() != 2){
					Integer suma = 0;
					user.setUserId(userId);
					user.setName("公");
					suma = fser.UserQinqCount(user);//通讯录联系人备注命中公检法司类个数
					user.setName("检");
					suma =suma + fser.UserQinqCount(user);
					user.setName("法");
					suma =suma + fser.UserQinqCount(user);
					user.setName("司");
					suma =suma + fser.UserQinqCount(user);
					if(suma != null){
						if(suma > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			id = 106;
			re = fser.RulelistFraction(id);//查询规则id为 106  的风险分值
			if(re.getStatus() != 2){
					Integer suma = 0;
					user.setUserId(userId);
					user.setName("公");
					suma = fser.UserQinqCount(user);//通讯录联系人备注命中公检法司类个数
					user.setName("检");
					suma =suma + fser.UserQinqCount(user);
					user.setName("法");
					suma =suma + fser.UserQinqCount(user);
					user.setName("司");
					suma =suma + fser.UserQinqCount(user);
					if(suma != null){
						if(suma > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			id = 107;
			re = fser.RulelistFraction(id);//查询规则id为 107  的风险分值
			if(re.getStatus() != 2){
					Integer suma = 0;
					user.setUserId(userId);
					user.setName("中");
					suma = fser.UserQinqCount(user);//通讯录联系人备注命中中介咨询类个数
					user.setName("介");
					suma =suma + fser.UserQinqCount(user);
					user.setName("咨");
					suma =suma + fser.UserQinqCount(user);
					user.setName("询");
					suma =suma + fser.UserQinqCount(user);
					if(suma != null){
						if(suma > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			id = 108;
			re = fser.RulelistFraction(id);//查询规则id为 108  的风险分值
			if(re.getStatus() != 2){
					Integer suma = 0;
					user.setUserId(userId);
					user.setName("投");
					suma = fser.UserQinqCount(user);//通讯录联系人备注命中投资理财类个数
					user.setName("资");
					suma =suma + fser.UserQinqCount(user);
					user.setName("理");
					suma =suma + fser.UserQinqCount(user);
					user.setName("财");
					suma =suma + fser.UserQinqCount(user);
					if(suma != null){
						if(suma > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			id = 109;
			re = fser.RulelistFraction(id);//查询规则id为 109  的风险分值
			if(re.getStatus() != 2){
					Integer suma = 0;
					user.setUserId(userId);
					user.setName("联盟");
					suma = fser.UserQinqCount(user);//通讯录联系人备注命中游戏类个数
					user.setName("王者荣耀");
					suma =suma + fser.UserQinqCount(user);
					user.setName("穿越");
					suma =suma + fser.UserQinqCount(user);
					user.setName("CF");
					suma =suma + fser.UserQinqCount(user);
					user.setName("飞车");
					suma =suma + fser.UserQinqCount(user);
					user.setName("吃鸡");
					suma =suma + fser.UserQinqCount(user);
					user.setName("堡垒");
					suma =suma + fser.UserQinqCount(user);
					if(suma != null){
						if(suma > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			id = 110;
			re = fser.RulelistFraction(id);//查询规则id为 110  的风险分值
			if(re.getStatus() != 2){
					Integer suma = 0;
					user.setUserId(userId);
					user.setName("借贷");
					suma = fser.UserQinqCount(user);//通讯录联系人备注命中借贷类个数
					if(suma != null){
						if(suma > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			id = 111;
			re = fser.RulelistFraction(id);//查询规则id为 111  的风险分值
			if(re.getStatus() != 2){
				Integer suma = 0;
					user.setUserId(userId);
					user.setName("毒");
					suma = fser.UserQinqCount(user);//通讯录联系人备注命中涉毒类个数
					if(suma != null){
						if(suma > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			id = 112;
			re = fser.RulelistFraction(id);//查询规则id为 110  的风险分值
			if(re.getStatus() != 2){
					Integer suma = 0;
					user.setUserId(userId);
					user.setName("博彩");
					suma = fser.UserQinqCount(user);//通讯录联系人备注命中涉赌类个数
					user.setName("金花");
					suma = fser.UserQinqCount(user);
					user.setName("斗地主");
					suma = fser.UserQinqCount(user);
					if(suma != null){
						if(suma > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
						}
					}
			}
			
			
			id = 114;
			re = fser.RulelistFraction(id);//查询规则id为 110  的风险分值
			if(re.getStatus() != 2){
					Integer zcnum = fser.UserZuC(userId);//紧急联系人为平台注册借款人
					if(zcnum != null){
						if(zcnum > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			id = 115;
			re = fser.RulelistFraction(id);//查询规则id为 115  的风险分值
			if(re.getStatus() != 2){
					user.setUserId(userId);
					Integer zcnum = fser.AppNum(user);//app安装个数
					if(zcnum != null){
						if(zcnum > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			id = 116;
			re = fser.RulelistFraction(id);//查询规则id为 116  的风险分值
			if(re.getStatus() != 2){
					Integer zcnum = fser.UserZuC(userId);//借贷类app安装个数
					if(zcnum != null){
						if(zcnum > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			
			id = 121;
			re = fser.RulelistFraction(id);//查询规则id为 121  的风险分值
			Integer zcnum = 0;
			user.setUserId(userId);
			user.setName("博彩");
			zcnum = fser.AppNum(user);//赌博类app安装个数
			if(re.getStatus() != 2){
					if(zcnum != null){
						if(zcnum > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			id = 122;
			re = fser.RulelistFraction(id);//查询规则id为 122  的风险分值
			Integer xynum = 0;
			user.setUserId(userId);
			user.setName("信用");
			xynum = fser.AppNum(user);//信用卡类app安装个数
			if(re.getStatus() != 2){
					if(xynum != null){
						if(xynum > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			id = 123;
			re = fser.RulelistFraction(id);//查询规则id为 123  的风险分值
			Integer xdnum = 0;
			user.setUserId(userId);
			user.setName("花");
			xdnum =xdnum + fser.AppNum(user);//超小额借贷类app安装个数
			user.setName("贷");
			xdnum =xdnum + fser.AppNum(user);
			user.setName("米");
			xdnum =xdnum + fser.AppNum(user);
			if(re.getStatus() != 2){
					if(xdnum != null){
						if(xdnum > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			id = 124;
			re = fser.RulelistFraction(id);//查询规则id为 124  的风险分值
			Integer cxnum = 0;
			user.setUserId(userId);
			user.setName("销");
			cxnum = fser.AppNum(user);//传销/直销类app安装个数
			if(re.getStatus() != 2){
					if(cxnum != null){
						if(cxnum > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			id = 125;
			re = fser.RulelistFraction(id);//查询规则id为 125  的风险分值
			Integer denum = 0;
			user.setUserId(userId);
			user.setName("花");
			denum =denum + fser.AppNum(user);//超小额借贷类app安装个数
			user.setName("贷");
			denum =denum + fser.AppNum(user);
			user.setName("米");
			denum =denum + fser.AppNum(user);
			if(re.getStatus() != 2){
					if(denum != null){
						if(denum > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			
			id = 126;
			re = fser.RulelistFraction(id);//查询规则id为 125  的风险分值
			Integer ptnum = 0;
			user.setUserId(userId);
			user.setName("钱");
			ptnum =ptnum + fser.AppNum(user);//贷款平台app安装个数
			user.setName("贷");
			ptnum =ptnum + fser.AppNum(user);
			user.setName("金");
			ptnum =ptnum + fser.AppNum(user);
			if(re.getStatus() != 2){
					if(ptnum != null){
						if(ptnum > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			
			id = 128;
			re = fser.RulelistFraction(id);//查询规则id为 128  的风险分值
			Integer mnum = 0;
			user.setUserId(userId);
			user.setName("模拟");
			mnum = fser.AppNum(user);//模拟器类app安装个数
			if(re.getStatus() != 2){
					if(mnum != null){
						if(mnum > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			
			id = 129;
			re = fser.RulelistFraction(id);//查询规则id为 129  的风险分值
			Integer xnum = 0;
			user.setUserId(userId);
			user.setName("虚拟");
			xnum =xnum + fser.AppNum(user);//虚拟定位类app安装个数
			user.setName("定位");
			xnum =xnum + fser.AppNum(user);
			if(re.getStatus() != 2){
					if(xnum != null){
						if(xnum > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			id = 130;
			re = fser.RulelistFraction(id);//查询规则id为 130  的风险分值
			Integer bxum = 0;
			user.setUserId(userId);
			user.setName("保险");
			bxum =bxum + fser.AppNum(user);//保险类app安装个数
			user.setName("平安");
			bxum =bxum + fser.AppNum(user);
			if(re.getStatus() != 2){
					if(bxum != null){
						if(bxum > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			
			id = 131;
			re = fser.RulelistFraction(id);//查询规则id为 131  的风险分值
			Integer zfnum = 0;
			user.setUserId(userId);
			user.setName("支付");
			zfnum =zfnum + fser.AppNum(user);//支付类app安装个数
			user.setName("钱包");
			zfnum =zfnum + fser.AppNum(user);
			if(re.getStatus() != 2){
					if(zfnum != null){
						if(zfnum > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			id = 132;
			re = fser.RulelistFraction(id);//查询规则id为 132  的风险分值
			Integer cpnum = 0;
			user.setUserId(userId);
			user.setName("彩票");
			cpnum =cpnum + fser.AppNum(user);//彩票类app安装个数
			user.setName("乐透");
			cpnum =cpnum + fser.AppNum(user);
			if(re.getStatus() != 2){
					if(cpnum != null){
						if(cpnum > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			id = 29;
			re = fser.RulelistFraction(id);//查询规则id为 29  的风险分值
			Integer dmnum = 0;
			user.setUserId(userId);
			user.setName("借");
			dmnum =dmnum + fser.AppNum(user);//借贷类app安装个数
			user.setName("贷");
			dmnum =dmnum + fser.AppNum(user);
			user.setName("米");
			dmnum =dmnum + fser.AppNum(user);
			if(re.getStatus() != 2){
					if(dmnum != null){
						if(dmnum > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			
			id = 133;
			re = fser.RulelistFraction(id);//查询规则id为 133  的风险分值
			Integer eynum = 0;
			user.setUserId(userId);
			user.setName("呼叫");
			eynum = fser.AppNum(user);//恶意呼叫类app安装个数
			if(re.getStatus() != 2){
					if(eynum != null){
						if(eynum > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			id = 134;
			re = fser.RulelistFraction(id);//查询规则id为 134  的风险分值
			Integer jrnum = 0;
			user.setUserId(userId);
			user.setName("金融");
			jrnum = fser.AppNum(user);//金融查询类app安装个数
			if(re.getStatus() != 2){
					if(jrnum != null){
						if(jrnum > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			id = 135;
			re = fser.RulelistFraction(id);//查询规则id为 135  的风险分值
			Integer wznum = 0;
			user.setUserId(userId);
			user.setName("赚");
			wznum =wznum + fser.AppNum(user);//网赚类app安装个数
			user.setName("乐透");
			wznum =wznum + fser.AppNum(user);
			if(re.getStatus() != 2){
					if(wznum != null){
						if(wznum > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			id = 136;
			re = fser.RulelistFraction(id);//查询规则id为 136  的风险分值
			Integer yxnum = 0;
			user.setUserId(userId);
			user.setName("王者");
			yxnum =yxnum + fser.AppNum(user);//游戏类app安装个数
			user.setName("战场");
			yxnum =yxnum + fser.AppNum(user);
			user.setName("飞车");
			yxnum =yxnum + fser.AppNum(user);
			user.setName("斗");
			yxnum =yxnum + fser.AppNum(user);
			if(re.getStatus() != 2){
					if(yxnum != null){
						if(yxnum > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			
			id = 9;
			re = fser.RulelistFraction(id);//查询规则id为 9 的风险分值
			Integer tnum = 0;
			tnum = tnum + fser.MaillstUserPhone(userId);//借款人通讯录关联平台注册借款人
			if(re.getStatus() != 2){
					if(tnum != null){
						if(tnum > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			id = 28;
			re = fser.RulelistFraction(id);//查询规则id为 28  的风险分值
			
			user.setUserId(userId);
			user.setName("花");
			Integer jnum = fser.AppNum(user);//借贷类app安装个数;
			if(re.getStatus() != 2){
					if(jnum != null){
						if(jnum > Integer.valueOf(re.getThresholdValue())){
							user.setName("贷");
							jnum =jnum + fser.AppNum(user);
							user.setName("米");
							jnum =jnum + fser.AppNum(user);
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			
			id = 18;
			re = fser.RulelistFraction(id);//查询规则id为 18  的风险分值
			Integer jknum = 0;
			user.setUserId(userId);
			jknum = fser.PayUserNum(user);//借款人通讯录相同备注个数
			if(re.getStatus() != 2){
					if(jknum != null){
						if(jknum > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			id = 16;
			re = fser.RulelistFraction(id);//查询规则id为 16  的风险分值
			Integer num = 0;
			user.setUserId(userId);
			num = fser.PhoneNum(user);//借款人通讯录号码相同个数
			if(re.getStatus() != 2){
					if(num != null){
						if(num > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			id = 22;
			re = fser.RulelistFraction(id);//查询规则id为 22  的风险分值
			Integer jjnum = 0;
			user.setUserId(userId);
			jjnum = fser.jjPhoneNum(user);//紧急联系人姓名不同但号码相同数
			if(re.getStatus() != 2){
					if(jjnum != null){
						if(jjnum > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			id = 14;
			re = fser.RulelistFraction(id);//查询规则id为 14  的风险分值
			Integer Pnum = 0;
			user.setUserId(userId);
			user.setId(7);
			Pnum = fser.PFhoneNum(user);//借款人通讯录号码号段前7位相同个数
			if(re.getStatus() != 2){
					if(Pnum != null){
						if(Pnum > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			id = 15;
			re = fser.RulelistFraction(id);//查询规则id为 15  的风险分值
			Integer Pfnum = 0;
			user.setUserId(userId);
			user.setId(9);
			Pfnum = fser.PFhoneNum(user);//借款人通讯录号码号段前9位相同个数
			if(re.getStatus() != 2){
					if(Pfnum != null){
						if(Pfnum > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			
			id = 81;
			re = fser.RulelistFraction(id);//查询规则id为 81  的风险分值
			user.setUserId(userId);
			String one = phone.substring(0,4);
			if(re.getStatus() != 2){
				if(one.equals("1700")){
					count = count-Integer.valueOf(re.getValue_at_risk());
					ru.setUserid(userId);
					ru.setValue_at_risk(re.getValue_at_risk());
					ru.setRtid(re.getTypeid());
					ru.setRid(id);
					fser.AddCount(ru);
				}else if(one.equals("1701")){
					count = count-Integer.valueOf(re.getValue_at_risk());
					ru.setUserid(userId);
					ru.setValue_at_risk(re.getValue_at_risk());
					ru.setRtid(re.getTypeid());
					ru.setRid(id);
					fser.AddCount(ru);
				}else if(one.equals("1702")){
					count = count-Integer.valueOf(re.getValue_at_risk());
					ru.setUserid(userId);
					ru.setValue_at_risk(re.getValue_at_risk());
					ru.setRtid(re.getTypeid());
					ru.setRid(id);
					fser.AddCount(ru);
				}else if(one.equals("1704")){
					count = count-Integer.valueOf(re.getValue_at_risk());
					ru.setUserid(userId);
					ru.setValue_at_risk(re.getValue_at_risk());
					ru.setRtid(re.getTypeid());
					ru.setRid(id);
					fser.AddCount(ru);
				}else if(one.equals("1707")){
					count = count-Integer.valueOf(re.getValue_at_risk());
					ru.setUserid(userId);
					ru.setValue_at_risk(re.getValue_at_risk());
					ru.setRtid(re.getTypeid());
					ru.setRid(id);
					fser.AddCount(ru);
				}else if(one.equals("1708")){
					count = count-Integer.valueOf(re.getValue_at_risk());
					ru.setUserid(userId);
					ru.setValue_at_risk(re.getValue_at_risk());
					ru.setRtid(re.getTypeid());
					ru.setRid(id);
					fser.AddCount(ru);
				}else if(one.equals("1709")){
					count = count-Integer.valueOf(re.getValue_at_risk());
					ru.setUserid(userId);
					ru.setValue_at_risk(re.getValue_at_risk());
					ru.setRtid(re.getTypeid());
					ru.setRid(id);
					fser.AddCount(ru);
				}else if(one.equals("1703")){
					count = count-Integer.valueOf(re.getValue_at_risk());
					ru.setUserid(userId);
					ru.setValue_at_risk(re.getValue_at_risk());
					ru.setRtid(re.getTypeid());
					ru.setRid(id);
					fser.AddCount(ru);
				}else if(one.equals("1705")){
					count = count-Integer.valueOf(re.getValue_at_risk());
					ru.setUserid(userId);
					ru.setValue_at_risk(re.getValue_at_risk());
					ru.setRtid(re.getTypeid());
					ru.setRid(id);
					fser.AddCount(ru);
				}else if(one.equals("1706")){
					count = count-Integer.valueOf(re.getValue_at_risk());
					ru.setUserid(userId);
					ru.setValue_at_risk(re.getValue_at_risk());
					ru.setRtid(re.getTypeid());
					ru.setRid(id);
					fser.AddCount(ru);
				}else if(one.equals("171")){
					count = count-Integer.valueOf(re.getValue_at_risk());
					ru.setUserid(userId);
					ru.setValue_at_risk(re.getValue_at_risk());
					ru.setRtid(re.getTypeid());
					ru.setRid(id);
					fser.AddCount(ru);
				}
			
						
			}
			
			
			
			
			id = 83;
			re = fser.RulelistFraction(id);//查询规则id为 83  的风险分值
			user.setUserId(userId);
			String onec = phone.substring(0,4);
			if(re.getStatus() != 2){
				if(onec.equals("147")){
					count = count-Integer.valueOf(re.getValue_at_risk());
					ru.setUserid(userId);
					ru.setValue_at_risk(re.getValue_at_risk());
					ru.setRtid(re.getTypeid());
					ru.setRid(id);
					fser.AddCount(ru);
				}else if(onec.equals("145")){
					count = count-Integer.valueOf(re.getValue_at_risk());
					ru.setUserid(userId);
					ru.setValue_at_risk(re.getValue_at_risk());
					ru.setRtid(re.getTypeid());
					ru.setRid(id);
					fser.AddCount(ru);
				}
			}
			
			
			
			id = 84;
			re = fser.RulelistFraction(id);//查询规则id为 84  的风险分值
			user.setUserId(userId);
			String Fnec = phone.substring(0,4);
			if(re.getStatus() != 2){
				if(Fnec != null){
					if(Fnec.equals("147")){
						count = count-Integer.valueOf(re.getValue_at_risk());
						ru.setUserid(userId);
						ru.setValue_at_risk(re.getValue_at_risk());
						ru.setRtid(re.getTypeid());
						ru.setRid(id);
						fser.AddCount(ru);
					}else if(Fnec.equals("145")){
						count = count-Integer.valueOf(re.getValue_at_risk());
						ru.setUserid(userId);
						ru.setValue_at_risk(re.getValue_at_risk());
						ru.setRtid(re.getTypeid());
						ru.setRid(id);
						fser.AddCount(ru);
					}
				}
						
			}
			
			
			
			
			id = 84;
			re = fser.RulelistFraction(id);//查询规则id为 84  的风险分值
			user.setUserId(userId);
			String FnecA = phone.substring(0,4);
			if(re.getStatus() != 2){
				if(FnecA != null){
					if(FnecA.equals("147")){
						count = count-Integer.valueOf(re.getValue_at_risk());
						ru.setUserid(userId);
						ru.setValue_at_risk(re.getValue_at_risk());
						ru.setRtid(re.getTypeid());
						ru.setRid(id);
						fser.AddCount(ru);
					}else if(FnecA.equals("145")){
						count = count-Integer.valueOf(re.getValue_at_risk());
						ru.setUserid(userId);
						ru.setValue_at_risk(re.getValue_at_risk());
						ru.setRtid(re.getTypeid());
						ru.setRid(id);
						fser.AddCount(ru);
					}
				}
						
			}
			
			
			
			id = 178;
			re = fser.RulelistFraction(id);//查询规则id为 178  的风险分值
			user.setUserId(userId);
			Integer reportnum = fser.ReportNum(user);//运营商风险结果分数
			if(re.getStatus() != 2){
				if(reportnum != null){
					if(reportnum < Integer.valueOf(re.getValue_at_risk())){
						count = count-Integer.valueOf(re.getValue_at_risk());
						ru.setUserid(userId);
						ru.setValue_at_risk(re.getValue_at_risk());
						ru.setRtid(re.getTypeid());
						ru.setRid(id);
						fser.AddCount(ru);
					}
				}
						
			}
			
			
			id = 179;
			re = fser.RulelistFraction(id);//查询规则id为 178  的风险分值
			user.setUserId(userId);
			Integer rportnum = fser.ReportNum(user);//运营商风险结果分数
			if(re.getStatus() != 2){
				if(rportnum != null){
					if(reportnum < Integer.valueOf(re.getValue_at_risk())){
						count = count-Integer.valueOf(re.getValue_at_risk());
						ru.setUserid(userId);
						ru.setValue_at_risk(re.getValue_at_risk());
						ru.setRtid(re.getTypeid());
						ru.setRid(id);
						fser.AddCount(ru);
					}
				}
			}
			
			
			
			
			
			id = 180;
			re = fser.RulelistFraction(id);//查询规则id为 180  的风险分值
			user.setUserId(userId);
			Integer rid = fser.ReportID(user);//运营商数据是否无法抓取
			if(re.getStatus() != 2){
				if(rid != null){
					if(reportnum < Integer.valueOf(re.getValue_at_risk())){
						count = count-Integer.valueOf(re.getValue_at_risk());
						ru.setUserid(userId);
						ru.setValue_at_risk(re.getValue_at_risk());
						ru.setRtid(re.getTypeid());
						ru.setRid(id);
						fser.AddCount(ru);
					}
				}
			}
			
			
			
			id = 181;
			re = fser.RulelistFraction(id);//查询规则id为 181  的风险分值
			user.setUserId(userId);
			user.setPhone(phone);
			Integer phoneType = fser.AppInfoUser(user);//借款用户手机号与运营商手机号是否匹配
			if(re.getStatus() != 2){
				if(phoneType == null){
						count = count-Integer.valueOf(re.getValue_at_risk());
						ru.setUserid(userId);
						ru.setValue_at_risk(re.getValue_at_risk());
						ru.setRtid(re.getTypeid());
						ru.setRid(id);
						fser.AddCount(ru);
				}
			}
			
			
			
			id = 182;
			re = fser.RulelistFraction(id);//查询规则id为 182  的风险分值
			user.setUserId(userId);
			user.setIdnumber(idNumber);
			Integer IdType = fser.AppInfoUser(user);//借款用户身份证号与运营商身份证号是否匹配
			if(re.getStatus() != 2){
				if(IdType == null){
						count = count-Integer.valueOf(re.getValue_at_risk());
						ru.setUserid(userId);
						ru.setValue_at_risk(re.getValue_at_risk());
						ru.setRtid(re.getTypeid());
						ru.setRid(id);
						fser.AddCount(ru);
				}
			}
			
			
			
			id = 183;
			re = fser.RulelistFraction(id);//查询规则id为 183  的风险分值
			user.setUserId(userId);
			user.setIdnumber(idNumber);
			Integer NameType = fser.AppInfoUser(user);//借款用户姓名与运营商姓名是否匹配
			if(re.getStatus() != 2){
				if(NameType == null){
						count = count-Integer.valueOf(re.getValue_at_risk());
						ru.setUserid(userId);
						ru.setValue_at_risk(re.getValue_at_risk());
						ru.setRtid(re.getTypeid());
						ru.setRid(id);
						fser.AddCount(ru);
				}
			}
			
			
			id = 46;
			re = fser.RulelistFraction(id);//查询规则id为 46  的风险分值
			user.setUserId(userId);
			user.setIdnumber(idNumber);
			Integer macnum = fser.MacUserNum(user);//MAC地址关联账户个数
			if(re.getStatus() != 2){
				if(macnum != null){
					if(macnum > Integer.valueOf(re.getValue_at_risk())){
						count = count-Integer.valueOf(re.getValue_at_risk());
						ru.setUserid(userId);
						ru.setValue_at_risk(re.getValue_at_risk());
						ru.setRtid(re.getTypeid());
						ru.setRid(id);
						fser.AddCount(ru);
					}
				}
			}
			
			
			
			id = 91;
			re = fser.RulelistFraction(id);//查询规则id为 91  的风险分值
			user.setUserId(userId);
			user.setIdnumber(idNumber);
			Integer phoneId = fser.PhoneUserNum(user);//借款人通讯录是否无法抓取
			if(re.getStatus() != 2){
				if(phoneId == null){
						count = count-Integer.valueOf(re.getValue_at_risk());
						ru.setUserid(userId);
						ru.setValue_at_risk(re.getValue_at_risk());
						ru.setRtid(re.getTypeid());
						ru.setRid(id);
						fser.AddCount(ru);
				}
			}
			
			
			u.setFraction(count);
			u.setIdnumber(idNumber);
			
			u.setUsername(name);
			u.setPhone(phone);
			u.setUserId(userId);
			Integer ida = fser.AddUser(u);
			if(ida == null){
				map.put("name", name);
				map.put("userId", userId);
				map.put("idNumber", idNumber);
				map.put("count", "请重新调用");
				return map;
			}
		} catch (Exception e) {
			e.addSuppressed(e);
		}
		
		if(count<0){
			count = 0;
		}
		map.put("name", name);
		map.put("userId", userId);
		map.put("idNumber", idNumber);
		map.put("count", count);
		return map;
	}

}

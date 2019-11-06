package com.zhita.Collection.fraction;

import java.math.BigDecimal;
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
import com.zhita.Model.CommunicationCityInfo;
import com.zhita.Model.CommunicationDetection;
import com.zhita.Model.Configuration;
import com.zhita.Model.EmergencyContactInfo;
import com.zhita.Model.Rulelist;
import com.zhita.Model.Rulelist_detail;
import com.zhita.Model.User;
import com.zhita.Service.FractionService;
import com.zhita.Util.Timestamps;
import com.zhita.Util.TuoMinUtil;



@Controller
@RequestMapping("fraction")
public class FractionController {
	
	
	@Autowired
	private FractionService fser;
	
	
	
	@Autowired
	private RiskDao rdao;
	
	
	
	@Autowired
	private FengkMapper fmap;
	
	
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
			if(re != null){
				System.out.println(re.getValue_at_risk());
				if(re.getStatus()!=2){
					if(a != null){
						if(a < Integer.valueOf(re.getThresholdValue())){
							count =count - Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							ru.setUsum(count);
							fser.AddCount(ru);
						}
					}
				}
			}
			
			
			id = 27; 
			re = fser.RulelistFraction(id);//查询规则id为  27  的风险分值
			if(re != null){
				if(re.getStatus()!=2){
					if(a != null){
						if(a > Integer.valueOf(re.getThresholdValue())){
							count =count - Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setRtid(re.getTypeid());
							ru.setUsum(count);
							fser.AddCount(ru);
						}
					}
				}
			}
			
			
			
			Configuration con = new Configuration();
			con = rdao.UserUUID(phone);
				
			
			Integer phonenum = rdao.UserPhoneCount(userId);//通讯录联系人数量
			id = 67;
			re = fser.RulelistFraction(id);//查询规则id为 67  的风险分值
			if(re != null){
				if(re.getStatus()!=2){
					if(phonenum != null){
						if(phonenum > 10){
							if(phonenum <= 20){
								count = count-Integer.valueOf(re.getValue_at_risk());
								ru.setUserid(userId);
								ru.setValue_at_risk(re.getValue_at_risk());
								ru.setRid(id);
								ru.setRtid(re.getTypeid());
								ru.setUsum(count);
								fser.AddCount(ru);
							}
						}
					}
				}
			}
			
			
			System.out.println("开始时间:"+statu_time);
			if(con != null){
				con.setStatu_time(statu_time);
				con.setEnd_time(end_time);
				id = 70;
				re = fser.RulelistFraction(id);//查询规则id为 70  的风险分值
				if(re != null){
					if(re.getStatus()!=2){
						if(con.getUuid()!=null){//	id 70 
							Integer daynum = rdao.UserLoginNum(con);//一天内的相同设备数
							if(daynum != null){
								if(daynum > Integer.valueOf(re.getValue_at_risk())){
									count = count-Integer.valueOf(re.getValue_at_risk());
									ru.setUserid(userId);
									ru.setValue_at_risk(re.getValue_at_risk());
									ru.setRid(id);
									ru.setUsum(count);
									ru.setRtid(re.getTypeid());
									fser.AddCount(ru);
								}
							}
						}
					}
				}
			}
			
			
			
			
			
			id = 71;
			re = fser.RulelistFraction(id);//查询规则id为 71  的风险分值
			if(con != null){
				if(re != null){
					if(re.getStatus() != 2){
						if(con.getUuid()==null){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setUsum(count);
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
				}
			}
			
			
			
			
			
			
			
			
			Configuration config = new Configuration();
			
			id = 76;
			re = fser.RulelistFraction(id);//查询规则id为 76  的风险分值
			if(re != null){
				if(re.getStatus() != 2){
					Integer sumcount = 0;
					System.out.println(userId);
					config.setUserId(userId);
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
							ru.setUsum(count);
							fser.AddCount(ru);
						}
					}
				}
			}
			
			id = 77;
			re = fser.RulelistFraction(id);//查询规则id为 77  的风险分值
			if(re != null){
				config.setUserId(userId);
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
							ru.setUsum(count);
							fser.AddCount(ru);
						}
					}
				}
			}
			
			
			
			id = 25;
			re = fser.RulelistFraction(id);//查询规则id为 25  的风险分值
			if(re != null){
				if(re.getStatus() != 2){
					Integer WifiMacNum = fser.Emergency_contact_infoPhone(userId);//WIFIMacnum 关联数
					if(WifiMacNum != null){
						if(WifiMacNum > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							ru.setUsum(count);
							fser.AddCount(ru);
						}
					}
				}
			}
			
			
			
			
			id = 59;
			re = fser.RulelistFraction(id);//查询规则id为 59  的风险分值
			if(re != null){
				if(re != null){
					if(re.getStatus() != 2){
						Integer IpPhone = fser.IpPhoneCount(userId);//WIFIMacnum 关联数
						if(IpPhone != null){
							if(IpPhone > Integer.valueOf(re.getThresholdValue())){
								count = count-Integer.valueOf(re.getValue_at_risk());
								ru.setUserid(userId);
								ru.setValue_at_risk(re.getValue_at_risk());
								ru.setRid(id);
								ru.setUsum(count);
								ru.setRtid(re.getTypeid());
								fser.AddCount(ru);
							}
						}
					}
				}
			}
			
			
			
			id = 74;
			re = fser.RulelistFraction(id);//查询规则id为 74  的风险分值
			if(re != null){
				if(re != null){
					if(re.getStatus() != 2){
						Integer Onephonecount = fser.OneHomeCount(phone);//1小时内同一手机号申请注册次数
						if(Onephonecount != null){
							if(Onephonecount > Integer.valueOf(re.getThresholdValue())){
								count = count-Integer.valueOf(re.getValue_at_risk());
								ru.setUserid(userId);
								ru.setValue_at_risk(re.getValue_at_risk());
								ru.setRid(id);
								ru.setUsum(count);
								ru.setRtid(re.getTypeid());
								fser.AddCount(ru);
							}
						}
					}
				}
			}
			
			
			id = 73;
			re = fser.RulelistFraction(id);//查询规则id为 73  的风险分值
			if(re != null){
				if(re.getStatus() != 2){
					Integer Onephonecount = fser.OneHomeIDnumberCount(idNumber);//1小时内同一身份证申请注册次数
					if(Onephonecount != null){
						if(Onephonecount > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setUsum(count);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
						}
					}
				}
			}
			
			
			id = 95;
			re = fser.RulelistFraction(id);//查询规则id为 95  的风险分值
			if(re != null){
				if(re.getStatus() != 2){
					Integer userPhoneCount = fser.UserPhoneCount(userId);//借款人通讯录400开头号码个数
					if(userPhoneCount != null){
						if(userPhoneCount > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setUsum(count);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							fser.AddCount(ru);
						}
					}
				}
			}
			
			
			
			id = 90;
			re = fser.RulelistFraction(id);//查询规则id为 90  的风险分值
			if(re != null){
				if(re.getStatus() != 2){
					Integer userPhoneCount = fser.UserPhoneCount1(userId);//借款人通讯录联系人数量
					if(userPhoneCount != null){
						if(userPhoneCount <= 10){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setUsum(count);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
						}
					}
				}
			}
			
			
			id = 102;
			re = fser.RulelistFraction(id);//查询规则id为 102  的风险分值
			if(re != null){
				if(re.getStatus() != 2){
					Integer userPhoneCount = fser.UserNameFatherCount(userId);//通讯录联系人备注命中父母个数
					if(userPhoneCount != null){
						if(userPhoneCount > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setUsum(count);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
						}
					}
				}
			}
			
			
			
			
			User user = new User();
			id = 103;
			re = fser.RulelistFraction(id);//查询规则id为 103  的风险分值
			if(re != null){
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
							ru.setUsum(count);
							fser.AddCount(ru);
						}
					}
				}
			}
			
			
			
			id = 104;
			re = fser.RulelistFraction(id);//查询规则id为 104  的风险分值
			if(re != null){
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
							ru.setUsum(count);
							fser.AddCount(ru);
						}
					}
				}
			}
			
			
			id = 105;
			re = fser.RulelistFraction(id);//查询规则id为 105  的风险分值
			if(re != null){
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
							ru.setUsum(count);
							fser.AddCount(ru);
						}
					}
				}
			}
			
			
			id = 106;
			re = fser.RulelistFraction(id);//查询规则id为 106  的风险分值
			if(re != null){
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
							ru.setUsum(count);
							fser.AddCount(ru);
						}
					}
				}
			}
			
			
			id = 107;
			re = fser.RulelistFraction(id);//查询规则id为 107  的风险分值
			if(re != null){
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
							ru.setUsum(count);
							fser.AddCount(ru);
						}
					}
				}
			}
			
			
			
			id = 108;
			re = fser.RulelistFraction(id);//查询规则id为 108  的风险分值
			if(re != null){
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
							ru.setUsum(count);
							fser.AddCount(ru);
						}
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
							ru.setUsum(count);
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
							ru.setUsum(count);
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
							ru.setUsum(count);
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
							ru.setUsum(count);
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
							ru.setUsum(count);
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
							ru.setUsum(count);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			id = 116;
			re = fser.RulelistFraction(id);//查询规则id为 116  的风险分值
			if(re.getStatus() != 2){
					Integer zcnum = fser.UserZuC(userId);//借贷类app安装个数
					if(zcnum != null){
						if(zcnum <= Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							ru.setUsum(count);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			
			id = 117;
			re = fser.RulelistFraction(id);//查询规则id为 117  的风险分值
			Integer phonjdnum = 0;
			user.setUserId(userId);
			user.setName("贷");
			phonjdnum = phonjdnum + fser.AppNum(user);//近1个月借款人手机号对应设备历史安装借贷类app类个数
			user.setName("米");
			phonjdnum = phonjdnum + fser.AppNum(user);
			user.setName("花");
			phonjdnum = phonjdnum + fser.AppNum(user);
			if(re.getStatus() != 2){
					if(phonjdnum != null){
						if(phonjdnum <= Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							ru.setUsum(count);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			id = 118;
			re = fser.RulelistFraction(id);//查询规则id为 118  的风险分值
			Integer phonzcnum = 0;
			user.setUserId(userId);
			user.setName("博彩");
			phonzcnum = phonzcnum + fser.AppNum(user);//近1个月借款人身份证号对应设备历史安装赌博类app类个数
			user.setName("斗地主");
			phonzcnum = phonzcnum + fser.AppNum(user);
			user.setName("金花");
			phonzcnum = phonzcnum + fser.AppNum(user);
			if(re.getStatus() != 2){
					if(phonzcnum != null){
						if(phonzcnum <= Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							ru.setUsum(count);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			
			
			id = 119;
			re = fser.RulelistFraction(id);//查询规则id为 119  的风险分值
			Integer phonjOdnum = 0;
			user.setUserId(userId);
			user.setName("贷");
			phonjOdnum = phonjOdnum + fser.AppNum(user);//近1个月借款人手机号对应设备历史安装借贷类app类个数
			user.setName("米");
			phonjOdnum = phonjOdnum + fser.AppNum(user);
			user.setName("花");
			phonjOdnum = phonjOdnum + fser.AppNum(user);
			if(re.getStatus() != 2){
					if(phonjOdnum != null){
						if(phonjOdnum <= Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							ru.setUsum(count);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			
			id = 120;
			re = fser.RulelistFraction(id);//查询规则id为 120  的风险分值
			Integer idzcnum = 0;
			user.setUserId(userId);
			user.setName("博彩");
			idzcnum = idzcnum + fser.AppNum(user);//近1个月借款人身份证号对应设备历史安装赌博类app类个数
			user.setName("斗地主");
			idzcnum = idzcnum + fser.AppNum(user);
			user.setName("金花");
			idzcnum = idzcnum + fser.AppNum(user);
			if(re.getStatus() != 2){
					if(idzcnum != null){
						if(idzcnum <= Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							ru.setUsum(count);
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
							ru.setUsum(count);
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
							ru.setUsum(count);
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
							ru.setUsum(count);
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
							ru.setUsum(count);
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
							ru.setUsum(count);
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
							ru.setUsum(count);
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
							ru.setUsum(count);
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
							ru.setUsum(count);
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
							ru.setUsum(count);
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
							ru.setUsum(count);
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
							ru.setUsum(count);
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
							ru.setUsum(count);
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
							ru.setUsum(count);
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
							ru.setUsum(count);
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
							ru.setUsum(count);
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
							ru.setUsum(count);
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
							ru.setUsum(count);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			id = 28;
			re = fser.RulelistFraction(id);//查询规则id为 28  的风险分值
			
			user.setUserId(userId);
			user.setName("花");
			Integer jnum = fser.AppNum(user);//借贷类app安装个数;
			user.setName("贷");
			jnum =jnum + fser.AppNum(user);
			user.setName("米");
			jnum =jnum + fser.AppNum(user);
			if(re.getStatus() != 2){
					if(jnum != null){
						if(jnum > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							ru.setUsum(count);
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
							ru.setUsum(count);
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
							ru.setUsum(count);
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
							ru.setUsum(count);
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
							ru.setUsum(count);
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
							ru.setUsum(count);
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
					ru.setUsum(count);
					fser.AddCount(ru);
				}else if(one.equals("1701")){
					count = count-Integer.valueOf(re.getValue_at_risk());
					ru.setUserid(userId);
					ru.setValue_at_risk(re.getValue_at_risk());
					ru.setRtid(re.getTypeid());
					ru.setRid(id);
					
					ru.setUsum(count);
					fser.AddCount(ru);
				}else if(one.equals("1702")){
					count = count-Integer.valueOf(re.getValue_at_risk());
					ru.setUserid(userId);
					ru.setValue_at_risk(re.getValue_at_risk());
					ru.setRtid(re.getTypeid());
					ru.setRid(id);
					ru.setUsum(count);
					fser.AddCount(ru);
				}else if(one.equals("1704")){
					count = count-Integer.valueOf(re.getValue_at_risk());
					ru.setUserid(userId);
					ru.setValue_at_risk(re.getValue_at_risk());
					ru.setRtid(re.getTypeid());
					ru.setRid(id);
					ru.setUsum(count);
					
					fser.AddCount(ru);
				}else if(one.equals("1707")){
					count = count-Integer.valueOf(re.getValue_at_risk());
					ru.setUserid(userId);
					ru.setValue_at_risk(re.getValue_at_risk());
					ru.setRtid(re.getTypeid());
					ru.setRid(id);
					ru.setUsum(count);
					fser.AddCount(ru);
				}else if(one.equals("1708")){
					count = count-Integer.valueOf(re.getValue_at_risk());
					ru.setUserid(userId);
					ru.setValue_at_risk(re.getValue_at_risk());
					ru.setRtid(re.getTypeid());
					ru.setRid(id);
					ru.setUsum(count);
					fser.AddCount(ru);
				}else if(one.equals("1709")){
					count = count-Integer.valueOf(re.getValue_at_risk());
					ru.setUserid(userId);
					ru.setValue_at_risk(re.getValue_at_risk());
					ru.setRtid(re.getTypeid());
					ru.setRid(id);
					ru.setUsum(count);
					fser.AddCount(ru);
				}else if(one.equals("1703")){
					count = count-Integer.valueOf(re.getValue_at_risk());
					ru.setUserid(userId);
					ru.setValue_at_risk(re.getValue_at_risk());
					ru.setRtid(re.getTypeid());
					ru.setRid(id);
					ru.setUsum(count);
					fser.AddCount(ru);
				}else if(one.equals("1705")){
					count = count-Integer.valueOf(re.getValue_at_risk());
					ru.setUserid(userId);
					ru.setValue_at_risk(re.getValue_at_risk());
					ru.setRtid(re.getTypeid());
					ru.setRid(id);
					ru.setUsum(count);
					fser.AddCount(ru);
				}else if(one.equals("1706")){
					count = count-Integer.valueOf(re.getValue_at_risk());
					ru.setUserid(userId);
					ru.setValue_at_risk(re.getValue_at_risk());
					ru.setRtid(re.getTypeid());
					ru.setRid(id);
					ru.setUsum(count);
					fser.AddCount(ru);
				}else if(one.equals("171")){
					count = count-Integer.valueOf(re.getValue_at_risk());
					ru.setUserid(userId);
					ru.setValue_at_risk(re.getValue_at_risk());
					ru.setRtid(re.getTypeid());
					ru.setRid(id);
					ru.setUsum(count);
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
					ru.setUsum(count);
					fser.AddCount(ru);
				}else if(onec.equals("145")){
					count = count-Integer.valueOf(re.getValue_at_risk());
					ru.setUserid(userId);
					ru.setValue_at_risk(re.getValue_at_risk());
					ru.setRtid(re.getTypeid());
					ru.setRid(id);
					ru.setUsum(count);
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
						ru.setUsum(count);
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
			
			
			
			
			id = 157;
			re = fser.RulelistFraction(id);//查询规则id为 157  的风险分值
			User userwifi = new User();
			userwifi.setPhone(phone);
			userwifi.setName("彩票");
			System.out.println(userwifi.getPhone()+"AA"+userwifi.getName());
			Integer wifiNum =  fser.WifiNameNum(userwifi);//wifi名称是否命中彩票类
			if(re.getStatus() != 2){
					if(wifiNum != null){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							ru.setUsum(count);
							fser.AddCount(ru);
						}
			}		
			
			
			
			
			id = 158;
			re = fser.RulelistFraction(id);//查询规则id为 157  的风险分值
			User uac = new User();
			uac.setPhone(phone);
			uac.setName(name);
			System.out.println(uac.getUserId()+"11111"+uac.getName());
			Integer wifiName =  fser.WifiNameNum(uac);//wifi名称是否命中金融类
			if(re.getStatus() != 2){
					if(wifiName != null){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							ru.setUsum(count);
							fser.AddCount(ru);
					}
			}		
			
			
			
			
			id = 159;
			re = fser.RulelistFraction(id);//查询规则id为 159  的风险分值
			User userwifiaY = new User();
			userwifi.setPhone(phone);
			userwifi.setName("歌");
			Integer userwifiaAY =  fser.WifiNameNum(userwifiaY);//wifi名称是否命中娱乐场所类
			userwifi.setName("酒吧");
			Integer userwifiaAj =  fser.WifiNameNum(userwifiaY);//wifi名称是否命中娱乐场所类
			userwifi.setName("KTV");
			Integer userwifiaAk =  fser.WifiNameNum(userwifiaY);//wifi名称是否命中娱乐场所类
			if(re.getStatus() != 2){
					if(userwifiaAY != null){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							ru.setUsum(count);
							fser.AddCount(ru);
					}else if(userwifiaAj != null){
						count = count-Integer.valueOf(re.getValue_at_risk());
						ru.setUserid(userId);
						ru.setValue_at_risk(re.getValue_at_risk());
						ru.setRtid(re.getTypeid());
						ru.setRid(id);
						ru.setUsum(count);
						fser.AddCount(ru);
					}else if(userwifiaAk != null){
						count = count-Integer.valueOf(re.getValue_at_risk());
						ru.setUserid(userId);
						ru.setValue_at_risk(re.getValue_at_risk());
						ru.setRtid(re.getTypeid());
						ru.setRid(id);
						ru.setUsum(count);
						fser.AddCount(ru);
				}
			}		
			
			
			
			
			id = 160;
			re = fser.RulelistFraction(id);//查询规则id为 160  的风险分值
			User userwifiaYd = new User();
			userwifi.setPhone(phone);
			userwifi.setName("博彩");
			Integer userwifiaAYc =  fser.WifiNameNum(userwifiaYd);//wifi名称是否命中赌博类
			userwifi.setName("斗地主");
			Integer userwifiaAjd =  fser.WifiNameNum(userwifiaYd);//wifi名称是否命中赌博类
			userwifi.setName("金花");
			Integer userwifiaAkj =  fser.WifiNameNum(userwifiaYd);//wifi名称是否命中赌博类
			if(re.getStatus() != 2){
					if(userwifiaAYc != null){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							ru.setUsum(count);
							fser.AddCount(ru);
					}else if(userwifiaAjd != null){
						count = count-Integer.valueOf(re.getValue_at_risk());
						ru.setUserid(userId);
						ru.setValue_at_risk(re.getValue_at_risk());
						ru.setRtid(re.getTypeid());
						ru.setRid(id);
						ru.setUsum(count);
						fser.AddCount(ru);
					}else if(userwifiaAkj != null){
						count = count-Integer.valueOf(re.getValue_at_risk());
						ru.setUserid(userId);
						ru.setValue_at_risk(re.getValue_at_risk());
						ru.setRtid(re.getTypeid());
						ru.setRid(id);
						ru.setUsum(count);
						fser.AddCount(ru);
				}
			}		
			
			
			
			
			
			id = 161;
			re = fser.RulelistFraction(id);//查询规则id为 161  的风险分值
			User userwifiaz = new User();
			userwifi.setPhone(phone);
			userwifi.setName("中介");
			System.out.println(userwifiaz.getUserId()+"11111"+userwifiaz.getName());
			Integer wifiNamez =  fser.WifiNameNum(userwifiaz);//wifi名称是否命中中介类
			if(re.getStatus() != 2){
					if(wifiNamez != null){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							ru.setUsum(count);
							fser.AddCount(ru);
					}
			}		
			
			
			
			
			
			id = 162;
			re = fser.RulelistFraction(id);//查询规则id为 162  的风险分值
			User userwifiazy = new User();
			userwifi.setPhone(phone);
			userwifi.setName("医院");
			Integer wifiNamezy =  fser.WifiNameNum(userwifiazy);//wifi名称是否命中医院类
			if(re.getStatus() != 2){
					if(wifiNamezy != null){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							ru.setUsum(count);
							fser.AddCount(ru);
					}
			}		
			
			
			
			
			id = 163;
			re = fser.RulelistFraction(id);//查询规则id为 163  的风险分值
			User userwifiaYdd = new User();
			userwifi.setPhone(phone);
			userwifi.setName("酒店");
			Integer userwifiaAYcd =  fser.WifiNameNum(userwifiaYdd);//wifi名称是否命中赌博类
			userwifi.setName("宾馆");
			Integer userwifiaAjdb =  fser.WifiNameNum(userwifiaYdd);//wifi名称是否命中赌博类
			if(re.getStatus() != 2){
					if(userwifiaAYcd != null){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							ru.setUsum(count);
							fser.AddCount(ru);
					}else if(userwifiaAjdb != null){
						count = count-Integer.valueOf(re.getValue_at_risk());
						ru.setUserid(userId);
						ru.setValue_at_risk(re.getValue_at_risk());
						ru.setRtid(re.getTypeid());
						ru.setRid(id);
						ru.setUsum(count);
						fser.AddCount(ru);
					}
			}		
			
			
			
			
			
			
			id = 174;
			re = fser.RulelistFraction(id);//查询规则id为 174  的风险分值
			user.setPhone(phone);
			Integer reportnumA = fser.UserLongintime(user);//登录app时间是否为12:00-5：00
			if(re.getStatus() != 2){
				if(reportnumA != null){
						count = count-Integer.valueOf(re.getValue_at_risk());
						ru.setUserid(userId);
						ru.setValue_at_risk(re.getValue_at_risk());
						ru.setRtid(re.getTypeid());
						ru.setRid(id);
						ru.setUsum(count);
						fser.AddCount(ru);
				}
						
			}
			
			
			
			
			
			
			
			id = 178;
			re = fser.RulelistFraction(id);//查询规则id为 178  的风险分值
			user.setUserId(userId);
			User reportnum = fser.ReportNum(user);//运营商风险结果分数
			if(re.getStatus() != 2){
				if(reportnum != null){
					System.out.println(reportnum+"风险"+re.getThresholdValue());
					if(reportnum.getScore() < Integer.valueOf(re.getThresholdValue())){
						count = count-Integer.valueOf(re.getValue_at_risk());
						ru.setUserid(userId);
						ru.setValue_at_risk(re.getValue_at_risk());
						ru.setRtid(re.getTypeid());
						ru.setRid(id);
						ru.setUsum(count);
						fser.AddCount(ru);
					}
				}
						
			}
			
			
			id = 179;
			re = fser.RulelistFraction(id);//查询规则id为 179  的风险分值
			user.setUserId(userId);
			User rportnum = fser.ReportNum(user);//运营商风险结果分数
			if(re.getStatus() != 2){
				if(rportnum != null){
					if(rportnum.getId() != null){
						System.out.println(rportnum+"风险B"+re.getThresholdValue());
						if(rportnum.getScore() > 400){
							if(rportnum.getScore() <= 500){
								count = count-Integer.valueOf(re.getValue_at_risk());
								ru.setUserid(userId);
								ru.setValue_at_risk(re.getValue_at_risk());
								ru.setRtid(re.getTypeid());
								ru.setRid(id);
								ru.setUsum(count);
								fser.AddCount(ru);
							}
						}
					}
				}
			}
			
			
			
			
			id = 180;
			re = fser.RulelistFraction(id);//查询规则id为 180  的风险分值
			User ua = new User();
			ua.setUserId(userId);
			Integer rid = fser.ReportID(ua);//运营商数据是否无法抓取
			if(re.getStatus() != 2){
				if(rid == null){
					System.out.println();
						count = count-Integer.valueOf(re.getValue_at_risk());
						ru.setUserid(userId);
						ru.setValue_at_risk(re.getValue_at_risk());
						ru.setRtid(re.getTypeid());
						ru.setRid(id);
						ru.setUsum(count);
						fser.AddCount(ru);
				}
			}
			
			TuoMinUtil to = new TuoMinUtil();
			
			id = 181;
			re = fser.RulelistFraction(id);//查询规则id为 181  的风险分值
			User uc = new User();
			uc.setUserId(userId);
			uc.setPhone(to.mobileEncrypt(phone));
			Integer phoneType = fser.AppInfoUser(uc);//借款用户手机号与运营商手机号是否匹配
			if(re.getStatus() != 2){
				if(phoneType == null){
						count = count-Integer.valueOf(re.getValue_at_risk());
						ru.setUserid(userId);
						ru.setValue_at_risk(re.getValue_at_risk());
						ru.setRtid(re.getTypeid());
						ru.setRid(id);
						ru.setUsum(count);
						fser.AddCount(ru);
				}
			}
			
			
			
			id = 182;
			re = fser.RulelistFraction(id);//查询规则id为 182  的风险分值
			User ub = new User();
			ub.setUserId(userId);
			ub.setIdnumber(idNumber);
			Integer IdType = fser.AppInfoUser(ub);//借款用户身份证号与运营商身份证号是否匹配
			if(re.getStatus() != 2){
				if(IdType == null){
						System.out.println("182:"+IdType);
						count = count-Integer.valueOf(re.getValue_at_risk());
						ru.setUserid(userId);
						ru.setValue_at_risk(re.getValue_at_risk());
						ru.setRtid(re.getTypeid());
						ru.setRid(id);
						ru.setUsum(count);
						fser.AddCount(ru);
				}
			}
			
			
			
			id = 72;
			re = fser.RulelistFraction(id);//查询规则id为 72  的风险分值
			if(con != null){
				if(re != null){
					if(re.getStatus() != 2){
						if(con.getWifiIP() != null){
							if(con.getWifiIP().length() != 0){
								Integer WifiIPNum = rdao.UserWifiIPNum(con);//一天内WIFIIP连接相同数
								if(WifiIPNum != null){
									System.out.println("WIFIIP:"+con.getWifiIP());
									if(WifiIPNum > Integer.valueOf(re.getThresholdValue())){
										count = count-Integer.valueOf(re.getValue_at_risk());
										ru.setUserid(userId);
										ru.setValue_at_risk(re.getValue_at_risk());
										ru.setRid(id);
										ru.setUsum(count);
										ru.setRtid(re.getTypeid());
										fser.AddCount(ru);
									}
							}
							}
						}
					}
				}
			}
			
			
			
			id = 75;
			re = fser.RulelistFraction(id);//查询规则id为 75  的风险分值
			if(con != null){
				if(re != null){
					if(re.getStatus() != 2){
						if(con.getWifiMac() != null){
							if(con.getWifiMac().length() != 0){
								System.out.println("WifiMacNum:"+con.getWifiMac());
								Integer WifiMacNum = rdao.UserWifiMacNum(con);//WIFIMacnum 关联数
								if(WifiMacNum != null){
									
									if(WifiMacNum > Integer.valueOf(re.getThresholdValue())){
										count = count-Integer.valueOf(re.getValue_at_risk());
										ru.setUserid(userId);
										ru.setUsum(count);
										ru.setValue_at_risk(re.getValue_at_risk());
										ru.setRtid(re.getTypeid());
										ru.setRid(id);
										fser.AddCount(ru);
									}
							}
							}
							
						}
					}
				}
			}
			
			
			
			
			id = 183;
			re = fser.RulelistFraction(id);//查询规则id为 183  的风险分值
			User uu = new User();
			uu.setUserId(userId);
			uu.setName(name);
			Integer NameType = fser.AppInfoUser(uu);//借款用户姓名与运营商姓名是否匹配
			if(re.getStatus() != 2){
				if(NameType == null){
					System.out.println("183:"+NameType);
						count = count-Integer.valueOf(re.getValue_at_risk());
						ru.setUserid(userId);
						ru.setValue_at_risk(re.getValue_at_risk());
						ru.setRtid(re.getTypeid());
						ru.setRid(id);
						ru.setUsum(count);
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
						ru.setUsum(count);
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
						ru.setUsum(count);
						fser.AddCount(ru);
				}
			}
			
			
			
			id = 185;
			re = fser.RulelistFraction(id);//查询规则id为 185  的风险分值
			String phonemoney = fser.PhoneUserMoney(userId);//手机余额 
			BigDecimal aphon = null;
			if(phonemoney != null){
				aphon = new BigDecimal(phonemoney);
			}else{
				aphon = new BigDecimal(0);
			}
			
			if(re.getStatus() != 2){
				BigDecimal bphon = new BigDecimal(re.getThresholdValue());
				int ctype = aphon.compareTo(bphon);
				if(ctype < 0){
						count = count-Integer.valueOf(re.getValue_at_risk());
						ru.setUserid(userId);
						ru.setValue_at_risk(re.getValue_at_risk());
						ru.setRtid(re.getTypeid());
						ru.setRid(id);
						ru.setUsum(count);
						fser.AddCount(ru);
				}
			}
			
			
			
			id = 197;
			re = fser.RulelistFraction(id);//查询规则id为 197  的风险分值
			Integer smsNum = fser.SmsUserMoney(userId);//短信发送次数
			if(re.getStatus() != 2){
				if(smsNum != null){
					if(smsNum < Integer.valueOf(re.getThresholdValue())){
						count = count-Integer.valueOf(re.getValue_at_risk());
						ru.setUserid(userId);
						ru.setValue_at_risk(re.getValue_at_risk());
						ru.setRtid(re.getTypeid());
						ru.setRid(id);
						ru.setUsum(count);
						fser.AddCount(ru);
					}
				}else{
					count = count-Integer.valueOf(re.getValue_at_risk());
					ru.setUserid(userId);
					ru.setValue_at_risk(re.getValue_at_risk());
					ru.setRtid(re.getTypeid());
					ru.setRid(id);
					ru.setUsum(count);
					fser.AddCount(ru);
				}
				
			}
			
			
			
			
			id = 198;
			re = fser.RulelistFraction(id);//查询规则id为 197  的风险分值
			Integer smsCNum = fser.SmsUserMoney(userId);//短信发送次数
			if(re.getStatus() != 2){
				if(smsCNum != null){
					if(smsCNum > Integer.valueOf(re.getThresholdValue())){
						count = count-Integer.valueOf(re.getValue_at_risk());
						ru.setUserid(userId);
						ru.setValue_at_risk(re.getValue_at_risk());
						ru.setRtid(re.getTypeid());
						ru.setRid(id);
						ru.setUsum(count);
						fser.AddCount(ru);
					}
				}
			}
			
			
			
			
			id = 186;
			re = fser.RulelistFraction(id);//查询规则id为 186  的风险分值
			Integer month = fser.MonthUserphone(userId);//近一月被叫号码个数
			if(re.getStatus() != 2){
				if(month < Integer.valueOf(re.getThresholdValue())){
						count = count-Integer.valueOf(re.getValue_at_risk());
						ru.setUserid(userId);
						ru.setValue_at_risk(re.getValue_at_risk());
						ru.setRtid(re.getTypeid());
						ru.setRid(id);
						ru.setUsum(count);
						fser.AddCount(ru);
				}
			}
			
			
			
			id = 187;
			re = fser.RulelistFraction(id);//查询规则id为 186  的风险分值
			Integer monthC = fser.MonthUserphone(userId);//近一月被叫号码个数
			if(re.getStatus() != 2){
				if(monthC > Integer.valueOf(re.getThresholdValue())){
						count = count-Integer.valueOf(re.getValue_at_risk());
						ru.setUserid(userId);
						ru.setValue_at_risk(re.getValue_at_risk());
						ru.setRtid(re.getTypeid());
						ru.setRid(id);
						ru.setUsum(count);
						fser.AddCount(ru);
				}
			}
			
			
			
			id = 199;
			re = fser.RulelistFraction(id);//查询规则id为 199  的风险分值
			Integer usernum = fser.UserNum(userId);//通讯录联系人数量
			if(re.getStatus() != 2){
				if(usernum != null){
					if(usernum < Integer.valueOf(re.getThresholdValue())){
						count = count-Integer.valueOf(re.getValue_at_risk());
						ru.setUserid(userId);
						ru.setValue_at_risk(re.getValue_at_risk());
						ru.setRtid(re.getTypeid());
						ru.setRid(id);
						ru.setUsum(count);
						fser.AddCount(ru);
				}
				}else{
					count = count-Integer.valueOf(re.getValue_at_risk());
					ru.setUserid(userId);
					ru.setValue_at_risk(re.getValue_at_risk());
					ru.setRtid(re.getTypeid());
					ru.setRid(id);
					ru.setUsum(count);
					fser.AddCount(ru);
				}
			}
			
			
			
			id = 30;
			re = fser.RulelistFraction(id);//查询规则id为 30  的风险分值
			Integer apnum = 0;
			user.setUserId(userId);
			user.setName("借");
			apnum =apnum + fser.AppNum(user);//近7天 借款人手机号对应设备历史安装借贷类app类个数
			user.setName("贷");
			apnum =apnum + fser.AppNum(user);
			user.setName("米");
			apnum =apnum + fser.AppNum(user);
			if(re.getStatus() != 2){
					if(dmnum != null){
						if(dmnum >= Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							ru.setUsum(count);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			
			id = 31;
			re = fser.RulelistFraction(id);//查询规则id为 30  的风险分值
			Integer monthapnum = 0;
			user.setUserId(userId);
			user.setName("借");
			monthapnum =monthapnum + fser.AppNum(user);//近1个月借款人手机号对应设备历史安装借贷类app类个数
			user.setName("贷");
			monthapnum =monthapnum + fser.AppNum(user);
			user.setName("米");
			monthapnum =monthapnum + fser.AppNum(user);
			if(re.getStatus() != 2){
					if(monthapnum != null){
						if(monthapnum >= Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							ru.setUsum(count);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			

			id = 32;
			re = fser.RulelistFraction(id);//查询规则id为 32  的风险分值
			Integer dcnum = 0;
			user.setUserId(userId);
			user.setName("博彩");
			dcnum = dcnum + fser.AppNum(user);//近7天借款人手机号对应设备历史安装赌博类app类个数
			user.setName("斗地主");
			dcnum = dcnum + fser.AppNum(user);//近7天借款人手机号对应设备历史安装赌博类app类个数
			user.setName("金花");
			dcnum = dcnum + fser.AppNum(user);//近7天借款人手机号对应设备历史安装赌博类app类个数
			if(re.getStatus() != 2){
					if(dcnum != null){
						if(dcnum >= Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							ru.setUsum(count);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			
			id = 33;
			re = fser.RulelistFraction(id);//查询规则id为 33  的风险分值
			Integer monthdcnum = 0;
			user.setUserId(userId);
			user.setName("博彩");
			monthdcnum = monthdcnum + fser.AppNum(user);//近1个月借款人手机号对应设备历史安装赌博类app类个数
			user.setName("斗地主");
			monthdcnum = monthdcnum + fser.AppNum(user);//近1个月借款人手机号对应设备历史安装赌博类app类个数
			user.setName("金花");
			monthdcnum = monthdcnum + fser.AppNum(user);//近1个月借款人手机号对应设备历史安装赌博类app类个数
			if(re.getStatus() != 2){
					if(monthdcnum != null){
						if(monthdcnum >= Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							ru.setUsum(count);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			
			id = 34;
			re = fser.RulelistFraction(id);//查询规则id为 30  的风险分值
			Integer idapnum = 0;
			user.setUserId(userId);
			user.setName("借");
			idapnum =idapnum + fser.AppNum(user);//近7天 借款人手机号对应设备历史安装借贷类app类个数
			user.setName("贷");
			idapnum =idapnum + fser.AppNum(user);
			user.setName("米");
			idapnum =idapnum + fser.AppNum(user);
			if(re.getStatus() != 2){
					if(idapnum != null){
						if(idapnum >= Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							ru.setUsum(count);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			
			id = 35;
			re = fser.RulelistFraction(id);//查询规则id为 30  的风险分值
			Integer idmonthapnum = 0;
			user.setUserId(userId);
			user.setName("借");
			idmonthapnum =idmonthapnum + fser.AppNum(user);//近1个月借款人手机号对应设备历史安装借贷类app类个数
			user.setName("贷");
			idmonthapnum =idmonthapnum + fser.AppNum(user);
			user.setName("米");
			idmonthapnum =idmonthapnum + fser.AppNum(user);
			if(re.getStatus() != 2){
					if(idmonthapnum != null){
						if(idmonthapnum >= Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							ru.setUsum(count);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			id = 36;
			re = fser.RulelistFraction(id);//查询规则id为 36  的风险分值
			Integer monthdAcnum = 0;
			user.setUserId(userId);
			user.setName("博彩");
			monthdAcnum = monthdAcnum + fser.AppNum(user);//近7天借款人手机号对应设备历史安装赌博类app类个数
			user.setName("斗地主");
			monthdAcnum = monthdAcnum + fser.AppNum(user);//近7天借款人手机号对应设备历史安装赌博类app类个数
			user.setName("金花");
			monthdAcnum = monthdAcnum + fser.AppNum(user);//近7天借款人手机号对应设备历史安装赌博类app类个数
			if(re.getStatus() != 2){
					if(monthdAcnum != null){
						if(monthdAcnum >= Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							ru.setUsum(count);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			
			id = 37;
			re = fser.RulelistFraction(id);//查询规则id为 33  的风险分值
			Integer monthdcnumC = 0;
			user.setUserId(userId);
			user.setName("博彩");
			monthdcnumC = monthdcnumC + fser.AppNum(user);//近1个月借款人手机号对应设备历史安装赌博类app类个数
			user.setName("斗地主");
			monthdcnumC = monthdcnumC + fser.AppNum(user);//近1个月借款人手机号对应设备历史安装赌博类app类个数
			user.setName("金花");
			monthdcnumC = monthdcnumC + fser.AppNum(user);//近1个月借款人手机号对应设备历史安装赌博类app类个数
			if(re.getStatus() != 2){
					if(monthdcnumC != null){
						if(monthdcnumC >= Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRtid(re.getTypeid());
							ru.setRid(id);
							ru.setUsum(count);
							fser.AddCount(ru);
						}
					}
			}
			
			
			
			
			id = 202;
			re = fser.RulelistFraction(id);//查询规则id为 186  的风险分值
			Integer monthZ = fser.MonthUserphone(userId);//近6月主叫号码数量
			if(re.getStatus() != 2){
				if(monthZ < Integer.valueOf(re.getThresholdValue())){
						count = count-Integer.valueOf(re.getValue_at_risk());
						ru.setUserid(userId);
						ru.setValue_at_risk(re.getValue_at_risk());
						ru.setRtid(re.getTypeid());
						ru.setRid(id);
						ru.setUsum(count);
						fser.AddCount(ru);
				}
			}
			
			
			
			
			
			id = 203;
			re = fser.RulelistFraction(id);//查询规则id为 186  的风险分值
			Integer monthCs = fser.MonthUserphone(userId);//近3月被叫号码数量
			if(re.getStatus() != 2){
				if(monthCs > Integer.valueOf(re.getThresholdValue())){
						count = count-Integer.valueOf(re.getValue_at_risk());
						ru.setUserid(userId);
						ru.setValue_at_risk(re.getValue_at_risk());
						ru.setRtid(re.getTypeid());
						ru.setRid(id);
						ru.setUsum(count);
						fser.AddCount(ru);
				}
			}
			
			
			
			
			
			id = 9;
			re = fser.RulelistFraction(id);//查询规则id为 9  的风险分值
			if(re != null){
				if(re.getStatus() != 2){
					Integer userPhoneCount = fser.Userpt(userId);//借款人通讯录关联平台注册借款人
					if(userPhoneCount != null){
						if(userPhoneCount >= Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setUsum(count);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
						}
					}
				}
			}
			
			
			
			
			
			
			
			
			
			id = 10;
			re = fser.RulelistFraction(id);//查询规则id为 10  的风险分值
			if(re != null){
				if(re.getStatus() != 2){
					Integer userPhoneCount = fser.Userpt(userId);//借款人通讯录关联平台逾期借款人
					if(userPhoneCount != null){
						if(userPhoneCount >= Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setUsum(count);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
						}
					}
				}
			}
			
			
			
			
			
//			id = 235;
//			re = fser.RulelistFraction(id);//查询规则id为 235  的风险分值
//			User uas = new User();
//			uas.setUserId(userId);
//			if(re != null){
//				if(re.getStatus() != 2){
//					Integer userPhoneCount = fser.Userappt(uas);//app安装个数
//					if(userPhoneCount != null){
//						if(userPhoneCount < Integer.valueOf(re.getThresholdValue())){
//							count = count-Integer.valueOf(re.getValue_at_risk());
//							ru.setUserid(userId);
//							ru.setValue_at_risk(re.getValue_at_risk());
//							ru.setRid(id);
//							ru.setUsum(count);
//							ru.setRtid(re.getTypeid());
//							fser.AddCount(ru);
//						}
//					}
//				}
//			}
			
			
			
			
			
			id = 236;
			re = fser.RulelistFraction(id);//查询规则id为 236  的风险分值
			User userIda = new User();
			userIda.setUserId(userId);
			userIda.setName("微信");
			if(re != null){
				if(re.getStatus() != 2){
					Integer userPhoneCount = fser.Userappt(userIda);//是否有安装微信app
					if(userPhoneCount == null){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setUsum(count);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
					}
				}
			}
			
			
			
			
			
			id = 237;
			re = fser.RulelistFraction(id);//查询规则id为 237  的风险分值
			User userIdz = new User();
			userIdz.setUserId(userId);
			userIdz.setName("支付宝");
			if(re != null){
				if(re.getStatus() != 2){
					Integer userPhoneCount = fser.Userappt(userIdz);//是否有安装支付宝app
					if(userPhoneCount == null){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setUsum(count);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
					}
				}
			}
			
			
			
			
			
			
//			id = 239;
//			re = fser.RulelistFraction(id);//查询规则id为 239  的风险分值
//			User userIdi = new User();
//			userIdi.setUserId(userId);
//			userIdi.setName("IMEI");
//			if(re != null){
//				if(re.getStatus() != 2){
//					Integer userPhoneCount = fser.Userappt(userIdi);//是否有IMEI修改app
//					if(userPhoneCount != null){
//							count = count-Integer.valueOf(re.getValue_at_risk());
//							ru.setUserid(userId);
//							ru.setValue_at_risk(re.getValue_at_risk());
//							ru.setRid(id);
//							ru.setUsum(count);
//							ru.setRtid(re.getTypeid());
//							fser.AddCount(ru);
//					}
//				}
//			}
			
			
			
			
//			
//			id = 245;
//			re = fser.RulelistFraction(id);//查询规则id为 245  的风险分值
//			User userIdq = new User();
//			userIdq.setUserId(userId);
//			userIdq.setName("QQ");
//			if(re != null){
//				if(re.getStatus() != 2){
//					Integer userPhoneCount = fser.Userappt(userIdq);//是否安装QQapp
//					if(userPhoneCount != null){
//							count = count-Integer.valueOf(re.getValue_at_risk());
//							ru.setUserid(userId);
//							ru.setValue_at_risk(re.getValue_at_risk());
//							ru.setRid(id);
//							ru.setUsum(count);
//							ru.setRtid(re.getTypeid());
//							fser.AddCount(ru);
//					}
//				}
//			}
			
			
			
			
			
//			id = 246;
//			re = fser.RulelistFraction(id);//查询规则id为 246  的风险分值
//			User userIdr = new User();
//			userIdr.setUserId(userId);
//			userIdr.setName("日历");
//			if(re != null){
//				if(re.getStatus() != 2){
//					Integer userPhoneCount = fser.Userappt(userIdr);//是否安装日历app
//					if(userPhoneCount != null){
//							count = count-Integer.valueOf(re.getValue_at_risk());
//							ru.setUserid(userId);
//							ru.setValue_at_risk(re.getValue_at_risk());
//							ru.setRid(id);
//							ru.setUsum(count);
//							ru.setRtid(re.getTypeid());
//							fser.AddCount(ru);
//					}
//				}
//			}
			
			
			
			
			
//			id = 240;
//			re = fser.RulelistFraction(id);//查询规则id为 240  的风险分值
//			User userIdn = new User();
//			userIdn.setUserId(userId);
//			userIdn.setName("微信");
//			if(re != null){
//				if(re.getStatus() != 2){
//					Integer userPhoneCount = fser.Userappt(userIdn);//微信app安装个数
//					if(userPhoneCount != null){
//						if(userPhoneCount > Integer.valueOf(re.getThresholdValue())){
//							count = count-Integer.valueOf(re.getValue_at_risk());
//							ru.setUserid(userId);
//							ru.setValue_at_risk(re.getValue_at_risk());
//							ru.setRid(id);
//							ru.setUsum(count);
//							ru.setRtid(re.getTypeid());
//							fser.AddCount(ru);
//						}
//					}
//				}
//			}
//			
//			
//			
//			
//			id = 241;
//			re = fser.RulelistFraction(id);//查询规则id为 241  的风险分值
//			User userIdzf = new User();
//			userIdzf.setUserId(userId);
//			userIdzf.setName("支付宝");
//			if(re != null){
//				if(re.getStatus() != 2){
//					Integer userPhoneCount = fser.Userappt(userIdzf);//支付宝app安装个数
//					if(userPhoneCount != null){
//						if(userPhoneCount > Integer.valueOf(re.getThresholdValue())){
//							count = count-Integer.valueOf(re.getValue_at_risk());
//							ru.setUserid(userId);
//							ru.setValue_at_risk(re.getValue_at_risk());
//							ru.setRid(id);
//							ru.setUsum(count);
//							ru.setRtid(re.getTypeid());
//							fser.AddCount(ru);
//						}
//					}
//				}
//			}
//			
//			
//			
//			
//			id = 247;
//			re = fser.RulelistFraction(id);//查询规则id为 247  的风险分值
//			User userIdx = new User();
//			userIdx.setUserId(userId);
//			userIdx.setName("相册");
//			if(re != null){
//				if(re.getStatus() != 2){
//					Integer userPhoneCount = fser.Userappt(userIdr);//是否安装相册app
//					if(userPhoneCount != null){
//							count = count-Integer.valueOf(re.getValue_at_risk());
//							ru.setUserid(userId);
//							ru.setValue_at_risk(re.getValue_at_risk());
//							ru.setRid(id);
//							ru.setUsum(count);
//							ru.setRtid(re.getTypeid());
//							fser.AddCount(ru);
//					}
//				}
//			}
//			
//			
//			
//			id = 248;
//			re = fser.RulelistFraction(id);//查询规则id为 248  的风险分值
//			User userIds = new User();
//			userIds.setUserId(userId);
//			userIds.setName("设置");
//			if(re != null){
//				if(re.getStatus() != 2){
//					Integer userPhoneCount = fser.Userappt(userIds);//是否安装设置app
//					if(userPhoneCount != null){
//							count = count-Integer.valueOf(re.getValue_at_risk());
//							ru.setUserid(userId);
//							ru.setValue_at_risk(re.getValue_at_risk());
//							ru.setRid(id);
//							ru.setUsum(count);
//							ru.setRtid(re.getTypeid());
//							fser.AddCount(ru);
//					}
//				}
//			}
//			
//			
//			
//			
//			
//			id = 249;
//			re = fser.RulelistFraction(id);//查询规则id为 249  的风险分值
//			User userIdl = new User();
//			userIdl.setUserId(userId);
//			userIdl.setName("浏览器");
//			if(re != null){
//				if(re.getStatus() != 2){
//					Integer userPhoneCount = fser.Userappt(userIdl);//是否安装浏览器app
//					if(userPhoneCount != null){
//							count = count-Integer.valueOf(re.getValue_at_risk());
//							ru.setUserid(userId);
//							ru.setValue_at_risk(re.getValue_at_risk());
//							ru.setRid(id);
//							ru.setUsum(count);
//							ru.setRtid(re.getTypeid());
//							fser.AddCount(ru);
//					}
//				}
//			}
//			
//			
//			
//			
//			id = 250;
//			re = fser.RulelistFraction(id);//查询规则id为 250  的风险分值
//			User userIdly = new User();
//			userIdly.setUserId(userId);
//			userIdly.setName("旅");
//			if(re != null){
//				if(re.getStatus() != 2){
//					Integer userPhoneCount = fser.Userappt(userIdly);//是否安装旅游出行类app
//					if(userPhoneCount != null){
//							count = count-Integer.valueOf(re.getValue_at_risk());
//							ru.setUserid(userId);
//							ru.setValue_at_risk(re.getValue_at_risk());
//							ru.setRid(id);
//							ru.setUsum(count);
//							ru.setRtid(re.getTypeid());
//							fser.AddCount(ru);
//					}
//				}
//			}
//			
//			
//			
//			
//			
//			id = 251;
//			re = fser.RulelistFraction(id);//查询规则id为 251  的风险分值
//			User userIdlya = new User();
//			userIdlya.setUserId(userId);
//			userIdlya.setName("旅");
//			if(re != null){
//				if(re.getStatus() != 2){
//					Integer userPhoneCount = fser.Userappt(userIdlya);//旅游出行类app安装个数
//					if(userPhoneCount != null){
//						if(userPhoneCount < Integer.valueOf(re.getThresholdValue())){
//							count = count-Integer.valueOf(re.getValue_at_risk());
//							ru.setUserid(userId);
//							ru.setValue_at_risk(re.getValue_at_risk());
//							ru.setRid(id);
//							ru.setUsum(count);
//							ru.setRtid(re.getTypeid());
//							fser.AddCount(ru);
//						}
//					}
//				}
//			}
//			
//			
//			
//			
//			id = 252;
//			re = fser.RulelistFraction(id);//查询规则id为 252  的风险分值
//			User userIdlq = new User();
//			userIdlq.setUserId(userId);
//			if(re != null){
//				if(re.getStatus() != 2){
//					Integer userPhoneCount = fser.Userappt(userIdlq);//其他类app安装个数
//					if(userPhoneCount != null){
//						if(userPhoneCount > Integer.valueOf(re.getThresholdValue())){
//							count = count-Integer.valueOf(re.getValue_at_risk());
//							ru.setUserid(userId);
//							ru.setValue_at_risk(re.getValue_at_risk());
//							ru.setRid(id);
//							ru.setUsum(count);
//							ru.setRtid(re.getTypeid());
//							fser.AddCount(ru);
//						}
//					}
//				}
//			}
//			
//			
//			
//			
//			
//			id = 253;
//			re = fser.RulelistFraction(id);//查询规则id为 253  的风险分值
//			User userIdld = new User();
//			userIdld.setUserId(userId);
//			userIdld.setName("毒");
//			if(re != null){
//				if(re.getStatus() != 2){
//					Integer userPhoneCount = fser.Userappt(userIdld);//是否安装软件杀毒类app
//					if(userPhoneCount != null){
//							count = count-Integer.valueOf(re.getValue_at_risk());
//							ru.setUserid(userId);
//							ru.setValue_at_risk(re.getValue_at_risk());
//							ru.setRid(id);
//							ru.setUsum(count);
//							ru.setRtid(re.getTypeid());
//							fser.AddCount(ru);
//					}
//				}
//			}
//			
//			
//			
//			
//			
//			id = 254;
//			re = fser.RulelistFraction(id);//查询规则id为 254  的风险分值
//			User userIdldn = new User();
//			userIdldn.setUserId(userId);
//			userIdldn.setName("毒");
//			if(re != null){
//				if(re.getStatus() != 2){
//					Integer userPhoneCount = fser.Userappt(userIdldn);//软件杀毒类app安装个数
//					if(userPhoneCount != null){
//						if(userPhoneCount > Integer.valueOf(re.getThresholdValue())){
//							count = count-Integer.valueOf(re.getValue_at_risk());
//							ru.setUserid(userId);
//							ru.setValue_at_risk(re.getValue_at_risk());
//							ru.setRid(id);
//							ru.setUsum(count);
//							ru.setRtid(re.getTypeid());
//							fser.AddCount(ru);
//						}
//					}
//				}
//			}
//			
//			
//			
//			
//			id = 255;
//			re = fser.RulelistFraction(id);//查询规则id为 255  的风险分值
//			User userIdldx = new User();
//			userIdldx.setUserId(userId);
//			userIdldx.setName("相");
//			User userIdldt = new User();
//			userIdldt.setUserId(userId);
//			userIdldt.setName("图");
//			if(re != null){
//				if(re.getStatus() != 2){
//					Integer userPhoneCount = fser.Userappt(userIdldn);//摄影图像类app安装个数
//					Integer userPhoneTCount = fser.Userappt(userIdldt);
//					userPhoneCount = userPhoneCount + userPhoneTCount;
//					if(userPhoneCount != null){
//						if(userPhoneCount > Integer.valueOf(re.getThresholdValue())){
//							count = count-Integer.valueOf(re.getValue_at_risk());
//							ru.setUserid(userId);
//							ru.setValue_at_risk(re.getValue_at_risk());
//							ru.setRid(id);
//							ru.setUsum(count);
//							ru.setRtid(re.getTypeid());
//							fser.AddCount(ru);
//						}
//					}
//				}
//			}
//			
//			
//			
//			
//			
//			id = 256;
//			re = fser.RulelistFraction(id);//查询规则id为 255  的风险分值
//			User userIdlds = new User();
//			userIdlds.setUserId(userId);
//			userIdlds.setName("美团");
//			if(re != null){
//				if(re.getStatus() != 2){
//					Integer userPhoneCount = fser.Userappt(userIdlds);//是否安装生活服务类app
//					if(userPhoneCount != null){
//							count = count-Integer.valueOf(re.getValue_at_risk());
//							ru.setUserid(userId);
//							ru.setValue_at_risk(re.getValue_at_risk());
//							ru.setRid(id);
//							ru.setUsum(count);
//							ru.setRtid(re.getTypeid());
//							fser.AddCount(ru);
//					}
//				}
//			}
//			
//			
//			
//			
//			id = 257;
//			re = fser.RulelistFraction(id);//查询规则id为 256  的风险分值
//			User userIdlds1 = new User();
//			userIdlds1.setUserId(userId);
//			userIdlds1.setName("美团");
//			User userIdldsh = new User();
//			userIdldsh.setUserId(userId);
//			userIdldsh.setName("生");
//			if(re != null){
//				if(re.getStatus() != 2){
//					Integer userPhoneCount = fser.Userappt(userIdlds1);//是否安装生活服务类app
//					Integer userPhoneTCount = fser.Userappt(userIdldsh);
//					userPhoneCount = userPhoneCount + userPhoneTCount;
//					if(userPhoneCount != null){
//						if(userPhoneCount < Integer.valueOf(re.getThresholdValue())){
//							count = count-Integer.valueOf(re.getValue_at_risk());
//							ru.setUserid(userId);
//							ru.setValue_at_risk(re.getValue_at_risk());
//							ru.setRid(id);
//							ru.setUsum(count);
//							ru.setRtid(re.getTypeid());
//							fser.AddCount(ru);
//						}
//					}
//				}
//			}
//			
//			
//			
//			
//			id = 258;
//			re = fser.RulelistFraction(id);//查询规则id为 258  的风险分值
//			User userIdldtx = new User();
//			userIdldtx.setUserId(userId);
//			userIdldtx.setName("通讯");
//			if(re != null){
//				if(re.getStatus() != 2){
//					Integer userPhoneCount = fser.Userappt(userIdldtx);//是否安装通讯社交类app
//					if(userPhoneCount != null){
//							count = count-Integer.valueOf(re.getValue_at_risk());
//							ru.setUserid(userId);
//							ru.setValue_at_risk(re.getValue_at_risk());
//							ru.setRid(id);
//							ru.setUsum(count);
//							ru.setRtid(re.getTypeid());
//							fser.AddCount(ru);
//					}
//				}
//			}
//			
//			
//			
//			id = 259;
//			re = fser.RulelistFraction(id);//查询规则id为 259  的风险分值
//			User userIdldtxn = new User();
//			userIdldtxn.setUserId(userId);
//			userIdldtxn.setName("通讯");
//			User userIdldtxn2 = new User();
//			userIdldtxn2.setUserId(userId);
//			userIdldtxn2.setName("社");
//			if(re != null){
//				if(re.getStatus() != 2){
//					Integer userPhoneCount = fser.Userappt(userIdldtxn);//通讯社交类app安装个数
//					Integer userPhoneCount1 = fser.Userappt(userIdldtxn2);
//					userPhoneCount = userPhoneCount + userPhoneCount1;
//					if(userPhoneCount != null){
//						if(userPhoneCount > Integer.valueOf(re.getThresholdValue())){
//							count = count-Integer.valueOf(re.getValue_at_risk());
//							ru.setUserid(userId);
//							ru.setValue_at_risk(re.getValue_at_risk());
//							ru.setRid(id);
//							ru.setUsum(count);
//							ru.setRtid(re.getTypeid());
//							fser.AddCount(ru);
//						}
//					}
//				}
//			}
//			
//			
//			
//			
//			id = 260;
//			re = fser.RulelistFraction(id);//查询规则id为 260  的风险分值
//			User userIdldtx2 = new User();
//			userIdldtx2.setUserId(userId);
//			userIdldtx2.setName("通讯");
//			User userIdldtx21 = new User();
//			userIdldtx21.setUserId(userId);
//			userIdldtx21.setName("社");
//			if(re != null){
//				if(re.getStatus() != 2){
//					Integer userPhoneCount = fser.Userappt(userIdldtx2);//通讯社交类app安装个数
//					Integer userPhoneCount2 = fser.Userappt(userIdldtx21);
//					userPhoneCount = userPhoneCount + userPhoneCount2;
//					if(userPhoneCount != null){
//						if(userPhoneCount < Integer.valueOf(re.getThresholdValue())){
//							count = count-Integer.valueOf(re.getValue_at_risk());
//							ru.setUserid(userId);
//							ru.setValue_at_risk(re.getValue_at_risk());
//							ru.setRid(id);
//							ru.setUsum(count);
//							ru.setRtid(re.getTypeid());
//							fser.AddCount(ru);
//						}
//					}
//				}
//			}
//			
//			
//			
//			
//			
//			id = 261;
//			re = fser.RulelistFraction(id);//查询规则id为 261  的风险分值
//			User userIdldtxg = new User();
//			userIdldtxg.setUserId(userId);
//			userIdldtxg.setName("淘宝");
//			if(re != null){
//				if(re.getStatus() != 2){
//					Integer userPhoneCount = fser.Userappt(userIdldtxg);//是否安装网上购物类app
//					if(userPhoneCount == null){
//							count = count-Integer.valueOf(re.getValue_at_risk());
//							ru.setUserid(userId);
//							ru.setValue_at_risk(re.getValue_at_risk());
//							ru.setRid(id);
//							ru.setUsum(count);
//							ru.setRtid(re.getTypeid());
//							fser.AddCount(ru);
//					}
//				}
//			}
//			
//			
//			
//			
//			id = 262;
//			re = fser.RulelistFraction(id);//查询规则id为 262  的风险分值
//			User userIdldtxg1 = new User();
//			userIdldtxg1.setUserId(userId);
//			userIdldtxg1.setName("淘宝");
//			User userIdldtxg2 = new User();
//			userIdldtxg2.setUserId(userId);
//			userIdldtxg2.setName("京东");
//			User userIdldtxg3 = new User();
//			userIdldtxg3.setUserId(userId);
//			userIdldtxg3.setName("拼多多");
//			User userIdldtxg4 = new User();
//			userIdldtxg4.setUserId(userId);
//			userIdldtxg4.setName("唯品会");
//			if(re != null){
//				if(re.getStatus() != 2){
//					int userPhoneCount = fser.Userappt(userIdldtxg1);//通讯社交类app安装个数
//					int userPhoneCount2 = fser.Userappt(userIdldtxg2);
//					int userPhoneCount3 = fser.Userappt(userIdldtxg3);
//					int userPhoneCount4 = fser.Userappt(userIdldtxg4);
//					userPhoneCount = userPhoneCount + userPhoneCount2 + userPhoneCount3 + userPhoneCount4;
//					if(userPhoneCount != 0){
//						if(userPhoneCount < Integer.valueOf(re.getThresholdValue())){
//							count = count-Integer.valueOf(re.getValue_at_risk());
//							ru.setUserid(userId);
//							ru.setValue_at_risk(re.getValue_at_risk());
//							ru.setRid(id);
//							ru.setUsum(count);
//							ru.setRtid(re.getTypeid());
//							fser.AddCount(ru);
//						}
//					}
//				}
//			}
//			
//			
//			
//			
//			
//			id = 263;
//			re = fser.RulelistFraction(id);//查询规则id为 263  的风险分值
//			User userIdldtxgq = new User();
//			userIdldtxgq.setUserId(userId);
//			if(re != null){
//				if(re.getStatus() != 2){
//					int userPhoneCount = fser.Userappt(userIdldtxgq);//未知类appp安装个数
//					if(userPhoneCount != 0){
//						if(userPhoneCount < Integer.valueOf(re.getThresholdValue())){
//							count = count-Integer.valueOf(re.getValue_at_risk());
//							ru.setUserid(userId);
//							ru.setValue_at_risk(re.getValue_at_risk());
//							ru.setRid(id);
//							ru.setUsum(count);
//							ru.setRtid(re.getTypeid());
//							fser.AddCount(ru);
//						}
//					}
//				}
//			}
//			
//			
//			
//			
//			id = 264;
//			re = fser.RulelistFraction(id);//查询规则id为 264  的风险分值
//			User userIdldtxw = new User();
//			userIdldtxw.setUserId(userId);
//			userIdldtxw.setName("新闻");
//			User userIdldtyd = new User();
//			userIdldtyd.setUserId(userId);
//			userIdldtyd.setName("阅读");
//			if(re != null){
//				if(re.getStatus() != 2){
//					int userPhoneCount = fser.Userappt(userIdldtxw);//是否安装新闻阅读类app
//					int userPhoneCount1 = fser.Userappt(userIdldtxw);//是否安装新闻阅读类app
//					userPhoneCount = userPhoneCount + userPhoneCount1;
//					if(userPhoneCount == 0){
//							count = count-Integer.valueOf(re.getValue_at_risk());
//							ru.setUserid(userId);
//							ru.setValue_at_risk(re.getValue_at_risk());
//							ru.setRid(id);
//							ru.setUsum(count);
//							ru.setRtid(re.getTypeid());
//							fser.AddCount(ru);
//					}
//				}
//			}
//			
//			
//			
//			
//			id = 265;
//			re = fser.RulelistFraction(id);//查询规则id为 265  的风险分值
//			User userIdldtsp = new User();
//			userIdldtsp.setUserId(userId);
//			userIdldtsp.setName("视频");
//			User userIdldtyy = new User();
//			userIdldtyy.setUserId(userId);
//			userIdldtyy.setName("影音");
//			if(re != null){
//				if(re.getStatus() != 2){
//					int userPhoneCount = fser.Userappt(userIdldtsp);//是否影音播放类app
//					int userPhoneCount1 = fser.Userappt(userIdldtyy);
//					userPhoneCount = userPhoneCount + userPhoneCount1;
//					if(userPhoneCount == 0){
//							count = count-Integer.valueOf(re.getValue_at_risk());
//							ru.setUserid(userId);
//							ru.setValue_at_risk(re.getValue_at_risk());
//							ru.setRid(id);
//							ru.setUsum(count);
//							ru.setRtid(re.getTypeid());
//							fser.AddCount(ru);
//					}
//				}
//			}
//			
//			
//			
//			
//			id = 266;
//			re = fser.RulelistFraction(id);//查询规则id为 266  的风险分值
//			User userIdldtspn = new User();
//			userIdldtspn.setUserId(userId);
//			userIdldtspn.setName("视频");
//			User userIdldtyyn = new User();
//			userIdldtyyn.setUserId(userId);
//			userIdldtyyn.setName("影音");
//			if(re != null){
//				if(re.getStatus() != 2){
//					int userPhoneCount = fser.Userappt(userIdldtspn);//是否影音播放类app
//					int userPhoneCount1 = fser.Userappt(userIdldtyyn);
//					userPhoneCount = userPhoneCount + userPhoneCount1;
//					if(userPhoneCount == 0){
//							count = count-Integer.valueOf(re.getValue_at_risk());
//							ru.setUserid(userId);
//							ru.setValue_at_risk(re.getValue_at_risk());
//							ru.setRid(id);
//							ru.setUsum(count);
//							ru.setRtid(re.getTypeid());
//							fser.AddCount(ru);
//					}
//				}
//			}
//			
//			
//			
//			
//			
//			id = 267;
//			re = fser.RulelistFraction(id);//查询规则id为 267  的风险分值
//			User userIdldtzf = new User();
//			userIdldtzf.setUserId(userId);
//			userIdldtzf.setName("支付");
//			if(re != null){
//				if(re.getStatus() != 2){
//					int userPhoneCount = fser.Userappt(userIdldtzf);//是否安装支付类app
//					if(userPhoneCount == 0){
//							count = count-Integer.valueOf(re.getValue_at_risk());
//							ru.setUserid(userId);
//							ru.setValue_at_risk(re.getValue_at_risk());
//							ru.setRid(id);
//							ru.setUsum(count);
//							ru.setRtid(re.getTypeid());
//							fser.AddCount(ru);
//					}
//				}
//			}
//			
//			
//			
//			id = 268;
//			re = fser.RulelistFraction(id);//查询规则id为 268  的风险分值
//			User userIdldtzfn = new User();
//			userIdldtzfn.setUserId(userId);
//			userIdldtzfn.setName("支付");
//			if(re != null){
//				if(re.getStatus() != 2){
//					int userPhoneCount = fser.Userappt(userIdldtzf);//支付类app安装个数
//					if(userPhoneCount != 0){
//						if(userPhoneCount < Integer.valueOf(re.getThresholdValue())){
//							count = count-Integer.valueOf(re.getValue_at_risk());
//							ru.setUserid(userId);
//							ru.setValue_at_risk(re.getValue_at_risk());
//							ru.setRid(id);
//							ru.setUsum(count);
//							ru.setRtid(re.getTypeid());
//							fser.AddCount(ru);
//						}
//					}
//				}
//			}
//			
			
			
			
			
			id = 270;
			re = fser.RulelistFraction(id);//查询规则id为 270  的风险分值
			User userIdldjkph = new User();
			userIdldjkph.setIdnumber(idNumber);
			userIdldjkph.setPhone(phone);
			if(re != null){
				if(re.getStatus() != 2){
					int userPhoneCount = fser.IDNumberCount(userIdldjkph);//借款人身份证绑定手机号码数量 
					if(userPhoneCount == 0){
						if(userPhoneCount > Integer.valueOf(re.getThresholdValue())){
							System.out.println(count+"分数：");
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setUsum(count);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
						}
					}
				}
			}
			
			
			
			id = 221;
			re = fser.RulelistFraction(id);//查询规则id为 221  的风险分值
			if(re != null){
				if(re.getStatus() != 2){
					CommunicationDetection userPhoneCount = fser.UserJm(userId);//静默时长
					if(userPhoneCount != null){
						if(Integer.valueOf(userPhoneCount.getSilentDurationTime()) > Integer.valueOf(re.getThresholdValue())){
							System.out.println(count+"分数：");
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setUsum(count);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
						}
					}
				}
			}
			
			
			
			
			
			
			id = 222;
			re = fser.RulelistFraction(id);//查询规则id为 222  的风险分值
			if(re != null){
				if(re.getStatus() != 2){
					CommunicationDetection userPhoneCount = fser.UserJm(userId);//静默次数
					if(userPhoneCount != null){
						if(userPhoneCount.getSilentCount() > Integer.valueOf(re.getThresholdValue())){
							System.out.println(count+"分数：");
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setUsum(count);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
						}
					}
				}
			}
			
			
			
			
			
			id = 277;
			re = fser.RulelistFraction(id);//查询规则id为 277  的风险分值
			if(re != null){
				if(re.getStatus() != 2){
					CommunicationCityInfo userPhoneCount = fser.Usercommun(userId);//通话区域分布表中被叫次数百分比
					if(userPhoneCount != null){
						System.out.println(userPhoneCount.getCallingCountPer());
						BigDecimal b = new BigDecimal(re.getThresholdValue());
						int c = userPhoneCount.getCallingCountPer().compareTo(b);
						if(c == 1){
							System.out.println(count+"分数：");
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setUsum(count);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
						}
					}
				}
			}
			
			
			
			
			
			id = 280;
			re = fser.RulelistFraction(id);//查询规则id为 280  的风险分值
			if(re != null){
				if(re.getStatus() != 2){
					CommunicationCityInfo userPhoneCount = fser.Usercommun(userId);//通话区域分布表中主叫次数百分比
					if(userPhoneCount != null){
						BigDecimal b = new BigDecimal(re.getThresholdValue());
						int c = userPhoneCount.getCallingCountPer().compareTo(b);
						if(c == 1){
							System.out.println(count+"分数：");
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setUsum(count);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
						}
					}
				}
			}
			
			
			
			
			
			id = 300;
			re = fser.RulelistFraction(id);//查询规则id为 300  的风险分值
			if(re != null){
				if(re.getStatus() != 2){
					Integer userPhoneCount = fser.PhoneCa(userId);//通话总时长前10是否含400开头
					if(userPhoneCount != null){
						if(userPhoneCount == 0){
							System.out.println(count+"分数：");
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setUsum(count);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
						}
					}
				}
			}
			
			
			
			
			id = 292;
			re = fser.RulelistFraction(id);//查询规则id为 292  的风险分值
			if(re != null){
				if(re.getStatus() != 2){
					EmergencyContactInfo userPhoneCount = fser.JjUserNum(userId);//紧急联系人主叫次数
					if(userPhoneCount == null){
							System.out.println(count+"分数：");
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setUsum(count);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
					}
				}
			}
			
			
			
			
			id = 293;
			re = fser.RulelistFraction(id);//查询规则id为 293  的风险分值
			if(re != null){
				if(re.getStatus() != 2){
					EmergencyContactInfo userPhoneCount = fser.JjUserNum(userId);//紧急联系人被叫次数
					if(userPhoneCount == null){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setUsum(count);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
					}
				}
			}
			
			
			
			
			id = 301;
			re = fser.RulelistFraction(id);//查询规则id为 301  的风险分值
			if(re != null){
				if(re.getStatus() != 2){
					Integer userPhoneCount = fser.TopUser(userId);//通话总时长前10中是否含通讯录号码（以号码后四位匹
					if(userPhoneCount != null){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setUsum(count);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
					}
				}
			}
			
			
			
			
			id = 302;
			re = fser.RulelistFraction(id);//查询规则id为 302  的风险分值
			if(re != null){
				if(re.getStatus() != 2){
					Integer userPhoneCount = fser.TopTime(userId);//单次通话时长前10中是否含通讯录号码（以号码后四位匹配）
					if(userPhoneCount != null){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setUsum(count);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
					}
				}
			}
			
			
			
			id = 307;
			re = fser.RulelistFraction(id);//查询规则id为 307  的风险分值
			if(re != null){
				if(re.getStatus() != 2){
					Integer userPhoneCount = fser.TopCount(userId);//通话次数前10中是否含通讯录号码
					if(userPhoneCount != null){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setUsum(count);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
					}
				}
			}
			
			
			
			
			id = 297;
			re = fser.RulelistFraction(id);//查询规则id为 297  的风险分值
			if(re != null){
				if(re.getStatus() != 2){
					Integer userPhoneCount = fser.UserAge(phone);//借款人年龄是否大于22 小于等于2
					if(userPhoneCount != null){
						if(userPhoneCount > 22){
							if(userPhoneCount <= 25){
								count = count-Integer.valueOf(re.getValue_at_risk());
								ru.setUserid(userId);
								ru.setValue_at_risk(re.getValue_at_risk());
								ru.setRid(id);
								ru.setUsum(count);
								ru.setRtid(re.getTypeid());
								fser.AddCount(ru);
							}
						}
					}
				}
			}
			
			
			
			
			id = 298;
			re = fser.RulelistFraction(id);//查询规则id为 298  的风险分值
			if(re != null){
				if(re.getStatus() != 2){
					Integer userPhoneCount = fser.UserAge(phone);//年龄
					if(userPhoneCount != null){
						if(userPhoneCount >= 43){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setUsum(count);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
						}
					}
				}
			}
			
			
			
			
			
			id = 295;
			re = fser.RulelistFraction(id);//查询规则id为 295  的风险分值
			if(re != null){
				if(re.getStatus() != 2){
					Integer userPhoneCount = fser.TopJjCount(userId);//紧急联系人号码是否在通话总时长前10中
					if(userPhoneCount != null){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setUsum(count);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
					}
				}
			}
			
			
			
			
			id = 208;
			re = fser.RulelistFraction(id);//查询规则id为 208  的风险分值
			if(re != null){
				if(re.getStatus() != 2){
					BigDecimal userPhoneCount = fser.UserPhoneMoney(userId);//单次充值金额(元)
					Integer am = userPhoneCount.compareTo(new BigDecimal(re.getThresholdValue()));
					if(am == -1){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setUsum(count);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
					}
				}
			}
			
			
			
			
			id = 209;
			re = fser.RulelistFraction(id);//查询规则id为 209  的风险分值
			if(re != null){
				if(re.getStatus() != 2){
					BigDecimal userPhoneCount = fser.UserPhoneMoney(userId);//单次充值金额(元)
					Integer am = userPhoneCount.compareTo(new BigDecimal(re.getThresholdValue()));
					if(am == 1){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setUsum(count);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
					}
				}
			}
			
			
			
			
			id = 226;
			re = fser.RulelistFraction(id);//查询规则id为 226  的风险分值
			if(re != null){
				if(re.getStatus() != 2){
					User userIdaC = new User();
					userIdaC.setUserId(userId);
					userIdaC.setName("民间");
					Integer userPhoneCount = fser.MinJUser(userIdaC);//民间借贷主叫次数
					if(userPhoneCount > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setUsum(count);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
					}
				}
			}
			
			
			
			
			id = 227;
			re = fser.RulelistFraction(id);//查询规则id为 227  的风险分值
			if(re != null){
				if(re.getStatus() != 2){
					User userIdaC = new User();
					userIdaC.setUserId(userId);
					userIdaC.setName("金融");
					Integer userPhoneCount = fser.MinJUser(userIdaC);//金融机构主叫次数
					if(userPhoneCount > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setUsum(count);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
					}
				}
			}
			
			
			
			
			id = 228;
			re = fser.RulelistFraction(id);//查询规则id为 228  的风险分值
			if(re != null){
				if(re.getStatus() != 2){
					User userIdaC = new User();
					userIdaC.setUserId(userId);
					userIdaC.setName("信用卡");
					Integer userPhoneCount = fser.MinJUser(userIdaC);//信用卡机构主叫次数
					if(userPhoneCount > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setUsum(count);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
					}
				}
			}
			
			
			
			
			
			id = 229;
			re = fser.RulelistFraction(id);//查询规则id为 229  的风险分值
			if(re != null){
				if(re.getStatus() != 2){
					User userIdaC = new User();
					userIdaC.setUserId(userId);
					userIdaC.setName("p2p");
					Integer userPhoneCount = fser.MinJUser(userIdaC);//p2p借贷平台主叫次数
					if(userPhoneCount > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setUsum(count);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
					}
				}
			}
			
			
			
			
			
			id = 230;
			re = fser.RulelistFraction(id);//查询规则id为 230  的风险分值
			if(re != null){
				if(re.getStatus() != 2){
					User userIdaC = new User();
					userIdaC.setUserId(userId);
					userIdaC.setName("互联网小贷");
					Integer userPhoneCount = fser.MinJUser(userIdaC);//互联网小贷主叫次数
					if(userPhoneCount > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setUsum(count);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
					}
				}
			}
			
			
			
			
			
			id = 231;
			re = fser.RulelistFraction(id);//查询规则id为 231  的风险分值
			if(re != null){
				if(re.getStatus() != 2){
					User userIdaC = new User();
					userIdaC.setUserId(userId);
					userIdaC.setName("律师");
					Integer userPhoneCount = fser.MinJUser(userIdaC);//律师主叫次数
					if(userPhoneCount >= Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setUsum(count);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
					}
				}
			}
			
			
			
			
			
			id = 232;
			re = fser.RulelistFraction(id);//查询规则id为 232  的风险分值
			if(re != null){
				if(re.getStatus() != 2){
					User userIdaC = new User();
					userIdaC.setUserId(userId);
					userIdaC.setName("法院");
					Integer userPhoneCount = fser.MinJUser(userIdaC);//法院主叫次数
					if(userPhoneCount >= Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setUsum(count);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
					}
				}
			}
			
			
			
			
			
			
			id = 233;
			re = fser.RulelistFraction(id);//查询规则id为 233  的风险分值
			if(re != null){
				if(re.getStatus() != 2){
					User userIdaC = new User();
					userIdaC.setUserId(userId);
					userIdaC.setName("110");
					Integer userPhoneCount = fser.MinJUser(userIdaC);//110主叫次数
					if(userPhoneCount >= Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setUsum(count);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
					}
				}
			}
			
			
			
			
			
			
			
			id = 234;
			re = fser.RulelistFraction(id);//查询规则id为 234  的风险分值
			if(re != null){
				if(re.getStatus() != 2){
					User userIdaC = new User();
					userIdaC.setUserId(userId);
					userIdaC.setName("澳门");
					Integer userPhoneCount = fser.MinJUser(userIdaC);//澳门通信主叫次数
					if(userPhoneCount >= Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setUsum(count);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
					}
				}
			}
			
			
			
			id = 200;
			re = fser.RulelistFraction(id);//查询规则id为 200  的风险分值
			if(re != null){
				if(re.getStatus() != 2){
					Integer userPhoneCount = fser.TongHUser(userId);//0:00-3:00通话次数
					if(userPhoneCount != null){
						if(userPhoneCount > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setUsum(count);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
						}
					}else{
						count = count-Integer.valueOf(re.getValue_at_risk());
						ru.setUserid(userId);
						ru.setValue_at_risk(re.getValue_at_risk());
						ru.setRid(id);
						ru.setUsum(count);
						ru.setRtid(re.getTypeid());
						fser.AddCount(ru);
					}
					
				}
			}
			
			
			
			
			
			id = 276;
			re = fser.RulelistFraction(id);//查询规则id为 276  的风险分值
			if(re != null){
				if(re.getStatus() != 2){
					Integer userPhoneCount = fser.ChuxTimeDay(userId);//出行分析表中行程时间（天）
					if(userPhoneCount != null){
						if(userPhoneCount > Integer.valueOf(re.getThresholdValue())){
							count = count-Integer.valueOf(re.getValue_at_risk());
							ru.setUserid(userId);
							ru.setValue_at_risk(re.getValue_at_risk());
							ru.setRid(id);
							ru.setUsum(count);
							ru.setRtid(re.getTypeid());
							fser.AddCount(ru);
						}
					}
				}
			}
			
			
			
			
			id = 303;
			re = fser.RulelistFraction(id);//查询规则id为 303  的风险分值
			if(re != null){
				if(re.getStatus() != 2){
					BigDecimal yuefData = fser.YueFLv(userId);//通话月份分布表中是否含互通占比>0.3
					if(yuefData != null){
						Integer userPhoneCount = yuefData.compareTo(new BigDecimal(0.3));
						if(userPhoneCount == 1){
								count = count-Integer.valueOf(re.getValue_at_risk());
								ru.setUserid(userId);
								ru.setValue_at_risk(re.getValue_at_risk());
								ru.setRid(id);
								ru.setUsum(count);
								ru.setRtid(re.getTypeid());
								fser.AddCount(ru);
						}
					}
				}
			}
			
			
			
			
			id = 304;
			re = fser.RulelistFraction(id);//查询规则id为 304  的风险分值
			if(re != null){
				if(re.getStatus() != 2){
					BigDecimal yuefData = fser.YueFLv(userId);//通话月份分布表中是否含互通占比<0.01
					if(yuefData != null){
						Integer userPhoneCount = yuefData.compareTo(new BigDecimal(0.3));
						if(userPhoneCount == 1){
								count = count-Integer.valueOf(re.getValue_at_risk());
								ru.setUserid(userId);
								ru.setValue_at_risk(re.getValue_at_risk());
								ru.setRid(id);
								ru.setUsum(count);
								ru.setRtid(re.getTypeid());
								fser.AddCount(ru);
						}
					}else{
						count = count-Integer.valueOf(re.getValue_at_risk());
						ru.setUserid(userId);
						ru.setValue_at_risk(re.getValue_at_risk());
						ru.setRid(id);
						ru.setUsum(count);
						ru.setRtid(re.getTypeid());
						fser.AddCount(ru);
					}
				}
			}
			
			
			
			
			
//			id = 297;
//			re = fser.RulelistFraction(id);//查询规则id为 297  的风险分值
//			if(re != null){
//				if(re.getStatus() != 2){
//					BigDecimal yuefData = fser.YueFLv(userId);//通话月份分布表中是否含互通占比<0.01
//					Integer userPhoneCount = yuefData.compareTo(new BigDecimal(0.3));
//					if(userPhoneCount == 1){
//							count = count-Integer.valueOf(re.getValue_at_risk());
//							ru.setUserid(userId);
//							ru.setValue_at_risk(re.getValue_at_risk());
//							ru.setRid(id);
//							ru.setUsum(count);
//							ru.setRtid(re.getTypeid());
//							fser.AddCount(ru);
//					}
//				}
//			}
//			
			
			
			
			
			
			
			
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
				map.put("count", 0);
				return map;
			}
			
			
			
		} catch (Exception e) {
			fser.DeleteRulet(userId, u.getAuthentication_time());
			map.put("name", name);
			map.put("userId", userId);
			map.put("idNumber", idNumber);
			map.put("count", -500);
			System.out.println("报错");
			return map;
//			e.addSuppressed(e);
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

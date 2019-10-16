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
	
	
	@RequestMapping("Exhibitionfraction")
	@ResponseBody
	public Map<String, Object> SeleExhibition(Integer userId,String phone,String name,String idNumber,String appId){
		Map<String, Object> map = new HashMap<String, Object>();
		Integer count = 1000;
		
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
			
			
			
			
			int a = fser.AppCount(userId);//26
			int id = 26; 
			Rulelist re = fser.RulelistFraction(id);//查询规则id为  27  的风险分值
			System.out.println(re.getValue_at_risk());
			if(re.getStatus()!=2){
				if(a < Integer.valueOf(re.getThresholdValue())){
					count = Integer.valueOf(re.getValue_at_risk());
				}
			}
			
			
			id = 27; 
			re = fser.RulelistFraction(id);//查询规则id为  27  的风险分值
			if(re.getStatus()!=2){
				if(a > Integer.valueOf(re.getThresholdValue())){
					count = Integer.valueOf(re.getValue_at_risk());
				}
			}
			
			
			
			
			Configuration con = rdao.UserUUID(phone);
				
			
			Integer phonenum = rdao.UserPhoneCount(userId);//通讯录联系人数量
			id = 67;
			re = fser.RulelistFraction(id);//查询规则id为 67  的风险分值
			if(re.getStatus()!=2){
				if(phonenum < Integer.valueOf(re.getThresholdValue())){
					count = count-Integer.valueOf(re.getValue_at_risk());
				}
			}
			
			con.setStatu_time(statu_time);
			con.setEnd_time(end_time);
			id = 70;
			re = fser.RulelistFraction(id);//查询规则id为 70  的风险分值
			if(re.getStatus()!=2){
				if(con.getUuid()!=null){//	id 70 
					Integer daynum = rdao.UserLoginNum(con);//一天内的相同设备数
					if(daynum > Integer.valueOf(re.getValue_at_risk())){
						count = count-Integer.valueOf(re.getValue_at_risk());
					}
				}
			}
			
			
			id = 71;
			re = fser.RulelistFraction(id);//查询规则id为 71  的风险分值
			if(re.getStatus() != 2){
				if(con.getUuid()==null){
					count = count-Integer.valueOf(re.getValue_at_risk());
				}
			}
			
			
			
			
			
			id = 72;
			re = fser.RulelistFraction(id);//查询规则id为 72  的风险分值
			if(re.getStatus() != 2){
				Integer WifiIPNum = rdao.UserWifiIPNum(con);//一天内WIFIIP连接相同数
				if(WifiIPNum > Integer.valueOf(re.getThresholdValue())){
					count = count-Integer.valueOf(re.getValue_at_risk());
				}
			}
			
			
			id = 75;
			re = fser.RulelistFraction(id);//查询规则id为 75  的风险分值
			if(re.getStatus() != 2){
				Integer WifiMacNum = rdao.UserWifiMacNum(con);//WIFIMacnum 关联数
				if(WifiMacNum > Integer.valueOf(re.getThresholdValue())){
					count = count-Integer.valueOf(re.getValue_at_risk());
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
				if(sumcount > Integer.valueOf(re.getThresholdValue())){
					count = count-Integer.valueOf(re.getValue_at_risk());
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
				if(appnum > Integer.valueOf(re.getThresholdValue())){
					count = count-Integer.valueOf(re.getValue_at_risk());
				}
			}
			
			
			
			id = 25;
			re = fser.RulelistFraction(id);//查询规则id为 25  的风险分值
			if(re.getStatus() != 2){
				Integer WifiMacNum = fser.Emergency_contact_infoPhone(userId);//WIFIMacnum 关联数
				if(WifiMacNum > Integer.valueOf(re.getThresholdValue())){
					count = count-Integer.valueOf(re.getValue_at_risk());
				}
			}
			
			
			
			
			id = 59;
			re = fser.RulelistFraction(id);//查询规则id为 59  的风险分值
			if(re.getStatus() != 2){
				Integer IpPhone = fser.IpPhoneCount(userId);//WIFIMacnum 关联数
				if(IpPhone > Integer.valueOf(re.getThresholdValue())){
					count = count-Integer.valueOf(re.getValue_at_risk());
				}
			}
			
			
			id = 74;
			re = fser.RulelistFraction(id);//查询规则id为 74  的风险分值
			if(re.getStatus() != 2){
				Integer Onephonecount = fser.OneHomeCount(phone);//1小时内同一手机号申请注册次数
				if(Onephonecount > Integer.valueOf(re.getThresholdValue())){
					count = count-Integer.valueOf(re.getValue_at_risk());
				}
			}
			
			
			id = 73;
			re = fser.RulelistFraction(id);//查询规则id为 73  的风险分值
			if(re.getStatus() != 2){
				Integer Onephonecount = fser.OneHomeIDnumberCount(idNumber);//1小时内同一身份证申请注册次数
				if(Onephonecount > Integer.valueOf(re.getThresholdValue())){
					count = count-Integer.valueOf(re.getValue_at_risk());
				}
			}
			
			
			id = 95;
			re = fser.RulelistFraction(id);//查询规则id为 95  的风险分值
			if(re.getStatus() != 2){
				Integer userPhoneCount = fser.UserPhoneCount(userId);//借款人通讯录400开头号码个数
				if(userPhoneCount > Integer.valueOf(re.getThresholdValue())){
					count = count-Integer.valueOf(re.getValue_at_risk());
				}
			}
			
			
			
			id = 90;
			re = fser.RulelistFraction(id);//查询规则id为 90  的风险分值
			if(re.getStatus() != 2){
				Integer userPhoneCount = fser.UserPhoneCount1(userId);//借款人通讯录联系人数量
				if(userPhoneCount > Integer.valueOf(re.getThresholdValue())){
					count = count-Integer.valueOf(re.getValue_at_risk());
				}
			}
			
			
			id = 102;
			re = fser.RulelistFraction(id);//查询规则id为 102  的风险分值
			if(re.getStatus() != 2){
				Integer userPhoneCount = fser.UserNameFatherCount(userId);//通讯录联系人备注命中父母个数
				if(userPhoneCount > Integer.valueOf(re.getThresholdValue())){
					count = count-Integer.valueOf(re.getValue_at_risk());
				}
			}
			
			User user = new User();
			id = 103;
			re = fser.RulelistFraction(id);//查询规则id为 103  的风险分值
			if(re.getStatus() != 2){
				int suma = 0;
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
				if(suma > Integer.valueOf(re.getThresholdValue())){
					count = count-Integer.valueOf(re.getValue_at_risk());
				}
			}
			
			
			
			id = 104;
			re = fser.RulelistFraction(id);//查询规则id为 104  的风险分值
			if(re.getStatus() != 2){
				int suma = 0;
				user.setUserId(userId);
				user.setName("彩票");
				suma = fser.UserQinqCount(user);//通讯录联系人备注命中彩票类个数
				if(suma > Integer.valueOf(re.getThresholdValue())){
					count = count-Integer.valueOf(re.getValue_at_risk());
				}
			}
			
			
			id = 105;
			re = fser.RulelistFraction(id);//查询规则id为 105  的风险分值
			if(re.getStatus() != 2){
				int suma = 0;
				user.setUserId(userId);
				user.setName("公");
				suma = fser.UserQinqCount(user);//通讯录联系人备注命中公检法司类个数
				user.setName("检");
				suma =suma + fser.UserQinqCount(user);
				user.setName("法");
				suma =suma + fser.UserQinqCount(user);
				user.setName("司");
				suma =suma + fser.UserQinqCount(user);
				if(suma > Integer.valueOf(re.getThresholdValue())){
					count = count-Integer.valueOf(re.getValue_at_risk());
				}
			}
			
			
			id = 106;
			re = fser.RulelistFraction(id);//查询规则id为 106  的风险分值
			if(re.getStatus() != 2){
				int suma = 0;
				user.setUserId(userId);
				user.setName("公");
				suma = fser.UserQinqCount(user);//通讯录联系人备注命中公检法司类个数
				user.setName("检");
				suma =suma + fser.UserQinqCount(user);
				user.setName("法");
				suma =suma + fser.UserQinqCount(user);
				user.setName("司");
				suma =suma + fser.UserQinqCount(user);
				if(suma > Integer.valueOf(re.getThresholdValue())){
					count = count-Integer.valueOf(re.getValue_at_risk());
				}
			}
			
			
			id = 107;
			re = fser.RulelistFraction(id);//查询规则id为 107  的风险分值
			if(re.getStatus() != 2){
				int suma = 0;
				user.setUserId(userId);
				user.setName("中");
				suma = fser.UserQinqCount(user);//通讯录联系人备注命中中介咨询类个数
				user.setName("介");
				suma =suma + fser.UserQinqCount(user);
				user.setName("咨");
				suma =suma + fser.UserQinqCount(user);
				user.setName("询");
				suma =suma + fser.UserQinqCount(user);
				if(suma > Integer.valueOf(re.getThresholdValue())){
					count = count-Integer.valueOf(re.getValue_at_risk());
				}
			}
			
			
			
			id = 108;
			re = fser.RulelistFraction(id);//查询规则id为 108  的风险分值
			if(re.getStatus() != 2){
				int suma = 0;
				user.setUserId(userId);
				user.setName("投");
				suma = fser.UserQinqCount(user);//通讯录联系人备注命中投资理财类个数
				user.setName("资");
				suma =suma + fser.UserQinqCount(user);
				user.setName("理");
				suma =suma + fser.UserQinqCount(user);
				user.setName("财");
				suma =suma + fser.UserQinqCount(user);
				if(suma > Integer.valueOf(re.getThresholdValue())){
					count = count-Integer.valueOf(re.getValue_at_risk());
				}
			}
			
			
			id = 109;
			re = fser.RulelistFraction(id);//查询规则id为 109  的风险分值
			if(re.getStatus() != 2){
				int suma = 0;
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
				if(suma > Integer.valueOf(re.getThresholdValue())){
					count = count-Integer.valueOf(re.getValue_at_risk());
				}
			}
			
			
			
			id = 110;
			re = fser.RulelistFraction(id);//查询规则id为 110  的风险分值
			if(re.getStatus() != 2){
				int suma = 0;
				user.setUserId(userId);
				user.setName("借贷");
				suma = fser.UserQinqCount(user);//通讯录联系人备注命中借贷类个数
				if(suma > Integer.valueOf(re.getThresholdValue())){
					count = count-Integer.valueOf(re.getValue_at_risk());
				}
			}
			
			
			
			id = 111;
			re = fser.RulelistFraction(id);//查询规则id为 111  的风险分值
			if(re.getStatus() != 2){
				int suma = 0;
				user.setUserId(userId);
				user.setName("毒");
				suma = fser.UserQinqCount(user);//通讯录联系人备注命中涉毒类个数
				if(suma > Integer.valueOf(re.getThresholdValue())){
					count = count-Integer.valueOf(re.getValue_at_risk());
				}
			}
			
			
			
			id = 112;
			re = fser.RulelistFraction(id);//查询规则id为 110  的风险分值
			if(re.getStatus() != 2){
				int suma = 0;
				user.setUserId(userId);
				user.setName("博彩");
				suma = fser.UserQinqCount(user);//通讯录联系人备注命中涉赌类个数
				user.setName("金花");
				suma = fser.UserQinqCount(user);
				user.setName("斗地主");
				suma = fser.UserQinqCount(user);
				if(suma > Integer.valueOf(re.getThresholdValue())){
					count = count-Integer.valueOf(re.getValue_at_risk());
				}
			}
			
			
			id = 114;
			re = fser.RulelistFraction(id);//查询规则id为 110  的风险分值
			if(re.getStatus() != 2){
				Integer zcnum = fser.UserZuC(userId);//紧急联系人为平台注册借款人
				if(zcnum > Integer.valueOf(re.getThresholdValue())){
					count = count-Integer.valueOf(re.getValue_at_risk());
				}
			}
			
			
			
			id = 115;
			re = fser.RulelistFraction(id);//查询规则id为 115  的风险分值
			if(re.getStatus() != 2){
				user.setUserId(userId);
				Integer zcnum = fser.AppNum(user);//app安装个数
				if(zcnum > Integer.valueOf(re.getThresholdValue())){
					count = count-Integer.valueOf(re.getValue_at_risk());
				}
			}
			
			
			
			id = 116;
			re = fser.RulelistFraction(id);//查询规则id为 116  的风险分值
			if(re.getStatus() != 2){
				Integer zcnum = fser.UserZuC(userId);//借贷类app安装个数
				if(zcnum > Integer.valueOf(re.getThresholdValue())){
					count = count-Integer.valueOf(re.getValue_at_risk());
				}
			}
			
			
			
			
			id = 121;
			re = fser.RulelistFraction(id);//查询规则id为 121  的风险分值
			int zcnum = 0;
			user.setUserId(userId);
			user.setName("博彩");
			zcnum =zcnum + fser.AppNum(user);//赌博类app安装个数
			if(re.getStatus() != 2){
				if(zcnum > Integer.valueOf(re.getThresholdValue())){
					count = count-Integer.valueOf(re.getValue_at_risk());
				}
			}
			
			
			id = 122;
			re = fser.RulelistFraction(id);//查询规则id为 122  的风险分值
			int xynum = 0;
			user.setUserId(userId);
			user.setName("信用");
			xynum = fser.AppNum(user);//信用卡类app安装个数
			if(re.getStatus() != 2){
				if(xynum > Integer.valueOf(re.getThresholdValue())){
					count = count-Integer.valueOf(re.getValue_at_risk());
				}
			}
			
			
			
			id = 123;
			re = fser.RulelistFraction(id);//查询规则id为 123  的风险分值
			int xdnum = 0;
			user.setUserId(userId);
			user.setName("花");
			xdnum =xdnum + fser.AppNum(user);//超小额借贷类app安装个数
			user.setName("贷");
			xdnum =xdnum + fser.AppNum(user);
			user.setName("米");
			xdnum =xdnum + fser.AppNum(user);
			if(re.getStatus() != 2){
				if(xdnum > Integer.valueOf(re.getThresholdValue())){
					count = count-Integer.valueOf(re.getValue_at_risk());
				}
			}
			
			
			id = 124;
			re = fser.RulelistFraction(id);//查询规则id为 124  的风险分值
			int cxnum = 0;
			user.setUserId(userId);
			user.setName("销");
			cxnum =cxnum + fser.AppNum(user);//传销/直销类app安装个数
			if(re.getStatus() != 2){
				if(cxnum > Integer.valueOf(re.getThresholdValue())){
					count = count-Integer.valueOf(re.getValue_at_risk());
				}
			}
			
			
			id = 125;
			re = fser.RulelistFraction(id);//查询规则id为 125  的风险分值
			int denum = 0;
			user.setUserId(userId);
			user.setName("花");
			denum =denum + fser.AppNum(user);//超小额借贷类app安装个数
			user.setName("贷");
			denum =denum + fser.AppNum(user);
			user.setName("米");
			denum =denum + fser.AppNum(user);
			if(re.getStatus() != 2){
				if(denum > Integer.valueOf(re.getThresholdValue())){
					count = count-Integer.valueOf(re.getValue_at_risk());
				}
			}
			
			
			
			
			id = 126;
			re = fser.RulelistFraction(id);//查询规则id为 125  的风险分值
			int ptnum = 0;
			user.setUserId(userId);
			user.setName("钱");
			ptnum =ptnum + fser.AppNum(user);//贷款平台app安装个数
			user.setName("贷");
			ptnum =ptnum + fser.AppNum(user);
			user.setName("金");
			ptnum =ptnum + fser.AppNum(user);
			if(re.getStatus() != 2){
				if(ptnum > Integer.valueOf(re.getThresholdValue())){
					count = count-Integer.valueOf(re.getValue_at_risk());
				}
			}
			
			
			
			
			id = 128;
			re = fser.RulelistFraction(id);//查询规则id为 128  的风险分值
			int mnum = 0;
			user.setUserId(userId);
			user.setName("模拟");
			mnum =mnum + fser.AppNum(user);//模拟器类app安装个数
			if(re.getStatus() != 2){
				if(mnum > Integer.valueOf(re.getThresholdValue())){
					count = count-Integer.valueOf(re.getValue_at_risk());
				}
			}
			
			
			
			
			id = 129;
			re = fser.RulelistFraction(id);//查询规则id为 129  的风险分值
			int xnum = 0;
			user.setUserId(userId);
			user.setName("虚拟");
			xnum =xnum + fser.AppNum(user);//虚拟定位类app安装个数
			user.setName("定位");
			xnum =xnum + fser.AppNum(user);
			if(re.getStatus() != 2){
				if(xnum > Integer.valueOf(re.getThresholdValue())){
					count = count-Integer.valueOf(re.getValue_at_risk());
				}
			}
			
			
			
			id = 130;
			re = fser.RulelistFraction(id);//查询规则id为 130  的风险分值
			int bxum = 0;
			user.setUserId(userId);
			user.setName("保险");
			bxum =bxum + fser.AppNum(user);//保险类app安装个数
			user.setName("平安");
			bxum =bxum + fser.AppNum(user);
			if(re.getStatus() != 2){
				if(bxum > Integer.valueOf(re.getThresholdValue())){
					count = count-Integer.valueOf(re.getValue_at_risk());
				}
			}
			
			
			
			
			id = 131;
			re = fser.RulelistFraction(id);//查询规则id为 129  的风险分值
			int zfnum = 0;
			user.setUserId(userId);
			user.setName("支付");
			zfnum =zfnum + fser.AppNum(user);//支付类app安装个数
			user.setName("钱包");
			zfnum =zfnum + fser.AppNum(user);
			if(re.getStatus() != 2){
				if(zfnum > Integer.valueOf(re.getThresholdValue())){
					count = count-Integer.valueOf(re.getValue_at_risk());
				}
			}
			
			
			
			id = 131;
			re = fser.RulelistFraction(id);//查询规则id为 129  的风险分值
			int cpnum = 0;
			user.setUserId(userId);
			user.setName("支付");
			cpnum =cpnum + fser.AppNum(user);//彩票类app安装个数
			user.setName("钱包");
			cpnum =cpnum + fser.AppNum(user);
			if(re.getStatus() != 2){
				if(cpnum > Integer.valueOf(re.getThresholdValue())){
					count = count-Integer.valueOf(re.getValue_at_risk());
				}
			}
			
			
			
			
			User u = new User();
			u.setFraction(count);
			u.setIdnumber(idNumber);
			SimpleDateFormat sima = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				u.setAuthentication_time(sima.format(new Date()));
			} catch (Exception e) {
				// TODO: handle exception
			}
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
		
		map.put("name", name);
		map.put("userId", userId);
		map.put("idNumber", idNumber);
		map.put("count", count);
		return map;
	}

}

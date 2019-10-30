package com.zhita.Collection.jiazhou;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhita.Dao.ApplierInfoMapper;
import com.zhita.Dao.BillInfoMapper;
import com.zhita.Dao.CallRecordListInfosMapper;
import com.zhita.Dao.CallRecordListItemInfosTwoMapper;
import com.zhita.Dao.CallStatisticsMapper;
import com.zhita.Dao.CircleOfFriendsLocationsMapper;
import com.zhita.Dao.CommunicationCityInfoMapper;
import com.zhita.Dao.CommunicationDetectionMapper;
import com.zhita.Dao.CommunicationMonthInfoMapper;
import com.zhita.Dao.CommunicationTimeBucketInfoMapper;
import com.zhita.Dao.CommunicationTimeDurationInfoMapper;
import com.zhita.Dao.ContactsCityInfosMapper;
import com.zhita.Dao.EmergencyContactInfoMapper;
import com.zhita.Dao.LabelInfoMapper;
import com.zhita.Dao.MainLocationsMapper;
import com.zhita.Dao.OperatorInfoMapper;
import com.zhita.Dao.RechargeInfoMapper;
import com.zhita.Dao.ReportInfoMapper;
import com.zhita.Dao.SensitiveInfoNewMapper;
import com.zhita.Dao.SensitiveInfoNewupaMapper;
import com.zhita.Dao.SocialConnectionsinfoMapper;
import com.zhita.Dao.Top10CallCountMapper;
import com.zhita.Dao.Top10CallTimeMapper;
import com.zhita.Dao.Top10SingleCallTimeMapper;
import com.zhita.Dao.TravelInfoMapper;
import com.zhita.Model.CallRecordListInfos;
import com.zhita.Model.CallRecordListItemInfosTwo;
import com.zhita.Model.CallStatistics;
import com.zhita.Model.OperatorInfo;
import com.zhita.Model.SensitiveInfoNewupa;

@Controller
@RequestMapping("/jiaZhouOperator")
public class JiaZhouOperator {
	@Autowired
	ApplierInfoMapper applierInfoMapper;
	
	@Autowired
	BillInfoMapper billInfoMapper;
	
	@Autowired
	CommunicationCityInfoMapper communicationCityInfoMapper;
	
	@Autowired
	CommunicationDetectionMapper communicationDetectionMapper;
	
	@Autowired 
	CommunicationMonthInfoMapper communicationMonthInfoMapper;
	
	@Autowired
	CommunicationTimeBucketInfoMapper communicationTimeBucketInfoMapper;
	
	@Autowired
	CommunicationTimeDurationInfoMapper communicationTimeDurationInfoMapper;
	
	@Autowired
	ContactsCityInfosMapper contactsCityInfosMapper;
	
	@Autowired
	EmergencyContactInfoMapper emergencyContactInfoMapper;
	
	@Autowired
	LabelInfoMapper labelInfoMapper;
	
	@Autowired
	OperatorInfoMapper operatorInfoMapper;
	
	@Autowired
	MainLocationsMapper mainLocationsMapper;
	
	@Autowired
	CircleOfFriendsLocationsMapper circleOfFriendsLocationsMapper;
	
	
	@Autowired
	RechargeInfoMapper rechargeInfoMapper;
	
	@Autowired
	ReportInfoMapper reportInfoMapper;
	
	
	@Autowired
	SensitiveInfoNewMapper sensitiveInfoNewMapper;
	
	
	@Autowired
	SocialConnectionsinfoMapper socialConnectionsinfoMapper;
	
	@Autowired
	Top10CallCountMapper top10CallCountMapper;
	
	@Autowired
	Top10CallTimeMapper top10CallTimeMapper;
	
	@Autowired
	Top10SingleCallTimeMapper top10SingleCallTimeMapper;
	
	@Autowired
	TravelInfoMapper travelInfoMapper;
	
	@Autowired
	SensitiveInfoNewupaMapper sensitiveInfoNewupaMapper;
	
	@Autowired
	CallRecordListInfosMapper callRecordListInfosMapper;
	
	@Autowired
	CallStatisticsMapper callStatisticsMapper;
	
	
	@Autowired
	CallRecordListItemInfosTwoMapper callRecordListItemInfosTwoMapper;

	@RequestMapping("/setOperator")
	@ResponseBody
	@Transactional
	public String setOperator(@RequestBody()String jString ){
		JSONObject jsonObject = JSONObject.parseObject(jString);
		String jsonString = (String) jsonObject.get("jsonString");
		JSONObject jObject = JSONObject.parseObject(jsonString);
		int userId = (int) jsonObject.get("userId");
		JSONObject data = (JSONObject) jObject.get("data");
		
		JSONObject jsonObject2 = null;
		// applier_info
		JSONObject applier_info = (JSONObject) data.get("applier_info");// 申请人基本信息
		int age = applier_info.getInteger("age");// 年龄
		String company_address = applier_info.getString("company_address");// 工作单位地址
		JSONObject company_address_map_result = (JSONObject) applier_info.get("company_address_map_result");// 工作单位位置信息
		String company_formatted_address = company_address_map_result.getString("formatted_address");// 工作地在地 图中定位后的输出地址
		String company_level = company_address_map_result.getString("level");// 公司匹配水平
		String company_latitude = company_address_map_result.getString("latitude");// 公司定位经度
		String company_longitude = company_address_map_result.getString("longitude");// 公司定位纬度
		String company_telephone_number = applier_info.getString("company_telephone_number");// 工作单位联系号码
		String gender = applier_info.getString("gender");// 性别
		String home_address = applier_info.getString("home_address");// 家庭地址
		JSONObject home_address_map_result = applier_info.getJSONObject("home_address_map_result");// 家庭位置信息
		String home_formatted_address = home_address_map_result.getString("formatted_address");// 居住地在地图中定位后的输出地址
		String home_level = home_address_map_result.getString("level");// 居住地匹配水平
		String home_latitude = home_address_map_result.getString("latitude");// 居住地定位经度
		String home_longitude = home_address_map_result.getString("longitude");// 居住地定位纬度
		String home_telephone_number = applier_info.getString("home_telephone_number");// 家庭号码
		String idcard = applier_info.getString("idcard");// 身份证号
		String idcard_location = applier_info.getString("idcard_location");// 身份证归属地
		String name = applier_info.getString("name");// 姓名
		String phone_number = applier_info.getString("phone_number");// 手机号
		applierInfoMapper.setApplierInfo(userId,name,gender,age,phone_number,idcard,idcard_location,home_telephone_number,home_address,home_formatted_address,home_level,home_latitude,home_longitude,company_telephone_number,company_address,company_formatted_address,company_level,company_latitude,company_longitude);
		

		// bill_info
		JSONArray bill_info = (JSONArray) data.get("bill_info");// 消费记录
		if (bill_info.size() > 0) {
			for (int i = 0; i < bill_info.size(); i++) {
				jsonObject2 = (JSONObject) bill_info.get(i);
				BigDecimal consumption_amount = jsonObject2.getBigDecimal("consumption_amount");// 消费金额
				String month = jsonObject2.getString("month");// 月份
				billInfoMapper.setBillInfo(userId,consumption_amount,month);
			}
		}

		// communication_city_info
		JSONArray communication_city_info = (JSONArray) data.get("communication_city_info");// 通话区域分布(省级)
		if (communication_city_info.size() > 0) {
			for (int i = 0; i < communication_city_info.size(); i++) {
				jsonObject2 = (JSONObject) communication_city_info.get(i);
				int call_count = jsonObject2.getInteger("call_count");// 通话次数
				int called_count = jsonObject2.getInteger("called_count");// 被叫次数
				BigDecimal called_count_per = jsonObject2.getBigDecimal("called_count_per");// 被叫次数百分比
				String called_duration_time = jsonObject2.getString("called_duration_time");// 被叫时间(分钟)
				BigDecimal called_duration_time_per = jsonObject2.getBigDecimal("called_duration_time_per");// 被叫时间百分比
				int calling_count = jsonObject2.getInteger("calling_count");// 主叫次数
				BigDecimal calling_count_per = jsonObject2.getBigDecimal("calling_count_per");// 主叫次数百分比
				String calling_duration_time = jsonObject2.getString("calling_duration_time");// 主叫时间(分钟)
				BigDecimal calling_duration_time_per = jsonObject2.getBigDecimal("calling_duration_time_per");// 主叫时间百分比
				String city = jsonObject2.getString("city");// 省份
				communicationCityInfoMapper.setCommunicationCityInfo(userId,city,call_count,calling_count,calling_duration_time,called_count,called_duration_time,calling_count_per,calling_duration_time_per,called_count_per,called_duration_time_per);
			}
		}

		// communication_detection
		JSONObject communication_detection = (JSONObject) data.get("communication_detection");// 通信检测
		String average_silent_duration_time = communication_detection.getString("average_silent_duration_time");// 平均静默时长：近六个月中24小时以内无通话记录或无短信记录或无上网信息”的总静默时间
																												// /
																												// 静默次数
		String long_silent_duration_time = communication_detection.getString("long_silent_duration_time");// 最长一次静默时长
		String long_silent_time = communication_detection.getString("long_silent_time");// 最长一次静默时间
		BigDecimal night_activities = communication_detection.getBigDecimal("night_activities");// 夜间活动情况 ：通话时间”字段中23点
																						// ~6点之间的通话占总通话数的比率
		int silent_count = communication_detection.getInteger("silent_count");//// 静默次数：近六个月中，24小时以内无通话记录或无短信记录或无上网信息”的总次数
		String silent_duration_time = communication_detection.getString("silent_duration_time");// 静默时长
		String the_last_call_time = communication_detection.getString("the_last_call_time");// 最近通话时长
		String the_last_silent_duration_time = communication_detection.getString("the_last_silent_duration_time");// 最近一次静默时长：最近一次24小时以内无通话记录或无短信记录或无上网信息时间
		String the_long_silent_duration_time = communication_detection.getString("the_long_silent_duration_time");// 最长一次静默时间
																													// +
																													// 时长
		communicationDetectionMapper.setcommunicationDetection(userId,the_last_call_time,silent_count,silent_duration_time,average_silent_duration_time,the_last_silent_duration_time,night_activities,long_silent_time,long_silent_duration_time,the_long_silent_duration_time);

		// communication_month_info
		JSONArray communication_month_info = (JSONArray) data.get("communication_month_info");// 通话月份分布
		if (communication_month_info.size() > 0) {
			for (int i = 0; i < communication_month_info.size(); i++) {
				jsonObject2 = (JSONObject) communication_month_info.get(i);
				int call_count = jsonObject2.getInteger("call_count");// 呼叫次数:计算当月总通话次数
				String call_phone_number_count = jsonObject2.getString("call_phone_number_count");// 通话号码
				int called_count = jsonObject2.getInteger("called_count"); // 发送次数
				String called_duration_time = jsonObject2.getString("called_duration_time");// 此字段暂未使用
				int calling_count = jsonObject2.getInteger("calling_count");// 收到短信次数
				String calling_duration_time = jsonObject2.getString("calling_duration_time");// 此字段暂未使用
				String month = jsonObject2.getString("month");// 月份
				int sms_count = jsonObject2.getInteger("sms_count");// 短信数量：计算当月短信数量
				BigDecimal two_way_phone_number_per = jsonObject2.getBigDecimal("two_way_phone_number_per");// 互相打电话的号码数占总通话号码数
				communicationMonthInfoMapper.setcommunicationMonthInfo(userId,month,call_phone_number_count,two_way_phone_number_per,call_count,calling_count,calling_duration_time,called_count,called_duration_time,sms_count);
			}
		}

		// communication_time_bucket_info
		JSONArray communication_time_bucket_info = (JSONArray) data.get("communication_time_bucket_info");// 通话月份分布
		if (communication_time_bucket_info.size() > 0) {
			for (int i = 0; i < communication_time_bucket_info.size(); i++) {
				jsonObject2 = (JSONObject) communication_time_bucket_info.get(i);
				int call_count = jsonObject2.getInteger("call_count");// 通话次数
				int called_count = jsonObject2.getInteger("called_count");// 被叫次数
				String called_duration_time = jsonObject2.getString("called_duration_time");// 被叫时长
				int calling_count = jsonObject2.getInteger("calling_count");// 主叫次数
				String calling_duration_time = jsonObject2.getString("calling_duration_time");// 主叫时长
				int phone_count = jsonObject2.getInteger("phone_count");// 号码个数
				String phone_times = jsonObject2.getString("phone_times");// 最常联系号码及次数
				String time_bucket = jsonObject2.getString("time_bucket");// 时间段
				communicationTimeBucketInfoMapper.setcommunicationTimeBucketInfo(userId,time_bucket,call_count,phone_count,phone_times,calling_count,calling_duration_time,called_count,called_duration_time);
			}

		}

		// communication_time_duration_info
		JSONArray communication_time_duration_info = (JSONArray) data.get("communication_time_duration_info");// 通话月份分布
		if (communication_time_duration_info.size() > 0) {
			for (int i = 0; i < communication_time_duration_info.size(); i++) {
				jsonObject2 = (JSONObject) communication_time_duration_info.get(i);
				int called_count = jsonObject2.getInteger("called_count");// 通话时间长分布
				String called_duration_time = jsonObject2.getString("called_duration_time");// 被叫时长
				int calling_count = jsonObject2.getInteger("calling_count");// 主叫次数
				String calling_duration_time = jsonObject2.getString("calling_duration_time");// 主叫时长
				String time_duration = jsonObject2.getString("time_duration");// 通话时长
				communicationTimeDurationInfoMapper.setcommunicationTimeDurationInfo(userId,time_duration,calling_count,calling_duration_time,called_count,called_duration_time);
			}
		}

		// contacts_city_infos
		JSONArray contacts_city_infos = (JSONArray) data.get("contacts_city_infos");// 通话区域分布(城市)
		if (contacts_city_infos.size() > 0) {
			for (int i = 0; i < contacts_city_infos.size(); i++) {
				jsonObject2 = (JSONObject) contacts_city_infos.get(i);
				String city = jsonObject2.getString("city");// 城市
				int call_count = jsonObject2.getInteger("call_count");// 通话次数通话详单中号码归属地统计，例：通话详单中本号 码与上海号通话次数
				int calling_count = jsonObject2.getInteger("calling_count");// 主叫时间(分钟)：通
																				// 话详单中主叫归属地时间统计，例：通话详单中本号码主动拨打上海号通话总时长
				String calling_duration_time = jsonObject2.getString("calling_duration_time");// 主叫时间(分钟)：通
																								// 话详单中主叫归属地时间统计，例：通话详单中本号码主动拨打上海号通话总时长
				int called_count = jsonObject2.getInteger("called_count");// 被叫次数：通话详单中被叫归属地统计，例：通话详单中被叫上海来电次数
				String called_duration_time = jsonObject2.getString("called_duration_time");// 被叫时间(分钟)：通话详单中被叫归属地时间统计，例：通话详单中本号码接到上海号通话总时长
				BigDecimal calling_count_per = jsonObject2.getBigDecimal("calling_count_per");// 主叫次数百分比：某城市主叫次数/总主叫次数
				BigDecimal calling_duration_time_per = jsonObject2.getBigDecimal("calling_duration_time_per");// 主叫时间百分比：某城市主叫时间/总主叫时间
				BigDecimal called_duration_time_per = jsonObject2.getBigDecimal("called_duration_time_per");// 被叫时间百分比：某城市被叫时间/总被叫时间
				BigDecimal called_count_per = jsonObject2.getBigDecimal("called_count_per");// 被叫次数百分比：某城市被叫次数/总被叫次数
				contactsCityInfosMapper.setContactsCityInfos(userId,city,call_count,calling_count,calling_duration_time,called_count,called_duration_time,calling_count_per,calling_duration_time_per,called_count_per,called_duration_time_per);
			}
		}

		// emergency_contact_info
		JSONArray emergency_contact_info = (JSONArray) data.get("emergency_contact_info");// 通话区域分布(城市)
		if (emergency_contact_info.size() > 0) {
			for (int i = 0; i < emergency_contact_info.size(); i++) {
				jsonObject2 = (JSONObject) emergency_contact_info.get(i);
				String relation = jsonObject2.getString("relation");// 关系
				String name1 = jsonObject2.getString("name");// 姓名
				String id_number = jsonObject2.getString("id_number");// 身份证号码
				String label_name = jsonObject2.getString("label_name");// 互联网标记
				String phone_location = jsonObject2.getString("phone_location");// 归属地
				JSONObject one_month_call_statistics = (JSONObject) jsonObject2.get("one_month_call_statistics");// 近一个月通话统计
				int one_calling_count = one_month_call_statistics.getInteger("calling_count");// 主叫次数
				int one_called_count = one_month_call_statistics.getInteger("called_count");// 被叫次数
				int one_total_call_count = one_month_call_statistics.getInteger("total_call_count");// 总共通话次数
				String one_calling_duration_time = one_month_call_statistics.getString("calling_duration_time");// 主叫通话时长
				String one_called_duration_time = one_month_call_statistics.getString("called_duration_time");// 主叫通话时长
				String one_total_call_duration_time = one_month_call_statistics.getString("total_call_duration_time");// 主叫通话时长
				JSONObject three_month_call_statistics = (JSONObject) jsonObject2.get("three_month_call_statistics");// 近三个月通话统计
				int three_calling_count = three_month_call_statistics.getInteger("calling_count");// 主叫次数
				int three_called_count = three_month_call_statistics.getInteger("calling_count");// 被叫次数
				int three_total_call_count = three_month_call_statistics.getInteger("total_call_count");// 总共通话次数
				String three_calling_duration_time = three_month_call_statistics.getString("calling_duration_time");// 主叫通话时长
				String three_called_duration_time = three_month_call_statistics.getString("called_duration_time");// 被叫通话次数
				String three_total_call_duration_time = three_month_call_statistics
						.getString("total_call_duration_time");// 总共通话时长
				JSONObject six_month_call_statistics = (JSONObject) jsonObject2.get("three_month_call_statistics");// 近六个月通话统计
				int six_calling_count = six_month_call_statistics.getInteger("calling_count");// 主叫次数
				int six_called_count = six_month_call_statistics.getInteger("calling_count");// 被叫次数
				int six_total_call_count = six_month_call_statistics.getInteger("total_call_count");// 总共通话次数
				String six_calling_duration_time = six_month_call_statistics.getString("calling_duration_time");// 主叫通话时长
				String six_called_duration_time = six_month_call_statistics.getString("called_duration_time");// 被叫通话次数
				String six_total_call_duration_time = six_month_call_statistics.getString("total_call_duration_time");// 总共通话时长
				JSONObject all_call_statistics = (JSONObject) jsonObject2.get("all_call_statistics");// 总共通话次数
				int all_calling_count = all_call_statistics.getInteger("calling_count");// 主叫次数
				int all_called_count = all_call_statistics.getInteger("calling_count");// 被叫次数
				int all_total_call_count = all_call_statistics.getInteger("total_call_count");// 总共通话次数
				String all_calling_duration_time = all_call_statistics.getString("calling_duration_time");// 主叫通话时长
				String all_called_duration_time = all_call_statistics.getString("called_duration_time");// 被叫通话次数
				String all_total_call_duration_time = all_call_statistics.getString("total_call_duration_time");// 总共通话时长
				String workday_duration_time = jsonObject2.getString("workday_duration_time");// 工作日通话时长
				String offday_duration_time = jsonObject2.getString("offday_duration_time");// 非工作日通话时长
				emergencyContactInfoMapper.setemergencyContactInfo(userId,relation,name,phone_number,id_number,label_name,phone_location,one_calling_count,one_called_count,
						one_total_call_count,one_calling_duration_time,one_called_duration_time,one_total_call_duration_time,three_calling_count,three_called_count,three_total_call_count,
						three_calling_duration_time,three_called_duration_time,three_total_call_duration_time,six_calling_count,six_called_count,six_total_call_count,six_calling_duration_time,
						six_called_duration_time,six_total_call_duration_time,all_calling_count,all_called_count,all_total_call_count,all_calling_duration_time,all_called_duration_time,all_total_call_duration_time,
						workday_duration_time,offday_duration_time);
			}
		}

		// label_info
		JSONArray label_info = (JSONArray) data.get("label_info");// 通话区域分布(城市)
		if (label_info.size() > 0) {
			for (int i = 0; i < label_info.size(); i++) {
				jsonObject2 = (JSONObject) label_info.get(i);
				int sort_index = jsonObject2.getInteger("sort_index");//联系次数排名
				int contact_count = jsonObject2.getInteger("contact_count");//联系次数
				String phone_number1 = jsonObject2.getString("phone_number");//号码
				String label_name = jsonObject2.getString("label_name");//互联网标识
				String label_type = jsonObject2.getString("label_type");//标识类型
				String phone_location = jsonObject2.getString("phone_location");//归属地
				String contact_duration = jsonObject2.getString("contact_duration");//通话时长
				int calling_count = jsonObject2.getInteger("calling_count");//主叫次数
				int called_count = jsonObject2.getInteger("called_count");//被叫次数
				String earliest_time = jsonObject2.getString("earliest_time");//最早一次通话时间
				String latest_time = jsonObject2.getString("latest_time");//最后一次通话时间
				labelInfoMapper.setlabelInfoMapper(userId,sort_index,contact_count,phone_number,label_name,label_type,phone_location,contact_duration,calling_count,called_count,earliest_time,latest_time);		
			}
		}
		
		//operator_info
		JSONObject operator_info = (JSONObject) data.get("operator_info");//运营商基本信息
		String phone_number1 = operator_info.getString("phone_number");//本机号码
		String operator_type = operator_info.getString("operator_type");//运营商类型
		String name1 = operator_info.getString("name");//姓名
		String email = operator_info.getString("email");//邮箱
		String address = operator_info.getString("address");//地址
		String vip_level = operator_info.getString("vip_level");//会员等级
		String registration_history = operator_info.getString("registration_history");//在网时长
		BigDecimal available_amount = operator_info.getBigDecimal("available_amount");//当前可用的余额
		String phone_number_location = operator_info.getString("phone_number_location");//本机号码归属地
		String main_active_location = operator_info.getString("main_active_location");//主要活动区域
		BigDecimal main_location_percent = operator_info.getBigDecimal("main_location_percent");//主要活动区域时间 占比
		String available_amount1 = operator_info.getString("available_amount");//当前可用的余额
		
		OperatorInfo operatorInfo = new OperatorInfo();
		operatorInfo.setXiaodaiUserid(userId);
		operatorInfo.setPhoneNumber(phone_number);
		operatorInfo.setOperatorType(operator_type);
		operatorInfo.setName(name);
		operatorInfo.setIdcard(idcard);
		operatorInfo.setEmail(email);
		operatorInfo.setAddress(address);
		operatorInfo.setVipLevel(vip_level);
		operatorInfo.setRegistrationHistory(registration_history);
		operatorInfo.setAvailableAmount(available_amount);
		operatorInfo.setPhoneNumberLocation(phone_number_location);
		operatorInfo.setMainActiveLocation(main_active_location);
		operatorInfo.setMainLocationPercent(main_location_percent);
		
		
//		operatorInfoMapper.setoperatorInfo(userId,phone_number,operator_type,name,idcard,email,address,vip_level,registration_history,available_amount,
//				phone_number_location,main_active_location,main_location_percent);
		
		operatorInfoMapper.setoperatorInfo(operatorInfo);
		int id = operatorInfo.getId();
		
		JSONArray main_locations = (JSONArray) operator_info.get("main_locations");// 通话区域分布(城市)
		if (main_locations.size() > 0) {
			for (int i = 0; i < main_locations.size(); i++) {
				jsonObject2 = (JSONObject) main_locations.get(i);
				String location = jsonObject2.getString("location");//主要活动区域
				BigDecimal percent = jsonObject2.getBigDecimal("percent");//主要活动区域占比
				mainLocationsMapper.setmainLocations(location,percent,id);
	}
		}
		
		JSONArray circle_of_friends_locations = (JSONArray) operator_info.get("circle_of_friends_locations");// 朋友圈区域集合
		if (circle_of_friends_locations.size() > 0) {
			for (int i = 0; i < circle_of_friends_locations.size(); i++) {
				jsonObject2 = (JSONObject) circle_of_friends_locations.get(i);
				String location = jsonObject2.getString("location");//主要活动区域
				BigDecimal percent = jsonObject2.getBigDecimal("percent");//主要活动区域占比
				circleOfFriendsLocationsMapper.setcircleOfFriendsLocations(location,percent);
	}
		}
		
		
		//recharge_info
		JSONArray recharge_info = (JSONArray) data.get("recharge_info");//充值记录
		if (recharge_info.size() > 0) {
			for (int i = 0; i < recharge_info.size(); i++) {
				jsonObject2 = (JSONObject) recharge_info.get(i);
				String recharge_time = jsonObject2.getString("recharge_time");//充值时间
				int recharge_count = jsonObject2.getInteger("recharge_count");//充值次数
				BigDecimal recharge_amount = jsonObject2.getBigDecimal("recharge_amount");//充值总金额
				BigDecimal recharge_max = jsonObject2.getBigDecimal("recharge_max");//最大单笔充值金额
				rechargeInfoMapper.setrechargeInfo(userId,recharge_time,recharge_count,recharge_amount,recharge_max);
	}
		}
		
		
		//report_info
		JSONObject report_info = (JSONObject) data.get("report_info");//报告基本信息
		String time = report_info.getString("time");//生成时间
		String report_no = report_info.getString("report_no");//报告编号
		String risk_level = report_info.getString("risk_level");//欺诈评估风险(旧)
		int score = report_info.getInteger("score");//运营商量化评分
		
		reportInfoMapper.setreportInfo(userId,time,report_no,risk_level,score);
		
		
		//sensitive_info_new
//		JSONArray sensitive_info = (JSONArray) data.get("sensitive_info_new");//风险信息检查
//		if (sensitive_info.size() > 0) {
//			JSONObject	jsonObject0 = (JSONObject) sensitive_info.get(0);
//		String key_information_risk_level = jsonObject0.getString("risk_level");//运营商关键信息匹配风险等级
//		int key_information_item_id = jsonObject0.getInteger("item_id");//运营商关键信息匹配风险项id
//		String key_information_item_name = jsonObject0.getString("item_name");//运营商关键信息匹配风险项名称
//		String key_information_check_result = jsonObject0.getString("check_result");//运营商关键信息匹配检查结果（结果有"未发现"、"result_detail_info"两种）		
//		JSONObject result_detail_info = (JSONObject) jsonObject0.get("result_detail_info");//结果详情
//				String key_information_idcard_matching = result_detail_info.getString("idcard_matching");//运营商关键信息匹配身份证匹配结果
//				String key_information_name_matching = result_detail_info.getString("name_matching");//运营商关键信息匹配姓名匹配结果
//
//				JSONObject	jsonObject1 = (JSONObject) sensitive_info.get(1);
//				String net_time_risk_level = jsonObject1.getString("risk_level");//入网时长检查风险等级
//				int net_time_item_id = jsonObject1.getInteger("item_id");//入网时长检查风险项id
//				String net_time_item_name = jsonObject1.getString("item_name");//入网时长检查风险项名称
//				String net_time_check_result = jsonObject1.getString("check_result");//入网时长检查检查结果（结果有"未发现"、"result_detail_info"两种）
//				result_detail_info = (JSONObject) jsonObject1.get("result_detail_info");//结果详情
//				String network_length_check = result_detail_info.getString("network_length_check");//入网时长检查
//				
//				jsonObject2 = (JSONObject) sensitive_info.get(2);
//				String applicant_blacklist_risk_level = jsonObject2.getString("risk_level");//申请人黑名单检查风险等级
//				int applicant_blacklist_item_id = jsonObject2.getInteger("item_id");//申请人黑名单检查风险项id
//				String applicant_blacklist_item_name = jsonObject2.getString("item_name");//申请人黑名单检查风险项名称
//				String applicant_blacklist_check_result = jsonObject2.getString("check_result");//申请人黑名单检查检查结果（结果有"未发现"、"result_detail_info"两种）
//				result_detail_info = (JSONObject) jsonObject2.get("result_detail_info");//结果详情
//				String applicant_blacklist_idcard = result_detail_info.getString("idcard");//身份证未在黑名单中出现
//				String applicant_blacklist_phone_number = result_detail_info.getString("phone_number");//手机号未在黑名单中出现
//				
//
//				JSONObject jsonObject3 = (JSONObject) sensitive_info.get(3);
//				String emergency_blacklist_blacklist_risk_level = jsonObject3.getString("risk_level");//紧急联系人黑名单检查风险等级
//				int emergency_blacklist_blacklist_item_id = jsonObject3.getInteger("item_id");//紧急联系人黑名单检查风险项id
//				String emergency_blacklist_blacklist_item_name = jsonObject3.getString("item_name");//紧急联系人黑名单检查风险项名称
//				String emergency_blacklist_check_result = jsonObject3.getString("check_result");//紧急联系人黑名单检查结果（结果有"未发现"、"result_detail_info"两种）
//				
//				JSONObject jsonObject4 = (JSONObject) sensitive_info.get(4);
//				String blacklist_communication_blacklist_risk_level = jsonObject4.getString("risk_level");//黑名单通信记录风险等级
//				int blacklist_communication_blacklist_item_id = jsonObject4.getInteger("item_id");//黑名单通信记录风险项id
//				String blacklist_communication_blacklist_item_name = jsonObject4.getString("item_name");//黑名单通信记录风险项名称
//				String blacklist_communication_check_result = jsonObject4.getString("check_result");//黑名单通信记录结果（结果有"未发现"、"result_detail_info"两种）
//				
//				JSONObject jsonObject5 = (JSONObject) sensitive_info.get(5);
//				String id_card_blacklist_risk_level = jsonObject5.getString("risk_level");//身份证关联信息检测风险等级
//				int id_card_blacklist_item_id = jsonObject5.getInteger("item_id");//身份证关联信息检测风险项id
//				String id_card_blacklist_item_name = jsonObject5.getString("item_name");//身份证关联信息检测风险项名称
//				String id_card_check_result = jsonObject5.getString("check_result");//身份证关联信息检测结果（结果有"未发现"、"result_detail_info"两种）
//				result_detail_info = (JSONObject) jsonObject2.get("result_detail_info");//结果详情
//				String result = result_detail_info.getString("result");
//				
//				JSONObject jsonObject6 = (JSONObject) sensitive_info.get(6);
//				String private_lending_risk_level = jsonObject6.getString("risk_level");//民间借贷风险等级
//				int private_lending_item_id = jsonObject6.getInteger("item_id");//民间借贷风险项id
//				String private_lending_item_name = jsonObject6.getString("item_name");//民间借贷风险项名称
//				String private_lending_check_result = jsonObject6.getString("check_result");//民间借贷检测结果（结果有"未发现"、"result_detail_info"两种）
//				
//				
//				JSONObject jsonObject7 = (JSONObject) sensitive_info.get(7);
//				String financial_institutions_risk_level = jsonObject7.getString("risk_level");//金融机构风险等级
//				int financial_institutions_item_id = jsonObject7.getInteger("item_id");//金融机构风险项id
//				String financial_institutions_item_name = jsonObject7.getString("item_name");//金融机构风险项名称
//				String financial_institutions_check_result = jsonObject7.getString("check_result");//金融机构检测结果（结果有"未发现"、"result_detail_info"两种）
//				
//				JSONObject jsonObject8 = (JSONObject) sensitive_info.get(8);
//				String credit_card_risk_level = jsonObject8.getString("risk_level");//信用卡机构风险等级
//				int credit_card_item_id = jsonObject8.getInteger("item_id");//信用卡机构风险项id
//				String credit_card_item_name = jsonObject8.getString("item_name");//信用卡机构风险项名称
//				String credit_card_check_result = jsonObject8.getString("check_result");//信用卡机构检测结果（结果有"未发现"、"result_detail_info"两种）
//				
//				JSONObject jsonObject9 = (JSONObject) sensitive_info.get(9);
//				String lending_platform_risk_level = jsonObject9.getString("risk_level");//p2p借贷平台风险等级
//				int lending_platform_item_id = jsonObject9.getInteger("item_id");//p2p借贷平台风险项id
//				String lending_platform_item_name = jsonObject9.getString("item_name");//p2p借贷平台风险项名称
//				String lending_platform_check_result = jsonObject9.getString("check_result");//p2p借贷平台检测结果（结果有"未发现"、"result_detail_info"两种）
//				
//				
//				JSONObject jsonObject10 = (JSONObject) sensitive_info.get(10);
//				String internet_loan_risk_level = jsonObject10.getString("risk_level");//互联网小贷风险等级
//				int internet_loan_item_id = jsonObject10.getInteger("item_id");//互联网小贷风险项id
//				String internet_loan_item_name = jsonObject10.getString("item_name");//互联网小贷风险项名称
//				String internet_loan_check_result = jsonObject10.getString("check_result");//互联网小贷检测结果（结果有"未发现"、"result_detail_info"两种）
//				
//				
//				JSONObject jsonObject11 = (JSONObject) sensitive_info.get(11);
//				String lawyer_risk_level = jsonObject11.getString("risk_level");//律师风险等级
//				int lawyer_item_id = jsonObject11.getInteger("item_id");//律师风险项id
//				String lawyer_item_name = jsonObject11.getString("item_name");//律师风险项名称
//				String lawyer_check_result = jsonObject11.getString("check_result");//律师检测结果（结果有"未发现"、"result_detail_info"两种）
//				
//				
//				JSONObject jsonObject12 = (JSONObject) sensitive_info.get(12);
//				String court_risk_level = jsonObject12.getString("risk_level");//法院风险等级
//				int court_item_id = jsonObject12.getInteger("item_id");//法院风险项id
//				String court_item_name = jsonObject12.getString("item_name");//法院风险项名称
//				String court_check_result = jsonObject12.getString("check_result");//法院检测结果（结果有"未发现"、"result_detail_info"两种）
//				
//				JSONObject jsonObject13 = (JSONObject) sensitive_info.get(13);
//				String risk_level_110 = jsonObject13.getString("risk_level");//110风险等级
//				int item_id_110 = jsonObject13.getInteger("item_id");//110风险项id
//				String item_name_110 = jsonObject13.getString("item_name");//110风险项名称
//				String check_result_110 = jsonObject13.getString("check_result");//110检测结果（结果有"未发现"、"result_detail_info"两种）
//				
//				
//				JSONObject jsonObject14 = (JSONObject) sensitive_info.get(14);
//				String risk_level_120 = jsonObject14.getString("risk_level");//120风险等级
//				int item_id_120 = jsonObject14.getInteger("item_id");//120风险项id
//				String item_name_120 = jsonObject14.getString("item_name");//120风险项名称
//				String check_result_120 = jsonObject14.getString("check_result");//120检测结果（结果有"未发现"、"result_detail_info"两种）
//				
//				
//				JSONObject jsonObject15 = (JSONObject) sensitive_info.get(15);
//				String macao_communication_risk_level = jsonObject15.getString("risk_level");//澳门通信风险等级
//				int macao_communication_item_id = jsonObject15.getInteger("item_id");//澳门通信风险项id
//				String macao_communication_item_name = jsonObject15.getString("item_name");//澳门通信风险项名称
//				String macao_communication_check_result = jsonObject15.getString("check_result");//澳门通信检测结果（结果有"未发现"、"result_detail_info"两种）
//				
//				sensitiveInfoNewMapper.setsensitiveInfoNew(userId,key_information_risk_level,key_information_item_id,key_information_item_name,key_information_check_result,key_information_idcard_matching,key_information_name_matching,
//						net_time_risk_level,net_time_item_id,net_time_item_name,net_time_check_result,network_length_check,applicant_blacklist_risk_level,applicant_blacklist_item_id,applicant_blacklist_item_name,applicant_blacklist_check_result,
//						applicant_blacklist_idcard,applicant_blacklist_phone_number,emergency_blacklist_blacklist_risk_level,emergency_blacklist_blacklist_item_id,emergency_blacklist_blacklist_item_name,emergency_blacklist_check_result,
//						blacklist_communication_blacklist_risk_level,blacklist_communication_blacklist_item_id,blacklist_communication_blacklist_item_name,blacklist_communication_check_result,id_card_blacklist_risk_level,id_card_blacklist_item_id,
//						id_card_blacklist_item_name,id_card_check_result,result,private_lending_risk_level,private_lending_item_id,private_lending_item_name,private_lending_check_result,financial_institutions_risk_level,financial_institutions_item_id,
//						financial_institutions_item_name,financial_institutions_check_result,credit_card_risk_level,credit_card_item_id,credit_card_item_name,credit_card_check_result,lending_platform_risk_level,lending_platform_item_id,lending_platform_item_name,
//						lending_platform_check_result,internet_loan_risk_level,internet_loan_item_id,internet_loan_item_name,internet_loan_check_result,court_risk_level,court_item_id,court_item_name,court_check_result,risk_level_110,item_id_110,item_name_110,
//						check_result_110,lawyer_risk_level,lawyer_item_id,lawyer_item_name,lawyer_check_result,risk_level_120,item_id_120,item_name_120,check_result_120,macao_communication_risk_level,macao_communication_item_id,macao_communication_item_name,macao_communication_check_result);
				

		//sensitive_info_new
		JSONArray sensitive_info_new = (JSONArray) data.get("sensitive_info_new");//风险信息检查
		String idcard_matching ="";
		String name_matching = "";
		String network_length_check = "";
		String idcard1 = "";
		String phone_number5 = "";
		String result ="";
		if (sensitive_info_new.size() > 0) {
			for (int i = 0; i < sensitive_info_new.size(); i++) {
			JSONObject	jsonObject0 = (JSONObject) sensitive_info_new.get(i);
		String risk_level1 = jsonObject0.getString("risk_level");//运营商关键信息匹配风险等级
		String item_id = jsonObject0.getInteger("item_id")+"";//运营商关键信息匹配风险项id
		String item_name = jsonObject0.getString("item_name");//运营商关键信息匹配风险项名称
		String check_result = jsonObject0.getString("check_result");//运营商关键信息匹配检查结果（结果有"未发现"、"result_detail_info"两种）		
		JSONObject result_detail_info = (JSONObject) jsonObject0.get("result_detail_info");//结果详情
		if(result_detail_info!=null) {
			idcard_matching = result_detail_info.getString("idcard_matching");//运营商关键信息匹配身份证匹配结果
			if(idcard_matching==null) {
				idcard_matching="";
			}
			name_matching = result_detail_info.getString("name_matching");//运营商关键信息匹配姓名匹配结果
			if(name_matching==null) {
				name_matching="";
			}
			network_length_check = result_detail_info.getString("network_length_check");
			if(network_length_check==null) {
				network_length_check="";
			}
			idcard1 = result_detail_info.getString("idcard");
			if(idcard1==null) {
				idcard1="";
			}
			phone_number5 = result_detail_info.getString("phone_number");
			if(phone_number5==null) {
				phone_number5="";
			}
			result = result_detail_info.getString("result");
			if(result==null) {
				result="";
			}
			SensitiveInfoNewupa sensitiveInfoNewupa = new SensitiveInfoNewupa();
			sensitiveInfoNewupa.setXiaodaiUserid(userId);
			sensitiveInfoNewupa.setCheckResult(check_result);
			sensitiveInfoNewupa.setItemId(item_id);
			sensitiveInfoNewupa.setItemName(item_name);
			sensitiveInfoNewupa.setRiskLevel(risk_level1);
			sensitiveInfoNewupa.setIdcardMatching(idcard_matching);
			sensitiveInfoNewupa.setNameMatching(name_matching);
			sensitiveInfoNewupa.setNetworkLengthCheck(network_length_check);
			sensitiveInfoNewupa.setIdcard(idcard1);
			sensitiveInfoNewupaMapper.setsensitiveInfoNewupa(sensitiveInfoNewupa);
			int sentivid = sensitiveInfoNewupa.getId();
			
			JSONArray call_record_list_infos = (JSONArray) result_detail_info.get("call_record_list_infos");//出行分析
			if(call_record_list_infos!=null){
				if (call_record_list_infos.size() > 0) {
					for (int j = 0; j < call_record_list_infos.size(); j++) {				
					JSONObject	jsonObject1 = (JSONObject) call_record_list_infos.get(j);
					String	name2 = (String) jsonObject1.get("name");
					CallRecordListInfos callRecordListInfos = new CallRecordListInfos();
					callRecordListInfos.setName(name2);
					callRecordListInfos.setSentivid(sentivid);
					callRecordListInfosMapper.setcallRecordListInfos(callRecordListInfos);
					int crlid =callRecordListInfos.getId();
					JSONArray call_record_list_item_infos = (JSONArray) jsonObject1.get("call_record_list_item_infos");
					if(call_record_list_item_infos!=null) {
						if (call_record_list_item_infos.size() > 0) {
							for (int k = 0; k < call_record_list_item_infos.size(); k++) {				
							JSONObject	jsonObject5 = (JSONObject) call_record_list_item_infos.get(k);
							Integer	called_countint = (Integer) jsonObject5.get("called_count");	
							String called_count =called_countint+"";
							Integer	calling_countint = (Integer) jsonObject5.get("calling_count");
							String calling_count = calling_countint+"";
							String	phone_number4 = (String) jsonObject5.get("phone_number");
							CallRecordListItemInfosTwo callRecordListItemInfosTwo = new CallRecordListItemInfosTwo();
							callRecordListItemInfosTwo.setCrlid(crlid);
							callRecordListItemInfosTwo.setCalledCount(called_count);
							callRecordListItemInfosTwo.setCallingCount(calling_count);
							callRecordListItemInfosTwo.setPhoneNumber(phone_number4);
							callRecordListItemInfosTwoMapper.setcallRecordListItemInfosTwo(callRecordListItemInfosTwo);
							int crtwoid =  callRecordListItemInfosTwo.getId();
							JSONArray call_statistics = (JSONArray) jsonObject5.get("call_statistics");
							if (call_statistics.size() > 0) {
								for (int l = 0; l < call_statistics.size(); l++) {	
									JSONObject	jsonObject3 = (JSONObject) call_statistics.get(l);
									Integer	total_call_count = (Integer) jsonObject3.get("total_call_count");
									Integer	total_call_duration_time = (Integer) jsonObject3.get("total_call_duration_time");
									CallStatistics callStatistics = new CallStatistics();
									callStatistics.setCrtwoid(crtwoid);
									callStatistics.setTotalCallCount(total_call_count);
									callStatistics.setTotalCallDurationTime(total_call_duration_time);
									callStatisticsMapper.setcallStatistics(callStatistics);
								}
				}

				
				}
				}
					}


	}
			}
			}

			}

		
		}
	}
			


			
			
		//social_connectionsInfo
		JSONObject social_connectionsInfo = (JSONObject) data.get("social_connectionsInfo");//社交关系
		String phone_count = social_connectionsInfo.getString("phone_count");//联系号码总数
		String interflow_call_phone_count = social_connectionsInfo.getString("interflow_call_phone_count");//互通号码数
		String compactness_call_count = social_connectionsInfo.getString("compactness_call_count");//朋友圈紧密联系人数
		String ephemeral_call_count = social_connectionsInfo.getString("ephemeral_call_count");//疑似骚扰电话个数
		JSONArray circle_of_friends_locations1 = (JSONArray) social_connectionsInfo.get("circle_of_friends_locations");//朋友圈区域分布
		socialConnectionsinfoMapper.setsocialConnectionsinfo(userId,phone_count,interflow_call_phone_count,compactness_call_count,ephemeral_call_count);
		if (circle_of_friends_locations.size() > 0) {
			for (int i = 0; i < circle_of_friends_locations.size(); i++) {
				jsonObject2 = (JSONObject) circle_of_friends_locations.get(i);
				String location = jsonObject2.getString("location");//地点
				String percent = jsonObject2.getString("percent");//百分比

	}
		
		}
		
		
		//top10_call_count
		JSONArray top10_call_count = (JSONArray) data.get("top10_call_count");//通话次数前10
		if (top10_call_count.size() > 0) {
			for (int i = 0; i < top10_call_count.size(); i++) {
			JSONObject	jsonObject0 = (JSONObject) top10_call_count.get(i);
		String phone_number2 = jsonObject0.getString("phone_number");//通话号码
		String call_count = jsonObject0.getString("call_count");//通话次数
		String calling_count = jsonObject0.getString("calling_count");//主叫次数
		String called_count = jsonObject0.getString("called_count");//被叫次数
		top10CallCountMapper.settop10CallCount(userId,phone_number2,call_count,calling_count,called_count);
			}
		}
		
		//top10_call_time
		JSONArray top10_call_time = (JSONArray) data.get("top10_call_time");//通话总时长前10
		if (top10_call_time.size() > 0) {
			for (int i = 0; i < top10_call_time.size(); i++) {
			JSONObject	jsonObject0 = (JSONObject) top10_call_time.get(i);
		phone_number = jsonObject0.getString("phone_number");//通话号码
		String call_duration_time = jsonObject0.getString("call_count");//通话时长
		String calling_duration_time = jsonObject0.getString("calling_duration_time");//主叫时长
		String called_duration_time = jsonObject0.getString("called_duration_time");//被叫时长
		top10CallTimeMapper.settop10CallTime(userId,phone_number,call_duration_time,calling_duration_time,called_duration_time);
		
			}
		}
		
		//top10_single_call_time
		
		JSONArray top10_single_call_time = (JSONArray) data.get("top10_single_call_time");//单次通话时长前10
		if (top10_single_call_time.size() > 0) {
			for (int i = 0; i < top10_single_call_time.size(); i++) {
			JSONObject	jsonObject0 = (JSONObject) top10_single_call_time.get(i);
		String phone_number4 = jsonObject0.getString("phone_number");//通话号码
		String call_duration_time = jsonObject0.getString("call_duration_time");//通话时长
		top10SingleCallTimeMapper.settop10SingleCallTime(userId,phone_number4,call_duration_time);
			}
		}
		
		//travel_info
		JSONArray travel_info = (JSONArray) data.get("travel_info");//出行分析
		if (travel_info.size() > 0) {
			for (int i = 0; i < travel_info.size(); i++) {
			JSONObject	jsonObject0 = (JSONObject) travel_info.get(i);
		String during_type = jsonObject0.getString("during_type");//时间段
		String start_time = jsonObject0.getString("start_time");//出行时间
		String return_time = jsonObject0.getString("return_time");//回程时间
		String departure_place = jsonObject0.getString("departure_place");//出行地
		String destination_place = jsonObject0.getString("destination_place");//目的地
		String duration_days = jsonObject0.getString("duration_days");//行程时间（天）
		travelInfoMapper.settravelInfo(userId,during_type,start_time,return_time,departure_place,destination_place,duration_days);
			}
		}

		return "1111111";
		
	}
	
	
	
	
}

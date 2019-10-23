package com.zhita.Serviceimp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhita.Dao.ApplierInfoMapper;
import com.zhita.Dao.BillInfoMapper;
import com.zhita.Dao.CommunicationCityInfoMapper;
import com.zhita.Dao.CommunicationDetectionMapper;
import com.zhita.Dao.CommunicationMonthInfoMapper;
import com.zhita.Dao.CommunicationTimeBucketInfoMapper;
import com.zhita.Dao.CommunicationTimeDurationInfoMapper;
import com.zhita.Dao.ContactsCityInfosMapper;
import com.zhita.Dao.EmergencyContactInfoMapper;
import com.zhita.Dao.LabelInfoMapper;
import com.zhita.Dao.OperatorInfoMapper;
import com.zhita.Dao.RechargeInfoMapper;
import com.zhita.Dao.ReportInfoMapper;
import com.zhita.Dao.SensitiveInfoNewupaMapper;
import com.zhita.Dao.SocialConnectionsinfoMapper;
import com.zhita.Dao.Top10CallCountMapper;
import com.zhita.Dao.Top10CallTimeMapper;
import com.zhita.Dao.Top10SingleCallTimeMapper;
import com.zhita.Dao.TravelInfoMapper;
import com.zhita.Model.ApplierInfo;
import com.zhita.Model.BillInfo;
import com.zhita.Model.CommunicationCityInfo;
import com.zhita.Model.CommunicationDetection;
import com.zhita.Model.CommunicationMonthInfo;
import com.zhita.Model.CommunicationTimeBucketInfo;
import com.zhita.Model.CommunicationTimeDurationInfo;
import com.zhita.Model.ContactsCityInfos;
import com.zhita.Model.EmergencyContactInfo;
import com.zhita.Model.LabelInfo;
import com.zhita.Model.OperatorInfo;
import com.zhita.Model.RechargeInfo;
import com.zhita.Model.ReportInfo;
import com.zhita.Model.SensitiveInfoNewupa;
import com.zhita.Model.SocialConnectionsinfo;
import com.zhita.Model.Top10CallCount;
import com.zhita.Model.Top10CallTime;
import com.zhita.Model.Top10SingleCallTime;
import com.zhita.Model.TravelInfo;
import com.zhita.Service.IntAuthenService;
import com.zhita.Util.PageUtil2;

@Service
public class AuthenServiceImp implements IntAuthenService{
	@Autowired
	private ApplierInfoMapper applierInfoMapper;
	@Autowired
	private BillInfoMapper billInfoMapper;
	@Autowired
	private CommunicationCityInfoMapper communicationCityInfoMapper;
	@Autowired
	private CommunicationDetectionMapper communicationDetectionMapper;
	@Autowired
	private CommunicationMonthInfoMapper communicationMonthInfoMapper;
	@Autowired
	private CommunicationTimeBucketInfoMapper communicationTimeBucketInfoMapper;
	@Autowired
	private CommunicationTimeDurationInfoMapper communicationTimeDurationInfoMapper;
	@Autowired
	private ContactsCityInfosMapper contactsCityInfosMapper;
	@Autowired
	private EmergencyContactInfoMapper emergencyContactInfoMapper;
	@Autowired
	private LabelInfoMapper labelInfoMapper;
	@Autowired
	private OperatorInfoMapper operatorInfoMapper;
	@Autowired
	private RechargeInfoMapper rechargeInfoMapper;
	@Autowired
	private ReportInfoMapper reportInfoMapper;
	@Autowired
	private SocialConnectionsinfoMapper socialConnectionsinfoMapper;
	@Autowired
	private TravelInfoMapper travelInfoMapper;
	@Autowired
	private Top10CallCountMapper top10CallCountMapper;
	@Autowired
	private Top10CallTimeMapper top10CallTimeMapper;
	@Autowired
	private Top10SingleCallTimeMapper top10SingleCallTimeMapper;
	@Autowired
	private SensitiveInfoNewupaMapper sensitiveInfoNewupaMapper;
	
	public Map<String,Object> queryauthen(Integer userid){
		List<ApplierInfo> listapplier=applierInfoMapper.queryAll(userid);//申请人基本信息OK
		
		List<BillInfo> listbill=billInfoMapper.queryAll(userid);//消费记录OK--可能会分页
		
		List<CommunicationCityInfo> listcomcity=communicationCityInfoMapper.queryAll(userid);//通话区域分布(省级)OK--可能会分页
		
		List<CommunicationDetection> listcomdet=communicationDetectionMapper.queryAll(userid);//通信检测---3OK
		
		List<CommunicationMonthInfo> listcommonth=communicationMonthInfoMapper.queryAll(userid);//通话月份分布OK--可能会分页
		
		List<CommunicationTimeBucketInfo> listcombuck=communicationTimeBucketInfoMapper.queryAll(userid);//通话时间段分布OK--可能会分页
		
		List<CommunicationTimeDurationInfo> listcomdur=communicationTimeDurationInfoMapper.queryAll(userid);//通话时长分布表OK--可能会分页
		
    	List<EmergencyContactInfo> listemecon=emergencyContactInfoMapper.queryAll(userid);//紧急联系人---4OK
    	
    	List<OperatorInfo> listopera=operatorInfoMapper.queryAll(userid);//运营商基本信息---2OK
    	
    	List<RechargeInfo> listrech=rechargeInfoMapper.queryAll(userid);//充值记录OK---可能会分页
    	
    	List<ReportInfo> listrepo=reportInfoMapper.queryAll(userid);//报告基本信息OK
    	
    	List<SocialConnectionsinfo> listsoc=socialConnectionsinfoMapper.queryAll(userid);//社交关系OK
    	
    	List<Top10CallCount> top10call=top10CallCountMapper.queryAll(userid);//通话次数前10 表OK
    	
    	List<Top10CallTime> top10time=top10CallTimeMapper.queryAll(userid);//通话总时长前10 表OK
    	
    	List<Top10SingleCallTime> top10sing=top10SingleCallTimeMapper.queryAll(userid);//单次通话时长前10 表OK
    	
		Map<String,Object> map=new HashMap<String, Object>();
		//map.put("listapplier", listapplier);//申请人基本信息
		//map.put("listbill", listbill);//消费记录
		//map.put("listcommonth", listcommonth);//通话月份分布
		//map.put("listcombuck", listcombuck);//通话时间段分布
		//map.put("listcomdur", listcomdur);//通话时长分布
		//map.put("listrech", listrech);//充值记录
		//map.put("listrepo", listrepo);//报告基本信息
		//map.put("listsoc", listsoc);//社交关系
		//map.put("top10call", top10call);//通话次数前10 表
		//map.put("top10time", top10time);//通话总时长前10表
		//map.put("top10sing", top10sing);//单次通话时长前10 表
		map.put("listopera", listopera);//运营商基本信息--2
		map.put("listcomdet", listcomdet);//通信检测--3
		map.put("listemecon", listemecon);//紧急联系人--4
		map.put("listcomcity", listcomcity);//通话区域分布(省级)--6
		return map;
	}
	
	public Map<String,Object> queryauthenconcity(Integer userid,Integer page){
		List<ContactsCityInfos> listconcity=new ArrayList<>();//通话区域分布（城市）表OK
		PageUtil2 pageUtil=null;
		int totalCount=contactsCityInfosMapper.queryAllCount(userid);//查询总数量
		pageUtil=new PageUtil2(page,totalCount);
    	if(page<1) {
    		page=1;
    		pageUtil.setPage(page);
    	}
    	else if(page>pageUtil.getTotalPageCount()) {
    		if(totalCount==0) {
    			page=pageUtil.getTotalPageCount()+1;
    		}else {
    			page=pageUtil.getTotalPageCount();
    		}
    		pageUtil.setPage(page);
    	}
    	int pages=(page-1)*pageUtil.getPageSize();
    	listconcity=contactsCityInfosMapper.queryAll(userid,pages,pageUtil.getPageSize());
    	
    	Map<String,Object> map=new HashMap<String, Object>();
		map.put("listconcity", listconcity);
		map.put("pageUtil", pageUtil);
		return map;
	}
	
	public Map<String,Object> queryauthenconlabel(Integer userid,Integer page){
    	List<LabelInfo> listlabel=new ArrayList<>();//通话数据分析OK
		PageUtil2 pageUtil=null;
		int totalCount=contactsCityInfosMapper.queryAllCount(userid);;//查询总数量
		pageUtil=new PageUtil2(page,totalCount);
    	if(page<1) {
    		page=1;
    		pageUtil.setPage(page);
    	}
    	else if(page>pageUtil.getTotalPageCount()) {
    		if(totalCount==0) {
    			page=pageUtil.getTotalPageCount()+1;
    		}else {
    			page=pageUtil.getTotalPageCount();
    		}
    		pageUtil.setPage(page);
    	}
    	int pages=(page-1)*pageUtil.getPageSize();
    	listlabel=labelInfoMapper.queryAll(userid,pages,pageUtil.getPageSize());

    	Map<String,Object> map=new HashMap<String, Object>();
		map.put("listlabel", listlabel);
		map.put("pageUtil", pageUtil);
		return map;
	}
	
	public Map<String,Object> queryauthenave(Integer userid,Integer page){
    	List<TravelInfo> listave=new ArrayList<>();//出行分析表----7OK
		PageUtil2 pageUtil=null;
		int totalCount=travelInfoMapper.queryAllCount(userid);;//查询总数量
		pageUtil=new PageUtil2(page,totalCount);
    	if(page<1) {
    		page=1;
    		pageUtil.setPage(page);
    	}
    	else if(page>pageUtil.getTotalPageCount()) {
    		if(totalCount==0) {
    			page=pageUtil.getTotalPageCount()+1;
    		}else {
    			page=pageUtil.getTotalPageCount();
    		}
    		pageUtil.setPage(page);
    	}
    	int pages=(page-1)*pageUtil.getPageSize();
    	listave=travelInfoMapper.queryAll(userid,pages,pageUtil.getPageSize());
    	
    	Map<String,Object> map=new HashMap<String, Object>();
		map.put("listave", listave);
		map.put("pageUtil", pageUtil);
		return map;
	}
	
	//后台管理——查询列表(风险信息检查)
    public Map<String,Object> queryAllsen(Integer userid){
    	List<SensitiveInfoNewupa> listsen=sensitiveInfoNewupaMapper.queryAll(userid);
    	Map<String,Object> map=new HashMap<>();
    	map.put("listsen", listsen);
        return map;
    }
    
    //通话详情（通话月份，通话时间段，通话时长分布）
    public Map<String,Object> queryTelephone(Integer userid){
    	List<CommunicationMonthInfo> listcommonth=communicationMonthInfoMapper.queryAll(userid);//通话月份分布OK--可能会分页
		List<CommunicationTimeBucketInfo> listcombuck=communicationTimeBucketInfoMapper.queryAll(userid);//通话时间段分布OK--可能会分页
		List<CommunicationTimeDurationInfo> listcomdur=communicationTimeDurationInfoMapper.queryAll(userid);//通话时长分布表OK--可能会分页
    	Map<String,Object> map=new HashMap<String, Object>();
    	map.put("listcommonth", listcommonth);//通话月份分布
    	map.put("listcombuck", listcombuck);//通话时间段分布
    	map.put("listcomdur", listcomdur);//通话时长分布
    	return map;
    }
}

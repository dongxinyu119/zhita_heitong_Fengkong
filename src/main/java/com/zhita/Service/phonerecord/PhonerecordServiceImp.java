package com.zhita.Service.phonerecord;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.zhita.Dao.CallrecordsMapper;
import com.zhita.Model.Callrecords;
import com.zhita.Model.Jsonlist2;

@Service
public class PhonerecordServiceImp implements IntPhonerecordService{
	@Autowired
	private CallrecordsMapper callrecordsMapper;
	
	//添加通话记录
	public Map<String, Object> addphonerecord(String jsonlist,Integer userid){
		Map<String, Object> map = new HashMap<String, Object>();
		int count = callrecordsMapper.querycount(userid);
		List<Jsonlist2> jsonlists = JSONObject.parseArray(jsonlist, Jsonlist2.class);
		if(count == 0){
			for (int j = 0; j < jsonlists.size(); j++) {
				Callrecords crd = new Callrecords();
				crd.setDate(jsonlists.get(j).getDate());
				crd.setDuration(jsonlists.get(j).getDuration());
				crd.setNumber(jsonlists.get(j).getNumber());
				crd.setName(jsonlists.get(j).getName());
				crd.setType(jsonlists.get(j).getType());
				crd.setUserid(userid);
				callrecordsMapper.insert(crd);
			}
			map.put("code", 200);
			map.put("msg", "导入成功");
		} else {
			map.put("code", 0);
			map.put("msg", "已导入");
		}
			return map;
	}
}

package com.zhita.Serviceimp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhita.Collection.beoverdue.Data;
import com.zhita.Dao.BeoverdueMapper;
import com.zhita.Model.Magic_wand3;
import com.zhita.Service.BeoverdueService;
import com.zhita.Util.Timestamps;


@Service
public class BeoverdueServiceimp implements BeoverdueService{
	
	@Autowired
	private BeoverdueMapper bervMap;

	@Override
	public Integer AddBeoverdue(Data data) {
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			data.setSend_time(Timestamps.dateToStamp1(sim.format(new Date())));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bervMap.AddBeoverdue(data);
	}

	@Override
	public Map<String, Object> AddMagicWand(Magic_wand3 magic) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer addId = bervMap.AddMagicwand(magic);
		if(addId == 1){
			map.put("code", 200);
			map.put("desc", "添加成功");
		}else{
			map.put("code", 0);
			map.put("desc", "添加失败");
		}
		return map;
	}

}

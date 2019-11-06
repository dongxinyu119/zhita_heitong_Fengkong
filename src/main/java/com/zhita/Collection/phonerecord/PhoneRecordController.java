package com.zhita.Collection.phonerecord;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhita.Service.phonerecord.IntPhonerecordService;

@Controller
@RequestMapping("/phonerecord")
public class PhoneRecordController {
	@Autowired
	private IntPhonerecordService intPhonerecordService;
	
	//添加通话记录
	@ResponseBody
	@RequestMapping("/addphonerecord")
	public Map<String, Object> addphonerecord(String jsonlist, Integer userid) {
		return intPhonerecordService.addphonerecord(jsonlist, userid);
	}

}

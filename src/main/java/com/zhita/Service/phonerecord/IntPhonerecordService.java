package com.zhita.Service.phonerecord;

import java.util.Map;

public interface IntPhonerecordService {
	
	//添加通话记录
	public Map<String, Object> addphonerecord(String jsonlist,Integer userid);
}

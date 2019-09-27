package com.zhita.Service;

import java.util.Map;

import com.zhita.Collection.beoverdue.Data;
import com.zhita.Model.Magic_wand3;


public interface BeoverdueService {
	
	Integer AddBeoverdue(Data data);


	
	
	Map<String, Object> AddMagicWand(Magic_wand3 magic);

}

package com.zhita.Collection.beoverdue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zhita.Model.Magic_wand3;
import com.zhita.Service.BeoverdueService;
import com.zhita.Util.AESUtil;


@Controller
@RequestMapping("beovcont")
public class BeoverdueController {
	
	static String account = "csdkkj145";
	
    static String key = "Absfxs58AT53Xanh95LSzA5TZ4c3i5Mb";
    
    static String url = "https://service.hicore.com/api";
    
    @Autowired
    private BeoverdueService bever;
    
    
    
    
    
    /**
     * 查询逾期金额和逾期数
     * @param username
     * @param phone
     * @param userId
     * @param idNumber
     * @return	
     */
    @ResponseBody
    @RequestMapping("BeoverdueUser")
	public Map<String, Object> Beoverdue(String name,String mobile,Integer userId,String idNumber) {
    	MapUtil maps = new MapUtil();
    	Map<String, Object> map = new HashMap<String, Object>();
	        String code = "102160";//代码（固定不变）
			String enctype="0";//加密方式
	        String clientNo = String.valueOf(userId);//客户自己定义，可忽略
	        String param = AESUtil.encrypt(key, "name="+name+"&idnumber="+idNumber+"&mobile="+mobile+"&enctype="+enctype+"&clientno="+clientNo);
	        String sign = AESUtil.md5(code + param + account + AESUtil.md5(key));//生成签名
	        String post_data = null;
	        try {
	            post_data = "code=" + code + "&param=" + URLEncoder.encode(param, "UTF-8") + "&account="
	                    + account + "&sign=" + sign;
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	            return map;
	        }
	        String json = postHtml(url, post_data);
	        BeoverdueReturn bereturn = JSON.parseObject(json, BeoverdueReturn.class);
	        
	        if(json!=null){
	        	if(bereturn.getData()!=null){
	        		Data data = bereturn.getData();
			        data.setUserId(userId);
			        data.setUsername(name);
			        data.setPhone(mobile);
			        data.setIdcardnumber(idNumber);
		        	if(bereturn.getResponseCode()==100){
		        		Integer a = bever.AddBeoverdue(data);
		        		if(a!= null){
		        			map.put("desc", data);
		        			map.put("msg", "添加成功");
		        			map.put("code", 200);
		        		}else{
		        			map.put("desc", data);
		        			map.put("msg", "添加失败");
		        			map.put("code", 0);
		        			
		        		}
	        	}else{
	        		map.put("msg", maps.getMap(String.valueOf(bereturn.getResponseCode())));
		        	map.put("code", 0);
	        	}
	        	
	        	}else{
	        		map.put("msg", maps.getMap(String.valueOf(bereturn.getResponseCode())));
		        	map.put("code", 0);
		        }
	        }else{
	        	map.put("msg", maps.getMap(String.valueOf(bereturn.getResponseCode())));
	        	map.put("code", 0);
	        	
	        }
	        //返回的json即为查询结果
	        System.out.println(json);
	        return map;
	    }
	
	

	 static String postHtml(String url, String postData) {
	        try {
	            URL obj = new URL(url);
	            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
	            conn.setRequestMethod("POST");
	            conn.setDoOutput(true);
	            conn.setDoInput(true);
	            PrintWriter out = new PrintWriter(conn.getOutputStream());
	            out.print(postData);
	            out.flush();
	            BufferedReader br = new BufferedReader(new InputStreamReader(
	                    conn.getInputStream(), "UTF-8"));
	            StringBuffer response = new StringBuffer();
	            String line;
	            while ((line = br.readLine()) != null) {
	                response.append(line);
	            }
	            br.close();
	            return response.toString();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "";
	        }
	    }
	 
	 
	 
	 
	 
	 /**
	  * 添加魔杖3 风控返回数据
	  * @return
	  */
	 @ResponseBody
	 @RequestMapping("AddMagic_wand")
	 public Map<String, Object> AddMagicwand(Magic_wand3 magic){
		 return bever.AddMagicWand(magic);
	 }
	 
	 
	 
	 
	 

	 
}

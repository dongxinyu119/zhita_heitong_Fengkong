package com.zhita.Collection.anti_fraud;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zhita.Collection.beoverdue.MapUtil;
import com.zhita.Model.Beoverdue;
import com.zhita.Model.Jointobligation;
import com.zhita.Model.Usercheat;
import com.zhita.Model.Userportrait;
import com.zhita.Service.FengService;
import com.zhita.Util.AESUtil;

//黑瞳

@Controller
@RequestMapping("Anti")
public class Anti_fraudController {
	
	static String account = "csdkkj145";
	
    static String key = "Absfxs58AT53Xanh95LSzA5TZ4c3i5Mb";
    
    static String url = "https://service.hicore.com/api";
    
    @Autowired
    private FengService fser;
    
    
    
    
    
    /**
     * 反欺诈评分
     * @param name		用户姓名
     * @param idNumber	身份证号
     * @param mobile	手机号
     * @param userId	用户ID 用户标识
     * @return
     */
    @ResponseBody
    @RequestMapping("AntiFraud")
    public Map<String, Object> AntiFraud(String name,String idNumber,String mobile,Integer userId){
    	MapUtil maps = new MapUtil();
    	Map<String, Object> map = new HashMap<String, Object>();
    	 String code = "200230";//代码（固定不变）
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
             map.put("code", 0);
             return map;
         }
         String json = postHtml(url, post_data);
         CheatReturn cheat = JSON.parseObject(json, CheatReturn.class);
         if(json!=null){
        	 if(cheat.getResponseCode()==100){
        		 Usercheat user = new Usercheat();
        		 user.setId(userId);
        		 user.setPhone(mobile);
        		 user.setUsername(name);
        		 user.setIdNumber(idNumber);
        		 user.setFraudScore(cheat.getData().getFraudScore());
        		 user.setFraudReasonCode(cheat.getData().getFraudReasonCode());
        		 Integer addId = fser.AddAntiFraud(user);
        		 if(addId!=null){
        			 map.put("Ncode", 2000);
        			 map.put("code", 200);
        			 map.put("CheatReturn", cheat);
        			 map.put("msg", "插入成功");
        		 }else{
        			 map.put("Ncode", 0);
        			 map.put("code", 401);
        			 map.put("CheatReturn", cheat);
        			 map.put("msg", "插入失败"); 
        		 }
        		 
        	 }else{
        		 map.put("Ncode", 0);
    			 map.put("code", 402);
    			 map.put("msg", maps.getMap(String.valueOf(cheat.getResponseCode())));
        	 }
         }else{
        	 map.put("Ncode", 0);
        	 map.put("msg", maps.getMap(String.valueOf(cheat.getResponseCode())));
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
     * 查询反欺诈分数
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("SelectAnti_fraud")
    public Map<String, Object> SelectAnti_fraud(Usercheat user){
    	return fser.SelectAnti_fraud(user);
    }
    
    
    /**
     * 查询逾期
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("SelectBeoverdue")
    public Map<String, Object> SelectBeoverdue(Beoverdue user){
    	return fser.SelectBeoverdue(user);
    }
    
    
    /**
     * 查询用户画像
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("SelectUserportrait")
    public Map<String, Object> SelectUserportrait(Userportrait user){
    	return fser.SelectUserportrait(user);
    }
    
    
    /**
     * 查询共债
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("SelectJointobligation")
    public Map<String, Object> SelectJointobligation(Jointobligation user){
    	return fser.SelectJointobligation(user);
    }
    
    
    
    /**
     * 用户手机信息
     * @param args
     */
    @ResponseBody
    @RequestMapping("AddUserPhone")
    public Map<String, Object> UserPhone(@RequestBody String jsonString){
    	return fser.AddUserPhone(jsonString);   
    }
    
    
    
    
    /**
     * 用户手机信息
     * @param args
     */
    @ResponseBody
    @RequestMapping("AllUserPhone")
    public Map<String, Object> AllUserPhone(){
    	return fser.AllUserPhone();
    }
    
    
    public static void main(String[] args) {
		Anti_fraudController ant = new Anti_fraudController();
		String name ="";
		String mobile = "";
		String idNumber = "";
		Integer userId = 4;
		ant.AntiFraud(name, idNumber, mobile,userId);
	}

}

package com.zhita.Collection.userportrait;

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
import com.zhita.Collection.beoverdue.MapUtil;
import com.zhita.Model.Userportrait;
import com.zhita.Service.FengService;
import com.zhita.Util.AESUtil;


@Controller
@RequestMapping("userport")
public class UserportraitController {

	
	static String account = "csdkkj145";
	
    static String key = "Absfxs58AT53Xanh95LSzA5TZ4c3i5Mb";
    
    static String url = "https://service.hicore.com/api";
    
    @Autowired
    private FengService fser;

    
    
    /**
     * 
     * @param username
     * @param userId
     * @param phone
     * @param idNumber
     * @return	用户画像
     */
    @ResponseBody
    @RequestMapping("OneUserportrait")
    public Map<String, Object> OneUserportrait(String username,Integer userId,String phone,String idNumber) {
    	MapUtil maps = new MapUtil();
    	Map<String, Object> map = new HashMap<String, Object>();
        String code = "200200";// 代码（固定不变）
        String mobile = phone;// 手机号码 （必须加密，必填）
        String idnumber = idNumber;// 身份证号 （必须加密，选填）
		String name = username;// 姓名 （明文，选填）
        String enctype = "0";// 加密方式
        String clientNo = String.valueOf(userId);// 客户自己定义，可忽略
        String param = AESUtil.encrypt(key, "mobile=" + mobile + "&idnumber=" + idnumber + "&name=" + name + "&enctype=" + enctype + "&clientno=" + clientNo);
        String sign = AESUtil.md5(code + param + account + AESUtil.md5(key));// 生成签名
        String post_data = null;
        try {
            post_data = "code=" + code + "&param=" + URLEncoder.encode(param, "UTF-8") + "&account=" + account
                    + "&sign=" + sign;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return map;
        }
        String json = postHtml(url, post_data);
        UserportraitReturn us = JSON.parseObject(json, UserportraitReturn.class);
        Userportrait userpor = new Userportrait();
        userpor.setIdnumber(idnumber);
        userpor.setOrgcombination(us.getData().getOrgcombination());
        userpor.setPhone(phone);
        userpor.setUserId(userId);
        userpor.setUsername(username);
        userpor.setResponselevel(us.getData().getResponselevel());
        userpor.setRisklevel(us.getData().getRisklevel());
        if(us!=null){
        	if(us.getData()!=null){
        		if(us.getResponseCode()==100){
                	Integer a = fser.AddUserportrait(userpor);
                	if(a==1){
                		map.put("msg", "插入成功");
                		map.put("code", 200);
                		map.put("desc", userpor);
                	}else{
                		map.put("msg", "插入失败");
                		map.put("code", 0);
                		map.put("desc", userpor);
                	}
                }else{
                	map.put("code", 0);
                	map.put("msg", maps.getMap(String.valueOf(us.getResponseCode())));
                }
        	}
        }
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
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
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
     * 添加通讯录
     * @param jsonlist
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping("AddMaillist")
    public Map<String, Object> AddMaillist(String jsonlist,String phone){
    	return fser.AddMaillist(jsonlist,phone);
    }
}

package com.zhita.Collection.jointobligation;

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
import com.zhita.Service.FengService;
import com.zhita.Util.AESUtil;



@Controller
@RequestMapping("Join")
public class JointobligationController {

	static String account = "csdkkj145";
	
    static String key = "Absfxs58AT53Xanh95LSzA5TZ4c3i5Mb";
    
    static String url = "https://service.hicore.com/api";
    
    @Autowired
    private FengService fser;
    
    
    
    /**
     * @param name		用户姓名
     * @param idNumber	身份证号
     * @param mobile	手机号
     * @param clientNo	用户标识  用户ID
     * @return	共债接口
     */
    @ResponseBody
    @RequestMapping("Jointobligation")
    public Map<String, Object> Jointobligation(String name,String idNumber,String mobile,Integer userId){
    	Map<String, Object> map = new HashMap<String, Object>();
    	MapUtil maps = new MapUtil();
        String code = "102170";//代码（固定不变）
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
            map.put("Ncode", 0);
            map.put("code", 500);
            map.put("msg", "数据异常");
            return map;
        }
        String json = postHtml(url, post_data);
        JointobligatReturn join = JSON.parseObject(json, JointobligatReturn.class);
        Data data = join.getData();
        data.setUsername(name);
        data.setUserId(userId);
        data.setIdNumber(idNumber);
        data.setPhone(mobile);
        if(join != null){
        	if(join.getData()!=null){
        		if(join.getResponseCode()==100){
            		int a = fser.AddJointobligation(data);
            		if(a==1){
            			 map.put("JointobligatReturn", join);
                         map.put("msg", "插入成功");
                         map.put("Ncode", 2000);
                         map.put("code", 200);
            		}else{
            			map.put("JointobligatReturn", join);
                        map.put("msg", "插入失败");
                        map.put("Ncode", 405);
                        map.put("code", 405);
            		}
                   
            	}else{
            		map.put("JointobligatReturn", join);
            		map.put("msg", maps.getMap(String.valueOf(join.getResponseCode())));
                    map.put("Ncode", 0);
                    map.put("code", 0);
            	}
        	}
        }
        //返回的json即为查询结果
        
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
    
    
    
    
    
    
    public static void main(String[] args) {
		
    
        JointobligationController jo = new JointobligationController();
	}
	
}

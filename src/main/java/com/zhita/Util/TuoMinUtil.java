package com.zhita.Util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


@Component
public class TuoMinUtil {
    // 手机号码前三后四脱敏
	
	
	
	public static TuoMinUtil tuoMinUtil;

	  @PostConstruct
	  public void init() {    
		  tuoMinUtil = this;
	  } 

	
	
    public String mobileEncrypt(String mobile) {
        if (StringUtils.isEmpty(mobile) || (mobile.length() != 11)) {
            return mobile;
        }
        String config = "1";
        if(config.equals("1")){
        	 return mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        }else if(config.equals("2")){
        	return mobile;
        }else{
        	return null;
        }
       
    }

    //身份证前三后四脱敏
    public String idEncrypt(String id) {
        if (StringUtils.isEmpty(id) || (id.length() < 8)) {
            return id;
        }
        return id.replaceAll("(?<=\\w{3})\\w(?=\\w{4})", "*");
    }
    
    //名字脱敏
//    public String formatToMask(int start ,int end ,String src){
//    	if (StringUtils.isEmpty(src)) {
//    		return "" ;
//    	}
//    	String regex = "(\\w{"+start+"})(\\w+)(\\w{"+end+"})";
//    	src.replaceAll(regex, "$1**********$3");
//    	return "";
//    	       
//    	    }
    
    public String nameEncrypt(String name) {  
    	String aString ="*";
    	if(name.length()==2) {
    	return name.replaceAll(name.substring(1,2),"*");   	
    	}
    	if(name.length()>2) {
        for(int i =1;i< name.length()-2;i++) {
        	aString+=aString;
        }
        String first = name.substring(0,1);
        String last =name.substring(name.length()-1,name.length());
        String string = first+aString+last;
        return string;
    	}
		return "";
    }
    public static void main(String[] args) {
		TuoMinUtil to = new TuoMinUtil();
		String aString = to.mobileEncrypt("13487139655");
		System.out.println("手机号:"+aString);
	}

    
    
}

package com.zhita.Model;


/**
 * 规则详情表
 * @author Administrator
 *
 */
public class Rulelist_detail {
	
	private Integer id;
	
	private Integer rtid;
	
	private Integer rid;
	
	private String sum;//该规则分类的总扣分
	
	private String type;//规则分类名

	private Integer userid;//用户id
	
	private String value_at_risk;//规则的风险分值
	
	private String authentication_time;//同步规则表的认证时间
	
	private String username;//姓名
	
	private String thresholdvalue;//阈值
	
	private String fraction;//最后得分

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRtid() {
		return rtid;
	}

	public void setRtid(Integer rtid) {
		this.rtid = rtid;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getValue_at_risk() {
		return value_at_risk;
	}

	public void setValue_at_risk(String value_at_risk) {
		this.value_at_risk = value_at_risk;
	}

	public String getAuthentication_time() {
		return authentication_time;
	}

	public void setAuthentication_time(String authentication_time) {
		this.authentication_time = authentication_time;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getThresholdvalue() {
		return thresholdvalue;
	}

	public void setThresholdvalue(String thresholdvalue) {
		this.thresholdvalue = thresholdvalue;
	}

	public String getFraction() {
		return fraction;
	}

	public void setFraction(String fraction) {
		this.fraction = fraction;
	}

}

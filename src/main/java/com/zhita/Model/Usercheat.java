package com.zhita.Model;

//用户反欺诈分数表
public class Usercheat {
	
	private Integer id;
	
	private String username;//姓名
	
	private String phone;//手机号
	
	private String idNumber;//身份证号
	
	private Integer fraudScore;//反欺诈评分
	
	private String fraudReasonCode;//反欺诈原因码
	
	private String send_time;
	
	private Integer page=0;
	
	private Integer pagesize=10;

	public String getSend_time() {
		return send_time;
	}

	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPagesize() {
		return pagesize;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public Integer getFraudScore() {
		return fraudScore;
	}

	public void setFraudScore(Integer fraudScore) {
		this.fraudScore = fraudScore;
	}

	public String getFraudReasonCode() {
		return fraudReasonCode;
	}

	public void setFraudReasonCode(String fraudReasonCode) {
		this.fraudReasonCode = fraudReasonCode;
	}
	
	
	
}	

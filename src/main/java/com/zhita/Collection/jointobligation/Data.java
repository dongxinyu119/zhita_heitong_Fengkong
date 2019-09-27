package com.zhita.Collection.jointobligation;

public class Data {
	
	private Integer userId;//用户标识
	
	private String username;//用户名称
	
	private String phone;//手机号
	
	private String idNumber;//身份证号
	
	private String L7D_714_DEBT_PCNT;//近 7 天(包含 7 天)，场景类型为超利贷，其共债总平台数
	
	private String L7D_714_DEBT_TOTAMT;//近 7 天(包含 7 天)，场景类型为超利贷，其共债金额  取A-K
	
	private String L7D_ONLINE_DEBT_PCNT;//近 7 天(包含 7 天)，场景类型为网贷，其共债总平台数
	
	private String L7D_ONLINE_DEBT_TOTAMT;//近 7 天(包含 7 天)，场景类型为网贷，其共债金额
	
	private String L7D_CUSTOMER_DEBT_PCNT;//近 7 天(包含 7 天)，场景类型为消费金融，其共债总平台数
	
	private String L7D_CUSTOMER_DEBT_TOTAMT;//近 7 天(包含 7 天)，场景类型为消费金融，其共债金额
	
	private String L7D_UNBANK_DEBT_PCNT;//近 7 天(包含 7 天)，非银场景类型，其共债总平台数
	
	private String L7D_UNBANK_DEBT_TOTAMT;//近 7 天(包含 7 天)，非银场景类型，其共债金额
	
	private String L30D_714_DEBT_PCNT;//近 30 天(包含 30 天)，场景类型为超利贷，其共债总平台数

	private String L30D_714_DEBT_TOTAMT;//近 30 天(包含 30 天)，场景类型为超利贷，其共债金额
	
	private String L30D_ONLINE_DEBT_PCNT;//近 30 天(包含 30 天)，场景类型为网贷，其共债总平台数
	
	private String L30D_ONLINE_DEBT_TOTAMT;//近 30 天(包含 30 天)，场景类型为网贷，其共债金额
	
	private String L30D_CUSTOMER_DEBT_PCNT;//近 30 天(包含 30 天)，场景类型为消费金融，其共债总平台数
	
	private String L30D_CUSTOMER_DEBT_TOTAMT;//近 30 天(包含 30 天)，场景类型为消费金融，其共债金额
	
	private String L30D_UNBANK_DEBT_PCNT;//近 30 天(包含 30 天)，非银场景类型，其共债总平台数
	
	private String L30D_UNBANK_DEBT_TOTAMT;//近 30 天(包含 30 天)，非银场景类型，其共债金额
	
	private String L3M_714_DEBT_PCNT;//近 3 个月（自然月，不包含当月）场景类型为超利贷，其共债总平台数
	
	private String L3M_714_DEBT_TOTAMT;//近 3 个月（自然月，不包含当月）场景类型为超利贷，其共债金额
	
	private String L3M_ONLINE_DEBT_PCNT;//近 3 个月（自然月，不包含当月）场景类型为网贷，其共债总平台数
	
	private String L3M_ONLINE_DEBT_TOTAMT;//近 3 个月（自然月，不包含当月）场景类型为网贷，其共债金额
	
	private String L3M_CUSTOMER_DEBT_PCNT;//近 3 个月（自然月，不包含当月）场景类型为消费金融，其共债总平台数
	
	private String L3M_CUSTOMER_DEBT_TOTAMT;//近 3 个月（自然月，不包含当月）场景类型为消费金融，其共债金额
	
	private String L3M_UNBANK_DEBT_PCNT;//近 3 个月（自然月，不包含当月）非银场景类型，其共债总平台数
	
	private String L3M_UNBANK_DEBT_TOTAMT;//近 3 个月（自然月，不包含当月）非银场景类型，其共债金额
	
	private String send_time;

	public String getSend_time() {
		return send_time;
	}

	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getL7D_714_DEBT_PCNT() {
		return L7D_714_DEBT_PCNT;
	}

	public void setL7D_714_DEBT_PCNT(String l7d_714_DEBT_PCNT) {
		L7D_714_DEBT_PCNT = l7d_714_DEBT_PCNT;
	}

	public String getL7D_714_DEBT_TOTAMT() {
		return L7D_714_DEBT_TOTAMT;
	}

	public void setL7D_714_DEBT_TOTAMT(String l7d_714_DEBT_TOTAMT) {
		L7D_714_DEBT_TOTAMT = l7d_714_DEBT_TOTAMT;
	}

	public String getL7D_ONLINE_DEBT_PCNT() {
		return L7D_ONLINE_DEBT_PCNT;
	}

	public void setL7D_ONLINE_DEBT_PCNT(String l7d_ONLINE_DEBT_PCNT) {
		L7D_ONLINE_DEBT_PCNT = l7d_ONLINE_DEBT_PCNT;
	}

	public String getL7D_ONLINE_DEBT_TOTAMT() {
		return L7D_ONLINE_DEBT_TOTAMT;
	}

	public void setL7D_ONLINE_DEBT_TOTAMT(String l7d_ONLINE_DEBT_TOTAMT) {
		L7D_ONLINE_DEBT_TOTAMT = l7d_ONLINE_DEBT_TOTAMT;
	}

	public String getL7D_CUSTOMER_DEBT_PCNT() {
		return L7D_CUSTOMER_DEBT_PCNT;
	}

	public void setL7D_CUSTOMER_DEBT_PCNT(String l7d_CUSTOMER_DEBT_PCNT) {
		L7D_CUSTOMER_DEBT_PCNT = l7d_CUSTOMER_DEBT_PCNT;
	}

	public String getL7D_CUSTOMER_DEBT_TOTAMT() {
		return L7D_CUSTOMER_DEBT_TOTAMT;
	}

	public void setL7D_CUSTOMER_DEBT_TOTAMT(String l7d_CUSTOMER_DEBT_TOTAMT) {
		L7D_CUSTOMER_DEBT_TOTAMT = l7d_CUSTOMER_DEBT_TOTAMT;
	}

	public String getL7D_UNBANK_DEBT_PCNT() {
		return L7D_UNBANK_DEBT_PCNT;
	}

	public void setL7D_UNBANK_DEBT_PCNT(String l7d_UNBANK_DEBT_PCNT) {
		L7D_UNBANK_DEBT_PCNT = l7d_UNBANK_DEBT_PCNT;
	}

	public String getL7D_UNBANK_DEBT_TOTAMT() {
		return L7D_UNBANK_DEBT_TOTAMT;
	}

	public void setL7D_UNBANK_DEBT_TOTAMT(String l7d_UNBANK_DEBT_TOTAMT) {
		L7D_UNBANK_DEBT_TOTAMT = l7d_UNBANK_DEBT_TOTAMT;
	}

	public String getL30D_714_DEBT_PCNT() {
		return L30D_714_DEBT_PCNT;
	}

	public void setL30D_714_DEBT_PCNT(String l30d_714_DEBT_PCNT) {
		L30D_714_DEBT_PCNT = l30d_714_DEBT_PCNT;
	}

	public String getL30D_714_DEBT_TOTAMT() {
		return L30D_714_DEBT_TOTAMT;
	}

	public void setL30D_714_DEBT_TOTAMT(String l30d_714_DEBT_TOTAMT) {
		L30D_714_DEBT_TOTAMT = l30d_714_DEBT_TOTAMT;
	}

	public String getL30D_ONLINE_DEBT_PCNT() {
		return L30D_ONLINE_DEBT_PCNT;
	}

	public void setL30D_ONLINE_DEBT_PCNT(String l30d_ONLINE_DEBT_PCNT) {
		L30D_ONLINE_DEBT_PCNT = l30d_ONLINE_DEBT_PCNT;
	}

	public String getL30D_ONLINE_DEBT_TOTAMT() {
		return L30D_ONLINE_DEBT_TOTAMT;
	}

	public void setL30D_ONLINE_DEBT_TOTAMT(String l30d_ONLINE_DEBT_TOTAMT) {
		L30D_ONLINE_DEBT_TOTAMT = l30d_ONLINE_DEBT_TOTAMT;
	}

	public String getL30D_CUSTOMER_DEBT_PCNT() {
		return L30D_CUSTOMER_DEBT_PCNT;
	}

	public void setL30D_CUSTOMER_DEBT_PCNT(String l30d_CUSTOMER_DEBT_PCNT) {
		L30D_CUSTOMER_DEBT_PCNT = l30d_CUSTOMER_DEBT_PCNT;
	}

	public String getL30D_CUSTOMER_DEBT_TOTAMT() {
		return L30D_CUSTOMER_DEBT_TOTAMT;
	}

	public void setL30D_CUSTOMER_DEBT_TOTAMT(String l30d_CUSTOMER_DEBT_TOTAMT) {
		L30D_CUSTOMER_DEBT_TOTAMT = l30d_CUSTOMER_DEBT_TOTAMT;
	}

	public String getL30D_UNBANK_DEBT_PCNT() {
		return L30D_UNBANK_DEBT_PCNT;
	}

	public void setL30D_UNBANK_DEBT_PCNT(String l30d_UNBANK_DEBT_PCNT) {
		L30D_UNBANK_DEBT_PCNT = l30d_UNBANK_DEBT_PCNT;
	}

	public String getL30D_UNBANK_DEBT_TOTAMT() {
		return L30D_UNBANK_DEBT_TOTAMT;
	}

	public void setL30D_UNBANK_DEBT_TOTAMT(String l30d_UNBANK_DEBT_TOTAMT) {
		L30D_UNBANK_DEBT_TOTAMT = l30d_UNBANK_DEBT_TOTAMT;
	}

	public String getL3M_714_DEBT_PCNT() {
		return L3M_714_DEBT_PCNT;
	}

	public void setL3M_714_DEBT_PCNT(String l3m_714_DEBT_PCNT) {
		L3M_714_DEBT_PCNT = l3m_714_DEBT_PCNT;
	}

	public String getL3M_714_DEBT_TOTAMT() {
		return L3M_714_DEBT_TOTAMT;
	}

	public void setL3M_714_DEBT_TOTAMT(String l3m_714_DEBT_TOTAMT) {
		L3M_714_DEBT_TOTAMT = l3m_714_DEBT_TOTAMT;
	}

	public String getL3M_ONLINE_DEBT_PCNT() {
		return L3M_ONLINE_DEBT_PCNT;
	}

	public void setL3M_ONLINE_DEBT_PCNT(String l3m_ONLINE_DEBT_PCNT) {
		L3M_ONLINE_DEBT_PCNT = l3m_ONLINE_DEBT_PCNT;
	}

	public String getL3M_ONLINE_DEBT_TOTAMT() {
		return L3M_ONLINE_DEBT_TOTAMT;
	}

	public void setL3M_ONLINE_DEBT_TOTAMT(String l3m_ONLINE_DEBT_TOTAMT) {
		L3M_ONLINE_DEBT_TOTAMT = l3m_ONLINE_DEBT_TOTAMT;
	}

	public String getL3M_CUSTOMER_DEBT_PCNT() {
		return L3M_CUSTOMER_DEBT_PCNT;
	}

	public void setL3M_CUSTOMER_DEBT_PCNT(String l3m_CUSTOMER_DEBT_PCNT) {
		L3M_CUSTOMER_DEBT_PCNT = l3m_CUSTOMER_DEBT_PCNT;
	}

	public String getL3M_CUSTOMER_DEBT_TOTAMT() {
		return L3M_CUSTOMER_DEBT_TOTAMT;
	}

	public void setL3M_CUSTOMER_DEBT_TOTAMT(String l3m_CUSTOMER_DEBT_TOTAMT) {
		L3M_CUSTOMER_DEBT_TOTAMT = l3m_CUSTOMER_DEBT_TOTAMT;
	}

	public String getL3M_UNBANK_DEBT_PCNT() {
		return L3M_UNBANK_DEBT_PCNT;
	}

	public void setL3M_UNBANK_DEBT_PCNT(String l3m_UNBANK_DEBT_PCNT) {
		L3M_UNBANK_DEBT_PCNT = l3m_UNBANK_DEBT_PCNT;
	}

	public String getL3M_UNBANK_DEBT_TOTAMT() {
		return L3M_UNBANK_DEBT_TOTAMT;
	}

	public void setL3M_UNBANK_DEBT_TOTAMT(String l3m_UNBANK_DEBT_TOTAMT) {
		L3M_UNBANK_DEBT_TOTAMT = l3m_UNBANK_DEBT_TOTAMT;
	}
	
	

}

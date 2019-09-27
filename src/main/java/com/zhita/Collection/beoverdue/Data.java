package com.zhita.Collection.beoverdue;

public class Data {
	
	private Integer id;
	
	private Integer userId;
	
	private String username;
	
	private String phone;
	
	private String idcardnumber;
	
	private String L7D_714_OVERDUE_PCNT;//近 7 天(包含 7 天)，场景类型为超利贷，其逾期总平台数

	private String L7D_714_OVERDUE_TOTAMT;//近 7 天(包含 7 天)，场景类型为超利贷，其逾期逾期总金额
	
	private String L7D_714_H1OVERDUE_PCNT;//近 7 天(包含 7 天)，场景类型为超利贷，其严重逾期(M4+)总平台数
	
	private String L7D_714_H1OVERDUE_TOTAMT;//近 7 天(包含 7 天)，场景类型为超利贷，其严重逾期(M4+)逾期总金额
	
	private String L7D_714_MOVERDUE_PCNT;//近 7 天(包含 7 天)，场景类型为超利贷，其逾期（逾期天数>=8）总平台数
	
	private String L7D_714_MOVERDUE_TOTAMT;//近 7 天(包含 7 天)，场景类型为超利贷，其逾期（逾期天数>=8）逾期总金额
	
	private String L7D_ONLINE_OVERDUE_PCNT;//近 7 天(包含 7 天)，场景类型为网贷，其逾期总平台数
	
	private String L7D_ONLINE_OVERDUE_TOTAMT;//近 7 天(包含 7 天)，场景类型为网贷，其逾期逾期总金额
	
	private String L7D_ONLINE_H1OVERDUE_PCNT;//近 7 天(包含 7 天)，场景类型为网贷，其严重逾期(M4+)总平台数
	
	private String L7D_ONLINE_H1OVERDUE_TOTAMT;//近 7 天(包含 7 天)，场景类型为网贷，其严重逾期(M4+)逾期总金额
	
	private String L7D_ONLINE_MOVERDUE_PCNT;//近 7 天(包含 7 天)，场景类型为网贷，其逾期（逾期天数>=8）总平台数
	
	private String L7D_ONLINE_MOVERDUE_TOTAMT;//近 7 天(包含 7 天)，场景类型为网贷，其逾期（逾期天数>=8）逾期总金额
	
	private String L7D_CUSTOMER_OVERDUE_PCNT;//近 7 天(包含 7 天)，场景类型为消费金融，其逾期总平台数

	private String L7D_CUSTOMER_OVERDUE_TOTAMT;//近 7 天(包含 7 天)，场景类型为消费金融，其逾期逾期总金额
	
	private String L7D_CUSTOMER_H1OVERDUE_PCNT;//近 7 天(包含 7 天)，场景类型为消费金融，其严重逾期(M4+)总平台数

	private String L7D_CUSTOMER_H1OVERDUE_TOTAMT;//近 7 天(包含 7 天)，场景类型为消费金融，其严重逾期(M4+)逾期总金额

	private String L7D_CUSTOMER_MOVERDUE_PCNT;//近 7 天(包含 7 天)，场景类型为消费金融，其逾期（逾期天数>=8）总平台数
	
	private String L7D_CUSTOMER_MOVERDUE_TOTAMT;//近 7 天(包含 7 天)，场景类型为消费金融，其逾期（逾期天数>=8）逾期总金额
	
	private String L7D_BANK_OVERDUE_PCNT;//近 7 天(包含 7 天)，场景类型为银行，其逾期总平台数
	
	private String L7D_BANK_OVERDUE_TOTAMT;//近 7 天(包含 7 天)，场景类型为银行，其逾期逾期总金额
	
	private String L7D_BANK_H1OVERDUE_PCNT;//近 7 天(包含 7 天)，场景类型为银行，其严重逾期(M4+)总平台数
	
	private String L7D_BANK_H1OVERDUE_TOTAMT;//近 7 天(包含 7 天)，场景类型为银行，其严重逾期(M4+)逾期总金额
	
	private String L7D_BANK_MOVERDUE_PCNT;//近 7 天(包含 7 天)，场景类型为银行，其逾期（逾期天数>=8）总平台数
	
	private String L7D_BANK_MOVERDUE_TOTAMT;//近 7 天(包含 7 天)，场景类型为银行，其逾期（逾期天数>=8）逾期总金额
	
	private String L7D_TOTORG_OVERDUE_PCNT;//近 7 天(包含 7 天)，所有场景，其逾期总平台数
	
	private String L7D_TOTORG_OVERDUE_TOTAMT;//近 7 天(包含 7 天)，所有场景，其逾期逾期总金额
	
	private String L7D_TOTORG_H1OVERDUE_PCNT;//近 7 天(包含 7 天)，所有场景，其严重逾期(M4+)总平台数
	
	private String L7D_TOTORG_H1OVERDUE_TOTAMT;//近 7 天(包含 7 天)，所有场景，其严重逾期(M4+)逾期总金额
	
	private String L7D_TOTORG_MOVERDUE_PCNT;//近 7 天(包含 7 天)，所有场景，其逾期（逾期天数>=8）总平台数
	
	private String L7D_TOTORG_MOVERDUE_TOTAMT;//近 7 天(包含 7 天)，所有场景，其逾期（逾期天数>=8）逾期总金额
	
	private String L30D_714_OVERDUE_PCNT;//近 30 天(包含 30 天)，场景类型为超利贷，其逾期总平台数
	
	private String L30D_714_OVERDUE_TOTAMT;//近 30 天(包含 30 天)，场景类型为超利贷，其逾期逾期总金额
	
	private String L30D_714_H1OVERDUE_PCNT;//近 30 天(包含 30 天)，场景类型为超利贷，其严重逾期(M4+)总平台数
	
	private String L30D_714_H1OVERDUE_TOTAMT;//近 30 天(包含 30 天)，场景类型为超利贷，其严重逾期(M4+)逾期总金额
	
	private String L30D_714_MOVERDUE_PCNT;//近 30 天(包含 30 天)，场景类型为超利贷，其逾期（逾期天数>=8）总平台数
	
	private String L30D_714_MOVERDUE_TOTAMT;//近 30 天(包含 30 天)，场景类型为超利贷，其逾期（逾期天数>=8）逾期总金额
	
	private String L30D_ONLINE_OVERDUE_PCNT;//近 30 天(包含 30 天)，场景类型为网贷，其逾期总平台数
	
	private String L30D_ONLINE_OVERDUE_TOTAMT;//近 30 天(包含 30 天)，场景类型为网贷，其逾期逾期总金额
	
	private String L30D_ONLINE_H1OVERDUE_PCNT;//近 30 天(包含 30 天)，场景类型为网贷，其严重逾期(M4+)总平台数
	
	private String L30D_ONLINE_H1OVERDUE_TOTAMT;//近 30 天(包含 30 天)，场景类型为网贷，其严重逾期(M4+)逾期总金额
	
	private String L30D_ONLINE_MOVERDUE_PCNT;//近 30 天(包含 30 天)，场景类型为网贷，其逾期（逾期天数>=8）总平台数
	
	private String L30D_ONLINE_MOVERDUE_TOTAMT;//近 30 天(包含 30 天)，场景类型为网贷，其逾期（逾期天数>=8）逾期总金额
	
	private String L30D_CUSTOMER_OVERDUE_PCNT;//近 30 天(包含 30 天)，场景类型为消费金融，其逾期总平台数
	
	private String L30D_CUSTOMER_OVERDUE_TOTAMT;//近 30 天(包含 30 天)，场景类型为消费金融，其逾期逾期总金额
	
	private String L30D_CUSTOMER_H1OVERDUE_PCNT;//近 30 天(包含 30 天)，场景类型为消费金融，其严重逾期(M4+)总平台数
	
	private String L30D_CUSTOMER_H1OVERDUE_TOTAMT;//近 30 天(包含 30 天)，场景类型为消费金融，其严重逾期(M4+)逾期总金额
	
	private String L30D_CUSTOMER_MOVERDUE_PCNT;//近 30 天(包含 30 天)，场景类型为消费金融，其逾期（逾期天数>=8）总平台数
	
	private String L30D_CUSTOMER_MOVERDUE_TOTAMT;//近 30 天(包含 30 天)，场景类型为消费金融，其逾期（逾期天数>=8）逾期总金额
	
	private String L30D_BANK_OVERDUE_PCNT;//近 30 天(包含 30 天)，场景类型为银行，其逾期总平台数
	
	private String L30D_BANK_OVERDUE_TOTAMT;//近 30 天(包含 30 天)，场景类型为银行，其逾期逾期总金额
	
	private String L30D_BANK_H1OVERDUE_PCNT;//近 30 天(包含 30 天)，场景类型为银行，其严重逾期(M4+)总平台数
	
	private String L30D_BANK_H1OVERDUE_TOTAMT;//近 30 天(包含 30 天)，场景类型为银行，其严重逾期(M4+)逾期总金额
	
	private String L30D_BANK_MOVERDUE_PCNT;//近 30 天(包含 30 天)，场景类型为银行，其逾期（逾期天数>=8）总平台数
	
	private String L30D_BANK_MOVERDUE_TOTAMT;//近 30 天(包含 30 天)，场景类型为银行，其逾期（逾期天数>=8）逾期总金额
	
	private String L30D_TOTORG_OVERDUE_PCNT;//近 30 天(包含 30 天)，所有场景，其逾期总平台数
	
	private String L30D_TOTORG_OVERDUE_TOTAMT;//近 30 天(包含 30 天)，所有场景，其逾期逾期总金额
	
	private String L30D_TOTORG_H1OVERDUE_PCNT;//近 30 天(包含 30 天)，所有场景，其严重逾期(M4+)总平台数
	
	private String L30D_TOTORG_H1OVERDUE_TOTAMT;//近 30 天(包含 30 天)，所有场景，其严重逾期(M4+)逾期总金额
	
	private String L30D_TOTORG_MOVERDUE_PCNT;//近 30 天(包含 30 天)，所有场景，其逾期（逾期天数>=8）总平台数
	
	private String L30D_TOTORG_MOVERDUE_TOTAMT;//近 30 天(包含 30 天)，所有场景，其逾期（逾期天数>=8）逾期总金额
	
	private String L3M_714_OVERDUE_PCNT;//近 3 个月（自然月，不包含当月）场景类型为超利贷，其逾期总平台数
	
	private String L3M_714_OVERDUE_TOTAMT;//近 3 个月（自然月，不包含当月）场景类型为超利贷，其逾期逾期总金额
	
	private String L3M_714_H1OVERDUE_PCNT;//近 3 个月（自然月，不包含当月）场景类型为超利贷，其严重逾期(M4+)总平台数
	
	private String L3M_714_H1OVERDUE_TOTAMT;//近 3 个月（自然月，不包含当月）场景类型为超利贷，其严重逾期(M4+)逾期总金额
	
	private String L3M_714_MOVERDUE_PCNT;//近 3 个月（自然月，不包含当月）场景类型为超利贷，其逾期（逾期天数>=8）总平台数
	
	private String L3M_714_MOVERDUE_TOTAMT;//近 3 个月（自然月，不包含当月）场景类型为超利贷，其逾期（逾期天数>=8）逾期总金额
	
	private String L3M_ONLINE_OVERDUE_PCNT;//近 3 个月（自然月，不包含当月）场景类型为网贷，其逾期总平台数
	
	private String L3M_ONLINE_OVERDUE_TOTAMT;//近 3 个月（自然月，不包含当月）场景类型为网贷，其逾期逾期总金额
	
	private String L3M_ONLINE_H1OVERDUE_PCNT;//近 3 个月（自然月，不包含当月）场景类型为网 贷 ， 其 严 重 逾 期(M4+)总平台数
	
	private String L3M_ONLINE_H1OVERDUE_TOTAMT;//近 3 个月（自然月，不包含当月）场景类型为网 贷 ， 其 严 重 逾 期(M4+)逾期总金额
	
	private String L3M_ONLINE_MOVERDUE_PCNT;//近 3 个月（自然月，不包含当月）场景类型为网贷，其逾期（逾期天数>=8）总平台数
	
	private String L3M_ONLINE_MOVERDUE_TOTAMT;//近 3 个月（自然月，不包含当月）场景类型为网贷，其逾期（逾期天数>=8）逾期总金额
	
	private String L3M_CUSTOMER_OVERDUE_PCNT;//近 3 个月（自然月，不包含当月）场景类型为消费金融，其逾期总平台

	private String L3M_CUSTOMER_OVERDUE_TOTAMT;//近 3 个月（自然月，不包含当月）场景类型为消费金融，其逾期逾期总金额
	
	private String L3M_CUSTOMER_H1OVERDUE_PCNT;//近 3 个月（自然月，不包含当月）场景类型为消费金融，其严重逾期(M4+)总平台数
	
	private String L3M_CUSTOMER_H1OVERDUE_TOTAMT;//近 3 个月（自然月，不包含当月）场景类型为消费金融，其严重逾期(M4+)逾期总金额
	
	private String L3M_CUSTOMER_MOVERDUE_PCNT;//近 3 个月（自然月，不包含当月）场景类型为消费金融，其逾期（逾期天数>=8）总平台数
	
	private String L3M_CUSTOMER_MOVERDUE_TOTAMT;//近 3 个月（自然月，不包含当月）场景类型为消费金融，其逾期（逾期天数>=8）逾期总金额
	
	private String L3M_BANK_OVERDUE_PCNT;//近 3 个月（自然月，不包含当月）场景类型为银行，其逾期总平台数
	
	private String L3M_BANK_OVERDUE_TOTAMT;//近 3 个月（自然月，不包含当月）场景类型为银行，其逾期逾期总金额
	
	private String L3M_BANK_H1OVERDUE_PCNT;//近 3 个月（自然月，不包含当月）场景类型为银 行 ， 其 严 重 逾 期(M4+)总平台数
	
	private String L3M_BANK_H1OVERDUE_TOTAMT;//近 3 个月（自然月，不包含当月）场景类型为银 行 ， 其 严 重 逾 期(M4+)逾期总金额
	
	private String L3M_BANK_MOVERDUE_PCNT;//近 3 个月（自然月，不包含当月）场景类型为银行，其逾期（逾期天数>=8）总平台数
	
	private String L3M_BANK_MOVERDUE_TOTAMT;//近 3 个月（自然月，不包含当月）场景类型为银行，其逾期（逾期天数>=8）逾期总金额
	
	private String L3M_TOTORG_OVERDUE_PCNT;//近 3 个月（自然月，不包含当月）所有场景，其逾期总平台数
	
	private String L3M_TOTORG_OVERDUE_TOTAMT;//近 3 个月（自然月，不包含当月）所有场景，其逾期逾期总金额
	
	private String L3M_TOTORG_H1OVERDUE_PCNT;//近 3 个月（自然月，不包含当月）所有场景，其严重逾期(M4+)总平台数
	
	private String L3M_TOTORG_H1OVERDUE_TOTAMT;//近 3 个月（自然月，不包含当月）所有场景，其严重逾期(M4+)逾期总金额
	
	private String L3M_TOTORG_MOVERDUE_PCNT;//近 3 个月（自然月，不包含当月）所有场景，其逾期（逾期天数>=8）总平台数
	
	private String L3M_TOTORG_MOVERDUE_TOTAMT;//近 3 个月（自然月，不包含当月）所有场景，其逾期（逾期天数>=8）逾期总金额
	
	private String send_time;

	public String getSend_time() {
		return send_time;
	}

	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getIdcardnumber() {
		return idcardnumber;
	}

	public void setIdcardnumber(String idcardnumber) {
		this.idcardnumber = idcardnumber;
	}

	public String getL7D_714_OVERDUE_PCNT() {
		return L7D_714_OVERDUE_PCNT;
	}

	public void setL7D_714_OVERDUE_PCNT(String l7d_714_OVERDUE_PCNT) {
		L7D_714_OVERDUE_PCNT = l7d_714_OVERDUE_PCNT;
	}

	public String getL7D_714_OVERDUE_TOTAMT() {
		return L7D_714_OVERDUE_TOTAMT;
	}

	public void setL7D_714_OVERDUE_TOTAMT(String l7d_714_OVERDUE_TOTAMT) {
		L7D_714_OVERDUE_TOTAMT = l7d_714_OVERDUE_TOTAMT;
	}

	public String getL7D_714_H1OVERDUE_PCNT() {
		return L7D_714_H1OVERDUE_PCNT;
	}

	public void setL7D_714_H1OVERDUE_PCNT(String l7d_714_H1OVERDUE_PCNT) {
		L7D_714_H1OVERDUE_PCNT = l7d_714_H1OVERDUE_PCNT;
	}

	public String getL7D_714_H1OVERDUE_TOTAMT() {
		return L7D_714_H1OVERDUE_TOTAMT;
	}

	public void setL7D_714_H1OVERDUE_TOTAMT(String l7d_714_H1OVERDUE_TOTAMT) {
		L7D_714_H1OVERDUE_TOTAMT = l7d_714_H1OVERDUE_TOTAMT;
	}

	public String getL7D_714_MOVERDUE_PCNT() {
		return L7D_714_MOVERDUE_PCNT;
	}

	public void setL7D_714_MOVERDUE_PCNT(String l7d_714_MOVERDUE_PCNT) {
		L7D_714_MOVERDUE_PCNT = l7d_714_MOVERDUE_PCNT;
	}

	public String getL7D_714_MOVERDUE_TOTAMT() {
		return L7D_714_MOVERDUE_TOTAMT;
	}

	public void setL7D_714_MOVERDUE_TOTAMT(String l7d_714_MOVERDUE_TOTAMT) {
		L7D_714_MOVERDUE_TOTAMT = l7d_714_MOVERDUE_TOTAMT;
	}

	public String getL7D_ONLINE_OVERDUE_PCNT() {
		return L7D_ONLINE_OVERDUE_PCNT;
	}

	public void setL7D_ONLINE_OVERDUE_PCNT(String l7d_ONLINE_OVERDUE_PCNT) {
		L7D_ONLINE_OVERDUE_PCNT = l7d_ONLINE_OVERDUE_PCNT;
	}

	public String getL7D_ONLINE_OVERDUE_TOTAMT() {
		return L7D_ONLINE_OVERDUE_TOTAMT;
	}

	public void setL7D_ONLINE_OVERDUE_TOTAMT(String l7d_ONLINE_OVERDUE_TOTAMT) {
		L7D_ONLINE_OVERDUE_TOTAMT = l7d_ONLINE_OVERDUE_TOTAMT;
	}

	public String getL7D_ONLINE_H1OVERDUE_PCNT() {
		return L7D_ONLINE_H1OVERDUE_PCNT;
	}

	public void setL7D_ONLINE_H1OVERDUE_PCNT(String l7d_ONLINE_H1OVERDUE_PCNT) {
		L7D_ONLINE_H1OVERDUE_PCNT = l7d_ONLINE_H1OVERDUE_PCNT;
	}

	public String getL7D_ONLINE_H1OVERDUE_TOTAMT() {
		return L7D_ONLINE_H1OVERDUE_TOTAMT;
	}

	public void setL7D_ONLINE_H1OVERDUE_TOTAMT(String l7d_ONLINE_H1OVERDUE_TOTAMT) {
		L7D_ONLINE_H1OVERDUE_TOTAMT = l7d_ONLINE_H1OVERDUE_TOTAMT;
	}

	public String getL7D_ONLINE_MOVERDUE_PCNT() {
		return L7D_ONLINE_MOVERDUE_PCNT;
	}

	public void setL7D_ONLINE_MOVERDUE_PCNT(String l7d_ONLINE_MOVERDUE_PCNT) {
		L7D_ONLINE_MOVERDUE_PCNT = l7d_ONLINE_MOVERDUE_PCNT;
	}

	public String getL7D_ONLINE_MOVERDUE_TOTAMT() {
		return L7D_ONLINE_MOVERDUE_TOTAMT;
	}

	public void setL7D_ONLINE_MOVERDUE_TOTAMT(String l7d_ONLINE_MOVERDUE_TOTAMT) {
		L7D_ONLINE_MOVERDUE_TOTAMT = l7d_ONLINE_MOVERDUE_TOTAMT;
	}

	public String getL7D_CUSTOMER_OVERDUE_PCNT() {
		return L7D_CUSTOMER_OVERDUE_PCNT;
	}

	public void setL7D_CUSTOMER_OVERDUE_PCNT(String l7d_CUSTOMER_OVERDUE_PCNT) {
		L7D_CUSTOMER_OVERDUE_PCNT = l7d_CUSTOMER_OVERDUE_PCNT;
	}

	public String getL7D_CUSTOMER_OVERDUE_TOTAMT() {
		return L7D_CUSTOMER_OVERDUE_TOTAMT;
	}

	public void setL7D_CUSTOMER_OVERDUE_TOTAMT(String l7d_CUSTOMER_OVERDUE_TOTAMT) {
		L7D_CUSTOMER_OVERDUE_TOTAMT = l7d_CUSTOMER_OVERDUE_TOTAMT;
	}

	public String getL7D_CUSTOMER_H1OVERDUE_PCNT() {
		return L7D_CUSTOMER_H1OVERDUE_PCNT;
	}

	public void setL7D_CUSTOMER_H1OVERDUE_PCNT(String l7d_CUSTOMER_H1OVERDUE_PCNT) {
		L7D_CUSTOMER_H1OVERDUE_PCNT = l7d_CUSTOMER_H1OVERDUE_PCNT;
	}

	public String getL7D_CUSTOMER_H1OVERDUE_TOTAMT() {
		return L7D_CUSTOMER_H1OVERDUE_TOTAMT;
	}

	public void setL7D_CUSTOMER_H1OVERDUE_TOTAMT(
			String l7d_CUSTOMER_H1OVERDUE_TOTAMT) {
		L7D_CUSTOMER_H1OVERDUE_TOTAMT = l7d_CUSTOMER_H1OVERDUE_TOTAMT;
	}

	public String getL7D_CUSTOMER_MOVERDUE_PCNT() {
		return L7D_CUSTOMER_MOVERDUE_PCNT;
	}

	public void setL7D_CUSTOMER_MOVERDUE_PCNT(String l7d_CUSTOMER_MOVERDUE_PCNT) {
		L7D_CUSTOMER_MOVERDUE_PCNT = l7d_CUSTOMER_MOVERDUE_PCNT;
	}

	public String getL7D_CUSTOMER_MOVERDUE_TOTAMT() {
		return L7D_CUSTOMER_MOVERDUE_TOTAMT;
	}

	public void setL7D_CUSTOMER_MOVERDUE_TOTAMT(String l7d_CUSTOMER_MOVERDUE_TOTAMT) {
		L7D_CUSTOMER_MOVERDUE_TOTAMT = l7d_CUSTOMER_MOVERDUE_TOTAMT;
	}

	public String getL7D_BANK_OVERDUE_PCNT() {
		return L7D_BANK_OVERDUE_PCNT;
	}

	public void setL7D_BANK_OVERDUE_PCNT(String l7d_BANK_OVERDUE_PCNT) {
		L7D_BANK_OVERDUE_PCNT = l7d_BANK_OVERDUE_PCNT;
	}

	public String getL7D_BANK_OVERDUE_TOTAMT() {
		return L7D_BANK_OVERDUE_TOTAMT;
	}

	public void setL7D_BANK_OVERDUE_TOTAMT(String l7d_BANK_OVERDUE_TOTAMT) {
		L7D_BANK_OVERDUE_TOTAMT = l7d_BANK_OVERDUE_TOTAMT;
	}

	public String getL7D_BANK_H1OVERDUE_PCNT() {
		return L7D_BANK_H1OVERDUE_PCNT;
	}

	public void setL7D_BANK_H1OVERDUE_PCNT(String l7d_BANK_H1OVERDUE_PCNT) {
		L7D_BANK_H1OVERDUE_PCNT = l7d_BANK_H1OVERDUE_PCNT;
	}

	public String getL7D_BANK_H1OVERDUE_TOTAMT() {
		return L7D_BANK_H1OVERDUE_TOTAMT;
	}

	public void setL7D_BANK_H1OVERDUE_TOTAMT(String l7d_BANK_H1OVERDUE_TOTAMT) {
		L7D_BANK_H1OVERDUE_TOTAMT = l7d_BANK_H1OVERDUE_TOTAMT;
	}

	public String getL7D_BANK_MOVERDUE_PCNT() {
		return L7D_BANK_MOVERDUE_PCNT;
	}

	public void setL7D_BANK_MOVERDUE_PCNT(String l7d_BANK_MOVERDUE_PCNT) {
		L7D_BANK_MOVERDUE_PCNT = l7d_BANK_MOVERDUE_PCNT;
	}

	public String getL7D_BANK_MOVERDUE_TOTAMT() {
		return L7D_BANK_MOVERDUE_TOTAMT;
	}

	public void setL7D_BANK_MOVERDUE_TOTAMT(String l7d_BANK_MOVERDUE_TOTAMT) {
		L7D_BANK_MOVERDUE_TOTAMT = l7d_BANK_MOVERDUE_TOTAMT;
	}

	public String getL7D_TOTORG_OVERDUE_PCNT() {
		return L7D_TOTORG_OVERDUE_PCNT;
	}

	public void setL7D_TOTORG_OVERDUE_PCNT(String l7d_TOTORG_OVERDUE_PCNT) {
		L7D_TOTORG_OVERDUE_PCNT = l7d_TOTORG_OVERDUE_PCNT;
	}

	public String getL7D_TOTORG_OVERDUE_TOTAMT() {
		return L7D_TOTORG_OVERDUE_TOTAMT;
	}

	public void setL7D_TOTORG_OVERDUE_TOTAMT(String l7d_TOTORG_OVERDUE_TOTAMT) {
		L7D_TOTORG_OVERDUE_TOTAMT = l7d_TOTORG_OVERDUE_TOTAMT;
	}

	public String getL7D_TOTORG_H1OVERDUE_PCNT() {
		return L7D_TOTORG_H1OVERDUE_PCNT;
	}

	public void setL7D_TOTORG_H1OVERDUE_PCNT(String l7d_TOTORG_H1OVERDUE_PCNT) {
		L7D_TOTORG_H1OVERDUE_PCNT = l7d_TOTORG_H1OVERDUE_PCNT;
	}

	public String getL7D_TOTORG_H1OVERDUE_TOTAMT() {
		return L7D_TOTORG_H1OVERDUE_TOTAMT;
	}

	public void setL7D_TOTORG_H1OVERDUE_TOTAMT(String l7d_TOTORG_H1OVERDUE_TOTAMT) {
		L7D_TOTORG_H1OVERDUE_TOTAMT = l7d_TOTORG_H1OVERDUE_TOTAMT;
	}

	public String getL7D_TOTORG_MOVERDUE_PCNT() {
		return L7D_TOTORG_MOVERDUE_PCNT;
	}

	public void setL7D_TOTORG_MOVERDUE_PCNT(String l7d_TOTORG_MOVERDUE_PCNT) {
		L7D_TOTORG_MOVERDUE_PCNT = l7d_TOTORG_MOVERDUE_PCNT;
	}

	public String getL7D_TOTORG_MOVERDUE_TOTAMT() {
		return L7D_TOTORG_MOVERDUE_TOTAMT;
	}

	public void setL7D_TOTORG_MOVERDUE_TOTAMT(String l7d_TOTORG_MOVERDUE_TOTAMT) {
		L7D_TOTORG_MOVERDUE_TOTAMT = l7d_TOTORG_MOVERDUE_TOTAMT;
	}

	public String getL30D_714_OVERDUE_PCNT() {
		return L30D_714_OVERDUE_PCNT;
	}

	public void setL30D_714_OVERDUE_PCNT(String l30d_714_OVERDUE_PCNT) {
		L30D_714_OVERDUE_PCNT = l30d_714_OVERDUE_PCNT;
	}

	public String getL30D_714_OVERDUE_TOTAMT() {
		return L30D_714_OVERDUE_TOTAMT;
	}

	public void setL30D_714_OVERDUE_TOTAMT(String l30d_714_OVERDUE_TOTAMT) {
		L30D_714_OVERDUE_TOTAMT = l30d_714_OVERDUE_TOTAMT;
	}

	public String getL30D_714_H1OVERDUE_PCNT() {
		return L30D_714_H1OVERDUE_PCNT;
	}

	public void setL30D_714_H1OVERDUE_PCNT(String l30d_714_H1OVERDUE_PCNT) {
		L30D_714_H1OVERDUE_PCNT = l30d_714_H1OVERDUE_PCNT;
	}

	public String getL30D_714_H1OVERDUE_TOTAMT() {
		return L30D_714_H1OVERDUE_TOTAMT;
	}

	public void setL30D_714_H1OVERDUE_TOTAMT(String l30d_714_H1OVERDUE_TOTAMT) {
		L30D_714_H1OVERDUE_TOTAMT = l30d_714_H1OVERDUE_TOTAMT;
	}

	public String getL30D_714_MOVERDUE_PCNT() {
		return L30D_714_MOVERDUE_PCNT;
	}

	public void setL30D_714_MOVERDUE_PCNT(String l30d_714_MOVERDUE_PCNT) {
		L30D_714_MOVERDUE_PCNT = l30d_714_MOVERDUE_PCNT;
	}

	public String getL30D_714_MOVERDUE_TOTAMT() {
		return L30D_714_MOVERDUE_TOTAMT;
	}

	public void setL30D_714_MOVERDUE_TOTAMT(String l30d_714_MOVERDUE_TOTAMT) {
		L30D_714_MOVERDUE_TOTAMT = l30d_714_MOVERDUE_TOTAMT;
	}

	public String getL30D_ONLINE_OVERDUE_PCNT() {
		return L30D_ONLINE_OVERDUE_PCNT;
	}

	public void setL30D_ONLINE_OVERDUE_PCNT(String l30d_ONLINE_OVERDUE_PCNT) {
		L30D_ONLINE_OVERDUE_PCNT = l30d_ONLINE_OVERDUE_PCNT;
	}

	public String getL30D_ONLINE_OVERDUE_TOTAMT() {
		return L30D_ONLINE_OVERDUE_TOTAMT;
	}

	public void setL30D_ONLINE_OVERDUE_TOTAMT(String l30d_ONLINE_OVERDUE_TOTAMT) {
		L30D_ONLINE_OVERDUE_TOTAMT = l30d_ONLINE_OVERDUE_TOTAMT;
	}

	public String getL30D_ONLINE_H1OVERDUE_PCNT() {
		return L30D_ONLINE_H1OVERDUE_PCNT;
	}

	public void setL30D_ONLINE_H1OVERDUE_PCNT(String l30d_ONLINE_H1OVERDUE_PCNT) {
		L30D_ONLINE_H1OVERDUE_PCNT = l30d_ONLINE_H1OVERDUE_PCNT;
	}

	public String getL30D_ONLINE_H1OVERDUE_TOTAMT() {
		return L30D_ONLINE_H1OVERDUE_TOTAMT;
	}

	public void setL30D_ONLINE_H1OVERDUE_TOTAMT(String l30d_ONLINE_H1OVERDUE_TOTAMT) {
		L30D_ONLINE_H1OVERDUE_TOTAMT = l30d_ONLINE_H1OVERDUE_TOTAMT;
	}

	public String getL30D_ONLINE_MOVERDUE_PCNT() {
		return L30D_ONLINE_MOVERDUE_PCNT;
	}

	public void setL30D_ONLINE_MOVERDUE_PCNT(String l30d_ONLINE_MOVERDUE_PCNT) {
		L30D_ONLINE_MOVERDUE_PCNT = l30d_ONLINE_MOVERDUE_PCNT;
	}

	public String getL30D_ONLINE_MOVERDUE_TOTAMT() {
		return L30D_ONLINE_MOVERDUE_TOTAMT;
	}

	public void setL30D_ONLINE_MOVERDUE_TOTAMT(String l30d_ONLINE_MOVERDUE_TOTAMT) {
		L30D_ONLINE_MOVERDUE_TOTAMT = l30d_ONLINE_MOVERDUE_TOTAMT;
	}

	public String getL30D_CUSTOMER_OVERDUE_PCNT() {
		return L30D_CUSTOMER_OVERDUE_PCNT;
	}

	public void setL30D_CUSTOMER_OVERDUE_PCNT(String l30d_CUSTOMER_OVERDUE_PCNT) {
		L30D_CUSTOMER_OVERDUE_PCNT = l30d_CUSTOMER_OVERDUE_PCNT;
	}

	public String getL30D_CUSTOMER_OVERDUE_TOTAMT() {
		return L30D_CUSTOMER_OVERDUE_TOTAMT;
	}

	public void setL30D_CUSTOMER_OVERDUE_TOTAMT(String l30d_CUSTOMER_OVERDUE_TOTAMT) {
		L30D_CUSTOMER_OVERDUE_TOTAMT = l30d_CUSTOMER_OVERDUE_TOTAMT;
	}

	public String getL30D_CUSTOMER_H1OVERDUE_PCNT() {
		return L30D_CUSTOMER_H1OVERDUE_PCNT;
	}

	public void setL30D_CUSTOMER_H1OVERDUE_PCNT(String l30d_CUSTOMER_H1OVERDUE_PCNT) {
		L30D_CUSTOMER_H1OVERDUE_PCNT = l30d_CUSTOMER_H1OVERDUE_PCNT;
	}

	public String getL30D_CUSTOMER_H1OVERDUE_TOTAMT() {
		return L30D_CUSTOMER_H1OVERDUE_TOTAMT;
	}

	public void setL30D_CUSTOMER_H1OVERDUE_TOTAMT(
			String l30d_CUSTOMER_H1OVERDUE_TOTAMT) {
		L30D_CUSTOMER_H1OVERDUE_TOTAMT = l30d_CUSTOMER_H1OVERDUE_TOTAMT;
	}

	public String getL30D_CUSTOMER_MOVERDUE_PCNT() {
		return L30D_CUSTOMER_MOVERDUE_PCNT;
	}

	public void setL30D_CUSTOMER_MOVERDUE_PCNT(String l30d_CUSTOMER_MOVERDUE_PCNT) {
		L30D_CUSTOMER_MOVERDUE_PCNT = l30d_CUSTOMER_MOVERDUE_PCNT;
	}

	public String getL30D_CUSTOMER_MOVERDUE_TOTAMT() {
		return L30D_CUSTOMER_MOVERDUE_TOTAMT;
	}

	public void setL30D_CUSTOMER_MOVERDUE_TOTAMT(
			String l30d_CUSTOMER_MOVERDUE_TOTAMT) {
		L30D_CUSTOMER_MOVERDUE_TOTAMT = l30d_CUSTOMER_MOVERDUE_TOTAMT;
	}

	public String getL30D_BANK_OVERDUE_PCNT() {
		return L30D_BANK_OVERDUE_PCNT;
	}

	public void setL30D_BANK_OVERDUE_PCNT(String l30d_BANK_OVERDUE_PCNT) {
		L30D_BANK_OVERDUE_PCNT = l30d_BANK_OVERDUE_PCNT;
	}

	public String getL30D_BANK_OVERDUE_TOTAMT() {
		return L30D_BANK_OVERDUE_TOTAMT;
	}

	public void setL30D_BANK_OVERDUE_TOTAMT(String l30d_BANK_OVERDUE_TOTAMT) {
		L30D_BANK_OVERDUE_TOTAMT = l30d_BANK_OVERDUE_TOTAMT;
	}

	public String getL30D_BANK_H1OVERDUE_PCNT() {
		return L30D_BANK_H1OVERDUE_PCNT;
	}

	public void setL30D_BANK_H1OVERDUE_PCNT(String l30d_BANK_H1OVERDUE_PCNT) {
		L30D_BANK_H1OVERDUE_PCNT = l30d_BANK_H1OVERDUE_PCNT;
	}

	public String getL30D_BANK_H1OVERDUE_TOTAMT() {
		return L30D_BANK_H1OVERDUE_TOTAMT;
	}

	public void setL30D_BANK_H1OVERDUE_TOTAMT(String l30d_BANK_H1OVERDUE_TOTAMT) {
		L30D_BANK_H1OVERDUE_TOTAMT = l30d_BANK_H1OVERDUE_TOTAMT;
	}

	public String getL30D_BANK_MOVERDUE_PCNT() {
		return L30D_BANK_MOVERDUE_PCNT;
	}

	public void setL30D_BANK_MOVERDUE_PCNT(String l30d_BANK_MOVERDUE_PCNT) {
		L30D_BANK_MOVERDUE_PCNT = l30d_BANK_MOVERDUE_PCNT;
	}

	public String getL30D_BANK_MOVERDUE_TOTAMT() {
		return L30D_BANK_MOVERDUE_TOTAMT;
	}

	public void setL30D_BANK_MOVERDUE_TOTAMT(String l30d_BANK_MOVERDUE_TOTAMT) {
		L30D_BANK_MOVERDUE_TOTAMT = l30d_BANK_MOVERDUE_TOTAMT;
	}

	public String getL30D_TOTORG_OVERDUE_PCNT() {
		return L30D_TOTORG_OVERDUE_PCNT;
	}

	public void setL30D_TOTORG_OVERDUE_PCNT(String l30d_TOTORG_OVERDUE_PCNT) {
		L30D_TOTORG_OVERDUE_PCNT = l30d_TOTORG_OVERDUE_PCNT;
	}

	public String getL30D_TOTORG_OVERDUE_TOTAMT() {
		return L30D_TOTORG_OVERDUE_TOTAMT;
	}

	public void setL30D_TOTORG_OVERDUE_TOTAMT(String l30d_TOTORG_OVERDUE_TOTAMT) {
		L30D_TOTORG_OVERDUE_TOTAMT = l30d_TOTORG_OVERDUE_TOTAMT;
	}

	public String getL30D_TOTORG_H1OVERDUE_PCNT() {
		return L30D_TOTORG_H1OVERDUE_PCNT;
	}

	public void setL30D_TOTORG_H1OVERDUE_PCNT(String l30d_TOTORG_H1OVERDUE_PCNT) {
		L30D_TOTORG_H1OVERDUE_PCNT = l30d_TOTORG_H1OVERDUE_PCNT;
	}

	public String getL30D_TOTORG_H1OVERDUE_TOTAMT() {
		return L30D_TOTORG_H1OVERDUE_TOTAMT;
	}

	public void setL30D_TOTORG_H1OVERDUE_TOTAMT(String l30d_TOTORG_H1OVERDUE_TOTAMT) {
		L30D_TOTORG_H1OVERDUE_TOTAMT = l30d_TOTORG_H1OVERDUE_TOTAMT;
	}

	public String getL30D_TOTORG_MOVERDUE_PCNT() {
		return L30D_TOTORG_MOVERDUE_PCNT;
	}

	public void setL30D_TOTORG_MOVERDUE_PCNT(String l30d_TOTORG_MOVERDUE_PCNT) {
		L30D_TOTORG_MOVERDUE_PCNT = l30d_TOTORG_MOVERDUE_PCNT;
	}

	public String getL30D_TOTORG_MOVERDUE_TOTAMT() {
		return L30D_TOTORG_MOVERDUE_TOTAMT;
	}

	public void setL30D_TOTORG_MOVERDUE_TOTAMT(String l30d_TOTORG_MOVERDUE_TOTAMT) {
		L30D_TOTORG_MOVERDUE_TOTAMT = l30d_TOTORG_MOVERDUE_TOTAMT;
	}

	public String getL3M_714_OVERDUE_PCNT() {
		return L3M_714_OVERDUE_PCNT;
	}

	public void setL3M_714_OVERDUE_PCNT(String l3m_714_OVERDUE_PCNT) {
		L3M_714_OVERDUE_PCNT = l3m_714_OVERDUE_PCNT;
	}

	public String getL3M_714_OVERDUE_TOTAMT() {
		return L3M_714_OVERDUE_TOTAMT;
	}

	public void setL3M_714_OVERDUE_TOTAMT(String l3m_714_OVERDUE_TOTAMT) {
		L3M_714_OVERDUE_TOTAMT = l3m_714_OVERDUE_TOTAMT;
	}

	public String getL3M_714_H1OVERDUE_PCNT() {
		return L3M_714_H1OVERDUE_PCNT;
	}

	public void setL3M_714_H1OVERDUE_PCNT(String l3m_714_H1OVERDUE_PCNT) {
		L3M_714_H1OVERDUE_PCNT = l3m_714_H1OVERDUE_PCNT;
	}

	public String getL3M_714_H1OVERDUE_TOTAMT() {
		return L3M_714_H1OVERDUE_TOTAMT;
	}

	public void setL3M_714_H1OVERDUE_TOTAMT(String l3m_714_H1OVERDUE_TOTAMT) {
		L3M_714_H1OVERDUE_TOTAMT = l3m_714_H1OVERDUE_TOTAMT;
	}

	public String getL3M_714_MOVERDUE_PCNT() {
		return L3M_714_MOVERDUE_PCNT;
	}

	public void setL3M_714_MOVERDUE_PCNT(String l3m_714_MOVERDUE_PCNT) {
		L3M_714_MOVERDUE_PCNT = l3m_714_MOVERDUE_PCNT;
	}

	public String getL3M_714_MOVERDUE_TOTAMT() {
		return L3M_714_MOVERDUE_TOTAMT;
	}

	public void setL3M_714_MOVERDUE_TOTAMT(String l3m_714_MOVERDUE_TOTAMT) {
		L3M_714_MOVERDUE_TOTAMT = l3m_714_MOVERDUE_TOTAMT;
	}

	public String getL3M_ONLINE_OVERDUE_PCNT() {
		return L3M_ONLINE_OVERDUE_PCNT;
	}

	public void setL3M_ONLINE_OVERDUE_PCNT(String l3m_ONLINE_OVERDUE_PCNT) {
		L3M_ONLINE_OVERDUE_PCNT = l3m_ONLINE_OVERDUE_PCNT;
	}

	public String getL3M_ONLINE_OVERDUE_TOTAMT() {
		return L3M_ONLINE_OVERDUE_TOTAMT;
	}

	public void setL3M_ONLINE_OVERDUE_TOTAMT(String l3m_ONLINE_OVERDUE_TOTAMT) {
		L3M_ONLINE_OVERDUE_TOTAMT = l3m_ONLINE_OVERDUE_TOTAMT;
	}

	public String getL3M_ONLINE_H1OVERDUE_PCNT() {
		return L3M_ONLINE_H1OVERDUE_PCNT;
	}

	public void setL3M_ONLINE_H1OVERDUE_PCNT(String l3m_ONLINE_H1OVERDUE_PCNT) {
		L3M_ONLINE_H1OVERDUE_PCNT = l3m_ONLINE_H1OVERDUE_PCNT;
	}

	public String getL3M_ONLINE_H1OVERDUE_TOTAMT() {
		return L3M_ONLINE_H1OVERDUE_TOTAMT;
	}

	public void setL3M_ONLINE_H1OVERDUE_TOTAMT(String l3m_ONLINE_H1OVERDUE_TOTAMT) {
		L3M_ONLINE_H1OVERDUE_TOTAMT = l3m_ONLINE_H1OVERDUE_TOTAMT;
	}

	public String getL3M_ONLINE_MOVERDUE_PCNT() {
		return L3M_ONLINE_MOVERDUE_PCNT;
	}

	public void setL3M_ONLINE_MOVERDUE_PCNT(String l3m_ONLINE_MOVERDUE_PCNT) {
		L3M_ONLINE_MOVERDUE_PCNT = l3m_ONLINE_MOVERDUE_PCNT;
	}

	public String getL3M_ONLINE_MOVERDUE_TOTAMT() {
		return L3M_ONLINE_MOVERDUE_TOTAMT;
	}

	public void setL3M_ONLINE_MOVERDUE_TOTAMT(String l3m_ONLINE_MOVERDUE_TOTAMT) {
		L3M_ONLINE_MOVERDUE_TOTAMT = l3m_ONLINE_MOVERDUE_TOTAMT;
	}

	public String getL3M_CUSTOMER_OVERDUE_PCNT() {
		return L3M_CUSTOMER_OVERDUE_PCNT;
	}

	public void setL3M_CUSTOMER_OVERDUE_PCNT(String l3m_CUSTOMER_OVERDUE_PCNT) {
		L3M_CUSTOMER_OVERDUE_PCNT = l3m_CUSTOMER_OVERDUE_PCNT;
	}

	public String getL3M_CUSTOMER_OVERDUE_TOTAMT() {
		return L3M_CUSTOMER_OVERDUE_TOTAMT;
	}

	public void setL3M_CUSTOMER_OVERDUE_TOTAMT(String l3m_CUSTOMER_OVERDUE_TOTAMT) {
		L3M_CUSTOMER_OVERDUE_TOTAMT = l3m_CUSTOMER_OVERDUE_TOTAMT;
	}

	public String getL3M_CUSTOMER_H1OVERDUE_PCNT() {
		return L3M_CUSTOMER_H1OVERDUE_PCNT;
	}

	public void setL3M_CUSTOMER_H1OVERDUE_PCNT(String l3m_CUSTOMER_H1OVERDUE_PCNT) {
		L3M_CUSTOMER_H1OVERDUE_PCNT = l3m_CUSTOMER_H1OVERDUE_PCNT;
	}

	public String getL3M_CUSTOMER_H1OVERDUE_TOTAMT() {
		return L3M_CUSTOMER_H1OVERDUE_TOTAMT;
	}

	public void setL3M_CUSTOMER_H1OVERDUE_TOTAMT(
			String l3m_CUSTOMER_H1OVERDUE_TOTAMT) {
		L3M_CUSTOMER_H1OVERDUE_TOTAMT = l3m_CUSTOMER_H1OVERDUE_TOTAMT;
	}

	public String getL3M_CUSTOMER_MOVERDUE_PCNT() {
		return L3M_CUSTOMER_MOVERDUE_PCNT;
	}

	public void setL3M_CUSTOMER_MOVERDUE_PCNT(String l3m_CUSTOMER_MOVERDUE_PCNT) {
		L3M_CUSTOMER_MOVERDUE_PCNT = l3m_CUSTOMER_MOVERDUE_PCNT;
	}

	public String getL3M_CUSTOMER_MOVERDUE_TOTAMT() {
		return L3M_CUSTOMER_MOVERDUE_TOTAMT;
	}

	public void setL3M_CUSTOMER_MOVERDUE_TOTAMT(String l3m_CUSTOMER_MOVERDUE_TOTAMT) {
		L3M_CUSTOMER_MOVERDUE_TOTAMT = l3m_CUSTOMER_MOVERDUE_TOTAMT;
	}

	public String getL3M_BANK_OVERDUE_PCNT() {
		return L3M_BANK_OVERDUE_PCNT;
	}

	public void setL3M_BANK_OVERDUE_PCNT(String l3m_BANK_OVERDUE_PCNT) {
		L3M_BANK_OVERDUE_PCNT = l3m_BANK_OVERDUE_PCNT;
	}

	public String getL3M_BANK_OVERDUE_TOTAMT() {
		return L3M_BANK_OVERDUE_TOTAMT;
	}

	public void setL3M_BANK_OVERDUE_TOTAMT(String l3m_BANK_OVERDUE_TOTAMT) {
		L3M_BANK_OVERDUE_TOTAMT = l3m_BANK_OVERDUE_TOTAMT;
	}

	public String getL3M_BANK_H1OVERDUE_PCNT() {
		return L3M_BANK_H1OVERDUE_PCNT;
	}

	public void setL3M_BANK_H1OVERDUE_PCNT(String l3m_BANK_H1OVERDUE_PCNT) {
		L3M_BANK_H1OVERDUE_PCNT = l3m_BANK_H1OVERDUE_PCNT;
	}

	public String getL3M_BANK_H1OVERDUE_TOTAMT() {
		return L3M_BANK_H1OVERDUE_TOTAMT;
	}

	public void setL3M_BANK_H1OVERDUE_TOTAMT(String l3m_BANK_H1OVERDUE_TOTAMT) {
		L3M_BANK_H1OVERDUE_TOTAMT = l3m_BANK_H1OVERDUE_TOTAMT;
	}

	public String getL3M_BANK_MOVERDUE_PCNT() {
		return L3M_BANK_MOVERDUE_PCNT;
	}

	public void setL3M_BANK_MOVERDUE_PCNT(String l3m_BANK_MOVERDUE_PCNT) {
		L3M_BANK_MOVERDUE_PCNT = l3m_BANK_MOVERDUE_PCNT;
	}

	public String getL3M_BANK_MOVERDUE_TOTAMT() {
		return L3M_BANK_MOVERDUE_TOTAMT;
	}

	public void setL3M_BANK_MOVERDUE_TOTAMT(String l3m_BANK_MOVERDUE_TOTAMT) {
		L3M_BANK_MOVERDUE_TOTAMT = l3m_BANK_MOVERDUE_TOTAMT;
	}

	public String getL3M_TOTORG_OVERDUE_PCNT() {
		return L3M_TOTORG_OVERDUE_PCNT;
	}

	public void setL3M_TOTORG_OVERDUE_PCNT(String l3m_TOTORG_OVERDUE_PCNT) {
		L3M_TOTORG_OVERDUE_PCNT = l3m_TOTORG_OVERDUE_PCNT;
	}

	public String getL3M_TOTORG_OVERDUE_TOTAMT() {
		return L3M_TOTORG_OVERDUE_TOTAMT;
	}

	public void setL3M_TOTORG_OVERDUE_TOTAMT(String l3m_TOTORG_OVERDUE_TOTAMT) {
		L3M_TOTORG_OVERDUE_TOTAMT = l3m_TOTORG_OVERDUE_TOTAMT;
	}

	public String getL3M_TOTORG_H1OVERDUE_PCNT() {
		return L3M_TOTORG_H1OVERDUE_PCNT;
	}

	public void setL3M_TOTORG_H1OVERDUE_PCNT(String l3m_TOTORG_H1OVERDUE_PCNT) {
		L3M_TOTORG_H1OVERDUE_PCNT = l3m_TOTORG_H1OVERDUE_PCNT;
	}

	public String getL3M_TOTORG_H1OVERDUE_TOTAMT() {
		return L3M_TOTORG_H1OVERDUE_TOTAMT;
	}

	public void setL3M_TOTORG_H1OVERDUE_TOTAMT(String l3m_TOTORG_H1OVERDUE_TOTAMT) {
		L3M_TOTORG_H1OVERDUE_TOTAMT = l3m_TOTORG_H1OVERDUE_TOTAMT;
	}

	public String getL3M_TOTORG_MOVERDUE_PCNT() {
		return L3M_TOTORG_MOVERDUE_PCNT;
	}

	public void setL3M_TOTORG_MOVERDUE_PCNT(String l3m_TOTORG_MOVERDUE_PCNT) {
		L3M_TOTORG_MOVERDUE_PCNT = l3m_TOTORG_MOVERDUE_PCNT;
	}

	public String getL3M_TOTORG_MOVERDUE_TOTAMT() {
		return L3M_TOTORG_MOVERDUE_TOTAMT;
	}

	public void setL3M_TOTORG_MOVERDUE_TOTAMT(String l3m_TOTORG_MOVERDUE_TOTAMT) {
		L3M_TOTORG_MOVERDUE_TOTAMT = l3m_TOTORG_MOVERDUE_TOTAMT;
	}
	
	
	
	
}

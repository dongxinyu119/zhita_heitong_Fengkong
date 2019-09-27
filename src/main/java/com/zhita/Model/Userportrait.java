package com.zhita.Model;

public class Userportrait {
	
	private Integer id;
	
	private String username;
	
	private Integer userId;
	
	private String idnumber;
	
	private String phone;
	
	private String Orgcombination;//活跃场景1 银行场景   2 消费金融场景   3 大额网贷   4 小额网贷   5 贷款超市   6 714
	
	private String Responselevel;//营销意愿评级	L< M < H < HH
	
	private String Risklevel;//风险评级 L< M < H < HH
	
	private Integer page=0;
	
	private Integer pagesize=10;

	private String send_time;
	
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getIdnumber() {
		return idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOrgcombination() {
		return Orgcombination;
	}

	public void setOrgcombination(String orgcombination) {
		Orgcombination = orgcombination;
	}

	public String getResponselevel() {
		return Responselevel;
	}

	public void setResponselevel(String responselevel) {
		Responselevel = responselevel;
	}

	public String getRisklevel() {
		return Risklevel;
	}

	public void setRisklevel(String risklevel) {
		Risklevel = risklevel;
	}
	
	

}

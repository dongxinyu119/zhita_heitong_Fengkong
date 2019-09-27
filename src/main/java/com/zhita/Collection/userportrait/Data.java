package com.zhita.Collection.userportrait;

public class Data {
	
	private String Orgcombination;//活跃场景1 银行场景   2 消费金融场景   3 大额网贷   4 小额网贷   5 贷款超市   6 714
	
	private String Responselevel;//营销意愿评级	L< M < H < HH
	
	private String Risklevel;//风险评级 L< M < H < HH

	private String send_time;

	public String getSend_time() {
		return send_time;
	}

	public void setSend_time(String send_time) {
		this.send_time = send_time;
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

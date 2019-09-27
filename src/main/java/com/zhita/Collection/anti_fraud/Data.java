package com.zhita.Collection.anti_fraud;

public class Data {
	
	private Integer FraudScore;
	
	private String FraudReasonCode;
	
	private String send_time;

	public String getSend_time() {
		return send_time;
	}

	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}

	public Integer getFraudScore() {
		return FraudScore;
	}

	public void setFraudScore(Integer fraudScore) {
		FraudScore = fraudScore;
	}

	public String getFraudReasonCode() {
		return FraudReasonCode;
	}

	public void setFraudReasonCode(String fraudReasonCode) {
		FraudReasonCode = fraudReasonCode;
	}
	
	

}

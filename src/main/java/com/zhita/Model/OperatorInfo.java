package com.zhita.Model;

import java.math.BigDecimal;

//运营商基本信息表
public class OperatorInfo {
    private Integer id;

    private Integer xiaodaiUserid;//用户id

    private String phoneNumber;//本机号码

    private String operatorType;//运营商类型

    private String name;//姓名

    private String idcard;//身份证号

    private String email;//邮箱

    private String address;//地址

    private String vipLevel;//会员等级

    private String accumulatePoints;//账户积分

    private String registrationHistory;//在网时长

    private String orderDescription;//套餐详情

    private BigDecimal availableAmount;//当前可用余额

    private String phoneNumberLocation;//本机号码归属地

    private String mainActiveLocation;//主要活动区域

    private BigDecimal mainLocationPercent;//主要活动区域占比
    
    private String mainLocationPercentStr;//主要活动区域占比（String类型）

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getXiaodaiUserid() {
        return xiaodaiUserid;
    }

    public void setXiaodaiUserid(Integer xiaodaiUserid) {
        this.xiaodaiUserid = xiaodaiUserid;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType == null ? null : operatorType.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(String vipLevel) {
        this.vipLevel = vipLevel == null ? null : vipLevel.trim();
    }

    public String getAccumulatePoints() {
        return accumulatePoints;
    }

    public void setAccumulatePoints(String accumulatePoints) {
        this.accumulatePoints = accumulatePoints == null ? null : accumulatePoints.trim();
    }

    public String getRegistrationHistory() {
        return registrationHistory;
    }

    public void setRegistrationHistory(String registrationHistory) {
        this.registrationHistory = registrationHistory == null ? null : registrationHistory.trim();
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription == null ? null : orderDescription.trim();
    }

    public BigDecimal getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(BigDecimal availableAmount) {
        this.availableAmount = availableAmount;
    }

    public String getPhoneNumberLocation() {
        return phoneNumberLocation;
    }

    public void setPhoneNumberLocation(String phoneNumberLocation) {
        this.phoneNumberLocation = phoneNumberLocation == null ? null : phoneNumberLocation.trim();
    }

    public String getMainActiveLocation() {
        return mainActiveLocation;
    }

    public void setMainActiveLocation(String mainActiveLocation) {
        this.mainActiveLocation = mainActiveLocation == null ? null : mainActiveLocation.trim();
    }

	public BigDecimal getMainLocationPercent() {
		return mainLocationPercent;
	}

	public void setMainLocationPercent(BigDecimal mainLocationPercent) {
		this.mainLocationPercent = mainLocationPercent;
	}

	public String getMainLocationPercentStr() {
		return mainLocationPercentStr;
	}

	public void setMainLocationPercentStr(String mainLocationPercentStr) {
		this.mainLocationPercentStr = mainLocationPercentStr;
	}
	

}
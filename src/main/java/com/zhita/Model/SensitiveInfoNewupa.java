package com.zhita.Model;

import java.util.List;

//风险信息检查表
public class SensitiveInfoNewupa {
    private Integer id;

    private Integer xiaodaiUserid;//用户id
    
    private String checkResult;//检查结果（结果有"未发现"、"result_detail_info"两种）

    private String itemId;//风险项id

    private String itemName;//风险项名称

    private String riskLevel;//风险等级

    private String idcardMatching;//身份证匹配结果

    private String nameMatching;//姓名匹配结果

    private String networkLengthCheck;//入网时长检查

    private String idcard;//身份证检查

    private String phoneNumber;//手机号检查

    private String result;//结果详情
    
    private List<CallRecordListInfos> listc;

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

	public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult == null ? null : checkResult.trim();
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel == null ? null : riskLevel.trim();
    }

    public String getIdcardMatching() {
        return idcardMatching;
    }

    public void setIdcardMatching(String idcardMatching) {
        this.idcardMatching = idcardMatching == null ? null : idcardMatching.trim();
    }

    public String getNameMatching() {
        return nameMatching;
    }

    public void setNameMatching(String nameMatching) {
        this.nameMatching = nameMatching == null ? null : nameMatching.trim();
    }

    public String getNetworkLengthCheck() {
        return networkLengthCheck;
    }

    public void setNetworkLengthCheck(String networkLengthCheck) {
        this.networkLengthCheck = networkLengthCheck == null ? null : networkLengthCheck.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

	public List<CallRecordListInfos> getListc() {
		return listc;
	}

	public void setListc(List<CallRecordListInfos> listc) {
		this.listc = listc;
	}
    
}
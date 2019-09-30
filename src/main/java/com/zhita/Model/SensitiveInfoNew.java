package com.zhita.Model;


//风险信息检查表
public class SensitiveInfoNew {
    private Integer id;

    private Integer xiaodaiUserid;//用户id

    private String riskLevel;//风险等级

    private Integer itemId;//风险项id

    private String itemName;//风险项名称

    private String checkResult;//检查结果（结果有"未发现"、"result_detail_info"两种）

    private String idcardMatching;//身份证匹配结果

    private String nameMatching;//姓名匹配结果

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

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel == null ? null : riskLevel.trim();
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult == null ? null : checkResult.trim();
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
}
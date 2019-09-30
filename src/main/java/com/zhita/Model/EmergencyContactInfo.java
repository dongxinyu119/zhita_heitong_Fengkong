package com.zhita.Model;

//紧急联系人表
public class EmergencyContactInfo {
    private Integer id;

    private Integer xiaodaiUserid;//用户id

    private String relation;//关系

    private String name;//姓名

    private String phoneNumber;//号码

    private String idNumber;////身份证号码

    private String labelName;//互联网标记

    private String phoneLocation;//归属地

    private Integer oneCallingCount;//近一个月通话统计——主叫次数

    private Integer oneCalledCount;//近一个月通话统计——被叫次数

    private Integer oneTotalCallCount;//近一个月通话统计——总共通话次数

    private String oneCallingDurationTime;//近一个月通话统计——主叫通话时长

    private String oneCalledDurationTime;//近一个月通话统计——被叫通话时长

    private String oneTotalCallDurationTime;//近一个月通话统计——总共通话时长

    private Integer threeCallingCount;//近三个月通话统计——主叫次数

    private Integer threeCalledCount;//近三个月通话统计——被叫次数

    private Integer threeTotalCallCount;//近三个月通话统计——总共通话次数

    private String threeCallingDurationTime;//近三个月通话统计——主叫通话时长

    private String threeCalledDurationTime;//近三个月通话统计——被叫通话时长

    private String threeTotalCallDurationTime;//近三个月通话统计——总共通话时长

    private Integer sixCallingCount;//近六个月通话统计——主叫次数

    private Integer sixCalledCount;//近六个月通话统计——被叫次数

    private Integer sixTotalCallCount;//近六个月通话统计——总共通话次数

    private String sixCallingDurationTime;//近六个月通话统计——主叫通话时长

    private String sixCalledDurationTime;//近六个月通话统计——被叫通话时长

    private String sixTotalCallDurationTime;//近六个月通话统计——总共通话时长

    private Integer allCallingCount;//总共通话次数——主叫次数

    private Integer allCalledCount;//总共通话次数——被叫次数

    private Integer allTotalCallCount;//总共通话次数——总共通话次数

    private String allCallingDurationTime;//总共通话次数——主叫通话时长

    private String allCalledDurationTime;//总共通话次数——被叫通话时长

    private String allTotalCallDurationTime;//总共通话次数——总共通话时长

    private String workdayDurationTime;//工作日通话时长

    private String offdayDurationTime;//非工作日通话时长

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

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation == null ? null : relation.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName == null ? null : labelName.trim();
    }

    public String getPhoneLocation() {
        return phoneLocation;
    }

    public void setPhoneLocation(String phoneLocation) {
        this.phoneLocation = phoneLocation == null ? null : phoneLocation.trim();
    }

    public Integer getOneCallingCount() {
        return oneCallingCount;
    }

    public void setOneCallingCount(Integer oneCallingCount) {
        this.oneCallingCount = oneCallingCount;
    }

    public Integer getOneCalledCount() {
        return oneCalledCount;
    }

    public void setOneCalledCount(Integer oneCalledCount) {
        this.oneCalledCount = oneCalledCount;
    }

    public Integer getOneTotalCallCount() {
        return oneTotalCallCount;
    }

    public void setOneTotalCallCount(Integer oneTotalCallCount) {
        this.oneTotalCallCount = oneTotalCallCount;
    }

    public String getOneCallingDurationTime() {
        return oneCallingDurationTime;
    }

    public void setOneCallingDurationTime(String oneCallingDurationTime) {
        this.oneCallingDurationTime = oneCallingDurationTime == null ? null : oneCallingDurationTime.trim();
    }

    public String getOneCalledDurationTime() {
        return oneCalledDurationTime;
    }

    public void setOneCalledDurationTime(String oneCalledDurationTime) {
        this.oneCalledDurationTime = oneCalledDurationTime == null ? null : oneCalledDurationTime.trim();
    }

    public String getOneTotalCallDurationTime() {
        return oneTotalCallDurationTime;
    }

    public void setOneTotalCallDurationTime(String oneTotalCallDurationTime) {
        this.oneTotalCallDurationTime = oneTotalCallDurationTime == null ? null : oneTotalCallDurationTime.trim();
    }

    public Integer getThreeCallingCount() {
        return threeCallingCount;
    }

    public void setThreeCallingCount(Integer threeCallingCount) {
        this.threeCallingCount = threeCallingCount;
    }

    public Integer getThreeCalledCount() {
        return threeCalledCount;
    }

    public void setThreeCalledCount(Integer threeCalledCount) {
        this.threeCalledCount = threeCalledCount;
    }

    public Integer getThreeTotalCallCount() {
        return threeTotalCallCount;
    }

    public void setThreeTotalCallCount(Integer threeTotalCallCount) {
        this.threeTotalCallCount = threeTotalCallCount;
    }

    public String getThreeCallingDurationTime() {
        return threeCallingDurationTime;
    }

    public void setThreeCallingDurationTime(String threeCallingDurationTime) {
        this.threeCallingDurationTime = threeCallingDurationTime == null ? null : threeCallingDurationTime.trim();
    }

    public String getThreeCalledDurationTime() {
        return threeCalledDurationTime;
    }

    public void setThreeCalledDurationTime(String threeCalledDurationTime) {
        this.threeCalledDurationTime = threeCalledDurationTime == null ? null : threeCalledDurationTime.trim();
    }

    public String getThreeTotalCallDurationTime() {
        return threeTotalCallDurationTime;
    }

    public void setThreeTotalCallDurationTime(String threeTotalCallDurationTime) {
        this.threeTotalCallDurationTime = threeTotalCallDurationTime == null ? null : threeTotalCallDurationTime.trim();
    }

    public Integer getSixCallingCount() {
        return sixCallingCount;
    }

    public void setSixCallingCount(Integer sixCallingCount) {
        this.sixCallingCount = sixCallingCount;
    }

    public Integer getSixCalledCount() {
        return sixCalledCount;
    }

    public void setSixCalledCount(Integer sixCalledCount) {
        this.sixCalledCount = sixCalledCount;
    }

    public Integer getSixTotalCallCount() {
        return sixTotalCallCount;
    }

    public void setSixTotalCallCount(Integer sixTotalCallCount) {
        this.sixTotalCallCount = sixTotalCallCount;
    }

    public String getSixCallingDurationTime() {
        return sixCallingDurationTime;
    }

    public void setSixCallingDurationTime(String sixCallingDurationTime) {
        this.sixCallingDurationTime = sixCallingDurationTime == null ? null : sixCallingDurationTime.trim();
    }

    public String getSixCalledDurationTime() {
        return sixCalledDurationTime;
    }

    public void setSixCalledDurationTime(String sixCalledDurationTime) {
        this.sixCalledDurationTime = sixCalledDurationTime == null ? null : sixCalledDurationTime.trim();
    }

    public String getSixTotalCallDurationTime() {
        return sixTotalCallDurationTime;
    }

    public void setSixTotalCallDurationTime(String sixTotalCallDurationTime) {
        this.sixTotalCallDurationTime = sixTotalCallDurationTime == null ? null : sixTotalCallDurationTime.trim();
    }

    public Integer getAllCallingCount() {
        return allCallingCount;
    }

    public void setAllCallingCount(Integer allCallingCount) {
        this.allCallingCount = allCallingCount;
    }

    public Integer getAllCalledCount() {
        return allCalledCount;
    }

    public void setAllCalledCount(Integer allCalledCount) {
        this.allCalledCount = allCalledCount;
    }

    public Integer getAllTotalCallCount() {
        return allTotalCallCount;
    }

    public void setAllTotalCallCount(Integer allTotalCallCount) {
        this.allTotalCallCount = allTotalCallCount;
    }

    public String getAllCallingDurationTime() {
        return allCallingDurationTime;
    }

    public void setAllCallingDurationTime(String allCallingDurationTime) {
        this.allCallingDurationTime = allCallingDurationTime == null ? null : allCallingDurationTime.trim();
    }

    public String getAllCalledDurationTime() {
        return allCalledDurationTime;
    }

    public void setAllCalledDurationTime(String allCalledDurationTime) {
        this.allCalledDurationTime = allCalledDurationTime == null ? null : allCalledDurationTime.trim();
    }

    public String getAllTotalCallDurationTime() {
        return allTotalCallDurationTime;
    }

    public void setAllTotalCallDurationTime(String allTotalCallDurationTime) {
        this.allTotalCallDurationTime = allTotalCallDurationTime == null ? null : allTotalCallDurationTime.trim();
    }

    public String getWorkdayDurationTime() {
        return workdayDurationTime;
    }

    public void setWorkdayDurationTime(String workdayDurationTime) {
        this.workdayDurationTime = workdayDurationTime == null ? null : workdayDurationTime.trim();
    }

    public String getOffdayDurationTime() {
        return offdayDurationTime;
    }

    public void setOffdayDurationTime(String offdayDurationTime) {
        this.offdayDurationTime = offdayDurationTime == null ? null : offdayDurationTime.trim();
    }
}
package com.zhita.Model;

//通话数据分析表
public class LabelInfo {
    private Integer id;

    private Integer xiaodaiUserid;//用户id

    private Integer sortIndex;//联系次数排名

    private Integer contactCount;//联系次数

    private String phoneNumber;//号码

    private String labelName;//互联网标识

    private String labelType;//标识类型

    private String phoneLocation;//归属地

    private String contactDuration;//通话时长

    private Integer callingCount;//主叫次数

    private Integer calledCount;//被叫次数

    private String earliestTime;//最早一次通话时间

    private String latestTime;//最后一次通话时间

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

    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }

    public Integer getContactCount() {
        return contactCount;
    }

    public void setContactCount(Integer contactCount) {
        this.contactCount = contactCount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName == null ? null : labelName.trim();
    }

    public String getLabelType() {
        return labelType;
    }

    public void setLabelType(String labelType) {
        this.labelType = labelType == null ? null : labelType.trim();
    }

    public String getPhoneLocation() {
        return phoneLocation;
    }

    public void setPhoneLocation(String phoneLocation) {
        this.phoneLocation = phoneLocation == null ? null : phoneLocation.trim();
    }

    public String getContactDuration() {
        return contactDuration;
    }

    public void setContactDuration(String contactDuration) {
        this.contactDuration = contactDuration == null ? null : contactDuration.trim();
    }

    public Integer getCallingCount() {
        return callingCount;
    }

    public void setCallingCount(Integer callingCount) {
        this.callingCount = callingCount;
    }

    public Integer getCalledCount() {
        return calledCount;
    }

    public void setCalledCount(Integer calledCount) {
        this.calledCount = calledCount;
    }

    public String getEarliestTime() {
        return earliestTime;
    }

    public void setEarliestTime(String earliestTime) {
        this.earliestTime = earliestTime == null ? null : earliestTime.trim();
    }

    public String getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(String latestTime) {
        this.latestTime = latestTime == null ? null : latestTime.trim();
    }
}
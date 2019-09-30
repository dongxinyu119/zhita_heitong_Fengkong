package com.zhita.Model;

//通话时间段分布表
public class CommunicationTimeBucketInfo {
    private Integer id;

    private Integer xiaodaiUserid;//用户id

    private String timeBucket;//时间段

    private Integer callCount;//通话次数

    private Integer phoneCount;//号码个数

    private String phoneTimes;//最常联系号码及次数

    private Integer callingCount;//主叫次数

    private String callingDurationTime;//主叫时长

    private Integer calledCount;//被叫次数

    private String calledDurationTime;//被叫时长

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

    public String getTimeBucket() {
        return timeBucket;
    }

    public void setTimeBucket(String timeBucket) {
        this.timeBucket = timeBucket == null ? null : timeBucket.trim();
    }

    public Integer getCallCount() {
        return callCount;
    }

    public void setCallCount(Integer callCount) {
        this.callCount = callCount;
    }

    public Integer getPhoneCount() {
        return phoneCount;
    }

    public void setPhoneCount(Integer phoneCount) {
        this.phoneCount = phoneCount;
    }

    public String getPhoneTimes() {
        return phoneTimes;
    }

    public void setPhoneTimes(String phoneTimes) {
        this.phoneTimes = phoneTimes == null ? null : phoneTimes.trim();
    }

    public Integer getCallingCount() {
        return callingCount;
    }

    public void setCallingCount(Integer callingCount) {
        this.callingCount = callingCount;
    }

    public String getCallingDurationTime() {
        return callingDurationTime;
    }

    public void setCallingDurationTime(String callingDurationTime) {
        this.callingDurationTime = callingDurationTime == null ? null : callingDurationTime.trim();
    }

    public Integer getCalledCount() {
        return calledCount;
    }

    public void setCalledCount(Integer calledCount) {
        this.calledCount = calledCount;
    }

    public String getCalledDurationTime() {
        return calledDurationTime;
    }

    public void setCalledDurationTime(String calledDurationTime) {
        this.calledDurationTime = calledDurationTime == null ? null : calledDurationTime.trim();
    }
}
package com.zhita.Model;

//通话总时长前10 表
public class Top10CallTime {
    private Integer id;

    private Integer xiaodaiUserid;//用户id

    private String phoneNumber;//通话号码

    private String callDurationTime;//通话时长

    private String callingDurationTime;//主叫时长

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getCallDurationTime() {
        return callDurationTime;
    }

    public void setCallDurationTime(String callDurationTime) {
        this.callDurationTime = callDurationTime == null ? null : callDurationTime.trim();
    }

    public String getCallingDurationTime() {
        return callingDurationTime;
    }

    public void setCallingDurationTime(String callingDurationTime) {
        this.callingDurationTime = callingDurationTime == null ? null : callingDurationTime.trim();
    }

    public String getCalledDurationTime() {
        return calledDurationTime;
    }

    public void setCalledDurationTime(String calledDurationTime) {
        this.calledDurationTime = calledDurationTime == null ? null : calledDurationTime.trim();
    }
}
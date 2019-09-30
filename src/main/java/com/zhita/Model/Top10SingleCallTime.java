package com.zhita.Model;

//单次通话时长前10 表
public class Top10SingleCallTime {
    private Integer id;

    private Integer xiaodaiUserid;//用户id

    private String phoneNumber;//通话号码

    private String callDurationTime;//通话时长

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
}
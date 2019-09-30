package com.zhita.Model;

//通话次数前10 表
public class Top10CallCount {
    private Integer id;

    private Integer xiaodaiUserid;//用户id

    private String phoneNumber;//通话号码

    private Integer callCount;//通话次数

    private Integer callingCount;//主叫次数

    private Integer calledCount;//被叫次数

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

    public Integer getCallCount() {
        return callCount;
    }

    public void setCallCount(Integer callCount) {
        this.callCount = callCount;
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
}
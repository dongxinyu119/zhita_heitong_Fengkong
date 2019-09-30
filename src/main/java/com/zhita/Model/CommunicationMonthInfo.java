package com.zhita.Model;

import java.math.BigDecimal;

//通话月份分布表
public class CommunicationMonthInfo {
    private Integer id;

    private Integer xiaodaiUserid;//用户id

    private String month;//月份

    private String callPhoneNumberCount;//通话号码

    private BigDecimal twoWayPhoneNumberPer;//互相打电话的号码数占总通话号码数的比率

    private Integer callCount;//呼叫次数:计算当月总通话次数

    private Integer callingCount;//主叫次数:计算当月总通话次数

    private String callingDurationTime;//主叫时长(分钟)：计算当月主叫次数总通话时长

    private Integer calledCount;//被叫次数:计算当月被叫次数

    private String calledDurationTime;//被叫时长(分钟)：计算当月被叫次数总通话时长

    private Integer smsCount;//短信数量：计算当月短信数量

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

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    public String getCallPhoneNumberCount() {
        return callPhoneNumberCount;
    }

    public void setCallPhoneNumberCount(String callPhoneNumberCount) {
        this.callPhoneNumberCount = callPhoneNumberCount == null ? null : callPhoneNumberCount.trim();
    }

    public BigDecimal getTwoWayPhoneNumberPer() {
        return twoWayPhoneNumberPer;
    }

    public void setTwoWayPhoneNumberPer(BigDecimal twoWayPhoneNumberPer) {
        this.twoWayPhoneNumberPer = twoWayPhoneNumberPer;
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

    public Integer getSmsCount() {
        return smsCount;
    }

    public void setSmsCount(Integer smsCount) {
        this.smsCount = smsCount;
    }
}
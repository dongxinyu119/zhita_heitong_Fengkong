package com.zhita.Model;

import java.math.BigDecimal;

//通话区域分布（城市）表
public class ContactsCityInfos {
    private Integer id;

    private Integer xiaodaiUserid;//用户id

    private String city;//城市

    private Integer callCount;//通话次数通话详单中号码归属地统计，例：通话详单中本号 码与上海号通话次数

    private Integer callingCount;//主叫次数：通话详单中主叫归属地统计，例：通话详单中本号码主动拨打上海号通话次数

    private String callingDurationTime;//话详单中主叫归属地时间统计，例：通话详单中本号码主动拨打上海号通话总时长

    private Integer calledCount;//被叫次数：通话详单中被叫归属地统计，例：通话详单中被叫上海来电次数

    private String calledDurationTime;//被叫时间(分钟)：通话详单中被叫归属地时间统计，例：通话详单中本号码接到上海号通话总时长

    private BigDecimal callingCountPer;//主叫次数百分比：某城市主叫次数/总主叫次数

    private BigDecimal callingDurationTimePer;//主叫时间百分比：某城市主叫时间/总主叫时间

    private BigDecimal calledCountPer;//被叫次数百分比：某城市被叫次数/总被叫次数

    private BigDecimal calledDurationTimePer;//被叫时间百分比：某城市被叫时间/总被叫时间

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
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

    public BigDecimal getCallingCountPer() {
        return callingCountPer;
    }

    public void setCallingCountPer(BigDecimal callingCountPer) {
        this.callingCountPer = callingCountPer;
    }

    public BigDecimal getCallingDurationTimePer() {
        return callingDurationTimePer;
    }

    public void setCallingDurationTimePer(BigDecimal callingDurationTimePer) {
        this.callingDurationTimePer = callingDurationTimePer;
    }

    public BigDecimal getCalledCountPer() {
        return calledCountPer;
    }

    public void setCalledCountPer(BigDecimal calledCountPer) {
        this.calledCountPer = calledCountPer;
    }

    public BigDecimal getCalledDurationTimePer() {
        return calledDurationTimePer;
    }

    public void setCalledDurationTimePer(BigDecimal calledDurationTimePer) {
        this.calledDurationTimePer = calledDurationTimePer;
    }
}
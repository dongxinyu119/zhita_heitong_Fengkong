package com.zhita.Model;

import java.math.BigDecimal;

//充值记录表
public class RechargeInfo {
    private Integer id;

    private Integer xiaodaiUserid;//用户id

    private String rechargeTime;//充值时间

    private Integer rechargeCount;//充值次数

    private BigDecimal rechargeAmount;//充值总金额

    private BigDecimal rechargeMax;//最大单笔充值金额

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

    public String getRechargeTime() {
        return rechargeTime;
    }

    public void setRechargeTime(String rechargeTime) {
        this.rechargeTime = rechargeTime == null ? null : rechargeTime.trim();
    }

    public Integer getRechargeCount() {
        return rechargeCount;
    }

    public void setRechargeCount(Integer rechargeCount) {
        this.rechargeCount = rechargeCount;
    }

    public BigDecimal getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(BigDecimal rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public BigDecimal getRechargeMax() {
        return rechargeMax;
    }

    public void setRechargeMax(BigDecimal rechargeMax) {
        this.rechargeMax = rechargeMax;
    }
}
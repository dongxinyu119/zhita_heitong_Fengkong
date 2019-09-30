package com.zhita.Model;

import java.math.BigDecimal;

//消费记录表
public class BillInfo {
    private Integer id;

    private Integer xiaodaiUserid;//用户id

    private String month;//月份

    private BigDecimal consumptionAmount;//消费金额

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

    public BigDecimal getConsumptionAmount() {
        return consumptionAmount;
    }

    public void setConsumptionAmount(BigDecimal consumptionAmount) {
        this.consumptionAmount = consumptionAmount;
    }
}
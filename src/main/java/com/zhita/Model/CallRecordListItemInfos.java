package com.zhita.Model;


//风险评估标记下的记录详情集合
public class CallRecordListItemInfos {
    private Integer id;

    private Integer srlid;//关联sms_record_label表

    private String phoneNumber;//短信号码

    private Integer calledCount;//收到短信次数

    private Integer totalCallCount;//总共收到次数

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSrlid() {
        return srlid;
    }

    public void setSrlid(Integer srlid) {
        this.srlid = srlid;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public Integer getCalledCount() {
        return calledCount;
    }

    public void setCalledCount(Integer calledCount) {
        this.calledCount = calledCount;
    }

    public Integer getTotalCallCount() {
        return totalCallCount;
    }

    public void setTotalCallCount(Integer totalCallCount) {
        this.totalCallCount = totalCallCount;
    }
}
package com.zhita.Model;

import java.math.BigDecimal;

//通信检测表
public class CommunicationDetection {
    private Integer id;

    private Integer xiaodaiUserid;//用户id

    private String theLastCallTime;//最近通话时间

    private Integer silentCount;//静默次数：近六个月中，24小时以内无通话记录或无短信记录或无上网信息”的总次数

    private String silentDurationTime;//静默时长

    private String averageSilentDurationTime;//平均静默时长：近六个月中24小时以内无通话记录或无短信记录或无上网信息”的总静默时间

    private String theLastSilentDurationTime;//最近一次静默时长：最近一次24小时以内无通话记录或无短信记录或无上网信息时间

    private BigDecimal nightActivities;//夜间活动情况 ：通话时间”字段中23点 ~6点之间的通话占总通话数的比率

    private String longSilentTime;//最长一次静默时间

    private String longSilentDurationTime;//最长一次静默时长

    private String theLongSilentDurationTime;//最长一次静默时间 + 时长

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

    public String getTheLastCallTime() {
        return theLastCallTime;
    }

    public void setTheLastCallTime(String theLastCallTime) {
        this.theLastCallTime = theLastCallTime == null ? null : theLastCallTime.trim();
    }

    public Integer getSilentCount() {
        return silentCount;
    }

    public void setSilentCount(Integer silentCount) {
        this.silentCount = silentCount;
    }

    public String getSilentDurationTime() {
        return silentDurationTime;
    }

    public void setSilentDurationTime(String silentDurationTime) {
        this.silentDurationTime = silentDurationTime == null ? null : silentDurationTime.trim();
    }

    public String getAverageSilentDurationTime() {
        return averageSilentDurationTime;
    }

    public void setAverageSilentDurationTime(String averageSilentDurationTime) {
        this.averageSilentDurationTime = averageSilentDurationTime == null ? null : averageSilentDurationTime.trim();
    }

    public String getTheLastSilentDurationTime() {
        return theLastSilentDurationTime;
    }

    public void setTheLastSilentDurationTime(String theLastSilentDurationTime) {
        this.theLastSilentDurationTime = theLastSilentDurationTime == null ? null : theLastSilentDurationTime.trim();
    }

    public BigDecimal getNightActivities() {
        return nightActivities;
    }

    public void setNightActivities(BigDecimal nightActivities) {
        this.nightActivities = nightActivities;
    }

    public String getLongSilentTime() {
        return longSilentTime;
    }

    public void setLongSilentTime(String longSilentTime) {
        this.longSilentTime = longSilentTime == null ? null : longSilentTime.trim();
    }

    public String getLongSilentDurationTime() {
        return longSilentDurationTime;
    }

    public void setLongSilentDurationTime(String longSilentDurationTime) {
        this.longSilentDurationTime = longSilentDurationTime == null ? null : longSilentDurationTime.trim();
    }

    public String getTheLongSilentDurationTime() {
        return theLongSilentDurationTime;
    }

    public void setTheLongSilentDurationTime(String theLongSilentDurationTime) {
        this.theLongSilentDurationTime = theLongSilentDurationTime == null ? null : theLongSilentDurationTime.trim();
    }
}
package com.zhita.Model;

//出行分析表
public class TravelInfo {
    private Integer id;

    private Integer xiaodaiUserid;//用户id

    private String duringType;//时间段

    private String startTime;//出行时间

    private String returnTime;//回程时间

    private String departurePlace;//出行地

    private String destinationPlace;//目的地

    private Integer durationDays;//行程时间（天）

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

    public String getDuringType() {
        return duringType;
    }

    public void setDuringType(String duringType) {
        this.duringType = duringType == null ? null : duringType.trim();
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime == null ? null : returnTime.trim();
    }

    public String getDeparturePlace() {
        return departurePlace;
    }

    public void setDeparturePlace(String departurePlace) {
        this.departurePlace = departurePlace == null ? null : departurePlace.trim();
    }

    public String getDestinationPlace() {
        return destinationPlace;
    }

    public void setDestinationPlace(String destinationPlace) {
        this.destinationPlace = destinationPlace == null ? null : destinationPlace.trim();
    }

    public Integer getDurationDays() {
        return durationDays;
    }

    public void setDurationDays(Integer durationDays) {
        this.durationDays = durationDays;
    }
}
package com.zhita.Model;

import java.math.BigDecimal;

//主要活动区域集合表
public class MainLocations {
    private Integer id;

    private Integer ofid;//关联operator_info表

    private String location;//主要活动区域

    private BigDecimal percent;//主要活动区域占比

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOfid() {
        return ofid;
    }

    public void setOfid(Integer ofid) {
        this.ofid = ofid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public BigDecimal getPercent() {
        return percent;
    }

    public void setPercent(BigDecimal percent) {
        this.percent = percent;
    }
}
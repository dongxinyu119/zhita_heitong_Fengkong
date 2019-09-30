package com.zhita.Model;

import java.math.BigDecimal;

//朋友圈区域集合表
public class CircleOfFriendsLocations {
    private Integer id;

    private Integer ofid;//关联operator_info表

    private Integer socid;//关联social_connectionsinfo表

    private String location;//朋友圈区域

    private BigDecimal percent;//朋友圈区域

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

    public Integer getSocid() {
        return socid;
    }

    public void setSocid(Integer socid) {
        this.socid = socid;
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
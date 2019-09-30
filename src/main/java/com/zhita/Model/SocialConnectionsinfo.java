package com.zhita.Model;

import java.util.List;

//社交关系表
public class SocialConnectionsinfo {
    private Integer id;

    private Integer xiaodaiUserid;//用户id

    private Integer phoneCount;//联系号码总数

    private Integer interflowCallPhoneCount;//互通号码数

    private Integer compactnessCallCount;//朋友圈紧密联系人数

    private Integer ephemeralCallCount;//疑是骚扰电话个数
    
    private List<CircleOfFriendsLocations> listcir;//朋友圈区域集合

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

    public Integer getPhoneCount() {
        return phoneCount;
    }

    public void setPhoneCount(Integer phoneCount) {
        this.phoneCount = phoneCount;
    }

    public Integer getInterflowCallPhoneCount() {
        return interflowCallPhoneCount;
    }

    public void setInterflowCallPhoneCount(Integer interflowCallPhoneCount) {
        this.interflowCallPhoneCount = interflowCallPhoneCount;
    }

    public Integer getCompactnessCallCount() {
        return compactnessCallCount;
    }

    public void setCompactnessCallCount(Integer compactnessCallCount) {
        this.compactnessCallCount = compactnessCallCount;
    }

    public Integer getEphemeralCallCount() {
        return ephemeralCallCount;
    }

    public void setEphemeralCallCount(Integer ephemeralCallCount) {
        this.ephemeralCallCount = ephemeralCallCount;
    }

	public List<CircleOfFriendsLocations> getListcir() {
		return listcir;
	}

	public void setListcir(List<CircleOfFriendsLocations> listcir) {
		this.listcir = listcir;
	}
    
}
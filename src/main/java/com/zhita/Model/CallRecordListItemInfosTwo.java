package com.zhita.Model;

import java.util.List;

//关联call_record_list_infos表
public class CallRecordListItemInfosTwo {
    private Integer id;

    private Integer crlid;//关联call_record_list_infos表

    private String calledCount;//别叫通话次数

    private String callingCount;//主叫通话次数

    private String phoneNumber;//号码
    
    private List<CallStatistics> listcs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCrlid() {
        return crlid;
    }

    public void setCrlid(Integer crlid) {
        this.crlid = crlid;
    }

    public String getCalledCount() {
        return calledCount;
    }

    public void setCalledCount(String calledCount) {
        this.calledCount = calledCount == null ? null : calledCount.trim();
    }

    public String getCallingCount() {
        return callingCount;
    }

    public void setCallingCount(String callingCount) {
        this.callingCount = callingCount == null ? null : callingCount.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

	public List<CallStatistics> getListcs() {
		return listcs;
	}

	public void setListcs(List<CallStatistics> listcs) {
		this.listcs = listcs;
	}
    
}
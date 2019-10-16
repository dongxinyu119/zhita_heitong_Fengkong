package com.zhita.Model;

import java.util.List;

//关联sensitive_info_newupa表
public class CallRecordListInfos {
    private Integer id;

    private Integer sentivid;//关联sensitive_info_newupa表

    private String name;//互联网标记名称
    
    private List<CallRecordListItemInfosTwo> listct;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSentivid() {
        return sentivid;
    }

    public void setSentivid(Integer sentivid) {
        this.sentivid = sentivid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

	public List<CallRecordListItemInfosTwo> getListct() {
		return listct;
	}

	public void setListct(List<CallRecordListItemInfosTwo> listct) {
		this.listct = listct;
	}
    
}
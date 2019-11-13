package com.zhita.Model;

//规则分类表
public class RulelistType {
    private Integer id;

    private String type;//规则分类
    
    private String bigtype;//规则大分类

    private String deleted;//假删除（1：删除；0：没删除）

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted == null ? null : deleted.trim();
    }

	public String getBigtype() {
		return bigtype;
	}

	public void setBigtype(String bigtype) {
		this.bigtype = bigtype;
	}
    
}
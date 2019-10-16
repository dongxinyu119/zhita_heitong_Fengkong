package com.zhita.Model;

//规则表
public class Rulelist {
    private Integer id;

    private Integer typeid;//规则分类id

    private String rulelist;//规则名字

    private String keyword;//关键词

    private String symbol;//符号

    private String thresholdValue;//阈值

    private String value_at_risk;//风险分值
    
    private String tablename;//表名
    
    private String status;//状态 (1 开启 ;2 关闭)

    private String deleted;//假删除（1：删除；0：没删除）
    
    private String type;//规则分类
    
    private Integer status;//开启状态  1 开启  2 关闭

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public String getRulelist() {
		return rulelist;
	}

	public void setRulelist(String rulelist) {
		this.rulelist = rulelist;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getThresholdValue() {
		return thresholdValue;
	}

	public void setThresholdValue(String thresholdValue) {
		this.thresholdValue = thresholdValue;
	}

	public String getValue_at_risk() {
		return value_at_risk;
	}

	public void setValue_at_risk(String value_at_risk) {
		this.value_at_risk = value_at_risk;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	

	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
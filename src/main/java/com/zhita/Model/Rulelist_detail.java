package com.zhita.Model;


/**
 * 规则详情表
 * @author Administrator
 *
 */
public class Rulelist_detail {
	
	private Integer id;
	
	private Integer rtid;
	
	private Integer rid;
	
	private Integer uid;
	
	private String sum;//该规则分类的总扣分
	
	private String type;//规则分类名

	public Integer getRtid() {
		return rtid;
	}

	public void setRtid(Integer rtid) {
		this.rtid = rtid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}

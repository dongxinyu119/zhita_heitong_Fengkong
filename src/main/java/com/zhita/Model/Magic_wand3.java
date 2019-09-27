package com.zhita.Model;

public class Magic_wand3 {
	
	private Integer id;//魔杖3ID
	
	private String name;//姓名
	
	private String idcard;//身份证号
	
	private String mobile;//手机号
	
	private Integer user_id;//用户ID
	
	private String trans_id;//流水号
	
	private String mz_score;//魔杖分
	
	private String has_mz_data;//魔杖标准版报告是否命中（0
	
	private String is_rule;//'高危规则是否命中（0:未命中；1:命中；-99999:未覆盖）',
	
	private String has_duotou_data;//'是否覆盖多头 0：未覆盖；1：覆盖',
	
	private String now_org_count;//'当天贷款申请机构数',
	
	private String org_count;//'注册机构数量',
	
	private String org_count_180d;//'近180天注册机构数（去重）',
	
	private String org_count_1d;//'近1天注册机构数（去重）',
	
	private String org_count_30d;//'近30天注册机构数（去重）',
	
	private String org_count_60d;//'近60天注册机构数（去重）',
	
	private String org_count_7d;//'近7天注册机构数（去重）',
	
	private String org_count_90d;//'近90天注册机构数（去重）',
	
	private String queried_detail_org_count;//机构查询次数（不去重）
	
	private String queried_detail_org_count_180d;//近180天机构查询次数
	
	private String queried_detail_org_count_1d;//'近1天机构查询次数
	
	private String queried_detail_org_count_30d;//'近30天机构查询次数',
	
	private String queried_detail_org_count_60d;//'近60天机构查询次数量
	
	private String queried_detail_org_count_7d;//'近7天机构查询次数',
	
	private String queried_detail_org_count_90d;//'近90天机构查询次数',
	
	private String attentionlist_1;//'是否命中关注名单I类（枚举：0-未命中，1-命中）',
	
	private String attentionlist_2;//'是否命中关注名单II类（枚举：0-未命中，1-命中）',
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getTrans_id() {
		return trans_id;
	}

	public void setTrans_id(String trans_id) {
		this.trans_id = trans_id;
	}

	public String getMz_score() {
		return mz_score;
	}

	public void setMz_score(String mz_score) {
		this.mz_score = mz_score;
	}

	public String getHas_mz_data() {
		return has_mz_data;
	}

	public void setHas_mz_data(String has_mz_data) {
		this.has_mz_data = has_mz_data;
	}

	public String getIs_rule() {
		return is_rule;
	}

	public void setIs_rule(String is_rule) {
		this.is_rule = is_rule;
	}

	public String getHas_duotou_data() {
		return has_duotou_data;
	}

	public void setHas_duotou_data(String has_duotou_data) {
		this.has_duotou_data = has_duotou_data;
	}

	public String getNow_org_count() {
		return now_org_count;
	}

	public void setNow_org_count(String now_org_count) {
		this.now_org_count = now_org_count;
	}

	public String getOrg_count() {
		return org_count;
	}

	public void setOrg_count(String org_count) {
		this.org_count = org_count;
	}

	public String getOrg_count_180d() {
		return org_count_180d;
	}

	public void setOrg_count_180d(String org_count_180d) {
		this.org_count_180d = org_count_180d;
	}

	public String getOrg_count_1d() {
		return org_count_1d;
	}

	public void setOrg_count_1d(String org_count_1d) {
		this.org_count_1d = org_count_1d;
	}

	public String getOrg_count_30d() {
		return org_count_30d;
	}

	public void setOrg_count_30d(String org_count_30d) {
		this.org_count_30d = org_count_30d;
	}

	public String getOrg_count_60d() {
		return org_count_60d;
	}

	public void setOrg_count_60d(String org_count_60d) {
		this.org_count_60d = org_count_60d;
	}

	public String getOrg_count_7d() {
		return org_count_7d;
	}

	public void setOrg_count_7d(String org_count_7d) {
		this.org_count_7d = org_count_7d;
	}

	public String getOrg_count_90d() {
		return org_count_90d;
	}

	public void setOrg_count_90d(String org_count_90d) {
		this.org_count_90d = org_count_90d;
	}

	public String getQueried_detail_org_count() {
		return queried_detail_org_count;
	}

	public void setQueried_detail_org_count(String queried_detail_org_count) {
		this.queried_detail_org_count = queried_detail_org_count;
	}

	public String getQueried_detail_org_count_180d() {
		return queried_detail_org_count_180d;
	}

	public void setQueried_detail_org_count_180d(
			String queried_detail_org_count_180d) {
		this.queried_detail_org_count_180d = queried_detail_org_count_180d;
	}

	public String getQueried_detail_org_count_1d() {
		return queried_detail_org_count_1d;
	}

	public void setQueried_detail_org_count_1d(String queried_detail_org_count_1d) {
		this.queried_detail_org_count_1d = queried_detail_org_count_1d;
	}

	public String getQueried_detail_org_count_30d() {
		return queried_detail_org_count_30d;
	}

	public void setQueried_detail_org_count_30d(String queried_detail_org_count_30d) {
		this.queried_detail_org_count_30d = queried_detail_org_count_30d;
	}

	public String getQueried_detail_org_count_60d() {
		return queried_detail_org_count_60d;
	}

	public void setQueried_detail_org_count_60d(String queried_detail_org_count_60d) {
		this.queried_detail_org_count_60d = queried_detail_org_count_60d;
	}

	public String getQueried_detail_org_count_7d() {
		return queried_detail_org_count_7d;
	}

	public void setQueried_detail_org_count_7d(String queried_detail_org_count_7d) {
		this.queried_detail_org_count_7d = queried_detail_org_count_7d;
	}

	public String getQueried_detail_org_count_90d() {
		return queried_detail_org_count_90d;
	}

	public void setQueried_detail_org_count_90d(String queried_detail_org_count_90d) {
		this.queried_detail_org_count_90d = queried_detail_org_count_90d;
	}

	public String getAttentionlist_1() {
		return attentionlist_1;
	}

	public void setAttentionlist_1(String attentionlist_1) {
		this.attentionlist_1 = attentionlist_1;
	}

	public String getAttentionlist_2() {
		return attentionlist_2;
	}

	public void setAttentionlist_2(String attentionlist_2) {
		this.attentionlist_2 = attentionlist_2;
	}
	
	

}

package com.zhita.Model;

import java.math.BigDecimal;

//充值记录表
public class RechargeInfo {
    private Integer id;

    private Integer xiaodaiUserid;//用户id

    private String rechargeTime;//充值时间

    private Integer rechargeCount;//充值次数

    private BigDecimal rechargeAmount;//充值总金额

    private BigDecimal rechargeMax;//最大单笔充值金额
    
    private Integer xiaodai_userid;//用户id

    private String recharge_time;//充值时间

    private Integer recharge_count;//充值次数

    private BigDecimal recharge_amount;//充值总金额

    private BigDecimal recharge_max;//最大单笔充值金额
    
    public Integer getXiaodai_userid() {
		return xiaodai_userid;
	}

	public void setXiaodai_userid(Integer xiaodai_userid) {
		this.xiaodai_userid = xiaodai_userid;
	}

	public String getRecharge_time() {
		return recharge_time;
	}

	public void setRecharge_time(String recharge_time) {
		this.recharge_time = recharge_time;
	}

	public Integer getRecharge_count() {
		return recharge_count;
	}

	public void setRecharge_count(Integer recharge_count) {
		this.recharge_count = recharge_count;
	}

	public BigDecimal getRecharge_amount() {
		return recharge_amount;
	}

	public void setRecharge_amount(BigDecimal recharge_amount) {
		this.recharge_amount = recharge_amount;
	}

	public BigDecimal getRecharge_max() {
		return recharge_max;
	}

	public void setRecharge_max(BigDecimal recharge_max) {
		this.recharge_max = recharge_max;
	}

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

    public String getRechargeTime() {
        return rechargeTime;
    }

    public void setRechargeTime(String rechargeTime) {
        this.rechargeTime = rechargeTime == null ? null : rechargeTime.trim();
    }

    public Integer getRechargeCount() {
        return rechargeCount;
    }

    public void setRechargeCount(Integer rechargeCount) {
        this.rechargeCount = rechargeCount;
    }

    public BigDecimal getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(BigDecimal rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public BigDecimal getRechargeMax() {
        return rechargeMax;
    }

    public void setRechargeMax(BigDecimal rechargeMax) {
        this.rechargeMax = rechargeMax;
    }
}
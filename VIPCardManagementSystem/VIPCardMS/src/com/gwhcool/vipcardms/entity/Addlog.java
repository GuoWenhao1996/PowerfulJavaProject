package com.gwhcool.vipcardms.entity;

import java.util.Date;

/**
 * 充值记录
 * 
 * @author gwh
 *
 */
public class Addlog {
	private int aid;// 充钱id
	private Date time;// 充值时间
	private double money;// 充值金额
	private int uid;// 用户id

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public Addlog(int aid, Date time, double money, int uid) {
		super();
		this.aid = aid;
		this.time = time;
		this.money = money;
		this.uid = uid;
	}

	public Addlog(Date time, double money, int uid) {
		super();
		this.time = time;
		this.money = money;
		this.uid = uid;
	}

	public Addlog() {
		super();
	}

	@Override
	public String toString() {
		return "Addlog [aid=" + aid + ", time=" + time + ", money=" + money + ", uid=" + uid + "]";
	}

}

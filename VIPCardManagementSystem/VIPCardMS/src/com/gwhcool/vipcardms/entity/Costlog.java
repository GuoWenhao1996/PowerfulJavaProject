package com.gwhcool.vipcardms.entity;

import java.util.Date;

/**
 * 消费记录
 * 
 * @author gwh
 *
 */
public class Costlog {
	
	private int cid;//消费id
	private Date time;//消费时间
	private double money;//消费金额
	private String desc;//消费详情
	private int uid;//用户id
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public Costlog(int cid, Date time, double money, String desc, int uid) {
		super();
		this.cid = cid;
		this.time = time;
		this.money = money;
		this.desc = desc;
		this.uid = uid;
	}
	
	public Costlog(Date time, double money, String desc, int uid) {
		super();
		this.time = time;
		this.money = money;
		this.desc = desc;
		this.uid = uid;
	}
	public Costlog() {
		super();
	}
	@Override
	public String toString() {
		return "Costlog [cid=" + cid + ", time=" + time + ", money=" + money + ", desc=" + desc + ", uid=" + uid + "]";
	}
	

}

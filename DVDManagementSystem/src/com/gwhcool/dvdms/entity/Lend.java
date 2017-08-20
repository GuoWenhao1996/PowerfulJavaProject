package com.gwhcool.dvdms.entity;

import java.util.Date;

/**
 * 借阅实体类
 * 
 * @author gwh
 * @since 1.5
 */
public class Lend {
	private int did;// DVD编号
	private int cid;// 客户编号
	private Date lendtime;// 借阅时间
	private Date backtime;// 归还时间

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public Date getLendtime() {
		return lendtime;
	}

	public void setLendtime(Date lendtime) {
		this.lendtime = lendtime;
	}

	public Date getBacktime() {
		return backtime;
	}

	public void setBacktime(Date backtime) {
		this.backtime = backtime;
	}

	public Lend() {
		super();
	}

	public Lend(int did, int cid, Date lendtime, Date backtime) {
		super();
		this.did = did;
		this.cid = cid;
		this.lendtime = lendtime;
		this.backtime = backtime;
	}

	public Lend(int did, int cid) {
		super();
		this.did = did;
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "Lend [did=" + did + ", cid=" + cid + ", lendtime=" + lendtime + ", backtime=" + backtime + "]";
	}

}

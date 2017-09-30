package com.chinasofti.blc.tiremusic.music.entity;
/**
 * 敏感词实体类
 * @author Administrator
 *
 */
public class Sensitiveword {

	private int swid;//敏感词id
	private String swtext;//敏感词内容
	public int getSwid() {
		return swid;
	}
	public void setSwid(int swid) {
		this.swid = swid;
	}
	public String getSwtext() {
		return swtext;
	}
	public void setSwtext(String swtext) {
		this.swtext = swtext;
	}
	public Sensitiveword() {
		super();
	}
	
}

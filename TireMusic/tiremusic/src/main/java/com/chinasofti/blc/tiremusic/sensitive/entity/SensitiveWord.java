package com.chinasofti.blc.tiremusic.sensitive.entity;

import java.io.Serializable;

/**
 * 违禁词汇实体
 * 
 * @author guowh
 *
 */
public class SensitiveWord implements Serializable {
	private static final long serialVersionUID = 1L;
	private int swid;// 违禁词汇id
	private String swtext;// 违禁词汇内容

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

	public SensitiveWord() {
		super();
	}

	public SensitiveWord(int swid, String swtext) {
		super();
		this.swid = swid;
		this.swtext = swtext;
	}

	@Override
	public String toString() {
		return "SensitiveWord [swid=" + swid + ", swtext=" + swtext + "]";
	}

}

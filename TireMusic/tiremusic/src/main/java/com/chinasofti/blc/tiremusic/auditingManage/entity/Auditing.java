package com.chinasofti.blc.tiremusic.auditingManage.entity;

import java.io.Serializable;

public class Auditing implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int uploadlistid;
	private int songid;
	private int uploadid;
	private int state;
	private String songname;
	private String uploadname;
	
	
	public String getUploadname() {
		return uploadname;
	}
	public void setUploadname(String uploadname) {
		this.uploadname = uploadname;
	}
	public String getSongname() {
		return songname;
	}
	public void setSongname(String songname) {
		this.songname = songname;
	}
	public int getUploadlistid() {
		return uploadlistid;
	}
	public void setUploadlistid(int uploadlistid) {
		this.uploadlistid = uploadlistid;
	}
	public int getSongid() {
		return songid;
	}
	public void setSongid(int songid) {
		this.songid = songid;
	}
	public int getUploadid() {
		return uploadid;
	}
	public void setUploadid(int uploadid) {
		this.uploadid = uploadid;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Auditing() {
		super();
	}
	public Auditing(int uploadlistid, int songid, int uploadid, int state, String songname, String uploadname) {
		super();
		this.uploadlistid = uploadlistid;
		this.songid = songid;
		this.uploadid = uploadid;
		this.state = state;
		this.songname = songname;
		this.uploadname = uploadname;
	}
	
	
}

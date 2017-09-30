package com.chinasofti.blc.tiremusic.music.entity;
/**
 * 流派实体类
 * @author Administrator
 *
 */
public class School {
	private int schoolid;//流派编号
	private String schoolname;//流派名称
	private String schooltext;//流派描述
	private int schoolstate;//流派状态
	public int getSchoolid() {
		return schoolid;
	}
	public void setSchoolid(int schoolid) {
		this.schoolid = schoolid;
	}
	public String getSchoolname() {
		return schoolname;
	}
	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}
	public String getSchooltext() {
		return schooltext;
	}
	public void setSchooltext(String schooltext) {
		this.schooltext = schooltext;
	}
	public int getSchoolstate() {
		return schoolstate;
	}
	public void setSchoolstate(int schoolstate) {
		this.schoolstate = schoolstate;
	}
	public School() {
		super();
	}
	
}

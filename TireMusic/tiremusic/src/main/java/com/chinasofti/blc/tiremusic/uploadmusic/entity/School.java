package com.chinasofti.blc.tiremusic.uploadmusic.entity;

import java.io.Serializable;

public class School implements Serializable{
private String schoolname;
private int schoolid;
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

public School(String schoolname, int schoolid) {
	super();
	this.schoolname = schoolname;
	this.schoolid = schoolid;
}

public School() {
	super();
}



}

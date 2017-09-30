package com.chinasofti.blc.tiremusic.uploadmusic.entity;

import java.io.Serializable;
import java.util.Date;

public class UploadMusic implements Serializable{
private java.util.Date uploadtime;
private String songname;
private int uploadlistid;
private String songername;
private String location;
private String schoolid;
private String songerid;
public String getSongerid() {
	return songerid;
}
public void setSongerid(String songerid) {
	this.songerid = songerid;
}
public String getSchoolid() {
	return schoolid;
}
public void setSchoolid(String schoolid) {
	this.schoolid = schoolid;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
private int state;
public int getState() {
	return state;
}
public void setState(int state) {
	this.state = state;
}
public String getSongername() {
	return songername;
}
public void setSongername(String songername) {
	this.songername = songername;
}
public String getSchoolname() {
	return schoolname;
}
public void setSchoolname(String schoolname) {
	this.schoolname = schoolname;
}
public String getAlbumname() {
	return albumname;
}
public void setAlbumname(String albumname) {
	this.albumname = albumname;
}
private String schoolname;
private String albumname;
public String getSongname() {
	return songname;
}
public void setSongname(String songname) {
	this.songname = songname;
}
public java.util.Date getUploadtime() {
	return uploadtime;
}
public void setUploadtime(java.util.Date uploadtime) {
	this.uploadtime = uploadtime;
}
public int getUploadlistid() {
	return uploadlistid;
}
public void setUploadlistid(int uploadlistid) {
	this.uploadlistid = uploadlistid;
}

public UploadMusic(Date uploadtime, String songname, int uploadlistid, String songername, String location, int state,
		String schoolname, String albumname) {
	super();
	this.uploadtime = uploadtime;
	this.songname = songname;
	this.uploadlistid = uploadlistid;
	this.songername = songername;
	this.location = location;
	this.state = state;
	this.schoolname = schoolname;
	this.albumname = albumname;
}
public UploadMusic() {
	super();
}

}

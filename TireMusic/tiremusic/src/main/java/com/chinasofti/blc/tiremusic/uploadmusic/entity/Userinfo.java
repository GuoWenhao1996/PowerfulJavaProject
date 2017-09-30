package com.chinasofti.blc.tiremusic.uploadmusic.entity;

import java.io.Serializable;

public class Userinfo implements Serializable{
private int uid;
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public int getUploadlistid() {
	return uploadlistid;
}
public void setUploadlistid(int uploadlistid) {
	this.uploadlistid = uploadlistid;
}
public int getDownloadlistid() {
	return downloadlistid;
}
public void setDownloadlistid(int downloadlistid) {
	this.downloadlistid = downloadlistid;
}
public int getConfirmid() {
	return confirmid;
}
public void setConfirmid(int confirmid) {
	this.confirmid = confirmid;
}
private int uploadlistid;
private int downloadlistid;
private int confirmid;
public Userinfo(int uid, int uploadlistid, int downloadlistid, int confirmid) {
	super();
	this.uid = uid;
	this.uploadlistid = uploadlistid;
	this.downloadlistid = downloadlistid;
	this.confirmid = confirmid;
}
public Userinfo() {
	super();
}

}

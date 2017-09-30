package com.chinasofti.blc.tiremusic.musiclist.entity;

import java.io.Serializable;

public class Musiclist implements Serializable{
private String songname;
public String getSongname() {
	return songname;
}
public void setSongname(String songname) {
	this.songname = songname;
}
public String getSongername() {
	return songername;
}
public void setSongername(String songername) {
	this.songername = songername;
}
public String getAlbumname() {
	return albumname;
}
public void setAlbumname(String albumname) {
	this.albumname = albumname;
}
public String getSchoolname() {
	return schoolname;
}
public void setSchoolname(String schoolname) {
	this.schoolname = schoolname;
}
private String songername;
private String albumname;
private String schoolname;
public Musiclist(String songname, String songername, String albumname, String schoolname) {
	super();
	this.songname = songname;
	this.songername = songername;
	this.albumname = albumname;
	this.schoolname = schoolname;
}
public Musiclist() {
	super();
}
}

package com.chinasofti.blc.tiremusic.downloadmusic.entity;

import java.io.Serializable;

public class DownloadMusic implements Serializable{

private static final long serialVersionUID = 1L;
private int songid;
public int getSongid() {
	return songid;
}
public void setSongid(int songid) {
	this.songid = songid;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
private String location;
public DownloadMusic(int songid, String location) {
	super();
	this.songid = songid;
	this.location = location;
}
public DownloadMusic() {
	super();
}

}

package com.chinasofti.blc.tiremusic.downloadmusic.entity;

public class Song {
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
public Song(int songid, String location) {
	super();
	this.songid = songid;
	this.location = location;
}
public Song() {
	super();
}

}

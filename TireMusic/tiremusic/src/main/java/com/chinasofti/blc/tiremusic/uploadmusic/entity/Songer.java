package com.chinasofti.blc.tiremusic.uploadmusic.entity;

public class Songer {
private int songerid;
private String songername;
public int getSongerid() {
	return songerid;
}
public void setSongerid(int songerid) {
	this.songerid = songerid;
}
public String getSongername() {
	return songername;
}
public void setSongername(String songername) {
	this.songername = songername;
}
public Songer(int songerid, String songername) {
	super();
	this.songerid = songerid;
	this.songername = songername;
}
public Songer() {
	super();
}

}

package com.chinasoft.tiremusic.test.entity;

import java.io.Serializable;

public class Song implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int songid;
	private String songname;
	private String songer;
	private String songurl;
	public int getSongid() {
		return songid;
	}
	public void setSongid(int songid) {
		this.songid = songid;
	}
	public String getSongname() {
		return songname;
	}
	public void setSongname(String songname) {
		this.songname = songname;
	}
	public String getSonger() {
		return songer;
	}
	public void setSonger(String songer) {
		this.songer = songer;
	}
	public String getSongurl() {
		return songurl;
	}
	public void setSongurl(String songurl) {
		this.songurl = songurl;
	}
	public Song() {
		super();
	}
	
	
}

package com.chinasofti.blc.tiremusic.statistics.entry;

public class DownNum {
	private int downnum;
	private int songid;
	private String songname;
	public int getDownnum() {
		return downnum;
	}
	public void setDownnum(int downnum) {
		this.downnum = downnum;
	}
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
	public DownNum() {
		super();
	}
	public DownNum(int downnum, int songid, String songname) {
		super();
		this.downnum = downnum;
		this.songid = songid;
		this.songname = songname;
	}
	@Override
	public String toString() {
		return "DownNum [downnum=" + downnum + ", songid=" + songid + ", songname=" + songname + "]";
	}
	
	
}

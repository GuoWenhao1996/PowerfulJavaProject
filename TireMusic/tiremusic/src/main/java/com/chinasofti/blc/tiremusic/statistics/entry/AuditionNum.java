package com.chinasofti.blc.tiremusic.statistics.entry;

public class AuditionNum {
	private int auditionnum;
	private int songid;
	private String songname;
	public int getAuditionnum() {
		return auditionnum;
	}
	public void setAuditionnum(int auditionnum) {
		this.auditionnum = auditionnum;
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
	public AuditionNum() {
		super();
	}
	public AuditionNum(int auditionnum, int songid, String songname) {
		super();
		this.auditionnum = auditionnum;
		this.songid = songid;
		this.songname = songname;
	}
	@Override
	public String toString() {
		return "AuditionNum [auditionnum=" + auditionnum + ", songid=" + songid + ", songname=" + songname + "]";
	}
	
}

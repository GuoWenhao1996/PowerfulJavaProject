package com.chinasofti.blc.tiremusic.statistics.entry;

public class DownSong {
	private int downnum;
	private int songid;
	private String songername;
	private String songname;
	private String location;
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
	public String getSongername() {
		return songername;
	}
	public void setSongername(String songername) {
		this.songername = songername;
	}
	public String getSongname() {
		return songname;
	}
	public void setSongname(String songname) {
		this.songname = songname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public DownSong() {
		super();
	}
	@Override
	public String toString() {
		return "DownSong [downnum=" + downnum + ", songid=" + songid + ", songername=" + songername + ", songname="
				+ songname + ", location=" + location + "]";
	}
	
}

package com.chinasofti.blc.tiremusic.statistics.entry;

public class AuditionSong {
	private int auditionnum;
	private int songid;
	private String songername;
	private String songname;
	private String location;
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
	public AuditionSong() {
		super();
	}
	@Override
	public String toString() {
		return "AuditionSong [auditionnum=" + auditionnum + ", songid=" + songid + ", songername=" + songername
				+ ", songname=" + songname + ", location=" + location + "]";
	}
	
	
}

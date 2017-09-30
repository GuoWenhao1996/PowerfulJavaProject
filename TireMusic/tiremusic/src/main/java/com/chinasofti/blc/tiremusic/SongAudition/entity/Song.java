package com.chinasofti.blc.tiremusic.SongAudition.entity;

import java.io.Serializable;

public class Song implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int songid;
	private String songname;
	private String songername;
	private String location;
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
	public String getSongername() {
		return songername;
	}
	public void setSongername(String songername) {
		this.songername = songername;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Song() {
		super();
	}
	@Override
	public String toString() {
		return "Song [songid=" + songid + ", songname=" + songname + ", songername=" + songername + ", location="
				+ location + "]";
	}
	
	
}

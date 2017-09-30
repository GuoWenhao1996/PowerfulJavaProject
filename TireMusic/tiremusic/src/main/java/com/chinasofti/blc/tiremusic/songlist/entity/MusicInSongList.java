package com.chinasofti.blc.tiremusic.songlist.entity;

import java.io.Serializable;

/**
 * 歌单中的歌曲实体
 * 
 * @author guowh
 *
 */
public class MusicInSongList implements Serializable {

	private static final long serialVersionUID = 1L;
	private int songid; // 歌曲id
	private String songname; // 歌名
	private String location; // url
	private String songername;// 作者

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSongername() {
		return songername;
	}

	public void setSongername(String songername) {
		this.songername = songername;
	}

	public MusicInSongList() {
		super();
	}

	public MusicInSongList(int songid, String songname, String location, String songername) {
		super();
		this.songid = songid;
		this.songname = songname;
		this.location = location;
		this.songername = songername;
	}

	@Override
	public String toString() {
		return "MusicInSongList [songid=" + songid + ", songname=" + songname + ", location=" + location
				+ ", songername=" + songername + "]";
	}
}

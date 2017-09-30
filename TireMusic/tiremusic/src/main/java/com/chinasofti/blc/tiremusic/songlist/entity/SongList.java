package com.chinasofti.blc.tiremusic.songlist.entity;

import java.io.Serializable;
/**
 * 歌单实体类
 * @author guowh
 *
 */
public class SongList implements Serializable {

	private static final long serialVersionUID = 1L;
	private int songlistid;// 歌单id
	private String songlistname;// 歌单名称
	private int uid;// 用户id

	public int getSonglistid() {
		return songlistid;
	}

	public void setSonglistid(int songlistid) {
		this.songlistid = songlistid;
	}

	public String getSonglistname() {
		return songlistname;
	}

	public void setSonglistname(String songlistname) {
		this.songlistname = songlistname;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public SongList() {
		super();
	}

	public SongList(int songlistid, String songlistname, int uid) {
		super();
		this.songlistid = songlistid;
		this.songlistname = songlistname;
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "SongList [songlistid=" + songlistid + ", songlistname=" + songlistname + ", uid=" + uid + "]";
	}

}

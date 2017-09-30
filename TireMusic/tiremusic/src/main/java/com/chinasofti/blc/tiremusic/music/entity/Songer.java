package com.chinasofti.blc.tiremusic.music.entity;
/**
 * 歌手实体类
 * @author Administrator
 *
 */
public class Songer {

	private int songerid;//歌手编号
	private String songername;//歌手
	private String songertext;
	private int songerstate;
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
	public String getSongertext() {
		return songertext;
	}
	public void setSongertext(String songertext) {
		this.songertext = songertext;
	}
	public int getSongerstate() {
		return songerstate;
	}
	public void setSongerstate(int songerstate) {
		this.songerstate = songerstate;
	}
	public Songer() {
		super();
	}
	public Songer(int songerid, String songername, String songertext, int songerstate) {
		super();
		this.songerid = songerid;
		this.songername = songername;
		this.songertext = songertext;
		this.songerstate = songerstate;
	}
	
	
}

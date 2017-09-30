package com.chinasofti.blc.tiremusic.music.entity;

import java.util.Date;

/**
 * 专辑实体类
 * @author Administrator
 *
 */
public class Album {
	private int albumid;//专辑编号
	private String albumname;//专辑名称
	private Date releasetime;//上架时间
	private String  albumtext;//专辑描述
	private int albumsatte;//专辑状态
	public int getAlbumid() {
		return albumid;
	}
	public void setAlbumid(int albumid) {
		this.albumid = albumid;
	}
	public String getAlbumname() {
		return albumname;
	}
	public void setAlbumname(String albumname) {
		this.albumname = albumname;
	}
	
	public Date getReleasetime() {
		return releasetime;
	}
	public void setReleasetime(Date releasetime) {
		this.releasetime = releasetime;
	}
	public String getAlbumtext() {
		return albumtext;
	}
	public void setAlbumtext(String albumtext) {
		this.albumtext = albumtext;
	}
	public int getAlbumsatte() {
		return albumsatte;
	}
	public void setAlbumsatte(int albumsatte) {
		this.albumsatte = albumsatte;
	}
	public Album() {
		super();
	}
	
}

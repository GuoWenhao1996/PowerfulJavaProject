package com.chinasofti.blc.tiremusic.mv.entity;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
/**
 * MV实体类
 * @author Administrator
 *
 */
public class Mv implements Serializable{
	private static final long serialVersionUID = 1L;
	private int mvid;
	private String mvname;
	private String songid;
	private Date releasetime;
	private int downloadtimes;
	private String frontimg;
	private String location;
	private int mvpustate;
	private String mvstate;
	private String mvtext;

	public String getMvtext() {
		return mvtext;
	}
	public void setMvtext(String mvtext) {
		this.mvtext = mvtext;
	}
	public String getMvstate() {
		return mvstate;
	}
	public void setMvstate(String mvstate) {
		this.mvstate = mvstate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getMvpustate() {
		return mvpustate;
	}
	public void setMvpustate(int mvpustate) {
		this.mvpustate = mvpustate;
	}
	public String getMvurl() {
		return location;
	}
	public void setMvurl(String mvurl) {
		this.location = mvurl;
	}
	public int getMvid() {
		return mvid;
	}
	public void setMvid(int mvid) {
		this.mvid = mvid;
	}
	public String getMvname() {
		return mvname;
	}
	public void setMvname(String mvname) {
		this.mvname = mvname;
	}
	public String getSongid() {
		return songid;
	}
	public void setSongid(String songid) {
		this.songid = songid;
	}
	public Date getReleasetime() {
		return releasetime;
	}
	public void setReleasetime(Date releasetime) {
		this.releasetime = releasetime;
	}
	
	public int getDownloadtimes() {
		return downloadtimes;
	}
	public void setDownloadtimes(int downloadtimes) {
		this.downloadtimes = downloadtimes;
	}
	public String getFrontimg() {
		return frontimg;
	}
	public void setFrontimg(String frontimg) {
		this.frontimg = frontimg;
	}
	public Mv() {
		super();
	}
	@Override
	public String toString() {
		return "Mv [mvid=" + mvid + ", mvname=" + mvname + ", songid=" + songid + ", releasetime=" + releasetime
				+ ", downloadtimes=" + downloadtimes + ", frontimg=" + frontimg + ", location=" + location
				+ ", mvpustate=" + mvpustate + ", mvstate=" + mvstate + ", mvtext=" + mvtext + "]";
	}
	
	
}

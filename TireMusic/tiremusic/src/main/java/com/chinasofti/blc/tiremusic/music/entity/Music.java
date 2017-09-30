package com.chinasofti.blc.tiremusic.music.entity;

/**
 * 歌曲信息实体类
 * @author Administrator
 *
 */
public class Music {
	private int songid;//歌曲名称       
	private String songname;//歌曲名称  
	private int songerid;//歌手id     
	private String songername;//歌手  
	private int albumid;//专辑id      
	private String albumname;//专辑   
	private int schoolid;//流派id     
	private String schoolname;//流派  
	private String frontimg;//歌曲封面  
	private int songstate;//歌曲状态 
	private String location;//歌曲位置
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
	public int getSchoolid() {
		return schoolid;
	}
	public void setSchoolid(int schoolid) {
		this.schoolid = schoolid;
	}
	public String getSchoolname() {
		return schoolname;
	}
	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}
	public String getFrontimg() {
		return frontimg;
	}
	public void setFrontimg(String frontimg) {
		this.frontimg = frontimg;
	}
	public int getSongstate() {
		return songstate;
	}
	public void setSongstate(int songstate) {
		this.songstate = songstate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Music() {
		super();
	}
	
	
}

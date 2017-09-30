package com.chinasofti.blc.tiremusic.SongAudition.service;

import java.util.List;

import com.chinasofti.blc.tiremusic.SongAudition.dao.SongListenDao;
import com.chinasofti.blc.tiremusic.SongAudition.entity.Song;

public class SongListenService {

	private SongListenDao songListenDao = new SongListenDao();
	
	public boolean addShiTing(int uid,int songid) {
		return songListenDao.addShiTing(uid, songid);
	}
	
	public List<Song> newSongs(){
		return songListenDao.newSongs();
	}
}

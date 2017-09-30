package com.chinasofti.blc.tiremusic.downloadmusic.service;

import java.util.List;

import com.chinasofti.blc.tiremusic.downloadmusic.dao.DownLoadMusicDao;
import com.chinasofti.blc.tiremusic.downloadmusic.entity.Song;
import com.chinasofti.blc.tiremusic.musiclist.entity.Musiclist;

public class DownloadMusicService {
	private DownLoadMusicDao dao=new DownLoadMusicDao();
public boolean downloadmusic(int uid,int songid,int downloadlistid) {
	return dao.downloadmusic(uid, songid,downloadlistid);
}
public List<Musiclist> getmusiclist(int uid){
	return dao.getdownloadmusiclist(uid);
}
public Song selectlocation(int songid) {
	return dao.selectlocation(songid);
	
}
}

package com.chinasofti.blc.tiremusic.uploadmusic.service;

import com.chinasofti.blc.tiremusic.uploadmusic.dao.UploadMusicDao;
import com.chinasofti.blc.tiremusic.uploadmusic.entity.UploadMusic;

public class UploadMusicService {
	private UploadMusicDao dao=new UploadMusicDao();
    public boolean uploadmusic(int uid,UploadMusic up) {
	return dao.uploadmusic(uid,up);
	
}
}

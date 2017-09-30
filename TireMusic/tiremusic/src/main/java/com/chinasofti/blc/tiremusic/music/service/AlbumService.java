
package com.chinasofti.blc.tiremusic.music.service;

import java.util.List;

import com.chinasofti.blc.tiremusic.music.dao.AlbumDao;
import com.chinasofti.blc.tiremusic.music.entity.Album;

public class AlbumService {

	private AlbumDao albumDao =new AlbumDao();
	/**
	 * 根据该歌手id查询该歌手的所有专辑
	 * @param songerid
	 * @return
	 */
	public List<Album> queryAllAlbumBySongerid(int songerid){
		return albumDao.queryAllAlbumBySongerid(songerid);
	}
}

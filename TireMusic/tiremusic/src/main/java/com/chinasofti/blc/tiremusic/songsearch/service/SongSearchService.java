package com.chinasofti.blc.tiremusic.songsearch.service;

import java.sql.Types;
import java.util.List;

import com.chinasofti.blc.tiremusic.SongAudition.entity.Song;
import com.chinasofti.blc.tiremusic.common.util.ConditionUtil;
import com.chinasofti.blc.tiremusic.songsearch.dao.SongSearchDao;

public class SongSearchService {
	
	private SongSearchDao songSearchDao = new SongSearchDao();
	/**
	 * 搜索歌曲
	 * @return
	 */
	public List<Song> searchSong(String songname,String songername,String schoolid){
		String sql = "select s.songid,s.songname,o.songername,s.location from song s join songer o on s.songerid=o.songerid join school c on s.schoolid=c.schoolid";
		ConditionUtil c = new ConditionUtil(sql);
		c.appendLike(ConditionUtil.AND, "s.songname", songname);
		c.appendLike(ConditionUtil.AND, "o.songername", songername);
		if(Integer.parseInt(schoolid)>0) {
			c.appendEquals(ConditionUtil.AND, "s.schoolid", schoolid,Types.INTEGER);
		}
		c.appendEquals(ConditionUtil.AND, "s.songstate", "1",Types.INTEGER);
		System.out.println(c.toString());
		List<Song> list = songSearchDao.searchSong(c.toString());
		return list;
	}
}

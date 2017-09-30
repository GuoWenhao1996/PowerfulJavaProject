package com.chinasofti.blc.tiremusic.songlist.service;

import java.util.List;

import com.chinasofti.blc.tiremusic.songlist.dao.SongListDao;
import com.chinasofti.blc.tiremusic.songlist.entity.MusicInSongList;
import com.chinasofti.blc.tiremusic.songlist.entity.SongList;

/**
 * 歌单服务层
 * 
 * @author guowh
 *
 */
public class SongListService {
	SongListDao songListDao = new SongListDao();

	/**
	 * 增加歌单
	 * 
	 * @param name
	 *            歌单名称
	 * @param uid
	 *            用户id
	 * @return 成功返回字符串true，失败返回错误信息
	 */
	public String addSongList(String name, int uid) {
		if (name == null || name.trim().isEmpty()) {
			return "歌单名称不能为空！";
		} else if (isInList(-1, name, songListDao.queryAllListByUid(uid))) {
			return "歌单名称重复！";
		} else if (songListDao.addSongList(name.trim(), uid)) {
			return "true";
		} else {
			return "服务器错误，请稍后再试！";
		}
	}

	/**
	 * 根据用户id查找歌单
	 * 
	 * @param uid
	 *            用户id
	 * @return 歌单集合
	 */
	public List<SongList> queryAllListByUid(int uid) {
		return songListDao.queryAllListByUid(uid);
	}

	/**
	 * 根据歌单id删除歌单
	 * 
	 * @param lid
	 *            歌单id
	 * @return 删除成功返回true
	 */
	public boolean deleteSongListByLid(String lid) {
		return songListDao.deleteSongListByLid(Integer.parseInt(lid));
	}

	/**
	 * 修改歌单名称
	 * 
	 * @param lid
	 *            歌单id
	 * @param name
	 *            歌单名称
	 * @param uid
	 *            用户Id
	 * @return 成功返回字符串true，失败返回错误信息
	 */
	public String updateSongListByLid(String lid, String name, int uid) {
		if (name == null || name.trim().isEmpty()) {
			return "歌单名称不能为空！";
		} else if (isInList(Integer.parseInt(lid), name, songListDao.queryAllListByUid(uid))) {
			return "歌单名称重复！";
		} else if (songListDao.updateSongListByLid(Integer.parseInt(lid), name)) {
			return "true";
		} else {
			return "服务器错误，请稍后再试！";
		}
	}

	/**
	 * 把指定歌曲加到指定歌单中
	 * 
	 * @param sid
	 *            歌曲id
	 * @param lid
	 *            歌单id
	 * @return 添加成功返回true
	 */
	public String addMusicToList(int sid, int lid) {
		if (isInList(sid, showAllMusicByListId(lid))) {
			return "歌曲已在歌单中！";
		} else if (songListDao.addMusicToList(sid, lid)) {
			return "true";
		} else {
			return "服务器错误，请稍后再试！";
		}
	}

	/**
	 * 把指定歌曲从指定歌单中移除
	 * 
	 * @param sid
	 *            歌曲id
	 * @param lid
	 *            歌单id
	 * @return 移除成功返回true
	 */
	public boolean deleteMusicInList(String sid, String lid) {
		return songListDao.deleteMusicInList(Integer.parseInt(sid), Integer.parseInt(lid));
	}

	/**
	 * 根据歌单id查找歌曲列表
	 * 
	 * @param lid
	 *            歌单
	 * @return 歌曲列表
	 */
	public List<MusicInSongList> showAllMusicByListId(int lid) {
		return songListDao.showAllMusicByListId(lid);
	}

	/**
	 * 判断歌单是否已存在
	 * 
	 * @param lid
	 *            歌单id
	 * @param name
	 *            要增加的歌单名称
	 * @param list
	 *            歌单列表
	 * @return
	 */
	public boolean isInList(int lid, String name, List<SongList> list) {
		for (SongList songList : list) {
			// 若名称相同,看id是否相同
			if (songList.getSonglistname().equals(name)) {
				// 如果id相同说明此名称不存在
				if (songList.getSonglistid() == lid) {
					return false;
				}
				// 如果id不相同说明此名称已存在
				else {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 判断歌曲是否已在歌单列表中
	 * 
	 * @param sid
	 *            歌曲id
	 * @param list
	 *            歌单中的歌曲集合
	 * @return
	 */
	public boolean isInList(int sid, List<MusicInSongList> list) {
		for (MusicInSongList musicInSongList : list) {
			if (musicInSongList.getSongid() == sid) {
				return true;
			}
		}
		return false;
	}
}

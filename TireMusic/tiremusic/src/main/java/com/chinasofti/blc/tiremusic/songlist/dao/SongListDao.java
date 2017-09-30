package com.chinasofti.blc.tiremusic.songlist.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.chinasofti.blc.tiremusic.common.util.DBUtil;
import com.chinasofti.blc.tiremusic.songlist.entity.MusicInSongList;
import com.chinasofti.blc.tiremusic.songlist.entity.SongList;

/**
 * 歌单dao层
 * 
 * @author guowh
 *
 */
public class SongListDao {

	/**
	 * 向歌单表从插入歌单
	 * 
	 * @param name
	 *            歌单名称
	 * @param uid
	 *            用户id
	 * @return 插入成功返回true
	 */
	public boolean addSongList(String name, int uid) {
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			int result = qr.update(con, "insert into songlist (songlistname,uid) values(?,?)", name, uid);
			if (result != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(null, null, con);
		}
		return false;
	}

	/**
	 * 根据用户id查找歌单
	 * 
	 * @param uid
	 *            用户id
	 * @return 歌单集合
	 */
	public List<SongList> queryAllListByUid(int uid) {
		List<SongList> lists = new LinkedList<>();
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			lists = qr.query(con, "select * from songlist where uid=?", new BeanListHandler<>(SongList.class), uid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}

	/**
	 * 根据歌单id删除歌单
	 * 
	 * @param lid
	 *            歌单id
	 * @return 删除成功返回true
	 */
	public boolean deleteSongListByLid(int lid) {
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			con.setAutoCommit(false);
			qr.update(con, "delete from song_songlist where songlistid=?", lid);
			int result = qr.update(con, "delete from songlist where songlistid=?", lid);
			if (result != 0) {
				con.commit();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(null, null, con);
		}
		return false;
	}

	/**
	 * 修改
	 * 
	 * @param lid
	 *            歌单id
	 * @param name
	 *            歌单名称
	 * @return
	 */
	public boolean updateSongListByLid(int lid, String name) {
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			int result = qr.update(con, "update songlist set songlistname=? where songlistid=?", name, lid);
			if (result != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(null, null, con);
		}
		return false;
	}

	/**
	 * 把歌曲id歌单id插入到歌曲歌单表
	 * 
	 * @param sid
	 *            歌曲id
	 * @param lid
	 *            歌单id
	 * @return 插入成功返回true
	 */
	public boolean addMusicToList(int sid, int lid) {
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			int result = qr.update(con, "insert into song_songlist (songlistid,songid) values(?,?)", lid, sid);
			if (result != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(null, null, con);
		}
		return false;
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
	public boolean deleteMusicInList(int sid, int lid) {
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			int result = qr.update(con, "delete from song_songlist where songlistid=? and songid=?", lid, sid);
			if (result != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(null, null, con);
		}
		return false;
	}

	/**
	 * 根据歌单id查找歌曲列表
	 * 
	 * @param lid
	 *            歌单id
	 * @return 歌曲列表
	 */
	public List<MusicInSongList> showAllMusicByListId(int lid) {
		List<MusicInSongList> lists = new LinkedList<>();
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			lists = qr.query(con,
					"select s.songid,songname,location,songername from song s join song_songlist ss on s.songid=ss.songid join songer ser on ser.songerid=s.songerid where ss.songlistid=? and s.songstate=1;",
					new BeanListHandler<>(MusicInSongList.class), lid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}

}

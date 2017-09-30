package com.chinasofti.blc.tiremusic.SongAudition.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.chinasofti.blc.tiremusic.SongAudition.entity.Song;
import com.chinasofti.blc.tiremusic.common.util.DBUtil;

public class SongListenDao {
	/**
	 * 增加试听量
	 * @param uid
	 * @param songid
	 * @return
	 */
	public boolean addShiTing(int uid,int songid) {
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			qr.update(con, "insert into song_listen (auditionid,songid) values(?,?)",uid,songid);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, con);
		}
		return false;
	}
	/**
	 * 查询最新的歌曲
	 * @return
	 */
	public List<Song> newSongs(){
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			List<Song> list = qr.query(con, "select * from song s join songer o on s.songerid=o.songerid where songstate=1 order by songid desc limit 0,6", new BeanListHandler<>(Song.class));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, con);
		}
		return null;
	}

}

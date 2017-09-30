package com.chinasofti.blc.tiremusic.songsearch.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.chinasofti.blc.tiremusic.SongAudition.entity.Song;
import com.chinasofti.blc.tiremusic.common.util.DBUtil;

public class SongSearchDao {
	/**
	 * 根据拼接好的sql语句查询歌曲
	 * @param sql
	 * @return
	 */
	public List<Song> searchSong(String sql){
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			List<Song> list = qr.query(con, sql, new BeanListHandler<>(Song.class));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, con);
		}
		return null;
	}
	
}

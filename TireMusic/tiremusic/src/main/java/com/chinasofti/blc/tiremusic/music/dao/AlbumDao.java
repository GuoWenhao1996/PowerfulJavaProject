package com.chinasofti.blc.tiremusic.music.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.chinasofti.blc.tiremusic.common.util.DBUtil;
import com.chinasofti.blc.tiremusic.music.entity.Album;

public class AlbumDao {
	/**
	 * 根据该歌手id查询专辑名称
	 * @param songerid
	 * @return
	 */
	public List<Album> queryAllAlbumBySongerid(int songerid){
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			List<Album> list = qr.query(con, "select distinct a.* from album a join song_album sa on a.albumid=sa.albumid join song s on sa.songid=s.songid join songer se on s.songerid=se.songerid where se.songerid=?",new BeanListHandler<>(Album.class),songerid);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, con);
		}
		return null;
	}
}

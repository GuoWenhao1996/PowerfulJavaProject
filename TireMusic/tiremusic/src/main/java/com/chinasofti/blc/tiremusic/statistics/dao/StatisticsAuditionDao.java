package com.chinasofti.blc.tiremusic.statistics.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.chinasofti.blc.tiremusic.common.util.DBUtil;
import com.chinasofti.blc.tiremusic.statistics.entry.AuditionNum;
import com.chinasofti.blc.tiremusic.statistics.entry.AuditionSong;

/**
 * 试听统计处理数据库操作
 * @author ljp
 *
 */
public class StatisticsAuditionDao {
	/**
	 * 查询并返回歌曲的试听量、歌曲id、歌曲名称
	 * @return
	 */
	public List<AuditionNum> getAuditionNum(){
		List<AuditionNum> auditionnum = new ArrayList<>();
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			auditionnum = qr.query(con, "select count(sl.auditionid) as auditionnum,s.songid, s.songname "+
									"from song s , song_listen sl "+
									"where s.songid = sl.songid "+
									"group by sl.songid "+
									"ORDER BY count(sl.auditionid) desc,sl.songid asc ", new BeanListHandler<>(AuditionNum.class));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return auditionnum;
	}
	
	/**
	 * 分页查询并返回歌曲的试听量、歌曲id、歌曲名称
	 * @return
	 */
	public List<AuditionNum> getAuditionNumPage(int pageNum,int pageSize){
		List<AuditionNum> auditionnum = new ArrayList<>();
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			auditionnum = qr.query(con, "select count(sl.auditionid) as auditionnum,s.songid, s.songname "+
									"from song s , song_listen sl "+
									"where s.songid = sl.songid "+
									"group by sl.songid "+
									"ORDER BY count(sl.auditionid) desc,sl.songid asc "+
									"limit "+(pageNum-1)*pageSize+","+pageSize, new BeanListHandler<>(AuditionNum.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return auditionnum;
	}
	/**
	 * 查询并返回指定数量的试听排行对象
	 * @return
	 */
	public List<AuditionSong> getAuditionList(int num){
		List<AuditionSong> auditionsong = new ArrayList<>();
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			auditionsong = qr.query(con, "select count(sl.auditionid) as auditionnum,s.songid,sr.songername,s.songname,s.location "+
									"from song s , song_listen sl , songer sr "+
									"where s.songid = sl.songid and s.songerid = sr.songerid "+
									"group by sl.songid "+
									"ORDER BY count(sl.auditionid) desc,sl.songid asc "+
									"limit "+num, new BeanListHandler<>(AuditionSong.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return auditionsong;
	}
}

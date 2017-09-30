package com.chinasofti.blc.tiremusic.statistics.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.chinasofti.blc.tiremusic.common.util.DBUtil;
import com.chinasofti.blc.tiremusic.statistics.entry.AuditionNum;
import com.chinasofti.blc.tiremusic.statistics.entry.DownNum;
import com.chinasofti.blc.tiremusic.statistics.entry.DownSong;

/**
 * 下载统计处理数据库操作
 * @author ljp
 *
 */
public class StatisticsDownDao {
	/**
	 * 查询并返回歌曲的下载量、歌曲id、歌曲名称
	 * @return
	 */
	public List<DownNum> getDownNum(){
		List<DownNum> downnum = new ArrayList<>();
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			downnum = qr.query(con, "select count(ds.Downloadlistid) as downnum ,s.songid,s.songname "+
									"from song s , download_song ds "+
									"where s.songid = ds.songid "+
									"group by ds.songid "+
									"ORDER BY count(ds.Downloadlistid) desc,ds.songid asc ", new BeanListHandler<>(DownNum.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return downnum;
	}
	
	/**
	 * 分页查询并返回歌曲的下载量、歌曲id、歌曲名称
	 * @return
	 */
	public List<DownNum> getDownNumPage(int pageNum,int pageSize){
		List<DownNum> downnum = new ArrayList<>();
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			downnum = qr.query(con, "select count(ds.Downloadlistid) as downnum,s.songid,s.songname "+
									"from song s , download_song ds "+
									"where s.songid = ds.songid "+
									"group by ds.songid "+
									"ORDER BY count(ds.Downloadlistid) desc,ds.songid asc "+
									"limit "+(pageNum-1)*pageSize+","+pageSize, new BeanListHandler<>(DownNum.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return downnum;
	}
	/**
	 * 查询并返回指定数量的下载排行对象
	 * @return
	 */
	public List<DownSong> getDownList(int num){
		List<DownSong> downsong = new ArrayList<>();
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			downsong = qr.query(con, "select count(ds.Downloadlistid) as downnum,s.songid,sr.songername,s.songname,s.location "+
									"from song s , download_song ds , songer sr "+
									"where s.songid = ds.songid and s.songerid = sr.songerid "+
									"group by ds.songid "+
									"ORDER BY count(ds.Downloadlistid) desc,ds.songid asc "+
									"limit "+num, new BeanListHandler<>(DownSong.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return downsong;
	}
}

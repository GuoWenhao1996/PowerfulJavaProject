package com.chinasofti.blc.tiremusic.music.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.chinasoft.tiremusic.test.entity.Song;
import com.chinasofti.blc.tiremusic.common.util.DBUtil;
import com.chinasofti.blc.tiremusic.music.entity.Music;

public class MusicDao {
	/**
	 * 查询并返回所有歌曲信息
	 * @return
	 */
	public List<Music> queryAllMusics() {
		Connection con =DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			List<Music> list=qr.query(con, "select * from song",new BeanListHandler<>(Music.class));
			//System.out.println(list);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, con);
		}
		return null;
	}
	public List<Music> queryAllMusicsPage(int page,int rows) {
		Connection con =DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			List<Music> list=qr.query(con, "select s.songid,s.songname,s.songerid,se.songername,a.albumid,a.albumname,s.schoolid,sc.schoolname,s.frontimg,s.songstate,s.location from song s join songer se on s.songerid= se.songerid join song_album sa on s.songid=sa.songid join album a on sa.albumid=a.albumid join school sc on s.schoolid=sc.schoolid limit "+(page-1)*rows+","+rows,new BeanListHandler<>(Music.class));
			//System.out.println(list);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, con);
		}
		return null;
	}
	/**
	 * 根据sql查询
	 * @param sql
	 * @return
	 */
	public List<Music> queryAllMusics(String sql) {
		Connection con =DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			List<Music> list=qr.query(con, sql,new BeanListHandler<>(Music.class));
			//System.out.println(list);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, con);
		}
		return null;
	}
	/**
	 * 分页加载music所有信息
	 * @param page
	 * @param row
	 * @return
	 */
	public List<Music> queryAllMusicsPage(String sql){
		Connection con =DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			List<Music> list=qr.query(con, sql,new BeanListHandler<>(Music.class));
			//System.out.println(list);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, con);
		}
		return null;
	}
	/**
	 * 添加歌曲
	 * @param songid
	 * @param schoolid
	 * @param songerid
	 * @param songname
	 * @param frontimg
	 * @param songstate
	 * @param location
	 * @param albumid
	 * @return
	 */
	public int addMusic(int schoolid,int songerid,String songname,String frontimg,int songstate,String location,int albumid) {
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		
		try {
			con.setAutoCommit(false);
			qr.insert(con, "insert into song(schoolid,songerid,uploadlistid,songname,frontimg,songstate,location) value(?,?,5,?,?,?,?)",new BeanListHandler<>(Music.class),schoolid,songerid,songname,frontimg,songstate,location);
			List<Music> musics = qr.query(con, "select songid from song where songname=? ",new BeanListHandler<>(Music.class),songname);
			qr.insert(con, "insert into song_album(songid,albumid) value (?,?) ",new BeanListHandler<>(Music.class),musics.get(0).getSongid(),albumid);
			con.commit();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, con);
		}
		return 0;
	}
	/**
	 * 非物理删除歌曲 ，将歌曲状态改为0，在用户页面不显示
	 * @param songid
	 * @return
	 */
	public int deleteMusic(int songid) {
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			qr.update(con,"update song set songstate=0 where songid=?",songid);
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, con);
		}
		return 0;
	}
	/**
	 * 修改歌曲
	 * @param songid
	 * @param songerid
	 * @param albumid
	 * @param schoolid
	 * @param songname
	 * @return
	 */
	public int  editMusic(int songid,int songerid,int albumid,int schoolid,String songname,int songstate ) {
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			con.setAutoCommit(false);
			qr.update(con,"update song set songname=? , songerid=? , schoolid=?  , songstate=? where songid=?",songname,songerid,schoolid,songstate,songid);
			qr.update(con, "update song_album set albumid=? where songid=?",albumid,songerid);
			con.commit();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, con);
		}
		return 0;
	}
}

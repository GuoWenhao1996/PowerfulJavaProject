package com.chinasofti.blc.tiremusic.music.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.chinasofti.blc.tiremusic.common.util.DBUtil;
import com.chinasofti.blc.tiremusic.music.entity.Songer;

public class SongerDao {
	/**
	 * 查询并返回所有的歌手
	 * @return
	 */
	public List<Songer> queryAllSongers(){
		
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			List<Songer> list = qr.query(con, "select *from songer",new BeanListHandler<>(Songer.class));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, con);
		}
		return null;
	}
	/**
	 * 返回歌手总数
	 * @return
	 */
	public int getSongerNum(){
		Connection con =DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		long num = 0; 
		try {
			num =  qr.query(con, " select count(*) from songer", new ScalarHandler<Long>());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(null, null, con);
		}
		return (int)num; 
	}
	/**
	 * 分页查询并返回所有的歌手
	 * @return
	 */
	public List<Songer> queryAllSongersPage(int PageNum,int PageSize){
		
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			List<Songer> list = qr.query(con, "select *from songer limit "+(PageNum-1)*PageSize+","+PageSize,new BeanListHandler<>(Songer.class));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, con);
		}
		return null;
	}
	/**
	 * 添加新歌手
	 * @param songer
	 * @return
	 */
	public int addNewSonger(Songer songer){
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			qr.insert(con, "insert into songer(songername,songertext,songerstate) values(?,?,?) ", new BeanHandler<>(Songer.class),songer.getSongername(),songer.getSongertext(),songer.getSongerstate());
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(null, null, con);
		}
		return 0;
	}
	
	/**
	 * 修改歌手
	 * @param songer
	 * @return
	 */
	public int changeSonger(Songer songer){
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			qr.update(con, "update songer set songername = ? , songertext = ?  where songerid = ? ",songer.getSongername(),songer.getSongertext(),songer.getSongerid());
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(null, null, con);
		}
		return 0;
	}
	/**
	 * 删除歌手
	 * @param songerid
	 * @return
	 */
	public int deleteSonger(int songerid){
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			qr.update(con, "update songer set songerstate = 0  where songerid = ? ",songerid);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(null, null, con);
		}
		return 0;
	}
}

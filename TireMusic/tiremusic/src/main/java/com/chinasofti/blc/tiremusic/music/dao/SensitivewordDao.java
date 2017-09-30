package com.chinasofti.blc.tiremusic.music.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.chinasofti.blc.tiremusic.common.util.DBUtil;
import com.chinasofti.blc.tiremusic.music.entity.Sensitiveword;

public class SensitivewordDao {

	public List<Sensitiveword> queryAllSW(){
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			List<Sensitiveword> list = qr.query(con, "select * from sensitiveword  ",new BeanListHandler<>(Sensitiveword.class));
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, con);
		}
		return null;
	}
	/**
	 * 分页加载所有敏感词
	 * @return
	 */
	public List<Sensitiveword> queryAllSW(int page,int rows){
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			List<Sensitiveword> list = qr.query(con, "select * from sensitiveword limit "+(page-1)*rows+","+rows,new BeanListHandler<>(Sensitiveword.class));
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, con);
		}
		return null;
	}
	/**
	 * 增加敏感词
	 * @return
	 */
	public int addSW(String swtext) {
		Connection con = DBUtil.getConnection();
		QueryRunner qr=new QueryRunner();
		try {
			qr.insert(con, "insert into sensitiveword(swtext) value(?)",new BeanListHandler<>(Sensitiveword.class),swtext);
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
	 * 删除敏感词
	 * @param swid
	 * @return
	 */
	public int deleteSW(int swid) {
		Connection con = DBUtil.getConnection();
		QueryRunner qr=new QueryRunner();
		try {
			qr.query(con, "delete from sensitiveword where swid=?",new BeanListHandler<>(Sensitiveword.class),swid);
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
	 * 根秀id修改敏感词内容
	 * @param swid
	 * @param swtext
	 * @return
	 */
	public int updateSW(int swid,String swtext) {
		Connection con = DBUtil.getConnection();
		QueryRunner qr=new QueryRunner();
		try {
			qr.update(con, "update sensitiveword set swtext=? where swid=? ",swtext,swid);
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, con);
		}
		return 0;
	}
}

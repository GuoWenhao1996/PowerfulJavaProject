package com.chinasofti.blc.tiremusic.sensitive.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.chinasofti.blc.tiremusic.common.util.DBUtil;
import com.chinasofti.blc.tiremusic.sensitive.entity.SensitiveWord;

public class SensitiveDao {

	/**
	 * 向违禁词汇表插入违禁词汇
	 * 
	 * @param name
	 *            违禁词汇内容
	 * @return 插入成功返回true
	 */
	public boolean addSensitive(String content) {
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			int result = qr.update(con, "insert into sensitiveword (swtext) values(?)", content);
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
	 * 查找所有违禁词汇
	 * 
	 * @return 违禁词汇集合
	 */
	public List<SensitiveWord> queryAllSensitive() {
		List<SensitiveWord> lists = new ArrayList<>();
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			lists = qr.query(con, "select * from sensitiveword", new BeanListHandler<>(SensitiveWord.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}

	/**
	 * 根据词汇id删除词汇
	 * 
	 * @param sid
	 *            词汇id
	 * @return 删除成功返回true
	 */
	public boolean deleteSensitiveBySid(int sid) {
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			con.setAutoCommit(false);
			int result = qr.update(con, "delete from sensitiveword where swid=?", sid);
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
	 * 修改词汇
	 * 
	 * @param sid
	 *            词汇sid
	 * @param content
	 *            词汇内容
	 * @return 修改成功返回true
	 */
	public boolean updateSensitiveBySid(int sid, String content) {
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			int result = qr.update(con, "update sensitiveword set swtext=? where swid=?", content, sid);
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

}

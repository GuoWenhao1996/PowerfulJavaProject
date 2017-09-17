package com.chinasofti.sms.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.chinasofti.sms.entity.Depart;
import com.chinasofti.sms.util.DBUtil;

/**
 * 学院dao层
 * 
 * @author guowh
 *
 */
public class DeptDao {
	/**
	 * 查询出所有的学院
	 * 
	 * @return
	 */
	public List<Depart> queryAllDepts() {
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			List<Depart> list = qr.query(con, "select * from tb_depart", new BeanListHandler<>(Depart.class));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 根据id查找学院
	 * @param id
	 * @return
	 */
	public Depart getDeptById(int id) {
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			return qr.query(con, "select * from tb_depart where dep_id=?", new BeanHandler<>(Depart.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(null, null, con);
		}
		return null;
	}
}

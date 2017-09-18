package com.chinasofti.sms.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.chinasofti.sms.entity.Login;
import com.chinasofti.sms.util.DBUtil;

/**
 * user表操作类
 * 
 * @author gwh
 *
 */
public class UserDao {
	/**
	 * 根据用户名查找用户对象
	 * 
	 * @param username
	 *            用户名
	 * @return 用户对象或null
	 */
	public Login getUserByUsername(String username) {
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			Login user = qr.query(con, "select * from tb_login where username= ? ", new BeanHandler<>(Login.class),
					username);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(null, null, con);
		}
		return null;
	}

	/**
	 * 修改密码
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean updatepassword(String username, String password) {
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			int result = qr.update(con, "update tb_login set password=?,state=1 where username=?", password, username);
			if (result == 1) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(null, null, con);
		}
		return false;
	}
}

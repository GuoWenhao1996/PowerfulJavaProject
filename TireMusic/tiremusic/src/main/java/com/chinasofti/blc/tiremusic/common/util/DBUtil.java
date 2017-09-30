package com.chinasofti.blc.tiremusic.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 数据库操作工具类
 * 
 * @author guowh
 *
 */
public class DBUtil {

	private static String driverClass;
	private static String url;
	private static String user;
	private static String password;

	static {
		Properties props = new Properties();
		InputStream in = DBUtil.class.getResourceAsStream("/config.properties");
		try {
			props.load(in);
			driverClass = props.getProperty("driverClass");
			url = props.getProperty("url");
			user = props.getProperty("user");
			password = props.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据链接
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		try {
			Class.forName(driverClass);
			Connection con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 关闭所有链接
	 * 
	 * @param rs
	 * @param st
	 * @param con
	 */
	public static void closeConnection(ResultSet rs, Statement st, Connection con) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 数据库操作简易处理<br/>
	 * 如果有复杂处理建议使用QueryRunner
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public static boolean operateDML(String sql, Object... params) {
		Connection con = getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			int result = ps.executeUpdate();
			if (result != 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(null, ps, con);
		}
		return false;
	}
}

package com.gwhcool.dvdms.util;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 数据库工具类
 * 
 * @author gwh
 *
 * @param <T>
 *            模板对象类型
 * @since 1.0
 */
public class DBUtil<T> {

	private static String driverClass;
	private static String jdbcUrl;
	private static String username;
	private static String password;
	private static final ComboPooledDataSource dataSource = new ComboPooledDataSource();

	static {
		Properties p = new Properties();
		try {
			p.load(DBUtil.class.getResourceAsStream("/com/gwhcool/dvdms/config/jdbc.properties"));
			driverClass = p.getProperty("driverClass");
			jdbcUrl = p.getProperty("jdbcUrl");
			username = p.getProperty("username");
			password = p.getProperty("password");
			dataSource.setJdbcUrl(jdbcUrl);
			dataSource.setDriverClass(driverClass);
			dataSource.setUser(username);
			dataSource.setPassword(password);
			dataSource.setMinPoolSize(10);
			dataSource.setMaxPoolSize(100000);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}

	public static DataSource getDataSource() {
		return dataSource;
	}

	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

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
		}
		return false;
	}

	public static List<Object> operateDQL(Class<?> c, String sql, Object... params) {
		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Object> lists = new LinkedList<>();
		try {
			ps = con.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			rs = ps.executeQuery();
			Object obj = null;
			Field[] fields = c.getDeclaredFields();
			while (rs.next()) {
				obj = c.newInstance();
				for (int i = 0; i < fields.length; i++) {
					Object fieldValue = rs.getObject(fields[i].getName());
					fields[i].setAccessible(true);
					fields[i].set(obj, fieldValue);
				}
				lists.add(obj);
			}
			return lists;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<T> changeObjListToTList(List<Object> listObj) {
		List<T> lists = new LinkedList<>();
		for (Object object : listObj) {
			lists.add((T) object);
		}
		return lists;
	}
}

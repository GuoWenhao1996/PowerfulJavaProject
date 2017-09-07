package util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * 不带线程池的数据库操作类
 * 
 * @author gwh
 *
 * @param <T>转换类型时使用
 */
public class DBUtil<T> {

	private static String dirverClass;
	private static String jdbcUrl;
	private static String username;
	private static String password;
	static {
		Properties p = new Properties();
		try {
			p.load(DBUtil.class.getResourceAsStream("/config/jdbc.properties"));
			dirverClass = p.getProperty("driverClass");
			jdbcUrl = p.getProperty("jdbcUrl");
			username = p.getProperty("username");
			password = p.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		try {
			Class.forName(dirverClass);
			return DriverManager.getConnection(jdbcUrl, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void closeAll(ResultSet rs, Statement st, Connection con) {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
		} finally {
			closeAll(null, ps, con);
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
		} finally {
			closeAll(rs, ps, con);
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

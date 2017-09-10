package com.gwhcool.vipcardms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.gwhcool.vipcardms.entity.User;
import com.gwhcool.vipcardms.util.DBUtil;

/**
 * user表操作类
 * 
 * @author gwh
 *
 */
public class UserDao {
	/**
	 * 根据用户列表
	 * 
	 * @return 用户列表
	 */
	public List<User> getUserList() {
		List<Object> objs = DBUtil.operateDQL(User.class, "select * from user order by uid asc");
		DBUtil<User> db = new DBUtil<>();
		return db.changeObjListToTList(objs);
	}

	/**
	 * 根据用户名查找用户信息
	 * 
	 * @param username
	 *            用户名
	 * @return 用户对象或null
	 */
	public User getUserByUsername(String username) {
		List<Object> objs = DBUtil.operateDQL(User.class, "select * from user where username= ? ", username);
		if (objs.size() == 0) {
			return null;
		} else {
			return (User) objs.get(0);
		}
	}

	/**
	 * 根据用户id查找用户信息
	 * 
	 * @param uid
	 *            用户id
	 * @return 用户对象或null
	 */
	public User getUserByUid(int uid) {
		List<Object> objs = DBUtil.operateDQL(User.class, "select * from user where uid= ? ", uid);
		if (objs.size() == 0) {
			return null;
		} else {
			return (User) objs.get(0);
		}
	}

	public void updateLoginTime(Date date, int uid) {
		DBUtil.operateDML("update user set logintime=? where uid=?", date, uid);
	}

	public boolean updateInfo(String username, String name, int sex, String address, String telephone, String email,
			String creditcard, int uid) {
		return DBUtil.operateDML(
				"update user set username=?,name=?,sex=?,address=?,telephone=?,email=?,creditcard=? where uid=?",
				username, name, sex, address, telephone, email, creditcard, uid);
	}

	public int checkUsername(String username, int uid) {
		Connection con = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("select count(*) from user where username=? and uid !=?");
			ps.setString(1, username);
			ps.setInt(2, uid);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, ps, con);
		}
		return -1;
	}

	public int checkPassword(String oldpassword, int uid) {
		Connection con = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("select count(*) from user where password=? and uid =?");
			ps.setString(1, oldpassword);
			ps.setInt(2, uid);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, ps, con);
		}
		return -1;
	}

	public boolean updatePassword(String passwordA, int uid) {
		return DBUtil.operateDML("update user set password=? where uid=?", passwordA, uid);
	}

	public boolean reg(User user) {
		return DBUtil.operateDML(
				"insert into user (username, password, name, sex, address, telephone, email, creditcard, count, logintime, cardid, jointime, money, cardtype) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
				user.getUsername(), user.getPassword(), user.getName(), user.getSex(), user.getAddress(),
				user.getTelephone(), user.getEmail(), user.getCreditcard(), user.getCount(), user.getLogintime(),
				user.getCardid(), user.getJointime(), user.getMoney(), user.getCardtype());
	}

	public List<User> getUserList(int type) {
		List<Object> objs=null;
		if(type==0) {
			objs= DBUtil.operateDQL(User.class, "select * from user where cardtype!=0 and cardtype!=1 order by count desc");			
		}else {
			objs= DBUtil.operateDQL(User.class, "select * from user where cardtype=? order by count desc",type);			
		}
		DBUtil<User> db = new DBUtil<>();
		return db.changeObjListToTList(objs);
	}

}

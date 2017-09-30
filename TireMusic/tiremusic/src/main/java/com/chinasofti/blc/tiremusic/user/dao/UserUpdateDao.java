package com.chinasofti.blc.tiremusic.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import javax.jws.soap.SOAPBinding.Use;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.chinasofti.blc.tiremusic.common.util.DBUtil;
import com.chinasofti.blc.tiremusic.user.entity.User;

public class UserUpdateDao {
	
	
	public User newSession(int uid) {
		Connection con = DBUtil.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		try {
			User user = queryRunner.query(con, "select uid,uname, upassword, realname, uaddress, uemail, utelephone, uidnumber, avatar, ustate, logindate, usersex, userbirthday from user where uid=?",new BeanHandler<>(User.class),uid);
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 更新用户信息
	 * @param uid
	 * @param uname
	 * @param realname
	 * @param usersex
	 * @param uaddress
	 * @param uemail
	 * @param utelephone
	 * @param uidnumber
	 * @param userbirthday
	 * @param avatar
	 * @return
	 */
	public boolean updateUser(int uid,String uname, String realname, int usersex, String uaddress, String uemail,String utelephone, String uidnumber, Date userbirthday, String avatar){
		Connection con = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("update user set uname=?,realname=?,usersex=?,uaddress=?,uemail=?,utelephone=?,uidnumber=?,userbirthday=?,avatar=? where uid=?");
			ps.setString(1, uname);
			ps.setString(2, realname);
			ps.setInt(3, usersex);
			ps.setString(4, uaddress);
			ps.setString(5, uemail);
			ps.setString(6, utelephone);
			ps.setString(7, uidnumber);
			ps.setDate(8, new java.sql.Date(userbirthday.getTime()));
			ps.setString(9, avatar);
			ps.setInt(10, uid);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.closeConnection(null, ps, con);
		}
		return false;
	}
}

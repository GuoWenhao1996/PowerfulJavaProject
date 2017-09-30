package com.chinasofti.blc.tiremusic.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.chinasofti.blc.tiremusic.common.util.DBUtil;
import com.chinasofti.blc.tiremusic.user.entity.User;

public class UserRegisterDao {
	/**
	 * 注册
	 * @param uname
	 * @param realname
	 * @param upassword
	 * @param uaddress
	 * @param uemail
	 * @param utelephone
	 * @param uidnumber
	 * @param avatar
	 * @param logindate
	 * @param usersex
	 * @param userbirthday
	 * @return
	 */
	public boolean addUserDao(String uname, String upassword, String realname, String uaddress, String uemail,String utelephone, String uidnumber, String avatar, Date logindate, int usersex,Date userbirthday){
		Connection con = DBUtil.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		PreparedStatement ps = null;
		try {
			con.setAutoCommit(false);
			queryRunner.update(con,"insert into user (uname,upassword,realname,uaddress,uemail,utelephone,uidnumber,avatar,logindate,usersex,userbirthday,ustate) values(?,?,?,?,?,?,?,?,?,?,?,1)",uname, upassword, realname, uaddress, uemail, utelephone, uidnumber, avatar, logindate, usersex, userbirthday);
			User user = queryRunner.query(con, "select uid,uname,upassword,realname,uaddress,uemail,utelephone,uidnumber,avatar,logindate,usersex,userbirthday,ustate from user where uname=?", new BeanHandler<>(User.class),uname);
			queryRunner.update(con, "insert into conform uid values ?",user.getUid());
			int i = queryRunner.update(con,"insert into songlist (uid,songlistname) values (?,'我喜欢')",user.getUid());
			if (i==1) {
				con.commit();
			}else {
				con.rollback();
				return false;
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, ps, con);
		}
		return false;
	}
	/**
	 * 验证用户民唯一
	 * @param uname
	 * @return
	 */
	public boolean regname(String uname) {
		Connection con = DBUtil.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		try {
			User user = queryRunner.query(con, "select uid,uname,upassword,realname,uaddress,uemail,utelephone,uidnumber,avatar,logindate,usersex,userbirthday,ustate from user where uname=?", new BeanHandler<>(User.class),uname);
			if (user!=null) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 验手机号唯一
	 * @param uname
	 * @return
	 */
	public boolean regutelephone(String utelephone) {
		Connection con = DBUtil.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		try {
			User user = queryRunner.query(con, "select uid,uname,upassword,realname,uaddress,uemail,utelephone,uidnumber,avatar,logindate,usersex,userbirthday,ustate from user where utelephone=?", new BeanHandler<>(User.class),utelephone);
			if (user!=null) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 验证身份证唯一
	 * @param uname
	 * @return
	 */
	public boolean reguidnumber(String uidnumber) {
		Connection con = DBUtil.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		try {
			User user = queryRunner.query(con, "select uid,uname,upassword,realname,uaddress,uemail,utelephone,uidnumber,avatar,logindate,usersex,userbirthday,ustate from user where uidnumber=?", new BeanHandler<>(User.class),uidnumber);
			if (user!=null) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}

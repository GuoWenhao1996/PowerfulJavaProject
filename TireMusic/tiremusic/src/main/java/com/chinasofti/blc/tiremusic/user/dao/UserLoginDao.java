package com.chinasofti.blc.tiremusic.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chinasofti.blc.tiremusic.common.util.DBUtil;
import com.chinasofti.blc.tiremusic.user.entity.User;

public class UserLoginDao {
	//从数据库查询匹配用户名
	public User loginByUname(String uname,String password) {
		Connection con = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps=con.prepareStatement("select * from user where uname=? and upassword=?");
			ps.setString(1, uname);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setUemail(rs.getString("uemail"));
				user.setUname(rs.getString("uname"));
				user.setUpassword(rs.getString("upassword"));
				user.setUid(rs.getInt("uid"));
				user.setUaddress(rs.getString("uaddress"));
				user.setRealname(rs.getString("realname"));
				user.setUemail(rs.getString("uemail"));
				user.setUtelephone(rs.getString("utelephone"));
				user.setUidnumber(rs.getString("uidnumber"));
				user.setAvatar(rs.getString("avatar"));
				user.setUstate(rs.getInt("ustate"));
				user.setUserbirthday(rs.getDate("userbirthday"));
				return user;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(rs, ps, con);
		}
		return null;
	}
	//从数据库查询匹配邮箱
	public User loginByUemail(String uemail,String password) {
		Connection con = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps=con.prepareStatement("select * from user where uemail=? and upassword=?");
			ps.setString(1, uemail);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setUemail(rs.getString("uemail"));
				user.setUname(rs.getString("uname"));
				user.setUpassword(rs.getString("upassword"));
				user.setUid(rs.getInt("uid"));
				user.setUaddress(rs.getString("uaddress"));
				user.setRealname(rs.getString("realname"));
				user.setUemail(rs.getString("uemail"));
				user.setUtelephone(rs.getString("utelephone"));
				user.setUidnumber(rs.getString("uidnumber"));
				user.setAvatar(rs.getString("avatar"));
				user.setUstate(rs.getInt("ustate"));
				user.setUserbirthday(rs.getDate("userbirthday"));
				return user;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(rs, ps, con);
		}
		return null;
	}
	//从数据库查询匹配电话号码
	public User loginByUtelephone(String utelephone,String password) {
		Connection con = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps=con.prepareStatement("select * from user where utelephone=? and upassword=?");
			ps.setString(1, utelephone);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setUemail(rs.getString("uemail"));
				user.setUname(rs.getString("uname"));
				user.setUpassword(rs.getString("upassword"));
				user.setUid(rs.getInt("uid"));
				user.setUaddress(rs.getString("uaddress"));
				user.setRealname(rs.getString("realname"));
				user.setUemail(rs.getString("uemail"));
				user.setUtelephone(rs.getString("utelephone"));
				user.setUidnumber(rs.getString("uidnumber"));
				user.setAvatar(rs.getString("avatar"));
				user.setUstate(rs.getInt("ustate"));
				user.setUserbirthday(rs.getDate("userbirthday"));
				return user;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(rs, ps, con);
		}
		return null;
	}
}

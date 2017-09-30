package com.chinasofti.blc.tiremusic.userManage.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.chinasofti.blc.tiremusic.common.util.DBUtil;
import com.chinasofti.blc.tiremusic.userManage.entity.User;

public class UserManageDao {
	
	/**
	 * 查询上传不良信息的用户
	 * @return
	 */
	public List<User> showUser(){
		Connection con = DBUtil.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		try {
			List<User> users = queryRunner.query(con, "select  uid,uname,upassword,realname,uaddress,uemail,utelephone,uidnumber,ustate from `user` where `user`.uid in (select upload.uid from upload where upload.state = 1 group by upload.uid ) and `user`.ustate=1",new BeanListHandler<>(User.class));
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DbUtils.close(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	/**
	 * 分页查询上传不良信息的用户
	 * @return
	 */
	public List<User> showUserPage(int pageSize,int pageNum){
		Connection con = DBUtil.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		try {
			List<User> users = queryRunner.query(con, "select  uid,uname,upassword,realname,uaddress,uemail,utelephone,uidnumber,ustate from `user` where `user`.uid in (select upload.uid from upload where upload.state = 2 group by upload.uid ) and `user`.ustate=1 limit "+(pageNum-1)*pageSize+","+pageSize,new BeanListHandler<>(User.class));
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DbUtils.close(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	/**
	 * 更改用户状态
	 * @param uid
	 * @return
	 */
	public boolean updateUserState(int uid) {
		Connection con = DBUtil.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		try {
			queryRunner.update(con, "update user set ustate=0 where uid = ?", uid);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DbUtils.close(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
}

package com.chinasofti.blc.tiremusic.focusotheruser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.chinasofti.blc.tiremusic.common.util.DBUtil;

public class FocusOtherUserDao {
public boolean focusotheruser(int uid,int confirmid) {
	Connection con=null;
	PreparedStatement pst=null;
	con=DBUtil.getConnection();
	String sql="insert into user_conformfrom(?,?) values(?,?)";
	String sql1="insert into conform(?) values(?)";
	
	try {
		con.setAutoCommit(false);
		pst=con.prepareStatement(sql);
		pst.setInt(1, uid);
		pst.setInt(2, confirmid);
		pst=con.prepareStatement(sql1);
		pst.setInt(1, uid);
		pst.executeUpdate();
		con.commit();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
	
}
}

package com.chinasofti.blc.tiremusic.uploadmusic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chinasofti.blc.tiremusic.common.util.DBUtil;
import com.chinasofti.blc.tiremusic.uploadmusic.entity.Userinfo;

public class SelectUserinfoDao {
public Userinfo getuserinfo(int uid) {
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	con=DBUtil.getConnection();
	Userinfo u=new Userinfo();
	String sql="select * from user where uid=?";
	try {
		pst=con.prepareStatement(sql);
		pst.setInt(1, uid);
		
		rs=pst.executeQuery();
		while(rs.next()) {
			
			u.setUploadlistid(rs.getInt("uploadlistid"));
			u.setDownloadlistid(rs.getInt("downloadlistid"));
			u.setConfirmid(rs.getInt("confirmid"));
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return u;
	
	
}
}

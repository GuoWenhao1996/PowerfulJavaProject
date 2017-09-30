package com.chinasofti.blc.tiremusic.uploadmusic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.chinasofti.blc.tiremusic.common.util.DBUtil;
import com.chinasofti.blc.tiremusic.uploadmusic.entity.UploadMusic;
public class UploadMusicDao {
public boolean uploadmusic(int uid,UploadMusic up) {
	Connection con=null;
	PreparedStatement pst=null;
	con=DBUtil.getConnection();
	
	String sql="insert into upload(uid,uploadtime,state) values(?,?,?)";
	String sql1="insert into song(uploadlistid,songname,songerid,schoolid,songstate,location) values(?,?,?,?,?,?)";
	
	try {
		con.setAutoCommit(false);
		pst=con.prepareStatement(sql);
		pst.setInt(1, uid);
		pst.setDate(2,new java.sql.Date(up.getUploadtime().getTime()));
		pst.setInt(3, up.getState());
		pst.executeUpdate();
		pst=con.prepareStatement(sql1);
		pst.setInt(1, up.getUploadlistid());
		pst.setString(2, up.getSongname());
		pst.setString(3, up.getSongerid());
		pst.setString(4, up.getSchoolid());
		pst.setInt(5, 0);
		pst.setString(6, up.getLocation());
		pst.executeUpdate();
		con.commit();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return true;
	
}
}

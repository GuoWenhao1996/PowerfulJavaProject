package com.chinasofti.blc.tiremusic.uploadmusic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chinasofti.blc.tiremusic.common.util.DBUtil;

import com.chinasofti.blc.tiremusic.uploadmusic.entity.Uploadlist;

public class Selectuploadlistid {
public Uploadlist selectuploadid() {
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	Uploadlist  up=new Uploadlist() ;
	con=DBUtil.getConnection();
	String sql="select uploadlistid from upload order by uploadlistid  desc limit 1";
	try {
		pst=con.prepareStatement(sql);
		
		rs=pst.executeQuery();
		while(rs.next()) {
			    
				up.setUploadlistid(rs.getInt("uploadlistid"));
				
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return up;
}
}

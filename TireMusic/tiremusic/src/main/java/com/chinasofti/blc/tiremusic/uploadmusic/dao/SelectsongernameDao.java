package com.chinasofti.blc.tiremusic.uploadmusic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chinasofti.blc.tiremusic.common.util.DBUtil;
import com.chinasofti.blc.tiremusic.uploadmusic.entity.School;
import com.chinasofti.blc.tiremusic.uploadmusic.entity.Songer;

public class SelectsongernameDao {
public Songer selectsongerbysongerid(int songerid) {
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	Songer songer=new Songer();
	con=DBUtil.getConnection();
	String sql="select * from songer where songerid=?";
	try {
		pst=con.prepareStatement(sql);
		pst.setInt(1, songerid);
		rs=pst.executeQuery();
		while(rs.next()) {
			    
				songer.setSongerid(rs.getInt("songerid"));
				songer.setSongername(rs.getString("songername"));
				
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return songer;
	
}
}

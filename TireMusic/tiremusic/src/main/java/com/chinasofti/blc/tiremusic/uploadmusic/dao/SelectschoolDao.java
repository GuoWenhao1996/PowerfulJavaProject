package com.chinasofti.blc.tiremusic.uploadmusic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chinasofti.blc.tiremusic.common.util.DBUtil;
import com.chinasofti.blc.tiremusic.uploadmusic.entity.School;

public class SelectschoolDao {
public School getschoolbyid(int schoolid) {
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	School school=new School();
	con=DBUtil.getConnection();
	String sql="select * from school where schoolid=?";
	try {
		pst=con.prepareStatement(sql);
		pst.setInt(1, schoolid);
		rs=pst.executeQuery();
		while(rs.next()) {
			    
				school.setSchoolid(rs.getInt("schoolid"));
				school.setSchoolname(rs.getString("schoolname"));
				
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return school;
	
}
}

package com.chinasofti.blc.tiremusic.uploadmusic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.blc.tiremusic.common.util.DBUtil;
import com.chinasofti.blc.tiremusic.uploadmusic.entity.School;

public class SelectschoolnameDao {
public List<School>  getschoolname() {
	 List<School> schools=new ArrayList<School>();
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	
	con=DBUtil.getConnection();
	String sql="select distinct schoolname,schoolid from school";
	try {
		pst=con.prepareStatement(sql);
		rs=pst.executeQuery();
		while(rs.next()) {
			    School school=new School();
				school.setSchoolid(rs.getInt("schoolid"));
				school.setSchoolname(rs.getString("schoolname"));
				schools.add(school);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	System.out.println(schools);
	return schools;
	
}
}

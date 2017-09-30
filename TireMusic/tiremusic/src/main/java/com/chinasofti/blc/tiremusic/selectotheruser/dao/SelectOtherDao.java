package com.chinasofti.blc.tiremusic.selectotheruser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.blc.tiremusic.common.util.DBUtil;
import com.chinasofti.blc.tiremusic.selectotheruser.entity.OtherUser;

public class SelectOtherDao {
public List<OtherUser> getotherusers(int start,int pagesize,String searchname){
	List<OtherUser> otherusers=new ArrayList<OtherUser>();
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	con=DBUtil.getConnection();
	String sql="select   uid,avatar,count(user.uid) fanscount,uname from user,conform,user_conformfrom  where    user_conformfrom.uid=user.uid and user_conformfrom.confirmid=conform.confirmid and uname like ? group by user.uid limit ?,?";
	try {
		pst=con.prepareStatement(sql);
		pst.setString(1, "%"+searchname+"%");
		pst.setInt(2, start);
		pst.setInt(3, pagesize);
		rs=pst.executeQuery();
		while(rs.next()) {
			OtherUser otheruser=new OtherUser();
			otheruser.setUid(rs.getInt("uid"));
			otheruser.setUsername(rs.getString("uname"));
			otheruser.setFanscount(rs.getInt("fanscount"));
			otheruser.setAvatar(rs.getString("avatar"));
			otherusers.add(otheruser);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return otherusers;
	
}

public int getotherusercount() {
	int otherusercount=0;
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	con=DBUtil.getConnection();
	String sql="select  count(*) otherusercount from user";
	try {
		pst=con.prepareStatement(sql);
		rs=pst.executeQuery();
		while(rs.next()) {
			otherusercount=rs.getInt("otherusercount");
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	return otherusercount;
	
}
}

package com.chinasofti.blc.tiremusic.uploadmusic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.blc.tiremusic.common.util.DBUtil;

import com.chinasofti.blc.tiremusic.uploadmusic.entity.Songer;

public class SelectsongerDao {
public List<Songer> selectsonger(){
	 List<Songer> songers=new ArrayList<Songer>();
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		con=DBUtil.getConnection();
		String sql="select  distinct songername,songerid  from songer";
		try {
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()) {
				    Songer songer=new Songer();
				    songer.setSongerid(rs.getInt("songerid"));
				    songer.setSongername(rs.getString("songername"));
					songers.add(songer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return songers;
}
}

package com.chinasofti.blc.tiremusic.music.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.chinasofti.blc.tiremusic.common.util.DBUtil;
import com.chinasofti.blc.tiremusic.music.entity.School;

public class SchoolDao {
	/**
	 * 查询并返回所有的流派信息
	 * @return
	 */
	public List<School> queryAllSchools(){
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			List<School> list = qr.query(con, "select * from school",new BeanListHandler<>(School.class));
			//System.out.println(list);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, con);
		}
		return null;
	}
}

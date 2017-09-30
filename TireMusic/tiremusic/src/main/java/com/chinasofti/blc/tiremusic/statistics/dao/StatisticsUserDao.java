package com.chinasofti.blc.tiremusic.statistics.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.chinasofti.blc.tiremusic.common.util.DBUtil;

public class StatisticsUserDao {
	/**
	 * 返回注册用户的数量
	 * @return
	 */
	public int getUserCount(){
		Connection con = DBUtil.getConnection();
		QueryRunner qr= new QueryRunner();
		long num = 0;
		try {
			num =  qr.query(con, "select count(*) from `user`", new ScalarHandler<Long>());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (int)num;
	}
	
}

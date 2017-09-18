package com.chinasofti.sms.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.chinasofti.sms.entity.Profess;
import com.chinasofti.sms.util.DBUtil;

/**
 * 专业dao层
 * 
 * @author guowh
 *
 */
public class ProfessDao {
	/**
	 * 查询出所有的专业
	 * 
	 * @return
	 */
	public List<Profess> queryAllProfessByDeptId(int deptId) {
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			List<Profess> list = qr.query(con, "select * from tb_profess where pro_deptid=? and pro_state=1", new BeanListHandler<>(Profess.class),deptId);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 根据id查找专业
	 * @param id
	 * @return
	 */
	public Profess getProfessById(int id) {
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			return qr.query(con, "select * from tb_profess where pro_id=?", new BeanHandler<>(Profess.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(null, null, con);
		}
		return null;
	}
}

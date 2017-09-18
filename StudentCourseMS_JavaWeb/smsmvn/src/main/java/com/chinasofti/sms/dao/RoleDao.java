package com.chinasofti.sms.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.chinasofti.sms.entity.Role;
import com.chinasofti.sms.util.DBUtil;

/**
 * 角色dao层
 * 
 * @author guowh
 *
 */
public class RoleDao {
	/**
	 * 查询出所有的角色
	 * 
	 * @return
	 */
	public List<Role> queryAllRoles() {
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			List<Role> list = qr.query(con, "select * from tb_role", new BeanListHandler<>(Role.class));
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
}

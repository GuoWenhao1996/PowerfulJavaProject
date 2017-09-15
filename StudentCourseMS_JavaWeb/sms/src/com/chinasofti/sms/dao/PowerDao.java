package com.chinasofti.sms.dao;
/**
 * 权限dao层
 * @author guowh
 *
 */

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.chinasofti.sms.entity.MenuVo;
import com.chinasofti.sms.util.DBUtil;

/**
 * 权限dao层
 * 
 * @author guowh
 *
 */
public class PowerDao {
	/**
	 * 查询权限
	 * 
	 * @param rid
	 * @return
	 */
	public List<MenuVo> queryPowerByRid(int rid) {
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			List<MenuVo> list = qr.query(con,
					"select mid as id,name as text,parentid,(select 1 from tb_power where mid=m.mid and rid=?) as checked from tb_menu m",
					new BeanListHandler<>(MenuVo.class), rid);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(null, null, con);
		}
		return null;
	}

	/**
	 * 修改权限
	 * 
	 * @param rid
	 * @param mids
	 * @return
	 */
	public boolean updatePower(int rid, int[] mids) {
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			con.setAutoCommit(false);
			qr.update(con, "delete from tb_power where rid=?", rid);
			for (int mid : mids) {
				qr.update(con, "insert into tb_power(rid,mid) values (?,?)", rid, mid);
			}
			con.commit();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(null, null, con);
		}
		return false;
	}
}

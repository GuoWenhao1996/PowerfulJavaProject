package com.chinasofti.sms.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.chinasofti.sms.entity.Menu;
import com.chinasofti.sms.util.DBUtil;

/**
 * 菜单dao层
 * 
 * @author guowh
 *
 */
public class MenuDao {
	/**
	 * 根据角色编号查找该角色权限下的菜单集合
	 * 
	 * @param rid
	 *            角色id
	 * @return 菜单集合
	 */
	public List<Menu> queryAllMenuByRid(int rid) {
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			List<Menu> list = qr.query(con, "select m.* from tb_menu m join  tb_power p on m.mid=p.mid where p.rid=?",
					new BeanListHandler<>(Menu.class), rid);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(null, null, con);
		}
		return null;
	}

	/**
	 * 查询并返回所有的菜单信息
	 * 
	 * @return
	 */
	public List<Menu> queryAllMenus(String name) {
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			List<Menu> list = qr.query(con, "select * from tb_menu where name like ?",
					new BeanListHandler<>(Menu.class), name);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(null, null, con);
		}
		return null;
	}

	/**
	 * 查询当前页上的菜单数据并返回
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<Menu> queryAllMenusPage(int pageNum, int pageSize, String name) {
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			List<Menu> list = qr.query(con,
					"select * from tb_menu where name like ? limit " + (pageNum - 1) * pageSize + "," + pageSize,
					new BeanListHandler<>(Menu.class), name);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(null, null, con);
		}
		return null;
	}

	/**
	 * 添加菜单
	 * 
	 * @param name
	 * @param url
	 * @param parseInt
	 * @return
	 */
	public boolean addMenu(String name, String url, int pid) {
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			int result = qr.update(con, "insert into tb_menu (name,url,parentid) values(?,?,?)", name, url, pid);
			if (result == 1) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(null, null, con);
		}
		return false;
	}

	/**
	 * 删除菜单
	 * 
	 * @param mids
	 * @return
	 */
	public boolean deleteMenu(int[] mids) {
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			con.setAutoCommit(false);
			for (int mid : mids) {
				qr.update(con, "delete from tb_power where mid=?", mid);
				qr.update(con, "delete from tb_menu where mid=?", mid);
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

	/**
	 * 修改菜单
	 * 
	 * @param mid
	 * @param name
	 * @param url
	 * @param pid
	 * @return
	 */
	public boolean editMenu(int mid, String name, String url, int pid) {
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			int result = qr.update(con, "update tb_menu set name=?,url=?,parentid=? where mid=?", name, url, pid, mid);
			if (result == 1) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(null, null, con);
		}
		return false;
	}

}

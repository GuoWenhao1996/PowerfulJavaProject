package com.chinasofti.sms.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.chinasofti.sms.entity.Student;
import com.chinasofti.sms.util.DBUtil;

/**
 * 学生dao层
 * 
 * @author guowh
 *
 */
public class StudentDao {

	/**
	 * 查询并返回所有的学生信息
	 * 
	 * @return
	 */
	public List<Student> queryAllStudents(String s_no) {
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			List<Student> list = qr.query(con, "select * from tb_students where s_no like ?",
					new BeanListHandler<>(Student.class), s_no);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(null, null, con);
		}
		return null;
	}

	/**
	 * 通过sql语句查询学生
	 * 
	 * @param sql
	 * @return
	 */
	public List<Student> queryStudentsBySql(String sql) {
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			List<Student> list = qr.query(con, sql, new BeanListHandler<>(Student.class));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(null, null, con);
		}
		return null;
	}

	/**
	 * 查询当前页上的学生数据并返回
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<Student> queryAllStudentsPage(int pageNum, int pageSize, String s_no) {
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			List<Student> list = qr.query(con,
					"select s.*,d.dep_name,p.pro_name from tb_students s join tb_depart d on s.s_dep_no=d.dep_id join tb_profess p on s.s_pro_id=p.pro_id where s_no like ? limit "
							+ (pageNum - 1) * pageSize + "," + pageSize,
					new BeanListHandler<>(Student.class), s_no);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(null, null, con);
		}
		return null;
	}

	/**
	 * 添加学生
	 * 
	 * @param name
	 * @param url
	 * @param i
	 * @param date
	 * @param zip
	 * @param parseInt
	 * @return
	 */
	public boolean addStudent(String sno, String name, String zip, Date date, int deptId, int professId) {
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			con.setAutoCommit(false);
			qr.update(con, "insert into tb_login(username,password,state,usertype) values(?,?,?,?)", sno, sno, -1, 1);
			int result = qr.update(con,
					"insert into tb_students (s_no,s_name,s_zip,s_indate,s_dep_no,s_pro_id,s_state) values(?,?,?,?,?,?,?)",
					sno, name, zip, date, deptId, professId, 1);
			con.commit();
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
	 * 删除学生
	 * 
	 * @param mids
	 * @return
	 */
	public boolean deleteStudent(String[] snos) {
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			con.setAutoCommit(false);
			for (String sno : snos) {
				qr.update(con, "update tb_login set state=? where username=?", 0, sno);
				qr.update(con, "update tb_students set s_state=? where s_no=?", 0, sno);
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
	 * 修改学生
	 * 
	 * @param mid
	 * @param name
	 * @param url
	 * @param pid
	 * @return
	 */
	public boolean editStudent(String sno, String name, String zip, Date date, int deptId, int professId, int state) {
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			con.setAutoCommit(false);
			qr.update(con, "update tb_login set state=? where username=?", state, sno);
			int result = qr.update(con,
					"update tb_students set s_name=?,s_zip=?,s_indate=?,s_dep_no=?,s_pro_id=?,s_state=? where s_no=?",
					name, zip, date, deptId, professId, state, sno);
			con.commit();
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

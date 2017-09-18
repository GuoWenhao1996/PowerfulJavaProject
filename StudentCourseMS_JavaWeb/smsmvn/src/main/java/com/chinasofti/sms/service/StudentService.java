package com.chinasofti.sms.service;

import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chinasofti.sms.dao.DeptDao;
import com.chinasofti.sms.dao.ProfessDao;
import com.chinasofti.sms.dao.StudentDao;
import com.chinasofti.sms.entity.Depart;
import com.chinasofti.sms.entity.Profess;
import com.chinasofti.sms.entity.Student;
import com.chinasofti.sms.util.ConditionUtil;

/**
 * 学生信息服务层
 * 
 * @author guowh
 *
 */
public class StudentService {
	StudentDao studentdao = new StudentDao();
	DeptDao deptDao = new DeptDao();
	ProfessDao professDao = new ProfessDao();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * 查询学生信息 并为easyUI分页提供total和rows
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public Map<String, Object> loadStudentsPage(int pageNum, int pageSize, String s_no) {
		if (s_no == null) {
			s_no = "%%";
		} else {
			s_no = "%" + s_no + "%";
		}
		int total = studentdao.queryAllStudents(s_no).size();
		List<Student> rows = studentdao.queryAllStudentsPage(pageNum, pageSize, s_no);
		Map<String, Object> map = new HashMap<>();
		map.put("total", total);
		map.put("rows", rows);
		return map;
	}

	/**
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param s_no
	 * @param s_name
	 * @param s_zip
	 * @param s_dept
	 * @param s_profess
	 * @param s_begin
	 * @param s_end
	 * @return
	 */
	public Map<String, Object> loadStudentsPage(int pageNum, int pageSize, String s_no, String s_name, String s_zip,
			String s_dept, String s_profess, String s_begin, String s_end) {
		if (s_dept != null && s_dept.equals("0")) {
			s_dept = "";
		}
		if (s_profess != null && s_profess.equals("0")) {
			s_profess = "";
		}
		String sql = "select * from tb_students";
		ConditionUtil co = new ConditionUtil(sql);
		co.appendLike(ConditionUtil.AND, "s_no", s_no);
		co.appendLike(ConditionUtil.AND, "s_name", s_name);
		co.appendLike(ConditionUtil.AND, "s_zip", s_zip);
		co.appendEquals(ConditionUtil.AND, "s_dep_no", s_dept, Types.INTEGER);
		co.appendEquals(ConditionUtil.AND, "s_pro_id", s_profess, Types.INTEGER);
		co.appendNoSmailler(ConditionUtil.AND, "s_indate", s_begin, Types.DATE);
		co.appendNoBigger(ConditionUtil.AND, "s_indate", s_end, Types.DATE);
		co.appendNotEquals(ConditionUtil.AND, "s_state", "0", Types.INTEGER);
		int total = studentdao.queryStudentsBySql(co.toString()).size();

		sql = "select s.*,d.dep_name,p.pro_name from tb_students s join tb_depart d on s.s_dep_no=d.dep_id join tb_profess p on s.s_pro_id=p.pro_id";
		co = new ConditionUtil(sql);
		co.appendLike(ConditionUtil.AND, "s_no", s_no);
		co.appendLike(ConditionUtil.AND, "s_name", s_name);
		co.appendLike(ConditionUtil.AND, "s_zip", s_zip);
		co.appendEquals(ConditionUtil.AND, "s_dep_no", s_dept, Types.INTEGER);
		co.appendEquals(ConditionUtil.AND, "s_pro_id", s_profess, Types.INTEGER);
		co.appendNoSmailler(ConditionUtil.AND, "s_indate", s_begin, Types.DATE);
		co.appendNoBigger(ConditionUtil.AND, "s_indate", s_end, Types.DATE);
		co.appendNotEquals(ConditionUtil.AND, "s_state", "0", Types.INTEGER);
		co.appendLimit(pageNum, pageSize);
		List<Student> rows = studentdao.queryStudentsBySql(co.toString());
		Map<String, Object> map = new HashMap<>();
		map.put("total", total);
		map.put("rows", rows);
		return map;
	}

	/**
	 * 添加学生信息
	 * 
	 * @param name
	 * @param url
	 * @param pid
	 * @param professId
	 * @param deptId
	 * @return
	 */
	public boolean addStudent(String name, String zip, String indate, String deptId, String professId) {

		try {
			Date date = sdf.parse(indate);
			Depart depart = deptDao.getDeptById(Integer.parseInt(deptId));
			Profess profess = professDao.getProfessById(Integer.parseInt(professId));
			String sno = indate.substring(2, 4) + depart.getDep_no() + profess.getPro_no();
			int total = studentdao.queryAllStudents(sno + "%").size() + 1;
			if (total < 10) {
				sno = sno + "000" + total;
			} else if (total < 100) {
				sno = sno + "00" + total;
			} else if (total < 1000) {
				sno = sno + "0" + total;
			} else {
				sno = sno + total;
			}
			return studentdao.addStudent(sno, name, zip, date, Integer.parseInt(deptId), Integer.parseInt(professId));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 删除学生
	 * 
	 * @param s_nos
	 * @return
	 */
	public boolean deleteStudent(String s_nos) {
		String snos[] = s_nos.split(",");
		return studentdao.deleteStudent(snos);
	}

	/**
	 * 修改学生信息
	 * 
	 * @param mid
	 * @param name
	 * @param url
	 * @param pid
	 * @param state
	 * @param professId
	 * @param deptId
	 * @return
	 */
	public boolean editStudent(String sno, String name, String zip, String indate, String deptId, String professId,
			String state) {
		try {
			return studentdao.editStudent(sno, name, zip, sdf.parse(indate), Integer.parseInt(deptId),
					Integer.parseInt(professId), Integer.parseInt(state));
		} catch (NumberFormatException | ParseException e) {
			e.printStackTrace();
		}
		return false;
	}
}

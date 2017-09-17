package com.chinasofti.sms.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.sms.service.StudentService;

import net.sf.json.JSONObject;

@WebServlet("/student/*")
public class StudentController extends BaseController {

	private static final long serialVersionUID = 1L;
	private StudentService studentService = new StudentService();

	/**
	 * 加载学生信息
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void loadStudents(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pageNum = Integer.parseInt(req.getParameter("page"));
		int pageSize = Integer.parseInt(req.getParameter("rows"));
		String s_no = req.getParameter("s_no");
		Map<String, Object> map = studentService.loadStudentsPage(pageNum, pageSize, s_no);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONObject.fromObject(map).toString());
	}

	/**
	 * 组合查询加载学生信息
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void zuheLoadStudents(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int pageNum = Integer.parseInt(req.getParameter("page"));
		int pageSize = Integer.parseInt(req.getParameter("rows"));
		String s_no = req.getParameter("sno");
		String s_name = req.getParameter("name");
		String s_zip = req.getParameter("zip");
		String s_dept = req.getParameter("dept");
		String s_profess = req.getParameter("profess");
		String s_begin = req.getParameter("begin");
		String s_end = req.getParameter("end");
		Map<String, Object> map = studentService.loadStudentsPage(pageNum, pageSize, s_no, s_name, s_zip, s_dept,
				s_profess, s_begin, s_end);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONObject.fromObject(map).toString());
	}

	/**
	 * 添加学生
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String zip = req.getParameter("zip");
		String indate = req.getParameter("indate");
		String deptId = req.getParameter("deptId");
		String professId = req.getParameter("professId");
		boolean result = studentService.addStudent(name, zip, indate, deptId, professId);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(String.valueOf(result));
	}

	/**
	 * 删除学生
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String s_nos = req.getParameter("midStr");
		boolean result = studentService.deleteStudent(s_nos);
		resp.getWriter().write(result + "");
	}

	/**
	 * 修改学生
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void editStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sno = req.getParameter("sno");
		String name = req.getParameter("name");
		String zip = req.getParameter("zip");
		String indate = req.getParameter("indate");
		String deptId = req.getParameter("deptId");
		String professId = req.getParameter("professId");
		String state = req.getParameter("state");
		boolean result = studentService.editStudent(sno, name, zip, indate, deptId, professId, state);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(String.valueOf(result));
	}

}

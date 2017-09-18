package com.chinasofti.sms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.sms.entity.Depart;
import com.chinasofti.sms.service.DeptService;

import net.sf.json.JSONArray;

@WebServlet("/dept/*")
public class DeptController extends BaseController {

	private static final long serialVersionUID = 1L;
	DeptService deptService = new DeptService();

	public void queryAllDept(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Depart> list = deptService.queryAllDepts();
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONArray.fromObject(list).toString());
	}
}

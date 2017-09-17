package com.chinasofti.sms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.sms.entity.Profess;
import com.chinasofti.sms.service.ProfessService;

import net.sf.json.JSONArray;

@WebServlet("/profess/*")
public class ProfessController extends BaseController {

	private static final long serialVersionUID = 1L;
	ProfessService professService = new ProfessService();

	public void queryAllProfessByDeptId(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String deptId = req.getParameter("deptId");
		List<Profess> list = professService.queryAllProfessByDeptId(deptId);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONArray.fromObject(list).toString());
	}
}

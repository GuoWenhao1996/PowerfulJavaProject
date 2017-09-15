package com.chinasofti.sms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.sms.entity.Role;
import com.chinasofti.sms.service.RoleService;

import net.sf.json.JSONArray;

@WebServlet("/role/*")
public class RoleController extends BaseController {

	private static final long serialVersionUID = 1L;
	RoleService roleService = new RoleService();

	public void queryAllRoles(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Role> list = roleService.queryAllRoles();
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONArray.fromObject(list).toString());
	}
}

package com.gwhcool.vipcardms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gwhcool.vipcardms.entity.User;
import com.gwhcool.vipcardms.service.AdminService;

import net.sf.json.JSONArray;

/**
 * 用户控制层
 * 
 * @author gwh
 *
 */
public class AdminController extends BaseServlet {

	private static final long serialVersionUID = 1L;
	AdminService adminService = new AdminService();

	/**
	 * 查找当前所有用户
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryAllUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int uid = (int) req.getSession().getAttribute("uid");
		List<User> users = adminService.queryAllUser();
		users.remove(uid);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONArray.fromObject(users).toString());
	}
	/**
	 * 根据用户级别查找所有用户
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryUserByType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int uid = (int) req.getSession().getAttribute("uid");
		System.out.println("uid:"+uid);
		String cardtype=req.getParameter("cardtype");
		List<User> users = adminService.queryUserByType(cardtype);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONArray.fromObject(users).toString());
	}
}

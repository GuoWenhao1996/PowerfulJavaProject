package com.gwhcool.phonebook.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gwhcool.phonebook.entity.User;
import com.gwhcool.phonebook.service.UserService;

/**
 * 用户控制层
 * 
 * @author gwh
 *
 */
public class UserController extends BaseServlet {

	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();

	/**
	 * 判断用户登录
	 * 
	 * @param req
	 *            请求
	 * @param resp
	 *            响应
	 * @throws ServletException
	 * @throws IOException
	 */
	public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean result = userService.login(username, password);
		if (!result) {
			req.setAttribute("loginInfo", "用户名或密码错误！");
			req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
		} else {
			User user = userService.getUserByUsername(username);
			req.getSession().setAttribute("user", user);
			resp.sendRedirect("/MVC_PhoneBookMS/view/jsp/index.jsp");
		}
	}

	/**
	 * 注销
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().invalidate();
		resp.sendRedirect("/MVC_PhoneBookMS/view/login.jsp");
	}
}

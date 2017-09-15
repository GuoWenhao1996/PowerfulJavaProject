package com.chinasofti.sms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.sms.entity.Login;
import com.chinasofti.sms.entity.Menu;
import com.chinasofti.sms.service.MenuService;
import com.chinasofti.sms.service.UserService;

@WebServlet("/user/*")
public class UserController extends BaseController {

	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();
	private MenuService menuService = new MenuService();

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
			req.setAttribute("loginInfo", "账号或密码错误！");
			req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
		} else {
			Login user = userService.getUserByUsername(username);
			req.getSession().setAttribute("user", user);
			List<Menu> menus = menuService.queryAllMenuByUserType(user.getUsertype());
			req.setAttribute("menus", menus);
			req.getRequestDispatcher("/view/index.jsp").forward(req, resp);
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
		resp.sendRedirect("/sms/view/login.jsp");
	}
}
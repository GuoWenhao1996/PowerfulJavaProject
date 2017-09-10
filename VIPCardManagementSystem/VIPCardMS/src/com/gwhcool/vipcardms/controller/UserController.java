package com.gwhcool.vipcardms.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gwhcool.vipcardms.entity.User;
import com.gwhcool.vipcardms.service.UserService;
import net.sf.json.JSONObject;

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
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		resp.setCharacterEncoding("utf-8");
		if (username.trim().length() == 0) {
			resp.getWriter().write("用户名不能为空！");
		} else if (password.length() == 0) {
			resp.getWriter().write("密码不能为空！");
		} else {
			boolean flag = userService.login(username, password);
			if (flag) {
				User user = userService.getUserByUsername(username);
				req.getSession().setAttribute("uid", user.getUid());
				req.getSession().setAttribute("cardid", user.getCardid());
				req.getSession().setAttribute("logintime", user.getLogintime());
				userService.updateLoginTime(new Date(), user.getUid());
				resp.getWriter().write("true");
			} else {
				resp.getWriter().write("用户名或密码错误！");
			}
		}
	}

	/**
	 * 注册
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void reg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String username = req.getParameter("username").trim();
		String passwordA = req.getParameter("passwordA");
		String passwordB = req.getParameter("passwordB");
		String name = req.getParameter("name").trim();
		String sex = req.getParameter("sex").trim();
		String address = req.getParameter("address").trim();
		String telephone = req.getParameter("telephone").trim();
		String email = req.getParameter("email").trim();
		String creditcard = req.getParameter("creditcard").trim();
		if (username.isEmpty()) {
			resp.getWriter().write("用户名不能为空！");
		} else if (passwordA.isEmpty()) {
			resp.getWriter().write("密码不能为空！");
		} else if (!passwordB.equals(passwordA)) {
			resp.getWriter().write("密码与确认密码不一致！");
		} else if (name.isEmpty()) {
			resp.getWriter().write("姓名不能为空！");
		} else if (sex.isEmpty()) {
			resp.getWriter().write("性别不能为空！");
		} else if (address.isEmpty()) {
			resp.getWriter().write("地址不能为空！");
		} else if (telephone.isEmpty()) {
			resp.getWriter().write("电话不能为空！");
		} else if (email.isEmpty()) {
			resp.getWriter().write("邮箱不能为空！");
		} else if (creditcard.isEmpty()) {
			resp.getWriter().write("信用卡不能为空！");
		} else {
			boolean result = userService.reg(username, passwordA, name, sex, address, telephone, email, creditcard);
			if (result) {
				resp.getWriter().write("true");
			} else {
				resp.getWriter().write("修改失败，服务器异常！");
			}
		}

	}

	/**
	 * 检查用户名是否可用
	 * 
	 * @param req
	 *            请求
	 * @param resp
	 *            响应
	 * @throws ServletException
	 * @throws IOException
	 */
	public void checkUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");
		int uid = 0;
		if (req.getSession().getAttribute("uid") == null) {
			uid = -1;
		} else {
			uid = (int) req.getSession().getAttribute("uid");
		}
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(userService.checkUsername(username, uid));
	}

	/**
	 * 检查密码是否正确
	 * 
	 * @param req
	 *            请求
	 * @param resp
	 *            响应
	 * @throws ServletException
	 * @throws IOException
	 */
	public void checkPassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String oldpassword = req.getParameter("oldpassword");
		int uid = (int) req.getSession().getAttribute("uid");
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(userService.checkPassword(oldpassword, uid));
	}

	/**
	 * 获取上次登录时间
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getLoginTime(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Date date = (Date) req.getSession().getAttribute("logintime");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		String logintime = sdf.format(date);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(logintime);
	}

	/**
	 * 获取用户个人信息
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int uid = (int) req.getSession().getAttribute("uid");
		User user = userService.getUserByUid(uid);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONObject.fromObject(user).toString());

	}
	/**
	 * 根据id获取用户个人信息
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getInfoByUid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid=req.getParameter("uid");
		System.out.println("--------"+uid);
		User user = userService.getUserByUid(Integer.parseInt(uid));
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONObject.fromObject(user).toString());

	}
	/**
	 * 修改个人信息
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int uid = (int) req.getSession().getAttribute("uid");
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String username = req.getParameter("username").trim();
		String name = req.getParameter("name").trim();
		String sex = req.getParameter("sex").trim();
		String address = req.getParameter("address").trim();
		String telephone = req.getParameter("telephone").trim();
		String email = req.getParameter("email").trim();
		String creditcard = req.getParameter("creditcard").trim();
		if (username.isEmpty()) {
			resp.getWriter().write("用户名不能为空！");
		} else if (name.isEmpty()) {
			resp.getWriter().write("姓名不能为空！");
		} else if (sex.isEmpty()) {
			resp.getWriter().write("性别不能为空！");
		} else if (address.isEmpty()) {
			resp.getWriter().write("地址不能为空！");
		} else if (telephone.isEmpty()) {
			resp.getWriter().write("电话不能为空！");
		} else if (email.isEmpty()) {
			resp.getWriter().write("邮箱不能为空！");
		} else if (creditcard.isEmpty()) {
			resp.getWriter().write("信用卡不能为空！");
		} else {
			boolean result = userService.updateInfo(username, name, sex, address, telephone, email, creditcard, uid);
			if (result) {
				resp.getWriter().write("修改成功！");
			} else {
				resp.getWriter().write("修改失败，服务器异常！");
			}
		}

	}

	/**
	 * 修改密码
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updatePassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int uid = (int) req.getSession().getAttribute("uid");
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String passwordA = req.getParameter("passwordA");
		String passwordB = req.getParameter("passwordB");
		if (passwordA.isEmpty()) {
			resp.getWriter().write("新密码不能为空！");
		} else if (!passwordB.equals(passwordA)) {
			resp.getWriter().write("新密码与确认密码不一致！");
		} else {
			boolean result = userService.updatePassword(passwordA, uid);
			if (result) {
				resp.getWriter().write("修改成功！");
			} else {
				resp.getWriter().write("修改失败，服务器异常！");
			}
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
	}
}

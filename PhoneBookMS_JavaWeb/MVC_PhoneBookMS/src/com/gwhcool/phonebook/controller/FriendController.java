package com.gwhcool.phonebook.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gwhcool.phonebook.entity.Friend;
import com.gwhcool.phonebook.entity.User;
import com.gwhcool.phonebook.service.FriendService;

/**
 * 好友控制层
 * 
 * @author gwh
 *
 */
public class FriendController extends BaseServlet {

	private static final long serialVersionUID = 1L;
	private FriendService friendService = new FriendService();

	/**
	 * 查找当前用户的所有好友
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryAllFriend(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getSession().getAttribute("user") == null) {
			req.setAttribute("loginInfo", "认证过期，请重新登录！");
			resp.sendRedirect("/MVC_PhoneBookMS/view/login.jsp");
		} else {
			int uid = ((User) req.getSession().getAttribute("user")).getUid();
			List<Friend> friends = friendService.queryAllFriendByUserId(uid);
			req.setAttribute("friends", friends);
			req.getRequestDispatcher("/view/jsp/queryFriend.jsp").forward(req, resp);
		}
	}

	/**
	 * 添加好友
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addFriend(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String birthday = req.getParameter("birthday");
		String telephone = req.getParameter("telephone");
		String sex = req.getParameter("sex");
		String qq = req.getParameter("qq");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		if (req.getSession().getAttribute("user") == null) {
			System.out.println("认证过期，请重新登录！");
			req.setAttribute("loginInfo", "认证过期，请重新登录！");
			req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
		} else {
			int uid = ((User) req.getSession().getAttribute("user")).getUid();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date birth = birthday.equals("") ? null : sdf.parse(birthday);
				Friend friend = new Friend(name, birth, telephone, Integer.parseInt(sex), qq, email, address, uid);
				boolean flag = friendService.addFriend(friend, uid);
				if (flag) {
					System.out.println("添加成功");
					req.setAttribute("addInfo", "addInfo:添加成功！");
					System.out.println(req.getAttribute("addInfo"));
					req.getRequestDispatcher("/jsp/addFriend.jsp").forward(req, resp);
				} else {
					System.out.println("添加失败");
					req.setAttribute("addInfo", "添加失败！");
					req.getRequestDispatcher("/view/jsp/addFriend.jsp").forward(req, resp);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
}

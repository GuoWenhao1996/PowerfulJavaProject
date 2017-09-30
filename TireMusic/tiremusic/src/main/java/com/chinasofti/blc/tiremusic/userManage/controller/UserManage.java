package com.chinasofti.blc.tiremusic.userManage.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.blc.tiremusic.common.controller.BaseController;
import com.chinasofti.blc.tiremusic.userManage.entity.User;
import com.chinasofti.blc.tiremusic.userManage.service.UserManageService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/usermanage/*")
public class UserManage extends BaseController{

	UserManageService userManageService = new UserManageService();
	
	/**
	 * 分页查询上传不良信息的用户
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showUserPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page = Integer.parseInt(req.getParameter("page"));
		int rows = Integer.parseInt(req.getParameter("rows"));
		resp.setCharacterEncoding("utf-8");
		Map<String, Object> map = userManageService.showUserPage(page,rows);
		resp.getWriter().write(JSONObject.fromObject(map).toString());
	}
	/**
	 * 查询上传不良信息超过5次的用户
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> list = userManageService.showUser();
		int page = Integer.parseInt(req.getParameter("page"));
		int rows = Integer.parseInt(req.getParameter("rows"));
		System.out.println(page);
		System.out.println(rows);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONArray.fromObject(list).toString());
	}
	/**
	 * 用户状态更新
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateUserState(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uids");
		String[] uids = uid.split(",");
		for (int i = 0; i < uids.length; i++) {
			userManageService.updateUserState(Integer.parseInt(uids[i]));
		}
		resp.getWriter().write("true");
	}
}

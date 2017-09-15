package com.chinasofti.sms.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.sms.service.MenuService;

import net.sf.json.JSONObject;

@WebServlet("/menu/*")
public class MenuController extends BaseController {

	private static final long serialVersionUID = 1L;
	private MenuService menuService = new MenuService();

	/**
	 * 加载数据表格
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void loadMenus(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pageNum = Integer.parseInt(req.getParameter("page"));
		int pageSize = Integer.parseInt(req.getParameter("rows"));
		String name = req.getParameter("name");
		Map<String, Object> map = menuService.loadMenusPage(pageNum, pageSize, name);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONObject.fromObject(map).toString());
	}

}

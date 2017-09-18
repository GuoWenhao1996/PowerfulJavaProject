package com.chinasofti.sms.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.sms.entity.Menu;
import com.chinasofti.sms.service.MenuService;

import net.sf.json.JSONArray;
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

	/**
	 * 查询所有父级菜单
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getParentMenu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Menu> menus = menuService.queryAllParentMenus();
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONArray.fromObject(menus).toString());
	}

	/**
	 * 添加菜单
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addMenu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String url = req.getParameter("url");
		String pid = req.getParameter("pid");
		boolean result = menuService.addMenu(name, url, pid);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(String.valueOf(result));
	}

	/**
	 * 删除菜单
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteMenu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mids = req.getParameter("midStr");
		boolean result = menuService.deleteMenu(mids);
		resp.getWriter().write(result + "");
	}

	/**
	 * 修改菜单
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void editMenu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mid = req.getParameter("mid");
		String name = req.getParameter("name");
		String url = req.getParameter("url");
		String pid = req.getParameter("pid");
		boolean result = menuService.editMenu(mid, name, url, pid);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(String.valueOf(result));
	}

}

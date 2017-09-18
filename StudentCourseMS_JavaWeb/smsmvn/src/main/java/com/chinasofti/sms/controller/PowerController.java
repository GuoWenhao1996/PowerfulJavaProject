package com.chinasofti.sms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.sms.entity.MenuVo;
import com.chinasofti.sms.service.PowerService;

import net.sf.json.JSONArray;

@WebServlet("/power/*")
public class PowerController extends BaseController {

	private static final long serialVersionUID = 1L;
	PowerService powerService = new PowerService();

	/**
	 * 加载某角色的权限
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void loadPowers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int rid = Integer.parseInt(req.getParameter("rid"));
		List<MenuVo> list = powerService.queryPowerByRid(rid);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONArray.fromObject(list).toString());
	}

	/**
	 * 修改权限
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updatePower(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int rid = Integer.parseInt(req.getParameter("rid"));
		String mids = req.getParameter("midStr");
		boolean result = powerService.updatePower(rid, mids);
		resp.getWriter().write(result + "");
	}

}

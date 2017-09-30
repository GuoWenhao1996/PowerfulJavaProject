package com.chinasofti.blc.tiremusic.music.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.blc.tiremusic.common.controller.BaseController;
import com.chinasofti.blc.tiremusic.music.entity.Sensitiveword;
import com.chinasofti.blc.tiremusic.music.service.SensitivewordService;

import net.sf.json.JSONObject;
@WebServlet("/sw/*")
public class SensitivewordController extends BaseController{

	
	private static final long serialVersionUID = 1L;
	private SensitivewordService sensitivewordService=new SensitivewordService();
	/**
	 * 加载敏感词
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void loadAllSensitiveword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page =Integer.parseInt(req.getParameter("page"));
		int rows =Integer.parseInt(req.getParameter("rows"));
		List<Sensitiveword> list = sensitivewordService.queryAllSW(page, rows);
		int total = sensitivewordService.queryAllSW().size();
		Map<String, Object> map = new HashMap<>();
		map.put("total",total);
		map.put("rows",list);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONObject.fromObject(map).toString());
	}
	
	/**
	 * 增加敏感词
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addSW(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String swtext =req.getParameter("swtext");
		int sw = sensitivewordService.addSW(swtext);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(sw+"");
		
	}
	/**
	 * 删除敏感词
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteSensitivewordBySwid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int swid =Integer.parseInt(req.getParameter("swid"));
		int sw =sensitivewordService.deleteSW(swid);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(sw+"");
		
	}
	/**
	 * 修改敏感词
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void editSW(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int swid =Integer.parseInt(req.getParameter("swid"));
		String swtext =req.getParameter("swtext");
		int sw=sensitivewordService.updateSW(swtext, swid);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(sw+"");
	}
}

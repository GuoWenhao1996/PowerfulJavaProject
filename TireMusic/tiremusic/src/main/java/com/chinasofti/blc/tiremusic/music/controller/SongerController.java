package com.chinasofti.blc.tiremusic.music.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.blc.tiremusic.common.controller.BaseController;
import com.chinasofti.blc.tiremusic.music.entity.Songer;
import com.chinasofti.blc.tiremusic.music.service.SongerService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@WebServlet("/songer/*")
public class SongerController extends BaseController{

	private static final long serialVersionUID = 1L;
	private SongerService songerService =new SongerService();
	/**
	 * 异步加载所有歌手
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void loadAllSongers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Songer> list=songerService.queryAllSongers();
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONArray.fromObject(list).toString());
	}
	
	/**
	 * 异步分页加载所有歌手
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void loadAllSongersPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pagenum = Integer.parseInt(req.getParameter("page"));
		int pagesize = Integer.parseInt(req.getParameter("rows"));
		Map<String,Object> map=songerService.queryAllSongersPage(pagenum, pagesize);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONObject.fromObject(map).toString());
	}
	/**
	 * 添加歌手
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addNewSonger(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String songername = req.getParameter("songername");
		String songertext = req.getParameter("songertext");
		int resoult = songerService.addNewSonger(songername, songertext); 
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(resoult+"");
	}
	/**
	 * 修改歌手信息
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void changeSonger(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int songerid = Integer.parseInt(req.getParameter("songerid"));
		String songername = req.getParameter("songername");
		String songertext = req.getParameter("songertext");
		int resoult = songerService.changeSonger(songerid,songername, songertext); 
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(resoult+"");
	}
	/**
	 * 删除歌手
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteSonger(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int songerid = Integer.parseInt(req.getParameter("songerid"));
		int resoult = songerService.deleteSonger(songerid); 
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(resoult+"");
	}
}

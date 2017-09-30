package com.chinasofti.blc.tiremusic.statistics.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.blc.tiremusic.common.controller.BaseController;
import com.chinasofti.blc.tiremusic.statistics.dao.StatisticsAuditionDao;
import com.chinasofti.blc.tiremusic.statistics.dao.StatisticsDownDao;
import com.chinasofti.blc.tiremusic.statistics.dao.StatisticsUserDao;
import com.chinasofti.blc.tiremusic.statistics.entry.AuditionNum;
import com.chinasofti.blc.tiremusic.statistics.entry.AuditionSong;
import com.chinasofti.blc.tiremusic.statistics.entry.DownNum;
import com.chinasofti.blc.tiremusic.statistics.entry.DownSong;
import com.chinasofti.blc.tiremusic.statistics.service.Statisticssrvice;

import net.sf.json.JSONArray;
/**
 * 统计下载量、试听量、用户量请求
 * @author ljp
 *
 */
@WebServlet("/Statistics/*")
public class Statisticscontroller extends BaseController{

	private static final long serialVersionUID = 1L;
	private Statisticssrvice ss = new Statisticssrvice();
	/**
	 * 获取歌曲下载量
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showDownNumber(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<DownNum> list = new ArrayList<>();
		//不分页返回
//		list = ss.getDownNum();
		int pageNum = Integer.parseInt(req.getParameter("page"));
		int pageSize = Integer.parseInt(req.getParameter("rows"));
		//分页返回
		list = ss.getDownNumPage(pageNum, pageSize);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONArray.fromObject(list).toString());
	}
	/**
	 * 获取歌曲试听量
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showAuditionNumber(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<AuditionNum> list= new ArrayList<>();
		//不分页返回
//		list=ss.getAuditionNum();
		int pageNum = Integer.parseInt(req.getParameter("page"));
		int pageSize = Integer.parseInt(req.getParameter("rows"));
//		//分页返回
		list = ss.getAuditionNumPage(pageNum, pageSize);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONArray.fromObject(list).toString());
	}
	/**
	 * 根据下载量排行获取指定数量的歌曲对象
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getDownTop(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("num"));
		List<DownSong> list = new ArrayList<>();
		list = ss.getDownSong(num);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONArray.fromObject(list).toString());
	}
	/**
	 * 根据试听量获取指定数量的歌曲对象
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getAuditionTop(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("num"));
		System.out.println(num);
		List<AuditionSong> list = new ArrayList<>();
		list = ss.getAuditionSong(num);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONArray.fromObject(list).toString());
	}
	/**
	 * 获取注册用户的数量
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getUserNumber(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num = ss.getUserNum();
		
	}
	
}

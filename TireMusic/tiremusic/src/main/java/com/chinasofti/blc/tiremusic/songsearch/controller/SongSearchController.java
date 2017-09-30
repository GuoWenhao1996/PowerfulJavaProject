package com.chinasofti.blc.tiremusic.songsearch.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.blc.tiremusic.SongAudition.entity.Song;
import com.chinasofti.blc.tiremusic.common.controller.BaseController;
import com.chinasofti.blc.tiremusic.songsearch.service.SongSearchService;

import net.sf.json.JSONArray;
@WebServlet("/songsearch/*")
public class SongSearchController extends BaseController{

	private static final long serialVersionUID = 1L;
	
	private SongSearchService songSearchService = new SongSearchService();
	
	/**
	 * 歌曲搜索
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void songSearch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String songname = req.getParameter("songname");
		String songername = req.getParameter("songername");
		String schoolid = req.getParameter("schoolid");
		List<Song> list = songSearchService.searchSong(songname, songername, schoolid);
		resp.setContentType("text/html; charset=utf-8");
		req.getSession().setAttribute("list1",list);
		resp.getWriter().write(JSONArray.fromObject(list).toString());
	}
	
}

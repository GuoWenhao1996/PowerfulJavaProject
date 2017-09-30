package com.chinasofti.blc.tiremusic.SongAudition.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.blc.tiremusic.SongAudition.entity.Song;
import com.chinasofti.blc.tiremusic.SongAudition.service.SongListenService;
import com.chinasofti.blc.tiremusic.common.controller.BaseController;

import net.sf.json.JSONArray;
@WebServlet("/songaudition/*")
public class SongAuditionController extends BaseController{

	private static final long serialVersionUID = 1L;
	
	private SongListenService songListenService = new SongListenService();
	/**
	 * 歌曲列表初始化
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void loginSongs(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Song song = new Song();
		song.setSongid(-1);
		song.setSongname("五月天 - 你不是真正的快乐.mp3");
		song.setSongername("五月天");
		song.setLocation("/tiremusic/chahua/五月天 - 你不是真正的快乐.mp3");
		Song song1 = new Song();
		song1.setSongid(-2);
		song1.setSongname("五月天 - 伤心的人别听慢歌(贯彻快乐).mp3");
		song1.setSongername("五月天");
		song1.setLocation("/tiremusic/chahua/五月天 - 伤心的人别听慢歌(贯彻快乐).mp3");
		Song song2 = new Song();
		song2.setSongid(-3);
		song2.setSongname("胡彦斌 - 蝴蝶.mp3");
		song2.setSongername("胡彦斌 ");
		song2.setLocation("/tiremusic/chahua/胡彦斌 - 蝴蝶.mp3");
		List<Song> list = new ArrayList<>();
		list.add(song2);
		list.add(song1);
		list.add(song);
		req.getSession().setAttribute("songs",list);
		resp.setContentType("text/html; charset=utf-8");
		resp.getWriter().write(JSONArray.fromObject(list).toString());
		
	}
	
	/**
	 * 歌曲试听
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void listenSong(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		List<Song> list = (List<Song>)req.getSession().getAttribute("songs");
		int songid = -1;
		if(req.getParameter("songid")!=null) {
			songid = Integer.parseInt(req.getParameter("songid"));
		}
		String songname = req.getParameter("songname");
		String songername = req.getParameter("songername");
		String location = req.getParameter("location");
		if(songname!=null&&songername!=null&&location!=null) {
			Object u =  req.getSession().getAttribute("uid");
			int uid = 0;
			if(u!=null) {
				uid = Integer.parseInt(u+"");
			}
			songListenService.addShiTing(uid, songid);
			Song song = new Song();
			song.setSongid(songid);
			song.setSongname(songname);
			song.setSongername(songername);
			song.setLocation(location);
			list.add(song);
		}
		resp.setContentType("text/html; charset=utf-8");
		resp.getWriter().write(JSONArray.fromObject(list).toString());
	}
	/**
	 * 刷新列表
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showSong(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		List<Song> list = (List<Song>)req.getSession().getAttribute("songs");
		resp.setContentType("text/html; charset=utf-8");
		resp.getWriter().write(JSONArray.fromObject(list).toString());
	}
	/**
	 * 加载最新歌曲
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void lodaNewSongs(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Song> list1 = songListenService.newSongs();
		resp.setContentType("text/html; charset=utf-8");
		resp.getWriter().write(JSONArray.fromObject(list1).toString());
	}
	/**
	 * 加载上传按键
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showUploadLogo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Object u =  req.getSession().getAttribute("uid");
		int uid = 0;
		boolean result = false;
		if(u!=null) {
			uid = Integer.parseInt(u+"");
		}
		if(uid>0) {
			result = true;
		}
		resp.getWriter().write(result+"");
	}
	
}

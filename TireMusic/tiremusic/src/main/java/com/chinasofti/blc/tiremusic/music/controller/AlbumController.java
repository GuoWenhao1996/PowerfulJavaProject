package com.chinasofti.blc.tiremusic.music.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.blc.tiremusic.common.controller.BaseController;
import com.chinasofti.blc.tiremusic.music.entity.Album;
import com.chinasofti.blc.tiremusic.music.service.AlbumService;

import net.sf.json.JSONArray;
@WebServlet("/album/*")
public class AlbumController extends BaseController{

	private static final long serialVersionUID = 1L;
	private AlbumService albumService = new AlbumService();
	/**
	 * 根据该歌手id查询该歌手所有专辑
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public  void loadAllAlbumsBySongerid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int songerid = Integer.parseInt(req.getParameter("songerid"));
		//System.out.println(songerid);
		List<Album> list = albumService.queryAllAlbumBySongerid(songerid);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONArray.fromObject(list).toString());
				
		
	}
}

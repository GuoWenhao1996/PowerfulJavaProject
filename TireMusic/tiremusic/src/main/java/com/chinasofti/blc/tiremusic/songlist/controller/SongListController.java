package com.chinasofti.blc.tiremusic.songlist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chinasofti.blc.tiremusic.common.controller.BaseController;
import com.chinasofti.blc.tiremusic.songlist.entity.MusicInSongList;
import com.chinasofti.blc.tiremusic.songlist.entity.SongList;
import com.chinasofti.blc.tiremusic.songlist.service.SongListService;

import net.sf.json.JSONArray;

/**
 * 歌单控制层
 * 
 * @author guowh
 *
 */
@WebServlet("/songlist/*")
public class SongListController extends BaseController {

	private static final long serialVersionUID = 1L;
	SongListService songListService = new SongListService();

	/**
	 * 增加歌单
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addMusicList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		Object uid =  req.getSession().getAttribute("uid");
		String result = songListService.addSongList(name, Integer.parseInt(uid+""));
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(result);
	}

	/**
	 * 删除歌单
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteMusicList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String lid = req.getParameter("listId");
		boolean result = songListService.deleteSongListByLid(lid);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(String.valueOf(result));
	}

	/**
	 * 修改歌单
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateMusicList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String lid = req.getParameter("listId");
		Object uid =  req.getSession().getAttribute("uid");
		String result = songListService.updateSongListByLid(lid, name, Integer.parseInt(uid+""));
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(result);
	}

	/**
	 * 显示该用户的所有歌单
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showAllMusicList(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Object uid =  req.getSession().getAttribute("uid");
		List<SongList> list = songListService.queryAllListByUid(Integer.parseInt(uid+""));
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONArray.fromObject(list).toString());
	}

	/**
	 * 显示某歌单下的所有歌曲
	 *
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showAllMusicByListId(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String lid = req.getParameter("lid");
		List<MusicInSongList> list = songListService.showAllMusicByListId(Integer.parseInt(lid));
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONArray.fromObject(list).toString());	
	}

	/**
	 * 把歌曲加到指定歌单中
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addMusicToList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sid = req.getParameter("sid");
		String lid = req.getParameter("lid");
		String result = songListService.addMusicToList(Integer.parseInt(sid), Integer.parseInt(lid));
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(result);
	}

	/**
	 * 把指定歌曲从指定歌单中移除
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteMusicInList(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String sid = req.getParameter("sid");
		String lid = req.getParameter("lid");
		boolean result = songListService.deleteMusicInList(sid, lid);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(String.valueOf(result));
	}
}

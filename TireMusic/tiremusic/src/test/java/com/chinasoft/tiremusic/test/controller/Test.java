package com.chinasoft.tiremusic.test.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.tiremusic.test.entity.Song;

import net.sf.json.JSONArray;
@WebServlet("/tt.do")
public class Test extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("请求进来了");
		Song song = new Song();
		song.setSongid(1);
		song.setSongname("五月天 - 你不是真正的快乐.mp3");
		song.setSonger("五月天");
		song.setSongurl("/tiremusic/chahua/五月天 - 你不是真正的快乐.mp3");
		Song song1 = new Song();
		song1.setSongid(2);
		song1.setSongname("五月天 - 伤心的人别听慢歌(贯彻快乐).mp3");
		song1.setSonger("五月天");
		song1.setSongurl("/tiremusic/chahua/五月天 - 伤心的人别听慢歌(贯彻快乐).mp3");
		Song song2 = new Song();
		song2.setSongid(3);
		song2.setSongname("胡彦斌 - 蝴蝶.mp3");
		song2.setSonger("胡彦斌 ");
		song2.setSongurl("/tiremusic/chahua/胡彦斌 - 蝴蝶.mp3");
		List<Song> list = new ArrayList<>();
		list.add(song);
		list.add(song1);
		list.add(song2);
		resp.setContentType("text/html; charset=utf-8");
		resp.getWriter().write(JSONArray.fromObject(list).toString());
	}

}

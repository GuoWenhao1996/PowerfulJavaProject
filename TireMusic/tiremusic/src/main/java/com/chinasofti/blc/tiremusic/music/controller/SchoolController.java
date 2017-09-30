package com.chinasofti.blc.tiremusic.music.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.blc.tiremusic.common.controller.BaseController;
import com.chinasofti.blc.tiremusic.music.entity.School;
import com.chinasofti.blc.tiremusic.music.entity.Songer;
import com.chinasofti.blc.tiremusic.music.service.SchoolService;

import net.sf.json.JSONArray;
@WebServlet("/school/*")
public class SchoolController extends BaseController{

	private static final long serialVersionUID = 1L;
	private SchoolService schoolService = new SchoolService();
	/**
	 * 查询所有的流派信息
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void loadAllSchools(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<School> list=schoolService.queryAllSchools();
		//System.out.println(list);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONArray.fromObject(list).toString());
	}
}

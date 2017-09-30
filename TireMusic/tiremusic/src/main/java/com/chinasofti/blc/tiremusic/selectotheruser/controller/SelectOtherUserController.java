package com.chinasofti.blc.tiremusic.selectotheruser.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.blc.tiremusic.common.controller.BaseController;
import com.chinasofti.blc.tiremusic.selectotheruser.service.SelectOtherUserService;

import net.sf.json.JSONObject;
@WebServlet(value="/otheruser/*",name="SelectOtherUserController")
public class SelectOtherUserController extends BaseController{
	private SelectOtherUserService otherUserService=new SelectOtherUserService();
	private static final long serialVersionUID = 1L;

	public void selectotheruser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 req.setCharacterEncoding("utf-8");
	        resp.setCharacterEncoding("utf-8");
	        resp.setHeader("content-type", "text/jsp;charset=utf-8");
			PrintWriter pw=resp.getWriter();
		    int page=Integer.parseInt(req.getParameter("page"));
		    int pagesize=Integer.parseInt(req.getParameter("rows"));
		    int start=(page-1)*pagesize;
		    String searchname=req.getParameter("searchname");
		    JSONObject otherusers=otherUserService.selectotherusers(start, pagesize, searchname);
		    pw.write(otherusers.toString());
	}
}

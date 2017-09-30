package com.chinasofti.blc.tiremusic.foucsotheruser.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.blc.tiremusic.common.controller.BaseController;
import com.chinasofti.blc.tiremusic.focusotheruser.service.FocusOtherUserService;

public class FoucsOtherUserController extends BaseController{
	private static final long serialVersionUID = 1L;
	private FocusOtherUserService otherUserService=new FocusOtherUserService();
	public void foucsotheruser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int uid=Integer.parseInt(req.getParameter("uid"));
		int confirmid=Integer.parseInt(req.getParameter("confirm"));
		boolean flag=false;
		flag=otherUserService.focusotheruser(uid, confirmid);
		resp.getWriter().write(String.valueOf(flag));	
	}
}

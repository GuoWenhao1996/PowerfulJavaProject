package com.chinasofti.blc.tiremusic.manage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.blc.tiremusic.common.controller.BaseController;
@WebServlet("/manage/*")
public class ManageLoginContorller extends BaseController{

	private static final long serialVersionUID = 1L;
	
	public void manageLoginContorller(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String manageusername = req.getParameter("manageusername");
		String managepassword = req.getParameter("managepassword");
		System.out.println(manageusername);
		System.out.println(managepassword);
		if(manageusername.equals("admin")&&managepassword.equals("admin")) {
			resp.sendRedirect("/tiremusic/view/manage/managemain.jsp");
		}else {
			req.getRequestDispatcher("/tiremusic/managelogin.jsp").forward(req, resp);
		}
	}
}
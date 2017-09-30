package com.chinasofti.blc.tiremusic.user.contorller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.blc.tiremusic.common.controller.BaseController;
import com.chinasofti.blc.tiremusic.mv.entity.Mv;
import com.chinasofti.blc.tiremusic.mv.service.MvService;
import com.chinasofti.blc.tiremusic.songlist.entity.SongList;
import com.chinasofti.blc.tiremusic.songlist.service.SongListService;
import com.chinasofti.blc.tiremusic.user.entity.User;
import com.chinasofti.blc.tiremusic.user.service.UserLoginService;
@WebServlet("/user/*")
public class UserLoginContorller extends BaseController{
	
	private static final long serialVersionUID = 1L;
	private UserLoginService userloginservice = new UserLoginService();
	private SongListService songListService = new SongListService();
	private MvService mvService = new MvService();
	/**
	 * 用户登录
	 */
	public void userLoginContorller(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String condition = req.getParameter("condition");
		String password = req.getParameter("upassword");
		//根据用户输入的手机号码登录
		if((userloginservice.userLoginByUtelephone(condition, password))!=null){
			User user = userloginservice.userLoginByUtelephone(condition, password);
			req.getSession().setAttribute("uid",user.getUid());
			req.getSession().setAttribute("user",user);
			List<SongList> songlist = songListService.queryAllListByUid(user.getUid());
			List<Mv> mvlist =mvService.loadAllMvByState();
			req.setAttribute("songlist", songlist);
			req.getSession().setAttribute("mvlist",mvlist);
			req.getRequestDispatcher("/chahua/index.jsp").forward(req, resp);
		}
		//根据用户输入的邮箱登录
		else if((userloginservice.userLoginByUemail(condition, password))!=null) {
			User user = userloginservice.userLoginByUemail(condition, password);
			req.getSession().setAttribute("user",user);
			req.getSession().setAttribute("uid",user.getUid());
			List<SongList> songlist = songListService.queryAllListByUid(user.getUid());
			List<Mv> mvlist =mvService.loadAllMvByState();
			req.setAttribute("songlist", songlist);
			req.getSession().setAttribute("mvlist",mvlist);
			req.getRequestDispatcher("/chahua/index.jsp").forward(req, resp);
		}
		//根据用户输入的用户名登录
		else if((userloginservice.userLoginByUname(condition, password))!=null) {
			User user = userloginservice.userLoginByUname(condition, password);
			System.out.println(user.toString()+"1111");
			System.out.println(user.getUserbirthday()+"2222");
			req.getSession().setAttribute("user",user);
			req.getSession().setAttribute("uid", user.getUid());
			List<SongList> songlist = songListService.queryAllListByUid(user.getUid());
			List<Mv> mvlist =mvService.loadAllMvByState();
			req.setAttribute("songlist", songlist);
			req.getSession().setAttribute("mvlist",mvlist);
			req.getRequestDispatcher("/chahua/index.jsp").forward(req, resp);
		}
		else {
			req.setAttribute("logininfo", "用户名或密码错误！");
			req.getRequestDispatcher("/chahua/signin.jsp").forward(req, resp);
		}
	}
	
	/**
	 * 登出
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void logOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().removeAttribute("user");
		req.getSession().removeAttribute("uid");
		resp.getWriter().write(true+"");
	}
}

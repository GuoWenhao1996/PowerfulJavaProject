package com.gwhcool.vipcardms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gwhcool.vipcardms.entity.Addlog;
import com.gwhcool.vipcardms.entity.Costlog;
import com.gwhcool.vipcardms.service.MoneyService;

import net.sf.json.JSONArray;

/**
 * 余额控制层
 * 
 * @author gwh
 *
 */
public class MoneyController extends BaseServlet {

	private static final long serialVersionUID = 1L;
	MoneyService moneyService = new MoneyService();

	/**
	 * 查找当前充值记录
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryAllAddLog(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int uid = (int) req.getSession().getAttribute("uid");
		List<Addlog> logs = null;
		if (uid == 0) {
			logs = moneyService.queryAllAddLog();
		} else {
			logs = moneyService.queryAddLogByUid(uid);
		}
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONArray.fromObject(logs).toString());
	}

	/**
	 * 查找当前消费记录
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryAllCostLog(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int uid = (int) req.getSession().getAttribute("uid");
		List<Costlog> logs = null;
		if (uid == 0) {
			logs = moneyService.queryAllCostLog();
		} else {
			logs = moneyService.queryCostLogByUid(uid);
		}
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONArray.fromObject(logs).toString());
	}

	/**
	 * 充值
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addmoney(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int uid = (int) req.getSession().getAttribute("uid");
		String money = req.getParameter("money");
		String count = req.getParameter("count");
		boolean result = moneyService.addmoney(uid, money,count);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(String.valueOf(result));
	}
	/**
	 * 消费
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void costmoney(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int uid = (int) req.getSession().getAttribute("uid");
		String descrip = req.getParameter("desc");
		String money = req.getParameter("money");
		String count = req.getParameter("count");
		boolean result = moneyService.costmoney(uid,descrip, money,count);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(String.valueOf(result));
	}

}

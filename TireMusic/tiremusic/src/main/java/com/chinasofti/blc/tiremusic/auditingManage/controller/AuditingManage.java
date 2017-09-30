package com.chinasofti.blc.tiremusic.auditingManage.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.blc.tiremusic.auditingManage.entity.Auditing;
import com.chinasofti.blc.tiremusic.auditingManage.service.AuditingManageService;
import com.chinasofti.blc.tiremusic.common.controller.BaseController;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 上传审核
 * @author 赵权
 *
 */
@WebServlet("/auditingmanage/*")
public class AuditingManage extends BaseController{
	
	private static final long serialVersionUID = 1L;
	AuditingManageService auditingManageService = new AuditingManageService();
	
	/**
	 * 显示所有的待审核的文件
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showAllAuditing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page = Integer.parseInt(req.getParameter("page"));
		int rows = Integer.parseInt(req.getParameter("rows"));
		resp.setCharacterEncoding("utf-8");
		Map<String, Object> map = auditingManageService.loadAuditingPage(page, rows);
		resp.getWriter().write(JSONObject.fromObject(map).toString());
	}
	
	/**
	 * 上传文件不通过
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void uploadAuditingNoAC(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uploadlistids = req.getParameter("uploadlistids");
		String[] uploadlistid = uploadlistids.split(",");
		for (int i = 0; i < uploadlistid.length; i++) {
			auditingManageService.updateAuditingStateNoAC(Integer.parseInt(uploadlistid[i]));
		}
		resp.getWriter().write("true");
	}
	
	/**
	 * 上传文件通过
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void uploadAuditingAC(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uploadlistids = req.getParameter("uploadlistids");
		String[] uploadlistid = uploadlistids.split(",");
		for (int i = 0; i < uploadlistid.length; i++) {
			auditingManageService.updateAuditingStateAC(Integer.parseInt(uploadlistid[i]));
		}
		resp.getWriter().write("true");
	}
}

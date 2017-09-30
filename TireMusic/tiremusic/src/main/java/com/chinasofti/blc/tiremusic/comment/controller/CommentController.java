package com.chinasofti.blc.tiremusic.comment.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.blc.tiremusic.comment.entity.Comment;
import com.chinasofti.blc.tiremusic.comment.service.CommentService;
import com.chinasofti.blc.tiremusic.common.controller.BaseController;

import net.sf.json.JSONArray;

/**
 * 评论控制层
 * 
 * @author guowh
 *
 */
@WebServlet("/comment/*")
public class CommentController extends BaseController {

	private static final long serialVersionUID = 1L;
	CommentService commentService = new CommentService();

	/**
	 * 新增评论
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addDiscuss(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Object uid = req.getSession().getAttribute("uid");
		String sid = req.getParameter("sid");
		String content = req.getParameter("content");
		String result = commentService.addDiscuss(uid + "", sid, content);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(result);
	}

	/**
	 * 删除评论
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteDiscuss(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cid = req.getParameter("cid");
		boolean result = commentService.deleteDiscuss(cid);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(String.valueOf(result));
	}

	/**
	 * 展示评论列表
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showDiscussList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sid = req.getParameter("sid");
		List<Comment> list = commentService.showDiscussList(sid);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONArray.fromObject(list).toString());
	}

}

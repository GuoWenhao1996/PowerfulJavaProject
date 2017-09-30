package com.chinasofti.blc.tiremusic.mv.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.chinasofti.blc.tiremusic.SongAudition.entity.Song;
import com.chinasofti.blc.tiremusic.common.controller.BaseController;
import com.chinasofti.blc.tiremusic.mv.entity.Mv;
import com.chinasofti.blc.tiremusic.mv.service.MvService;

import net.sf.json.JSONArray;
@WebServlet("/MV/*")
@MultipartConfig
/**
 * MV控制类
 * @author Administrator
 *
 */
public class MvController extends BaseController{
	
	private MvService mvService =new MvService();
	private static final long serialVersionUID = 1L;
	/**
	 * 获取文件名
	 * @param part
	 * @return
	 */
	private String getFileName(Part part){
		String contentDispostion=part.getHeader("content-disposition");
		String filename=contentDispostion.substring(contentDispostion.indexOf("filename")+10,contentDispostion.length()-1);
		return filename;
	}
	/**
	 * 查看所有的MV
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void loadAllMv(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//查询参数
		/**
		 * mvid:mvid,
			mvname:mvname,
			mvtext:mvtext,
			songid:songid,
			mvstate:mvstate,
			beginDate:beginDate,
			endDate:endDate
		 */	
		String mvid=req.getParameter("mvid");
		String mvname=req.getParameter("mvname");
		String mvtext=req.getParameter("mvtext");
		String songid=req.getParameter("songid");
		String mvstate=req.getParameter("mvstate");
		String beginDate=req.getParameter("beginDate");
		String endDate=req.getParameter("endDate");
		String mvpustate=req.getParameter("mvpustate");
		List<Mv> list = mvService.loadAllMv(mvid,mvname,mvtext,songid,mvstate,beginDate,endDate,mvpustate);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONArray.fromObject(list).toString());
	}
	/**
	 * 根据状态查询
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void loadAllMvByState(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Mv> list = mvService.loadAllMvByState();
		
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONArray.fromObject(list).toString());
	}
	/**
	 * 上架MV
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void putMv(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int mvid =Integer.valueOf(req.getParameter("mvid"));
		boolean result=mvService.putMv(mvid);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(result+"");
	}
	/**
	 * 下架MV
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void downMv(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int mvid =Integer.valueOf(req.getParameter("mvid"));
		boolean result=mvService.downMv(mvid);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(result+"");
	}
	/**
	 * 根据歌曲id查询歌曲名称
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void serachSongnameBysongid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int songid =Integer.valueOf(req.getParameter("songid"));
		String songname =mvService.serachSongnameBysongid(songid);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(songname);
	}
	/**
	 * 查询所有的歌曲id
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void searchAllSongid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Song> list = mvService.searchAllSongid();
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONArray.fromObject(list).toString());
	}
	/**
	 * 更新MV信息
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateMvInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mvname=req.getParameter("mvname");
		int songid=Integer.parseInt(req.getParameter("songid"));
		String mvtext=req.getParameter("mvtext");
		String releasetime=req.getParameter("releasetime");
		int mvid =Integer.parseInt(req.getParameter("mvid"));
		SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd");
        Date date=null;
		try {
			date =format.parse(releasetime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int i =mvService.updateMvInfo(mvname, songid, mvtext, date, mvid);
		resp.getWriter().write(i);
	}
	
	/**
	 * 增加MV
	 
	public void addMv(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MvService mvService =new MvService();
		req.setCharacterEncoding("utf-8");
		String mvname=req.getParameter("mvname");
		int songid=Integer.parseInt(req.getParameter("songid"));
		String mvtext=req.getParameter("mvtext");
		String releasetime =req.getParameter("releasetime");
		SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd");
        Date date=null;
		try {
			date =format.parse(releasetime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//判断文件夹是否存在,不存在则创建文件夹
		File file =new File("e:\\frontimg");
		if (!file.exists()&&!file.isDirectory()) {
			file.mkdir();
		}
		File file1 =new File("e:\\MV");
		if (!file1.exists()&&!file1.isDirectory()) {
			file1.mkdir();
		}
		//上传封面的路径
		Part frontimg=req.getPart("frontimg");
		String frontimgfilename=getFileName(frontimg);
		frontimg.write("e:/frontimg/"+frontimgfilename);
		//上传MV的路径
		Part location =req.getPart("location");
		String locationfilename=getFileName(location);
		location.write("/e:/MV/"+locationfilename);
		//本机封面地址
		String frontimgurl=("file:///e:/frontimg"+frontimgfilename);
		//本机MV地址
		String loacationurl=("file:///e:/MV"+locationfilename);
		int i=mvService.addMv(mvname, songid, mvtext, date, frontimgurl, loacationurl);
		resp.getWriter().write(i);
	}*/
	/**
	 * 审核MV
	 */
	public void auditingMv(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int mvid=Integer.parseInt(req.getParameter("mvid"));
		boolean result=mvService.auditingMv(mvid);
		resp.getWriter().write(result+"");
	}
	/**
	 * 根据MVid查询MV地址
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void loadMvById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int mvid =Integer.valueOf(req.getParameter("mvid"));
		String location=mvService.loadMvById(mvid);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(location);
	}
}

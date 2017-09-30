package com.chinasofti.blc.tiremusic.user.contorller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.chinasofti.blc.tiremusic.common.controller.BaseController;
import com.chinasofti.blc.tiremusic.mv.entity.Mv;
import com.chinasofti.blc.tiremusic.mv.service.MvService;
import com.chinasofti.blc.tiremusic.songlist.entity.SongList;
import com.chinasofti.blc.tiremusic.songlist.service.SongListService;
import com.chinasofti.blc.tiremusic.user.entity.User;
import com.chinasofti.blc.tiremusic.user.service.UserUpdateService;
@WebServlet("/userupdate/*")
public class UserUpdateContorller extends BaseController{
	
	private static final long serialVersionUID = 1L;
	
	private UserUpdateService userUpdateService = new UserUpdateService();
	private SongListService songListService = new SongListService();
	private MvService mvService = new MvService();
	public void userUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ParseException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		int uid = (int)req.getSession().getAttribute("uid");
		String uname = "";
		String realname = "";
		int usersex = 0;
		String uaddress = "";
		String uemail = "";
		String utelephone = "";
		String uidnumber = "";
		String date = "";
		String avatar = "";
		Date userbirthday = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		DiskFileItemFactory factory = new DiskFileItemFactory();//文件上传
		ServletFileUpload upload = new ServletFileUpload(factory);//文件上传解析器
		upload.setHeaderEncoding("utf-8");//防止文件名中文乱码
		OutputStream out = null;
		try {
			//获得文件名
			List<FileItem> fileItems = upload.parseRequest(req);
			FileItem fileItem = fileItems.get(0);
			Iterator iter = fileItems.iterator();
			String fileName = "";
			InputStream in = null;
			while(iter.hasNext()) {
		        FileItem item = (FileItem)iter.next();
		        // 判断该属性是否是file类型
		        if (!item.isFormField()) {
		            in = item.getInputStream();
		            fileName = item.getName();
		            if (fileName.equals("")||fileName==null) {
		            	User user1 = (User)(req.getSession().getAttribute("user"));
		            	avatar = user1.getAvatar();
					}else {
			            System.out.println("文件名："+fileName);
						String[] strings = fileName.split("\\\\");
						File file = new File("E:\\project\\img");
						if (!file.exists()) {
							file.mkdirs();
						}
						out = new FileOutputStream(new File("E:\\project\\img"+File.separator+strings[strings.length-1]));
						avatar = "http://localhost:8080/img/"+strings[strings.length-1];
						byte[] b = new byte[1024*1024];
						int count = 0;
						while((count=in.read(b))!=-1) {
							out.write(b, 0, count);
						}
						resp.setHeader("content-type", "text/html;charset=utf-8");
					}
		         } else {
		            // 不是file类型的话，就利用getFieldName判断name属性获取相应的值
		             if("uname".equals(item.getFieldName())) {
		            	 uname = item.getString();
		             }else if ("realname".equals(item.getFieldName())) {
		            	 realname = item.getString("UTF-8");
		            	 System.out.println(realname+"111");
					 }else if ("uaddress".equals(item.getFieldName())) {
						 uaddress = item.getString("UTF-8");
					 }else if ("uemail".equals(item.getFieldName())) {
						 uemail = item.getString();	
					 }else if ("utelephone".equals(item.getFieldName())) {
						 utelephone = item.getString();	
				     }else if ("uidnumber".equals(item.getFieldName())) {
				    	 uidnumber = item.getString();	
					 }else if ("userbirthday".equals(item.getFieldName())) {
						 date = item.getString();
						 userbirthday = sdf.parse(date);
					 }else if ("usersex".equals(item.getFieldName())) {
						 usersex = Integer.parseInt(item.getString());	
					 }
		         }
		         
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FileUploadException e) {
			e.printStackTrace();
		}finally {
			
		}
		userUpdateService.updateUser(uid,uname, realname, usersex, uaddress, uemail, utelephone, uidnumber, userbirthday, avatar);
		User user = userUpdateService.newSession(uid);
		req.getSession().setAttribute("user", user);
		List<SongList> songlist = songListService.queryAllListByUid(user.getUid());
		List<Mv> mvlist =mvService.loadAllMvByState();
		req.setAttribute("songlist", songlist);
		req.setAttribute("mvlist",mvlist);
		req.getRequestDispatcher("/chahua/index.jsp").forward(req, resp);
	}
}
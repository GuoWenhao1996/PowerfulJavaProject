package com.chinasofti.blc.tiremusic.uploadmusic.controller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.chinasofti.blc.tiremusic.uploadmusic.entity.School;
import com.chinasofti.blc.tiremusic.uploadmusic.entity.Songer;
import com.chinasofti.blc.tiremusic.uploadmusic.entity.UploadMusic;
import com.chinasofti.blc.tiremusic.uploadmusic.entity.Uploadlist;
import com.chinasofti.blc.tiremusic.uploadmusic.entity.Userinfo;
import com.chinasofti.blc.tiremusic.uploadmusic.service.SelectSongerService;
import com.chinasofti.blc.tiremusic.uploadmusic.service.SelectschoolService;
import com.chinasofti.blc.tiremusic.uploadmusic.service.SelectuploadlistidSrevice;
import com.chinasofti.blc.tiremusic.uploadmusic.service.UploadMusicService;
import com.chinasofti.blc.tiremusic.user.entity.User;

import net.sf.json.JSONArray;
@WebServlet(value="/uploadmusic/*",name="UploadMusicController")
public class UploadMusicController extends BaseController{
	private static final long serialVersionUID = 1L;
	private SelectschoolService service=new SelectschoolService();
	private UploadMusicService musicService=new UploadMusicService();
	private SelectSongerService songerService=new SelectSongerService();
	private SelectuploadlistidSrevice srevice=new SelectuploadlistidSrevice();
	private SongListService songListService = new SongListService();
	private MvService mvService = new MvService();
	
	public void selectsonger(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		List<Songer> songers=new ArrayList<Songer>();
		
		songers=songerService.selectsonger();
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONArray.fromObject(songers).toString());
	}
	
	
	public void selectschool(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		List<School> schools=new ArrayList<School>();
		
		schools=service.getschools();
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONArray.fromObject(schools).toString());
	}
	public void uploadmusic(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int uid=Integer.parseInt(req.getSession().getAttribute("uid")+"");
	
	String  schoolid="";
	String location="";
	String songerid="";
	String songname="";
	DiskFileItemFactory factory = new DiskFileItemFactory();//文件上传
	ServletFileUpload upload = new ServletFileUpload(factory);//文件上传解析器
	upload.setHeaderEncoding("utf-8");
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
				String[] strings = fileName.split("\\\\");
				File file = new File("E:\\project\\musiclist");
				if (!file.exists()) {
					file.mkdirs();
				}
				out = new FileOutputStream(new File("E:\\project\\musiclist"+File.separator+strings[strings.length-1]));
				location = "http://localhost:8080/musiclist/"+strings[strings.length-1];
				byte[] b = new byte[1024*1024];
				int count = 0;
				while((count=in.read(b))!=-1) {
					out.write(b, 0, count);
				}
				resp.setHeader("content-type", "text/html;charset=utf-8");
	         } else {
	             if("songname".equals(item.getFieldName())) {
	            	 songname = item.getString("UTF-8");
	             }
				 else if ("schoolid".equals(item.getFieldName())) {
					 schoolid =item.getString("UTF-8");
					 
				 }
				 else if ("songerid".equals(item.getFieldName())) {
					 songerid = item.getString("UTF-8");
					
				 }
	         }
	        
	    }
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {		
		e.printStackTrace();
	} catch (FileUploadException e) {		
		e.printStackTrace();
	}
	    Date uploadtime=null;
	    Date d= new Date();   
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  
	    String dateNowStr = sdf.format(d); 
	    
	    try {
			 uploadtime=sdf.parse(dateNowStr);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		UploadMusic up=new UploadMusic();
		Userinfo ui=new Userinfo();
		Uploadlist upl=new Uploadlist();
		upl=srevice.selectuploadid();
		int uploadlistid=upl.getUploadlistid();		
		up.setUploadtime(uploadtime);
		up.setSchoolid(schoolid);
		up.setUploadlistid(uploadlistid+1);
		up.setState(0);
		up.setSongerid(songerid);
		up.setLocation(location);
		up.setSongname(songname);
		boolean flag=false;
		flag=musicService.uploadmusic(uid,up);
		
		if(flag=true) {
			User user = (User)req.getSession().getAttribute("user");
			List<SongList> songlist = songListService.queryAllListByUid(user.getUid());
			List<Mv> mvlist =mvService.loadAllMvByState();
			req.setAttribute("songlist", songlist);
			req.setAttribute("mvlist",mvlist);
			req.getRequestDispatcher("/chahua/index.jsp").forward(req, resp);
		}
	}
	
	
}

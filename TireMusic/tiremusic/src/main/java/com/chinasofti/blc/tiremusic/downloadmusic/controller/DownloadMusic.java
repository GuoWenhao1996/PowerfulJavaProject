package com.chinasofti.blc.tiremusic.downloadmusic.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chinasofti.blc.tiremusic.common.controller.BaseController;
import com.chinasofti.blc.tiremusic.downloadmusic.entity.Song;
import com.chinasofti.blc.tiremusic.downloadmusic.service.DownloadMusicService;
import com.chinasofti.blc.tiremusic.musiclist.entity.Musiclist;
import com.chinasofti.blc.tiremusic.uploadmusic.entity.Userinfo;
import com.chinasofti.blc.tiremusic.uploadmusic.service.SelectUserinfoService;
import com.chinasofti.blc.tiremusic.user.entity.User;

import net.sf.json.JSONArray;
@WebServlet(value="/download/*",name="DownloadMusic")
public class DownloadMusic extends BaseController{
	private static final long serialVersionUID = 1L;
	private DownloadMusicService musicService=new DownloadMusicService();
	private SelectUserinfoService userinfoService=new SelectUserinfoService();
	
	public void downloadmusic(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int uid=Integer.parseInt(req.getSession().getAttribute("uid")+"");
		int songid=Integer.parseInt(req.getParameter("songid"));
		Userinfo userinfo=new Userinfo();
		userinfo=userinfoService.getuserinfo(uid);
		int downloadlistid=userinfo.getDownloadlistid();
		musicService.downloadmusic(uid, songid,downloadlistid);
	    Song song=musicService.selectlocation(songid);
	    String path=song.getLocation();
	    File file=null;
	    int index = path.lastIndexOf( "/" );
        String filename = path.substring(index +1);
        String filename1=URLEncoder.encode(filename, "utf-8");
        String  path1=path.substring(0,32 );
        String path3=path1+filename1;
	    URL url = new URL(path3);
	    URLConnection urlConnection = url.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Charset", "UTF-8");
        httpURLConnection.connect();
        int fileLength = httpURLConnection.getContentLength();   
        resp.setHeader("Content-Disposition", "attachment:filename="+java.net.URLEncoder.encode(filename,"utf-8"));
        URLConnection con=url.openConnection();
        BufferedInputStream bis=new BufferedInputStream(httpURLConnection.getInputStream());
        String path2="f:\\"+filename;
        file=new File(path2);
        OutputStream out=new FileOutputStream(file);
        int size=0;
        int len = 0;
	    byte[] buf = new byte[1024];
	    while ((size = bis.read(buf)) != -1) {
	        len += size;
	        out.write(buf, 0, size);
	        }
		
	}
	
	public void getdownloadmusiclist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User u= (User) req.getSession().getAttribute("user");
		int uid=u.getUid();
		List<Musiclist> musiclist=musicService.getmusiclist(uid);
		resp.getWriter().write(JSONArray.fromObject(musiclist).toString());
	}

}

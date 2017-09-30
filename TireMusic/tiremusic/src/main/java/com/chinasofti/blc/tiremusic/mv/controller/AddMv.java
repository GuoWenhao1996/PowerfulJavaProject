package com.chinasofti.blc.tiremusic.mv.controller;

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
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.chinasofti.blc.tiremusic.mv.service.MvService;
@WebServlet(value="/addMV")
@MultipartConfig
public class AddMv extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MvService mvService =new MvService();
		req.setCharacterEncoding("utf-8");
		String mvname="";
		int songid=0;
		String mvtext="";
		String date = "";
		Date releasetime =null;
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		DiskFileItemFactory factory = new DiskFileItemFactory();//文件上传
		ServletFileUpload upload = new ServletFileUpload(factory);//文件上传解析器
		upload.setHeaderEncoding("utf-8");//防止文件名中文乱码
		OutputStream out = null;
		String location ="";
		try {
			//获得文件名
			List<FileItem> fileItems = upload.parseRequest(req);
			Iterator iter = fileItems.iterator();
			String fileName = "";
			InputStream in = null;
			while(iter.hasNext()) {
		        FileItem item = (FileItem)iter.next();
		        // 判断该属性是否是file类型
		        if (!item.isFormField()) {
		            in = item.getInputStream();
		            fileName = item.getName();
		            
			            System.out.println("文件名："+fileName);
						String[] strings = fileName.split("\\\\");
						File file = new File("E:\\project\\MV");
						if (!file.exists()) {
							file.mkdirs();
						}
						out = new FileOutputStream(new File("E:\\project\\MV"+File.separator+strings[strings.length-1]));
						location = "http://localhost:8080/MV/"+strings[strings.length-1];
						byte[] b = new byte[1024*1024];
						int count = 0;
						while((count=in.read(b))!=-1) {
							out.write(b, 0, count);
						}
						resp.setHeader("content-type", "text/html;charset=utf-8");
					
		         } else {
		            // 不是file类型的话，就利用getFieldName判断name属性获取相应的值
		             if("mvname".equals(item.getFieldName())) {
		            	 mvname = item.getString("UTF-8");
		            	 System.out.println(mvname+"111");
		             }else if ("songid".equals(item.getFieldName())) {
		            	 songid = Integer.parseInt(item.getString());
		            	 System.out.println(songid+"111");
					 }else if ("mvtext".equals(item.getFieldName())) {
						 mvtext = item.getString("UTF-8");
					 }else if ("releasetime".equals(item.getFieldName())) {
						 date = item.getString();
						 releasetime = sdf.parse(date);
					 }
		         }
		         
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}finally {
			
		}
		boolean result=mvService.addMv(mvname,songid,mvtext,releasetime,location);
		req.setAttribute("result", result);
		req.getRequestDispatcher("/view/manage/manageMVmain.jsp").forward(req, resp);;
	}
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
}

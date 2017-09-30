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
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.chinasofti.blc.tiremusic.common.controller.BaseController;
import com.chinasofti.blc.tiremusic.user.entity.User;
import com.chinasofti.blc.tiremusic.user.service.UserRegistService;
@WebServlet("/userRegister/*")
public class UserRegisterContorller extends BaseController{
	
	private static final long serialVersionUID = 1L;
	private UserRegistService userRegistService = new UserRegistService();
	private StringBuilder stringBuilder ;
	/**
	 * 用户注册
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @throws ParseException
	 */
	public void userRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ParseException {
		req.getSession().invalidate();
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		String reg = "";
		String uname = "";
		String realname = "";
		String upassword = "";
		String uaddress = "";
		String uemail = "";
		String utelephone = "";
		String uidnumber = "";
		String date = "";
		String avatar = "";
		int usersex = 0;
		Date userbirthday = null; 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date logindate = sdf.parse(sdf.format(new Date())); //将字符串转化成util.date
		DiskFileItemFactory factory = new DiskFileItemFactory();//文件上传
		ServletFileUpload upload = new ServletFileUpload(factory);//文件上传解析器
		upload.setHeaderEncoding("utf-8");//防止文件名中文乱码
		OutputStream out = null;
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
		            if (fileName.equals("")||fileName==null) {
		            	avatar = "http://localhost:8080/img/1.png";
					}else {
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
					 }else if ("upassword".equals(item.getFieldName())) {
						 upassword = item.getString();
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
					 }else if ("reg".equals(item.getFieldName())) {
						 reg =item.getString();	
					 }
		         }
		    }
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
		User user = null;
	    if (req.getSession().getAttribute("user")!=null) {
	    	user = (User)req.getSession().getAttribute("user");
	    	if (!user.getUname().equals(uname)&&!user.getUemail().equals(uemail)&&!user.getUtelephone().equals(utelephone)) {
		    	boolean result = userRegistService.addUserDao(uname, realname, upassword, uaddress, uemail, utelephone, uidnumber, avatar, logindate, usersex, userbirthday);
		    	if (result) {
		    		req.getSession().setAttribute("user", user);
		    		resp.setCharacterEncoding("utf-8");
		    		req.getRequestDispatcher("/chahua/signin.jsp").forward(req, resp);
		    	}else {
		    		req.setAttribute("error", "输入的信息有误，注册失败");
		    	}
			}else {
				req.setAttribute("warm", "用户名已存在!");
			}
		}else {
			boolean result = userRegistService.addUserDao(uname, realname, upassword, uaddress, uemail, utelephone, uidnumber, avatar, logindate, usersex, userbirthday);
			if (result) {
				user = new User(uname, upassword, realname, uaddress, uemail, utelephone, uidnumber, avatar, 1, logindate, usersex, userbirthday);
	    		req.getSession().setAttribute("user", user);
	    		resp.setCharacterEncoding("utf-8");
	    		req.getRequestDispatcher("/chahua/signin.jsp").forward(req, resp);
	    	}else {
	    		req.setAttribute("error", "输入的信息有误，注册失败");
	    	}
		}
	}
	
	/**
	 * 发送验证码到邮箱
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @throws ParseException
	 * @throws MessagingException
	 */
	public void sendMail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ParseException, MessagingException {
		String uemail = req.getParameter("uemail");
		Properties props = new Properties();
		props.setProperty("mail.host", "smtp.sohu.com");
		props.setProperty("mail.user", "zqAnonymous@sohu.com");
		props.setProperty("mail.from", "zqAnonymous@sohu.com");
		props.setProperty("mail.transport.protocol", "smtp");
		//获得一个Session
		Session session = Session.getInstance(props);
		
		Transport ts = session.getTransport();
		
		//连接
		ts.connect("smtp.sohu.com", "zqAnonymous@sohu.com", "zq7108392");
		
		
		//对一个邮件的封装
		MimeMessage message = new MimeMessage(session);
		
		//带有样式的邮件内容
		MimeMultipart multipart = new MimeMultipart();
		
		MimeBodyPart text = new MimeBodyPart();
		String[] strings = new String[]{"1","2","3","4","5","6","7","8","9","0"};
		stringBuilder = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			stringBuilder.append(strings[(int)(Math.random()*9)]);
		}
		text.setContent("<h1>欢迎注册TireMusic在线音乐平台</h1><p style='color:#000'>验证码是:"+stringBuilder.toString()+"<p>", "text/html;charset=utf-8");
		multipart.addBodyPart(text);
		multipart.setSubType("related");
		message.setFrom(new InternetAddress("zqAnonymous@sohu.com"));
		message.addRecipient(RecipientType.TO,new InternetAddress(uemail));
		
		message.setSubject("这是邮件的主题");
		message.setContent(multipart);
		
		//Get all the recipient addresses for the message.
		ts.sendMessage(message,message.getAllRecipients());
		ts.close();
		resp.getWriter().write("true");
	}
	/**
	 * 验证验证码
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void equalsMail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reg = req.getParameter("reg");
		if (reg.equals(stringBuilder.toString())) {
			resp.getWriter().write("true");
		}else {
			resp.getWriter().write("false");
		}
	}
	/**
	 * 验证用户名是否唯一
	 */
	public void reguname(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		boolean result = userRegistService.regname(uname);
		resp.getWriter().write(result+"");
	}
	/**
	 * 验证手机号码是否唯一
	 */
	public void regutelephone(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String utelephone = req.getParameter("utelephone");
		boolean result = userRegistService.regutelephone(utelephone);
		resp.getWriter().write(result+"");
	}
	/**
	 * 验证身份证是否唯一
	 */
	public void reguidnumber(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uidnumber = req.getParameter("uidnumber");
		boolean result = userRegistService.reguidnumber(uidnumber);
		resp.getWriter().write(result+"");
	}
}

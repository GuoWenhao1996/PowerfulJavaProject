package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtil;
import util.DateUtil;

/**
 * 登录判断
 * 
 * @author gwh
 * @version 1.0
 */
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if (username == null) {
			resp.sendRedirect("/ResumeMS/login.html");
		} else {

			Connection con = DBUtil.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = con.prepareStatement("select id from user where username=? and password=?");
				ps.setString(1, username);
				ps.setString(2, password);
				rs = ps.executeQuery();
				if (rs.next()) {
					int id = rs.getInt(1);
					ps = con.prepareStatement("select * from resume where id=?");
					ps.setInt(1, id);
					rs = ps.executeQuery();

					if (rs.next()) {
						String resume1 = rs.getString(2);
						String resume2 = rs.getString(3);
						String resume3 = rs.getString(4);
						String resume4 = rs.getString(5);
						String resume5 = rs.getString(6);
						String resume6 = rs.getString(7);
						String resume7 = rs.getString(8);
						String resume8 = rs.getString(9);
						String resume9 = rs.getString(10);
						String resume10 = rs.getString(11);
						String resume11 = rs.getString(12);
						String resume12 = rs.getString(13);
						String resume13 = rs.getString(14);
						String resume14 = rs.getString(15);
						String resume15 = rs.getString(16);
						String resume16 = rs.getString(17);
						String resume17 = rs.getString(18);
						String resume18 = rs.getString(19);
						String resume19 = rs.getString(20);
						String resume20 = rs.getString(21);
						String resume21 = rs.getString(22);
						String resume22 = rs.getString(23);
						String resume23 = rs.getString(24);
						String resume24 = rs.getString(25);

						resume3 = DateUtil.changeDateFomat(resume3);
						resume11 = DateUtil.changeDateFomat(resume11);
						resume14 = DateUtil.changeDateFomat(resume14);
						resume17 = DateUtil.changeDateFomat(resume17);

						resp.setHeader("content-type", "text/html;charset=utf-8");
						PrintWriter pw = resp.getWriter();
						pw.write("<!DOCTYPE html>\r\n" + "<html>\r\n" + "\r\n" + "	<head>\r\n"
								+ "		<meta charset=\"utf-8\" />\r\n" + "		<title>" + username
								+ "的个人简历</title>\r\n"
								+ "		<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.min.css\" />\r\n"
								+ "		<script src=\"js/jquery-1.11.0.min.js\" type=\"text/javascript\" charset=\"utf-8\"></script>\r\n"
								+ "		<script src=\"js/bootstrap.min.js\" type=\"text/javascript\" charset=\"utf-8\"></script>\r\n"
								+ "	</head>\r\n" + "\r\n" + "	<body style=\"background-color: #fedcbd;\">\r\n"
								+ "		<div class=\"container\">\r\n" + "			<div class=\"row\">\r\n"
								+ "				<div class=\"col-md-8 col-md-offset-2\" style=\"background-color: #deab8a;\">\r\n"
								+ "					<h3 class=\"text-center\">" + username + "的个人简历</h3>\r\n"
								+ "					<table class=\"table table-bordered\">\r\n"
								+ "						<tr class=\"warning\">\r\n"
								+ "							<td colspan=\"12\"><b>基本信息</b></td>\r\n"
								+ "						</tr>\r\n" + "						<tr>\r\n"
								+ "							<td colspan=\"2\">姓名</td>\r\n"
								+ "							<td colspan=\"2\">" + resume1 + "</td>\r\n"
								+ "							<td colspan=\"1\">性别</td>\r\n"
								+ "							<td colspan=\"1\">" + resume2 + "</td>\r\n"
								+ "							<td colspan=\"1\">出生年月</td>\r\n"
								+ "							<td colspan=\"2\">" + resume3 + "</td>\r\n"
								+ "						</tr>\r\n" + "						<tr>\r\n"
								+ "							<td colspan=\"2\">民族</td>\r\n"
								+ "							<td colspan=\"2\">" + resume4 + "</td>\r\n"
								+ "							<td colspan=\"1\">政治面貌</td>\r\n"
								+ "							<td colspan=\"1\">" + resume5 + "</td>\r\n"
								+ "							<td colspan=\"1\">身高</td>\r\n"
								+ "							<td colspan=\"2\">" + resume6 + "厘米</td>\r\n"
								+ "						</tr>\r\n" + "						<tr>\r\n"
								+ "							<td colspan=\"2\">专业</td>\r\n"
								+ "							<td colspan=\"2\">" + resume7 + "</td>\r\n"
								+ "							<td colspan=\"2\">毕业学校</td>\r\n"
								+ "							<td colspan=\"2\">" + resume8 + "</td>\r\n"
								+ "						</tr>\r\n" + "						<tr class=\"warning\">\r\n"
								+ "							<td colspan=\"12\"><b>技能、特长或爱好</b></td>\r\n"
								+ "						</tr>\r\n" + "						<tr>\r\n"
								+ "							<td colspan=\"2\">外语等级</td>\r\n"
								+ "							<td colspan=\"3\">" + resume9 + "</td>\r\n"
								+ "							<td colspan=\"1\">计算机</td>\r\n"
								+ "							<td colspan=\"2\">" + resume10 + "</td>\r\n"
								+ "						</tr>\r\n" + "						<tr class=\"warning\">\r\n"
								+ "							<td colspan=\"12\"><b>个人履历</b></td>\r\n"
								+ "						</tr>\r\n" + "						<tr>\r\n"
								+ "							<td colspan=\"2\">时间</td>\r\n"
								+ "							<td colspan=\"3\">单位</td>\r\n"
								+ "							<td colspan=\"7\">经历</td>\r\n"
								+ "						</tr>\r\n" + "						<tr>\r\n"
								+ "							<td colspan=\"2\">" + resume11 + "</td>\r\n"
								+ "							<td colspan=\"3\">" + resume12 + "</td>\r\n"
								+ "							<td colspan=\"7\">" + resume13 + "</td>\r\n"
								+ "						</tr>\r\n" + "						<tr>\r\n"
								+ "							<td colspan=\"2\">" + resume14 + "</td>\r\n"
								+ "							<td colspan=\"3\">" + resume15 + "</td>\r\n"
								+ "							<td colspan=\"7\">" + resume16 + "</td>\r\n"
								+ "						</tr>\r\n" + "						<tr>\r\n"
								+ "							<td colspan=\"2\">" + resume17 + "</td>\r\n"
								+ "							<td colspan=\"3\">" + resume18 + "</td>\r\n"
								+ "							<td colspan=\"7\">" + resume19 + "</td>\r\n"
								+ "						</tr>\r\n" + "						<tr class=\"warning\">\r\n"
								+ "							<td colspan=\"12\"><b>联系方式</b></td>\r\n"
								+ "						</tr>\r\n" + "						<tr>\r\n"
								+ "							<td colspan=\"2\">通信地址</td>\r\n"
								+ "							<td colspan=\"3\">" + resume20 + "</td>\r\n"
								+ "							<td colspan=\"1\">联系电话</td>\r\n"
								+ "							<td colspan=\"6\">" + resume21 + "</td>\r\n"
								+ "						</tr>\r\n" + "						<tr>\r\n"
								+ "							<td colspan=\"2\">E-mail</td>\r\n"
								+ "							<td colspan=\"3\">" + resume22 + "</td>\r\n"
								+ "							<td colspan=\"1\">邮编</td>\r\n"
								+ "							<td colspan=\"6\">" + resume23 + "</td>\r\n"
								+ "						</tr>\r\n" + "						<tr class=\"warning\">\r\n"
								+ "							<td colspan=\"12\"><b>自我评价</b></td>\r\n"
								+ "						</tr>\r\n" + "						<tr>\r\n"
								+ "							<td colspan=\"12\">\r\n"
								+ "								" + resume24 + "\r\n"
								+ "							</td>\r\n" + "						</tr>\r\n"
								+ "						<tr>\r\n"
								+ "							<td colspan=\"12\" align=\"center\">\r\n"
								+ "								<a href=\"login.html\"><button class=\"btn btn-primary\">返回</button></a>\r\n"
								+ "							</td>\r\n" + "						</tr>\r\n"
								+ "					</table>\r\n" + "				</div>\r\n" + "			</div>\r\n"
								+ "		</div>\r\n" + "\r\n" + "	</body>\r\n" + "\r\n" + "</html>");
					}
				} else {
					resp.sendRedirect("/ResumeMS/login.html");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.closeConnection(null, null, con);
			}
		}
	}

}

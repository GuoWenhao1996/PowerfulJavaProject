package servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import util.DBUtil;

/**
 * 登录
 * 
 * @author gwh
 *
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
		List<Object> objs = DBUtil.operateDQL(User.class, "select * from user where username=? and password=?",
				username, password);
		if (objs.size() == 0) {
			req.setAttribute("loginInfo","用户名或密码错误！");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		} else {
			User user = (User) objs.get(0);
			req.getSession().setAttribute("user", user);
			resp.sendRedirect("/PhoneBookMS/jsp/index.jsp");
		}
	}

}

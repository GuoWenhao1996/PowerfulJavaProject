package servlet.friend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import util.DBUtil;

/**
 * 增加好友
 * 
 * @author gwh
 *
 */
public class AddFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		String birthday = req.getParameter("birthday");
		String telephone = req.getParameter("telephone");
		String sex = req.getParameter("sex");
		String qq = req.getParameter("qq");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		int uid = ((User) req.getSession().getAttribute("user")).getUid();
		boolean flag = DBUtil.operateDML(
				"insert into friend (name,birthday,telephone,sex,qq,email,address,uid) values(?,?,?,?,?,?,?,?)", name,
				birthday.equals("")?null:birthday, telephone, sex, qq, email, address, uid);
		if (flag) {
			System.out.println("添加成功");
			req.setAttribute("addInfo", "addInfo:添加成功！");
			System.out.println(req.getAttribute("addInfo"));
			req.getRequestDispatcher("/jsp/addFriend.jsp").forward(req, resp);
		} else {
			System.out.println("添加失败");
			req.setAttribute("addInfo", "添加失败！");
			req.getRequestDispatcher("/jsp/addFriend.jsp").forward(req, resp);
		}
	}
}

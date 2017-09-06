package servlet.friend;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Friend;
import entity.User;
import util.DBUtil;

/**
 * 查询所有朋友
 * 
 * @author gwh
 *
 */
public class QueryAllFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int uid = ((User) req.getSession().getAttribute("user")).getUid();
		List<Object> objs = DBUtil.operateDQL(Friend.class, "select * from friend where uid=?", uid);
		DBUtil<Friend> db = new DBUtil<>();
		List<Friend> friends = db.changeObjListToTList(objs);
		req.setAttribute("friends",friends);
		req.getRequestDispatcher("/jsp/queryFriend.jsp").forward(req, resp);
	}
}
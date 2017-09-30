package com.chinasofti.blc.tiremusic.comment.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.chinasofti.blc.tiremusic.comment.entity.Comment;
import com.chinasofti.blc.tiremusic.common.util.DBUtil;

/**
 * 评论dao层
 * 
 * @author guowh
 *
 */
public class CommentDao {

	/**
	 * 向评论表插入评论数据
	 * 
	 * @param uid
	 *            用户id
	 * @param sid
	 *            歌曲id
	 * @param content
	 *            评论内容
	 * @param date
	 *            时间
	 * @return 插入成功返回true
	 */
	public boolean addDiscuss(int uid, int sid, String content, Date date) {
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			int result = qr.update(con, "insert into comment (uid,songid,commentcontent,commenttime) values(?,?,?,?)",
					uid, sid, content, date);
			if (result != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(null, null, con);
		}
		return false;
	}

	/**
	 * 删除评论表中的数据
	 * 
	 * @param cid
	 *            评论id
	 * @return 删除成功返回true
	 */
	public boolean deleteDiscuss(int cid) {
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			con.setAutoCommit(false);
			int result = qr.update(con, "delete from comment where commentid=?", cid);
			if (result != 0) {
				con.commit();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(null, null, con);
		}
		return false;
	}

	/**
	 * 根据歌曲id查出评论表中的评论
	 * 
	 * @param sid
	 *            歌曲id
	 * @return 评论列表
	 */
	public List<Comment> showDiscussList(int sid) {
		List<Comment> lists = new LinkedList<>();
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			lists = qr.query(con,
					"select  commentid,c.uid,u.uname,avatar,commentcontent,commenttime from `comment` c join user u on c.uid=u.uid where songid=? order by commenttime desc",
					new BeanListHandler<>(Comment.class), sid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}

}

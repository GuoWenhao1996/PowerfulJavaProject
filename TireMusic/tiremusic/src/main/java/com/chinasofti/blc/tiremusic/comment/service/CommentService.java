package com.chinasofti.blc.tiremusic.comment.service;

import java.util.Date;
import java.util.List;

import com.chinasofti.blc.tiremusic.comment.dao.CommentDao;
import com.chinasofti.blc.tiremusic.comment.entity.Comment;
import com.chinasofti.blc.tiremusic.sensitive.dao.SensitiveDao;
import com.chinasofti.blc.tiremusic.sensitive.entity.SensitiveWord;

/**
 * 评论服务层
 * 
 * @author guowh
 *
 */
public class CommentService {
	CommentDao commentDao = new CommentDao();
	SensitiveDao sensitiveDao = new SensitiveDao();

	/**
	 * 增加评论
	 * 
	 * @param uid
	 *            用户id
	 * @param sid
	 *            歌曲id
	 * @param content
	 *            评论内容
	 * @return 成功返回字符串true 失败返回失败原因
	 */
	public String addDiscuss(String uid, String sid, String content) {
		if (content == null || content.trim().isEmpty()) {
			return "评论内容不能为空！";
		} else if (isSensitiveWord(content)) {
			return "评论内容包含敏感词汇！";
		} else {
			if (commentDao.addDiscuss(Integer.parseInt(uid), Integer.parseInt(sid), content.trim(), new Date())) {
				return "true";
			} else {
				return "服务器错误，请稍后再试！";
			}
		}
	}

	/**
	 * 判断是否包含敏感词汇
	 * 
	 * @param content
	 *            内容
	 * @return 包含返回true
	 */
	private boolean isSensitiveWord(String content) {
		List<SensitiveWord> list = sensitiveDao.queryAllSensitive();
		for (SensitiveWord sensitiveWord : list) {
			if (content.indexOf(sensitiveWord.getSwtext()) != -1)
				return true;
		}
		return false;
	}

	/**
	 * 删除评论
	 * 
	 * @param cid
	 *            评论id
	 * @return 成功返回true
	 */
	public boolean deleteDiscuss(String cid) {
		return commentDao.deleteDiscuss(Integer.parseInt(cid));
	}

	/**
	 * 歌曲的评论列表
	 * 
	 * @param sid
	 *            歌曲id
	 * @return 列表
	 */
	public List<Comment> showDiscussList(String sid) {
		return commentDao.showDiscussList(Integer.parseInt(sid));
	}

}

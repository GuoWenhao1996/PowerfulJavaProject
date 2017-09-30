package com.chinasofti.blc.tiremusic.comment.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 评论实体类
 * 
 * @author guowh
 *
 */
public class Comment implements Serializable {

	private static final long serialVersionUID = 1L;
	private int commentid;// 评论id
	private int uid;// 用户id
	private String uname;// 用户名
	private String commentcontent;// 评论内容
	private String avatar;// 头像
	private Date commenttime;// 评论时间

	public int getCommentid() {
		return commentid;
	}

	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getCommentcontent() {
		return commentcontent;
	}

	public void setCommentcontent(String commentcontent) {
		this.commentcontent = commentcontent;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Date getCommenttime() {
		return commenttime;
	}

	public void setCommenttime(Date commenttime) {
		this.commenttime = commenttime;
	}

	public Comment() {
		super();
	}

	public Comment(int commentid, int uid, String uname, String commentcontent, String avatar, Date commenttime) {
		super();
		this.commentid = commentid;
		this.uid = uid;
		this.uname = uname;
		this.commentcontent = commentcontent;
		this.avatar = avatar;
		this.commenttime = commenttime;
	}

	@Override
	public String toString() {
		return "Comment [commentid=" + commentid + ", uid=" + uid + ", uname=" + uname + ", commentcontent="
				+ commentcontent + ", avatar=" + avatar + ", commenttime=" + commenttime + "]";
	}

}

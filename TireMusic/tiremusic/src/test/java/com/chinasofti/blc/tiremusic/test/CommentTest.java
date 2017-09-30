package com.chinasofti.blc.tiremusic.test;

import java.util.List;

import org.junit.Test;

import com.chinasofti.blc.tiremusic.comment.entity.Comment;
import com.chinasofti.blc.tiremusic.comment.service.CommentService;

/**
 * 评论模块单元测试代码
 * 
 * @author guowh
 *
 */
public class CommentTest {
	CommentService commentService = new CommentService();

	/**
	 * 新增评论测试
	 */
	@Test
	public void testAddDiscuss() {
		// System.out.println(commentService.addDiscuss("1", "1", "好歌"));
		// System.out.println(commentService.addDiscuss("1", "1", null));
		// System.out.println(commentService.addDiscuss("1", "1", ""));
		// System.out.println(commentService.addDiscuss("1", "1", " "));
		// System.out.println(commentService.addDiscuss("1", "1", "1 "));
		System.out.println(commentService.addDiscuss("1", "1", " 222 1 "));
		// System.out.println(commentService.addDiscuss("1", "1", " 很喜欢这首歌 "));
	}

	/**
	 * 删除评论测试
	 */
	@Test
	public void testDeleteDiscuss() {
		System.out.println(commentService.deleteDiscuss("6"));
	}

	/**
	 * 评论列表
	 */
	@Test
	public void testShowDiscussList() {
		List<Comment> list = commentService.showDiscussList("1");
		// List<Comment> list = commentService.showDiscussList("2");
		for (Comment comment : list) {
			System.out.println(comment);
		}
	}

}

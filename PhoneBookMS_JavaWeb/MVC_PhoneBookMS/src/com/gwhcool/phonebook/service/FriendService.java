package com.gwhcool.phonebook.service;

import java.util.List;

import com.gwhcool.phonebook.dao.FriendDao;
import com.gwhcool.phonebook.entity.Friend;

/**
 * 用户服务层
 * 
 * @author gwh
 *
 */
public class FriendService {

	private FriendDao friendDao = new FriendDao();

	/**
	 * 根据用户id查找所有的好友
	 * 
	 * @param UserId
	 *            用户id
	 * @return 好友列表
	 */
	public List<Friend> queryAllFriendByUserId(int UserId) {
		return friendDao.queryAllFriendByUserId(UserId);
	}

	public boolean addFriend(Friend friend, int UserId) {
		return friendDao.addFriend(friend, UserId);
	}
}

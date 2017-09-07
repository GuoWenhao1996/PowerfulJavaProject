package com.gwhcool.phonebook.dao;

import java.util.List;

import com.gwhcool.phonebook.entity.Friend;
import com.gwhcool.phonebook.util.DBUtil;

/**
 * friend表操作类
 * 
 * @author gwh
 *
 */
public class FriendDao {
	/**
	 * 根据用户id查找所有的好友
	 * 
	 * @param UserId
	 *            用户id
	 * @return 好友列表
	 */
	public List<Friend> queryAllFriendByUserId(int UserId) {
		List<Object> objs = DBUtil.operateDQL(Friend.class, "select * from friend where uid=?", UserId);
		DBUtil<Friend> db = new DBUtil<>();
		return db.changeObjListToTList(objs);
	}

	/**
	 * 增加好友
	 * 
	 * @param friend
	 *            好友对象
	 * @param UserId
	 *            用户id
	 * @return 增加成功返回true
	 */
	public boolean addFriend(Friend friend, int UserId) {
		return DBUtil.operateDML(
				"insert into friend (name,birthday,telephone,sex,qq,email,address,uid) values(?,?,?,?,?,?,?,?)",
				friend.getName(), friend.getBirthday(), friend.getTelephone(), friend.getSex(), friend.getQq(),
				friend.getEmail(), friend.getAddress(), UserId);
	}
}

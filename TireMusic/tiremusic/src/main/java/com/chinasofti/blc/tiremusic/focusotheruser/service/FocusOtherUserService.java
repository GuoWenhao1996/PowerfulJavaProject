package com.chinasofti.blc.tiremusic.focusotheruser.service;

import com.chinasofti.blc.tiremusic.focusotheruser.dao.FocusOtherUserDao;

public class FocusOtherUserService {
	private FocusOtherUserDao dao=new FocusOtherUserDao();
	public boolean focusotheruser(int uid,int confirmid) {
		return dao.focusotheruser(uid, confirmid);
	}
}

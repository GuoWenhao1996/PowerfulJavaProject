package com.chinasofti.blc.tiremusic.uploadmusic.service;

import com.chinasofti.blc.tiremusic.uploadmusic.dao.SelectUserinfoDao;
import com.chinasofti.blc.tiremusic.uploadmusic.entity.Userinfo;

public class SelectUserinfoService {
	private SelectUserinfoDao dao=new SelectUserinfoDao();
	public Userinfo getuserinfo(int uid) {
		return dao.getuserinfo(uid);
	}
}

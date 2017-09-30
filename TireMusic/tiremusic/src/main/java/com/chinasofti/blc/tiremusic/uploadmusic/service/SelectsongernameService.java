package com.chinasofti.blc.tiremusic.uploadmusic.service;
import com.chinasofti.blc.tiremusic.uploadmusic.dao.SelectsongernameDao;
import com.chinasofti.blc.tiremusic.uploadmusic.entity.Songer;
public class SelectsongernameService {
	private SelectsongernameDao dao=new SelectsongernameDao();
	public Songer getsongername(int songerid) {
		return dao.selectsongerbysongerid(songerid);
	}
}

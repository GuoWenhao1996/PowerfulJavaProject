package com.chinasofti.blc.tiremusic.uploadmusic.service;

import java.util.List;
import com.chinasofti.blc.tiremusic.uploadmusic.dao.SelectsongerDao;
import com.chinasofti.blc.tiremusic.uploadmusic.entity.Songer;

public class SelectSongerService {
	private SelectsongerDao selectsongerDao=new SelectsongerDao();
	public List<Songer> selectsonger(){
		return selectsongerDao.selectsonger();
	}
}

package com.chinasofti.blc.tiremusic.uploadmusic.service;

import com.chinasofti.blc.tiremusic.uploadmusic.dao.SelectschoolDao;
import com.chinasofti.blc.tiremusic.uploadmusic.entity.School;

public class SelectschoolnameService {
private SelectschoolDao dao=new SelectschoolDao();
public School getschoolname(int schoolid) {
	return dao.getschoolbyid(schoolid);
}
}

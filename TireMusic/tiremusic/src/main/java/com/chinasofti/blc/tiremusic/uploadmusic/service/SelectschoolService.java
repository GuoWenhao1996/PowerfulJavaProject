package com.chinasofti.blc.tiremusic.uploadmusic.service;

import java.util.List;

import com.chinasofti.blc.tiremusic.uploadmusic.dao.SelectschoolnameDao;
import com.chinasofti.blc.tiremusic.uploadmusic.entity.School;

public class SelectschoolService {
private SelectschoolnameDao dao=new SelectschoolnameDao();
public List<School>   getschools() {
	return dao.getschoolname();
	
}
}

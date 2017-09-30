package com.chinasofti.blc.tiremusic.music.service;

import java.io.Serializable;
import java.util.List;

import com.chinasofti.blc.tiremusic.music.dao.SchoolDao;
import com.chinasofti.blc.tiremusic.music.entity.School;

public class SchoolService implements Serializable{


	private static final long serialVersionUID = 1L;
	private SchoolDao schoolDao = new SchoolDao();
	/**
	 * 查询并返回所有的流派信息
	 * @return
	 */
	public List<School> queryAllSchools(){
		return schoolDao.queryAllSchools();
	}
}

package com.chinasofti.blc.tiremusic.music.service;

import java.util.List;

import com.chinasofti.blc.tiremusic.music.dao.SensitivewordDao;
import com.chinasofti.blc.tiremusic.music.entity.Sensitiveword;

public class SensitivewordService {

	private SensitivewordDao sensitivewordDao = new SensitivewordDao();
	/**
	 * 分页加载所有敏感词
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<Sensitiveword> queryAllSW(int page,int rows){
		return sensitivewordDao.queryAllSW(page, rows);
	}
	/**
	 * 增加敏感词
	 * @param swtext
	 * @return
	 */
	public int addSW(String swtext) {
		return sensitivewordDao.addSW(swtext);
	}
	/**
	 * 根据id删除敏感词
	 * @param swid
	 * @return
	 */
	public int deleteSW(int swid) {
		return sensitivewordDao.deleteSW(swid);
	}
	/**
	 * g根据id修改敏感词
	 * @param swtext
	 * @param swid
	 * @return
	 */
	public int updateSW(String swtext,int swid) {
		return sensitivewordDao.updateSW(swid, swtext);
	}
	/**
	 * 查询所有所有敏感词 
	 * @return
	 */
	public List<Sensitiveword> queryAllSW(){
		return sensitivewordDao.queryAllSW();
	}
}

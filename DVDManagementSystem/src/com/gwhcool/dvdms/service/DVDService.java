package com.gwhcool.dvdms.service;

import java.util.List;

import com.gwhcool.dvdms.entity.DVD;

/**
 * dvd 业务层接口
 * 
 * @author gwh
 * @since 1.2
 * 
 */
public interface DVDService {
	/**
	 * 查询出数据库中所有的dvd
	 * 
	 * @return dvd集合
	 */
	public List<DVD> getALLDVD();
	
	/**
	 * 根据id查询dvd
	 * 
	 * @return 只有一项内容的dvd集合
	 */
	public List<DVD> getDVDByid(int id);

	/**
	 * 根据名称模糊查询dvd
	 * 
	 * @return 有相关名字的dvd集合
	 */
	public List<DVD> getDVDByName(String name);
}

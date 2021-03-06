package com.gwhcool.dvdms.dao;

import java.util.List;

import com.gwhcool.dvdms.entity.DVD;

/**
 * dvd dao层接口
 * 
 * @author gwh
 * @since 1.2
 */
public interface DVDDao {
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

	/**
	 * 新增dvd
	 * 
	 * @param dvd
	 *            增加的dvd对象
	 * @return 增加成功返回true
	 */
	public boolean addDvd(DVD dvd);

	/**
	 * 下架dvd
	 * 
	 * @param dvd
	 *            下架的dvd对象
	 * @return 下架成功返回true
	 */
	public boolean deleteDvd(DVD dvd);
}

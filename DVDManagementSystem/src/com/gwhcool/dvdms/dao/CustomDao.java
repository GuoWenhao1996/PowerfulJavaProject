package com.gwhcool.dvdms.dao;

import java.util.List;

import com.gwhcool.dvdms.entity.Custom;
/**
 * 客户 dao层接口
 * 
 * @author gwh
 * @since 1.3
 */
public interface CustomDao {
	/**
	 * 查询出数据库中所有的客户
	 * 
	 * @return 客户集合
	 */
	public List<Custom> getALLCustom();

	/**
	 * 根据id查询客户
	 * 
	 * @return 只有一项内容的客户集合
	 */
	public List<Custom> getCustomByid(int id);

	/**
	 * 根据名称模糊查询客户
	 * 
	 * @return 有相关名字的客户集合
	 */
	public List<Custom> getCustomByName(String name);
}

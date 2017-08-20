package com.gwhcool.dvdms.service;

import java.util.List;

import com.gwhcool.dvdms.entity.Custom;

/**
 * 客户 业务层接口
 * 
 * @author gwh
 * @since 1.3
 */
public interface CustomService {
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

	/**
	 * 新增custom
	 * 
	 * @param custom
	 *            增加的custom对象
	 * @return 增加成功返回true
	 */
	public boolean addCustom(Custom custom);

	/**
	 * 删除客户
	 * 
	 * @param custom
	 *            要删除的custom对象
	 * @return 删除成功返回true
	 */
	public boolean deleteCustom(Custom custom);
}

package com.gwhcool.dvdms.dao;

/**
 * 员工管理dao层接口
 * 
 * @author gwh
 * @since 1.1
 */
public interface EmployeeDao {
	/**
	 * 判断是否登录成功
	 * 
	 * @param id
	 *            员工编号
	 * @param pwd
	 *            密码
	 * @return -1表示服务器错误 0表示登录失败 1表示登录成功 2表示已离职
	 */
	public int login(int id, String pwd);
}

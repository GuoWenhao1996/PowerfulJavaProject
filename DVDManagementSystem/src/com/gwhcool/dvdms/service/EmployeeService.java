package com.gwhcool.dvdms.service;

import java.util.List;

import com.gwhcool.dvdms.entity.Employee;

/**
 * 员工管理业务层接口
 * 
 * @author gwh
 * @since 1.1
 */
public interface EmployeeService {
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

	/**
	 * 查询出数据库中所有的员工
	 * 
	 * @return 员工集合
	 */
	public List<Employee> getALLEmployee();

	/**
	 * 根据id查询员工
	 * 
	 * @return 只有一项内容的员工集合
	 */
	public List<Employee> getEmployeeByid(int id);

	/**
	 * 根据名称模糊查询员工
	 * 
	 * @return 有相关名字的员工集合
	 */
	public List<Employee> getEmployeeByName(String name);

	/**
	 * 新增employee
	 * 
	 * @param employee
	 *            增加的employee对象
	 * @return 增加成功返回true
	 */
	public boolean addEmployee(Employee employee);
	

	/**
	 * 删除员工
	 * 
	 * @param employee
	 *            要删除的employee对象
	 * @return 删除成功返回true
	 */
	public boolean deleteEmployee(Employee employee);
}

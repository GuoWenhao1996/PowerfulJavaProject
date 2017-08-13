package com.gwhcool.studentcoursems.service;

import java.util.List;

/**
 * 选课管理操作接口
 * 
 * @author gwh
 * @since 1.4
 */
public interface ElectiveManageService {
	/**
	 * 为指定课程添加学生
	 * 
	 * @param courseID
	 *            课程号
	 * @param stuIDs
	 *            要选课的学生学号的集合
	 */
	public void addElective(String courseID, List<String> stuIDs);

	/**
	 * 删除选择指定课程的指定学生
	 * 
	 * @param courseID
	 *            课程号
	 * @param stuID
	 *            学生学号
	 */
	public void deleteElectiveByStuID(String courseID, String stuID);

	/**
	 * 删除选择指定课程的所有学生
	 * 
	 * @param courseID
	 *            课程号
	 */
	public void deleteAllElective(String courseID);

	/**
	 * 通过学号查询选课情况
	 * 
	 * @param stuID
	 *            学号
	 * @return 课程号的集合
	 * 
	 */
	public List<String> findElectiveByStuID(String stuID);

	/**
	 * 通过课程号查询选课情况
	 * 
	 * @param courseID
	 *            课程号
	 * @return 学号的集合
	 */
	public List<String> findElectiveByCoursID(String courseID);

}

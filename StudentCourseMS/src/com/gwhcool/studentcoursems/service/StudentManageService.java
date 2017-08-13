package com.gwhcool.studentcoursems.service;

import com.gwhcool.studentcoursems.entity.Student;

/**
 * 学生管理接口
 * 
 * @author gwh
 * @since 1.1
 */
public interface StudentManageService {
	/**
	 * 向内存中的List和对象文件中增加学生
	 * 
	 * @param student
	 *            学生对象
	 */
	public void addStudent(Student student);

	/**
	 * 删除List中和对象文件中的指定学生
	 * 
	 * @param index
	 *            要删除的学生的索引
	 */
	public void deleteStudent(int index);

	/**
	 * 修改List中和对象文件中的指定学生
	 * 
	 * @param index
	 *            要修改的学生的索引
	 * @param student
	 *            新的学生对象
	 */
	public void updateStudent(int index, Student student);

	/**
	 * 根据学生ID查找学生索引
	 * 
	 * @param stuID
	 *            学生ID
	 * @return 学生索引
	 */
	public int findStudentByID(String stuID);

	/**
	 * 根据学生姓名查找学生索引
	 * 
	 * @param stuName
	 *            学生姓名
	 * @return 学生索引数组
	 */
	public int[] findStudentByName(String stuName);

	/**
	 * 根据班级名称查找学生索引
	 * 
	 * @param className
	 *            班级名称
	 * @return 学生索引数组
	 */
	public int[] findStudentByClassName(String className);

	/**
	 * 根据索引打印学生信息
	 * 
	 * @param index
	 */
	public void printStudentByIndex(int index);

	/**
	 * 根据索引数组打印学生信息
	 * 
	 * @param indexs
	 */
	public void printStudentByIndex(int[] indexs);

}

package com.gwhcool.studentcoursems.service;

import java.util.Set;

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
	 * @return 学生索引的Set集合
	 */
	public Set<Integer> findStudentByName(String stuName);

	/**
	 * 根据班级名称查找学生索引
	 * 
	 * @param className
	 *            班级名称
	 * @return 学生索引的Set集合
	 */
	public Set<Integer> findStudentByClassName(String className);

	/**
	 * 根据索引打印学生信息
	 * 
	 * @param index
	 *            学生索引
	 */
	public void printStudentByIndex(int index);

	/**
	 * 根据学生索引的Set集合打印学生信息
	 * 
	 * @param indexs
	 *            学生索引的Set集合
	 */
	public void printStudentByIndex(Set<Integer> indexs);

	/**
	 * 打印出所有的学生信息
	 */
	public void printAllStudent();

}

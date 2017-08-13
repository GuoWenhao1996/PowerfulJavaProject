package com.gwhcool.studentcoursems.service;

import com.gwhcool.studentcoursems.entity.Course;

/**
 * 课程管理接口
 * 
 * @author gwh
 * @since 1.3
 */
public interface CourseManageService {
	/**
	 * 向内存中的List和对象文件中增加课程
	 * 
	 * @param course
	 *            课程对象
	 */
	public void addCourse(Course course);

	/**
	 * 删除List中和对象文件中的指定课程
	 * 
	 * @param index
	 *            要删除的课程的索引
	 */
	public void deleteCourse(int index);

	/**
	 * 修改List中和对象文件中的指定课程
	 * 
	 * @param index
	 *            要修改的课程的索引
	 * @param student
	 *            新的课程对象
	 */
	public void updateCourse(int index, Course course);

	/**
	 * 根据课程ID查找课程索引
	 * 
	 * @param courseID
	 *            课程ID
	 * @return 课程索引
	 */
	public int findCourseByID(String courseID);

	/**
	 * 根据索引打印课程信息
	 * 
	 * @param index
	 *            课程索引
	 */
	public void printCourseByIndex(int index);

	/**
	 * 打印出所有的课程信息
	 */
	public void printAllCourse();
}

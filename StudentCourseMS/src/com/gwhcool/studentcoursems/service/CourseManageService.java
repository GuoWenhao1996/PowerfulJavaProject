package com.gwhcool.studentcoursems.service;

import com.gwhcool.studentcoursems.entity.Course;

/**
 * �γ̹���ӿ�
 * 
 * @author gwh
 * @since 1.3
 */
public interface CourseManageService {
	/**
	 * ���ڴ��е�List�Ͷ����ļ������ӿγ�
	 * 
	 * @param course
	 *            �γ̶���
	 */
	public void addCourse(Course course);

	/**
	 * ɾ��List�кͶ����ļ��е�ָ���γ�
	 * 
	 * @param index
	 *            Ҫɾ���Ŀγ̵�����
	 */
	public void deleteCourse(int index);

	/**
	 * �޸�List�кͶ����ļ��е�ָ���γ�
	 * 
	 * @param index
	 *            Ҫ�޸ĵĿγ̵�����
	 * @param student
	 *            �µĿγ̶���
	 */
	public void updateCourse(int index, Course course);

	/**
	 * ���ݿγ�ID���ҿγ�����
	 * 
	 * @param courseID
	 *            �γ�ID
	 * @return �γ�����
	 */
	public int findCourseByID(String courseID);

	/**
	 * ����������ӡ�γ���Ϣ
	 * 
	 * @param index
	 *            �γ�����
	 */
	public void printCourseByIndex(int index);

	/**
	 * ��ӡ�����еĿγ���Ϣ
	 */
	public void printAllCourse();
}

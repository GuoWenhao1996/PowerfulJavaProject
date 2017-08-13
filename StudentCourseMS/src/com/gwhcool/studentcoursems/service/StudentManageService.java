package com.gwhcool.studentcoursems.service;

import com.gwhcool.studentcoursems.entity.Student;

/**
 * ѧ������ӿ�
 * 
 * @author gwh
 * @since 1.1
 */
public interface StudentManageService {
	/**
	 * ���ڴ��е�List�Ͷ����ļ�������ѧ��
	 * 
	 * @param student
	 *            ѧ������
	 */
	public void addStudent(Student student);

	/**
	 * ɾ��List�кͶ����ļ��е�ָ��ѧ��
	 * 
	 * @param index
	 *            Ҫɾ����ѧ��������
	 */
	public void deleteStudent(int index);

	/**
	 * �޸�List�кͶ����ļ��е�ָ��ѧ��
	 * 
	 * @param index
	 *            Ҫ�޸ĵ�ѧ��������
	 * @param student
	 *            �µ�ѧ������
	 */
	public void updateStudent(int index, Student student);

	/**
	 * ����ѧ��ID����ѧ������
	 * 
	 * @param stuID
	 *            ѧ��ID
	 * @return ѧ������
	 */
	public int findStudentByID(String stuID);

	/**
	 * ����ѧ����������ѧ������
	 * 
	 * @param stuName
	 *            ѧ������
	 * @return ѧ����������
	 */
	public int[] findStudentByName(String stuName);

	/**
	 * ���ݰ༶���Ʋ���ѧ������
	 * 
	 * @param className
	 *            �༶����
	 * @return ѧ����������
	 */
	public int[] findStudentByClassName(String className);

	/**
	 * ����������ӡѧ����Ϣ
	 * 
	 * @param index
	 */
	public void printStudentByIndex(int index);

	/**
	 * �������������ӡѧ����Ϣ
	 * 
	 * @param indexs
	 */
	public void printStudentByIndex(int[] indexs);

}

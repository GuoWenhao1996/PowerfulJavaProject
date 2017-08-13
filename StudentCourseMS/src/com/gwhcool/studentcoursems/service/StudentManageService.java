package com.gwhcool.studentcoursems.service;

import java.util.Set;

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
	 * @return ѧ��������Set����
	 */
	public Set<Integer> findStudentByName(String stuName);

	/**
	 * ���ݰ༶���Ʋ���ѧ������
	 * 
	 * @param className
	 *            �༶����
	 * @return ѧ��������Set����
	 */
	public Set<Integer> findStudentByClassName(String className);

	/**
	 * ����������ӡѧ����Ϣ
	 * 
	 * @param index
	 *            ѧ������
	 */
	public void printStudentByIndex(int index);

	/**
	 * ����ѧ��������Set���ϴ�ӡѧ����Ϣ
	 * 
	 * @param indexs
	 *            ѧ��������Set����
	 */
	public void printStudentByIndex(Set<Integer> indexs);

	/**
	 * ��ӡ�����е�ѧ����Ϣ
	 */
	public void printAllStudent();

}

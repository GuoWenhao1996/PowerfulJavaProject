package com.gwhcool.studentcoursems.service;

import java.util.List;

/**
 * ѡ�ι�������ӿ�
 * 
 * @author gwh
 * @since 1.4
 */
public interface ElectiveManageService {
	/**
	 * Ϊָ���γ����ѧ��
	 * 
	 * @param courseID
	 *            �γ̺�
	 * @param stuIDs
	 *            Ҫѡ�ε�ѧ��ѧ�ŵļ���
	 */
	public void addElective(String courseID, List<String> stuIDs);

	/**
	 * ɾ��ѡ��ָ���γ̵�ָ��ѧ��
	 * 
	 * @param courseID
	 *            �γ̺�
	 * @param stuID
	 *            ѧ��ѧ��
	 */
	public void deleteElectiveByStuID(String courseID, String stuID);

	/**
	 * ɾ��ѡ��ָ���γ̵�����ѧ��
	 * 
	 * @param courseID
	 *            �γ̺�
	 */
	public void deleteAllElective(String courseID);

	/**
	 * ͨ��ѧ�Ų�ѯѡ�����
	 * 
	 * @param stuID
	 *            ѧ��
	 * @return �γ̺ŵļ���
	 * 
	 */
	public List<String> findElectiveByStuID(String stuID);

	/**
	 * ͨ���γ̺Ų�ѯѡ�����
	 * 
	 * @param courseID
	 *            �γ̺�
	 * @return ѧ�ŵļ���
	 */
	public List<String> findElectiveByCoursID(String courseID);

}

package com.gwhcool.studentcoursems.window;

import java.util.Scanner;

/**
 * ѡ�ι�����<br>
 * ���湦��:
 * <li>ͨ��ѧ�Ų�ѯѡ�����</li>
 * <li>ͨ���γ̺Ŵ�ӡѧ����Ϣ</li>
 * <li>���ѡ���ſγ̵�ѧ��</li>
 * <li>ɾ��ѡ�����ſγ̵�ѧ��</li>
 * <li>������һ��</li>
 * 
 * @author gwh
 * @since 1.2
 *
 */
public class ElectiveMangeWindow extends Window {

	@Override
	public void show(Scanner sc) {
		System.out.println("***************************");
		System.out.println("|          ѡ�ι���                             |");
		System.out.println("|                         |");
		System.out.println("| 1��ͨ��ѧ�Ų�ѯѡ�����                         |");
		System.out.println("| 2��ͨ���γ̺Ŵ�ӡѧ����Ϣ                     |");
		System.out.println("| 3�����ѡ���ſγ̵�ѧ��                         |");
		System.out.println("| 4��ɾ��ѡ�����ſγ̵�ѧ��                     |");
		System.out.println("| 0��������һ��                                             |");
		System.out.println("|                         |");
		System.out.println("|      ��Ȩ����   ����ؾ�                      |");
		System.out.println("***************************");
		System.out.println("��������Ų�����");
		String choose = sc.next();
		if ("1".equals(choose)) {

		} else if ("2".equals(choose)) {
			WindowUtil.byebye(sc);
		} else if ("3".equals(choose)) {
			WindowUtil.byebye(sc);
		} else if ("0".equals(choose)) {
			WindowUtil.start(sc);
		} else {
			System.out.println("�����������������룡");
			show(sc);
		}
	}
}

package com.gwhcool.studentcoursems.window;

import java.util.Scanner;

/**
 * ��ӭҳ����<br>
 * ���湦��:
 * <li>ѧ������</li>
 * <li>�γ̹���</li>
 * <li>ѡ�ι���</li>
 * <li>�˳�ϵͳ</li>
 * 
 * @author gwh
 * @since 1.2
 *
 */
public class WelcomeWindow extends Window {

	@Override
	public void show(Scanner sc) {
		System.out.println("***************************");
		System.out.println("|     ��ӭʹ��gdsѧ������ϵͳ           |");
		System.out.println("|                         |");
		System.out.println("| 1��ѧ������                                                 |");
		System.out.println("| 2���γ̹���                                                 |");
		System.out.println("| 3��ѡ�ι���                                                 |");
		System.out.println("| 0���˳�                                                         |");
		System.out.println("|                         |");
		System.out.println("|      ��Ȩ����   ����ؾ�                      |");
		System.out.println("***************************");
		System.out.println("��������Ų�����");
		String choose = sc.next();
		if ("1".equals(choose)) {
			WindowUtil.studentMange(sc);
		} else if ("2".equals(choose)) {
			WindowUtil.courseMange(sc);
		} else if ("3".equals(choose)) {
			WindowUtil.electiveMange(sc);
		} else if ("0".equals(choose)) {
			WindowUtil.byebye(sc);
		} else {
			System.out.println("�����������������룡");
			show(sc);
		}
	}
}

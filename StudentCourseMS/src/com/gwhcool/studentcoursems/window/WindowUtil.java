package com.gwhcool.studentcoursems.window;

import java.util.Scanner;

/**
 * ���ڹ�����<br>
 * ���崰�ڵ�һЩ��������
 * 
 * @author gwh
 * @since 1.2
 */
public final class WindowUtil {
	/**
	 * ���ý������ڣ�Ȼ���˳�����
	 * 
	 * @param sc
	 *            ������
	 */
	protected static void byebye(Scanner sc) {
		Window window = new ByeByeWindow();
		window.show(sc);
		System.exit(0);
	}

	/**
	 * ���û�ӭ���ڣ����뵼��ҳ��
	 * 
	 * @param sc
	 *            ������
	 */
	public static void start(Scanner sc) {
		Window window = new WelcomeWindow();
		window.show(sc);
	}

	/**
	 * ����ѧ�������ڣ�����ѧ������ҳ��
	 * 
	 * @param sc
	 *            ������
	 */
	public static void studentMange(Scanner sc) {
		Window window = new StudentMangeWindow();
		window.show(sc);
	}

	/**
	 * ���ÿγ̹����ڣ�����γ̹���ҳ��
	 * 
	 * @param sc
	 *            ������
	 */
	public static void courseMange(Scanner sc) {
		Window window = new CourseMangeWindow();
		window.show(sc);
	}

	/**
	 * ����ѡ�ι����ڣ�����ѡ�ι���ҳ��
	 * 
	 * @param sc
	 *            ������
	 */
	public static void electiveMange(Scanner sc) {
		Window window = new ElectiveMangeWindow();
		window.show(sc);
	}
}

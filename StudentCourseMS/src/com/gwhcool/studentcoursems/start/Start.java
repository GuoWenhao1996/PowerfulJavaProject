package com.gwhcool.studentcoursems.start;

import java.util.Scanner;

import com.gwhcool.studentcoursems.window.WindowUtil;

/**
 * 学生课程控制台应用程序主入口文件
 * 
 * @author gwh
 * @version 1.2
 *
 */
public class Start {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		WindowUtil.start(sc);
	}
}

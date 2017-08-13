package com.gwhcool.studentcoursems.window;

import java.util.Scanner;

/**
 * 显示窗口抽象类<br>
 * 任何窗口类必须实现该类中show()抽象方法
 * 
 * @author gwh
 * @since 1.2
 *
 */
public abstract class Window {
	/**
	 * 显示窗口
	 * 
	 * @param sc
	 *            接收器
	 */
	public abstract void show(Scanner sc);
}

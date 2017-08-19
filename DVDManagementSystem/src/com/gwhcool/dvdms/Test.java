package com.gwhcool.dvdms;

import com.gwhcool.dvdms.service.EmployeeService;
import com.gwhcool.dvdms.service.impl.EmployeeServiceImpl;
import com.gwhcool.dvdms.util.DBUtil;
import com.gwhcool.dvdms.util.MySystemUtil;

public class Test {
	public static void main(String[] args) {
		
		EmployeeService es=new EmployeeServiceImpl();
		System.out.println(es.login(1001, "111111"));
		System.out.println(es.login(1002, "111111"));
		System.out.println(es.login(1003, "11111"));
		
		
		// DBUtil.getDataSource();
		// System.out.println("连接池测试成功！");
		// DBUtil.getConnection();
		// System.out.println("mysql连接测试成功！");

		 System.out.println(MySystemUtil.getSystemTime());
		//
		// String pwd="111111";
		// pwd=MySystemUtil.md5Password(pwd);
		// System.out.println(pwd);
		// System.out.println(pwd.length());
	}
}

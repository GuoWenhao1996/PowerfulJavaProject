package com.gwhcool.dvdms.test;

import java.util.List;

import com.gwhcool.dvdms.dao.DVDDao;
import com.gwhcool.dvdms.dao.impl.DVDDaoImpl;
import com.gwhcool.dvdms.entity.DVD;
import com.gwhcool.dvdms.service.EmployeeService;
import com.gwhcool.dvdms.service.impl.EmployeeServiceImpl;
import com.gwhcool.dvdms.util.DBUtil;
import com.gwhcool.dvdms.util.MySystemUtil;

public class Test {
	public static void main(String[] args) {

		DVDDao dd = new DVDDaoImpl();
		List<DVD> list = dd.getALLDVD();
		for (DVD dvd : list) {
			System.out.println(dvd);
		}
		// EmployeeService es=new EmployeeServiceImpl();
		// System.out.println(es.login(1001, "111111"));
		// System.out.println(es.login(1002, "111111"));
		// System.out.println(es.login(1003, "11111"));

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

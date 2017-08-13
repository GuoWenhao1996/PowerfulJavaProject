package com.gwhcool.studentcoursems.service;

import java.time.LocalDate;
import java.util.List;

import com.gwhcool.studentcoursems.entity.Student;
import com.gwhcool.studentcoursems.util.DBUtil;
import com.gwhcool.studentcoursems.util.FileUtil;

public class StudentManageServiceImpl implements StudentManageService {

	private DBUtil db = DBUtil.getInstance();
	private List<Student> list = null;

	@Override
	public void addStudent(Student student) {
		list = db.getStudentList();
		String lastStudentID = list.get(list.size() - 1).getStuID();
		String lastStudentMonth = lastStudentID.substring(6, 8);
		String lastID = lastStudentID.substring(8);
		// 为新学生设置相应规则的id
		LocalDate ld = LocalDate.now();
		String month = "";
		if (ld.getMonthValue() < 10) {
			month = "0" + ld.getMonthValue();
		} else {
			month += ld.getMonthValue();
		}
		if (!lastStudentMonth.equals(month)) {
			lastID = "0001";
		} else {
			int ID = Integer.parseInt(lastID) + 1;
			if (ID > 999) {
				lastID = "" + ID;
			} else if (ID > 99) {
				lastID = "0" + ID;
			} else if (ID > 9) {
				lastID = "00" + ID;
			} else {
				lastID = "000" + ID;
			}
		}
		String newStudentID = "zr" + ld.getYear() + month + lastID;
		student.setStuID(newStudentID);

		// 插入新学生
		FileUtil.ObjToFile(student);
		list.add(student);
		db.setStudentList(list);
	}

	@Override
	public void deleteStudent(int index) {

	}

	@Override
	public void updateStudent(int index, Student student) {
		// TODO Auto-generated method stub

	}

	@Override
	public int findStudentByID(String stuID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[] findStudentByName(String stuName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] findStudentByClassName(String className) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printStudentByIndex(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void printStudentByIndex(int[] indexs) {
		// TODO Auto-generated method stub

	}

}

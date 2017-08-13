package com.gwhcool.studentcoursems.service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.gwhcool.studentcoursems.entity.Student;
import com.gwhcool.studentcoursems.util.DBUtil;
import com.gwhcool.studentcoursems.util.FileUtil;

/**
 * 学生管理接口实现类
 * 
 * @author gwh
 * @version 1.1
 */
public class StudentManageServiceImpl implements StudentManageService {

	private DBUtil db = DBUtil.getInstance();
	private List<Student> list = null;

	@Override
	public void addStudent(Student student) {
		list = db.getStudentList();
		String lastStudentID = null;
		if (list.isEmpty()) {
			lastStudentID = "zr2000000000";
		} else {
			lastStudentID = list.get(list.size() - 1).getStuID();
		}
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
		System.out.println("添加成功！系统分配给【" + student.getStuName() + "】的学号为：【" + newStudentID + "】");
	}

	@Override
	public void deleteStudent(int index) {
		list = db.getStudentList();
		Student student = list.get(index);
		student.setStuName("已删除！！！");
		FileUtil.ObjToFile(student);
		list.set(index, student);
	}

	@Override
	public void updateStudent(int index, Student student) {
		list = db.getStudentList();
		FileUtil.ObjToFile(student);
		list.set(index, student);
	}

	@Override
	public int findStudentByID(String stuID) {
		list = db.getStudentList();
		for (Student student : list) {
			if (student.getStuID().equals(stuID)) {
				return list.indexOf(student);
			}
		}
		return -1;
	}

	@Override
	public Set<Integer> findStudentByName(String stuName) {
		list = db.getStudentList();
		Set<Integer> sets = new HashSet<>();
		for (Student student : list) {
			if (student.getStuName().equals(stuName)) {
				sets.add(list.indexOf(student));
			}
		}
		return sets;
	}

	@Override
	public Set<Integer> findStudentByClassName(String className) {
		list = db.getStudentList();
		Set<Integer> sets = new HashSet<>();
		for (Student student : list) {
			if (student.getClassName().equals(className)) {
				sets.add(list.indexOf(student));
			}
		}
		return sets;
	}

	@Override
	public void printStudentByIndex(int index) {
		if (index == -1) {
			System.out.println("查找的学生不存在！");
		} else {
			list = db.getStudentList();
			Student student = list.get(index);
			if (student.getStuName().equals("已删除！！！")) {
				// System.out.println("查找的学生不存在！");
			} else {
				System.out.println(student);
			}
		}
	}

	@Override
	public void printStudentByIndex(Set<Integer> indexs) {
		System.out.println("=====================================================");
		System.out.println("学号\t\t姓名\t性别\t年龄\t班级");
		System.out.println("-----------------------------------------------------");
		for (Integer integer : indexs) {
			printStudentByIndex(integer);
		}
		System.out.println("=====================================================");
	}

	@Override
	public void printAllStudent() {
		list = db.getStudentList();
		System.out.println("=====================================================");
		System.out.println("学号\t\t姓名\t性别\t年龄\t班级");
		System.out.println("-----------------------------------------------------");
		for (int i = 0; i < list.size(); i++) {
			printStudentByIndex(i);
		}
		System.out.println("=====================================================");
	}

}

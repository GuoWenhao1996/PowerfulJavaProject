package com.gwhcool.studentcoursems.service;

import java.util.ArrayList;
import java.util.List;

import com.gwhcool.studentcoursems.entity.Elective;
import com.gwhcool.studentcoursems.util.DBUtil;
import com.gwhcool.studentcoursems.util.FileUtil;

/**
 * 选课管理操作实现类
 * 
 * @author gwh
 * @since 1.4
 */
public class ElectiveManageServiceImpl implements ElectiveManageService {

	private DBUtil db = DBUtil.getInstance();
	List<Elective> list = null;

	@Override
	public void addElective(String courseID, List<String> stuIDs) {
		list = db.getElectiveList();
		Elective elective = null;
		for (String stuID : stuIDs) {
			elective = new Elective(courseID, stuID, true);
			FileUtil.ObjToFile(elective);
			list.add(elective);
		}
	}

	@Override
	public void deleteElectiveByStuID(String courseID, String stuID) {
		list = db.getElectiveList();
		for (Elective elective : list) {
			if (elective.getCourseID().equals(courseID) && elective.getStuID().equals(stuID)) {
				elective.setFlag(false);
				FileUtil.ObjToFile(elective);
			}
		}
	}

	@Override
	public void deleteAllElective(String courseID) {
		list = db.getElectiveList();
		for (Elective elective : list) {
			if (elective.getCourseID().equals(courseID) && elective.isFlag()) {
				elective.setFlag(false);
				FileUtil.ObjToFile(elective);
			}
		}
	}

	@Override
	public List<String> findElectiveByStuID(String stuID) {
		list = db.getElectiveList();
		List<String> listCourseID = new ArrayList<>();
		for (Elective elective : list) {
			if (elective.getStuID().equals(stuID) && elective.isFlag())
				listCourseID.add(elective.getCourseID());
		}
		return listCourseID;
	}

	@Override
	public List<String> findElectiveByCoursID(String courseID) {
		list = db.getElectiveList();
		List<String> listStuID = new ArrayList<>();
		for (Elective elective : list) {
			if (elective.getCourseID().equals(courseID) && elective.isFlag())
				listStuID.add(elective.getStuID());
		}
		return listStuID;
	}

}

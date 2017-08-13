package com.gwhcool.studentcoursems.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.gwhcool.studentcoursems.entity.Course;
import com.gwhcool.studentcoursems.entity.Elective;
import com.gwhcool.studentcoursems.entity.Student;

/**
 * 文件工具类<br>
 * 提供一些文件的读写操作，主要是将obj存入文件，或将文件中的obj读取出来
 * 
 * @author gwh
 * @since 1.0
 *
 */
public class FileUtil {

	/**
	 * 将学生对象存入到文件中
	 * 
	 * @param student
	 *            要存入的学生对象
	 */
	public static void ObjToFile(Student student) {
		OutputStream out = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			out = new FileOutputStream(new File(
					"src/com/gwhcool/studentcoursems/datafile/student/Student_" + student.getStuID() + ".obj"));
			objectOutputStream = new ObjectOutputStream(out);
			objectOutputStream.writeObject(student);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				objectOutputStream.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 将课程对象存入到文件中
	 * 
	 * @param course
	 *            要存入的课程对象
	 */
	public static void ObjToFile(Course course) {
		OutputStream out = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			out = new FileOutputStream(new File(
					"src/com/gwhcool/studentcoursems/datafile/course/Course_" + course.getCourseID() + ".obj"));
			objectOutputStream = new ObjectOutputStream(out);
			objectOutputStream.writeObject(course);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				objectOutputStream.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 将选课对象存入到文件中
	 * 
	 * @param elective
	 *            要存入的选课对象
	 */
	public static void ObjToFile(Elective elective) {
		OutputStream out = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			out = new FileOutputStream(new File("src/com/gwhcool/studentcoursems/datafile/elective/Elective_"
					+ elective.getCourseID() + "_" + elective.getStuID() + ".obj"));
			objectOutputStream = new ObjectOutputStream(out);
			objectOutputStream.writeObject(elective);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				objectOutputStream.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 将文件中的学生对象读取到ArrayList列表中
	 * 
	 * @return 学生对象的list
	 */
	public static List<Student> fileToStudentObj() {
		List<Student> list = new ArrayList<>();
		Student stu = null;
		InputStream in = null;
		File file = new File("src/com/gwhcool/studentcoursems/datafile/student");
		ObjectInputStream objectInputStream = null;
		try {
			File[] objfiles = file.listFiles();
			for (File f : objfiles) {
				in = new FileInputStream(f);
				objectInputStream = new ObjectInputStream(in);
				stu = (Student) objectInputStream.readObject();
				list.add(stu);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				objectInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	/**
	 * 将文件中的课程对象读取到ArrayList列表中
	 * 
	 * @return 课程对象的list
	 */
	public static List<Course> fileToCourseObj() {
		List<Course> list = new ArrayList<>();
		Course course = null;
		InputStream in = null;
		File file = new File("src/com/gwhcool/studentcoursems/datafile/course");
		ObjectInputStream objectInputStream = null;
		try {
			File[] objfiles = file.listFiles();
			for (File f : objfiles) {
				in = new FileInputStream(f);
				objectInputStream = new ObjectInputStream(in);
				course = (Course) objectInputStream.readObject();
				list.add(course);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				objectInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	/**
	 * 将文件中的选课对象读取到ArrayList列表中
	 * 
	 * @return 选课对象的list
	 */
	public static List<Elective> fileToElectiveObj() {
		List<Elective> list = new ArrayList<>();
		Elective elective = null;
		InputStream in = null;
		File file = new File("src/com/gwhcool/studentcoursems/datafile/elective");
		ObjectInputStream objectInputStream = null;
		try {
			File[] objfiles = file.listFiles();
			for (File f : objfiles) {
				in = new FileInputStream(f);
				objectInputStream = new ObjectInputStream(in);
				elective = (Elective) objectInputStream.readObject();
				list.add(elective);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				objectInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	/**
	 * 删除指定课程对象文件以及选课对象文件
	 * 
	 * @param course
	 *            要删除的课程对象
	 */
	public static void deleteObjFile(Course course) {
		String deleteID = course.getCourseID();
		// 删除课程对象文件
		File f = new File("src/com/gwhcool/studentcoursems/datafile/course/Course_" + deleteID + ".obj");
		System.out.println(f.exists());
		System.out.println(f.getName());
		System.out.println(f.getAbsolutePath());

		boolean b = f.delete();
		System.out.println(b);
		// 删除选课对象文件
		File eleDir = new File("src/com/gwhcool/studentcoursems/datafile/elective");
		File[] files = eleDir.listFiles();
		for (File file : files) {
			if (file.getName().contains(deleteID)) {
				System.out.println(file.getName());
				file.delete();
			}
		}
	}

}
